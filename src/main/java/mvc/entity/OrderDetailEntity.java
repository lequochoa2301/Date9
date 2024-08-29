package mvc.entity;

import javax.persistence.*;

@Entity
@Table(name = "order_details")
public class OrderDetailEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int ID;

    @Column(name = "OrderDetailsID")
    private int OrderDetailsID;

    @Column(name = "OrderID")
    private int OrderID;

    @Column(name = "ProductID")
    private int ProductID;

    @Column(name = "Quantity")
    private String Quantity;

    @ManyToOne
    @JoinColumn(name = "OrderID", insertable = false, updatable = false)
    private OrderEntity order;

    @ManyToOne
    @JoinColumn(name = "ProductID", insertable = false, updatable = false)
    private ProductEntity product;

    public OrderDetailEntity() {

    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getOrderDetailsID() {
        return OrderDetailsID;
    }

    public void setOrderDetailsID(int orderDetailsID) {
        OrderDetailsID = orderDetailsID;
    }

    public int getOrderID() {
        return OrderID;
    }

    public void setOrderID(int orderID) {
        OrderID = orderID;
    }

    public int getProductID() {
        return ProductID;
    }

    public void setProductID(int productID) {
        ProductID = productID;
    }

    public String getQuantity() {
        return Quantity;
    }

    public void setQuantity(String quantity) {
        Quantity = quantity;
    }

    public OrderEntity getOrder() {
        return order;
    }

    public void setOrder(OrderEntity order) {
        this.order = order;
    }

    public ProductEntity getProduct() {
        return product;
    }

    public void setProduct(ProductEntity product) {
        this.product = product;
    }
}

