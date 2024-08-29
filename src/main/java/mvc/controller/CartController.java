package mvc.controller;

import mvc.entity.CartSession;
import mvc.entity.OrderEntity;
import mvc.entity.ProductEntity;
import mvc.repository.OrderRepository;
import mvc.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class CartController {
    @Autowired
    ProductRepository productRepository;

    @Autowired
    OrderRepository orderRepository;

    private Map<Integer, CartSession> cart = new HashMap<>();

    @RequestMapping(value = "/addTocart/{id}", method = RequestMethod.GET)
    public String addToCart(@PathVariable("id") Integer id, Model model) {
        ProductEntity product = productRepository.findById(id).orElse(null);
        if (product != null) {
            CartSession cartSession = cart.get(id);
            if (cartSession == null) {
                cartSession = new CartSession(product);
                cart.put(id, cartSession);
            } else {
                cartSession.incrementQuantity();
            }
            model.addAttribute("productList", new ArrayList<>(cart.values()));
            model.addAttribute("msg", "My shopping cart");
        } else {
            model.addAttribute("msg", "Product not found");
        }
        return "cart";
    }


    @RequestMapping(value = "/cart", method = RequestMethod.GET)
    public String showCart(Model model) {
        // Chuyển danh sách sản phẩm trong giỏ hàng vào mô hình
        model.addAttribute("productList", new ArrayList<>(cart.values()));
        return "cart";
    }


    @RequestMapping(value = "/remove/{id}", method = RequestMethod.GET)
    public String removeItem(@PathVariable("id") Integer id, Model model) {
        CartSession cartSession = cart.remove(id);
        if (cartSession != null) {
            model.addAttribute("msg", "Item removed from cart");
        } else {
            model.addAttribute("msg", "Item not found in cart");
        }
        model.addAttribute("productList", new ArrayList<>(cart.values()));
        return "cart";
    }

    @RequestMapping(value = "/checkOut", method = RequestMethod.GET)
    public String checkPage(HttpServletRequest request, Model model) {
        model.addAttribute("order", new OrderEntity());
        return "checkOut";
    }

    @RequestMapping(value = "/checkOut", method = RequestMethod.POST)
    public String processCheckout(@ModelAttribute("order") OrderEntity order, Model model) {

        orderRepository.save(order);
        return "redirect:/order";
    }


    @RequestMapping(value = "/order", method = RequestMethod.GET)
    public String showOrders(Model model) {
        List<OrderEntity> orderList = (List<OrderEntity>) orderRepository.findAll();
        model.addAttribute("orderList", orderList);
        return "myOrder";
    }

    @RequestMapping(value = "/orderDetails/{id}", method = RequestMethod.GET)
    public String orderDetails(@PathVariable("id") Integer id, Model model) {

        OrderEntity order = orderRepository.findById(id).orElse(null);
        if (order != null) {
            model.addAttribute("order", order);
            return "orderDetails";
        } else {
            model.addAttribute("msg", "Order not found");
            return "error";
        }
    }

}