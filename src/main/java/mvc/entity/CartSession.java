package mvc.entity;

public class CartSession {
    private ProductEntity product;
    private int quantity;

    public CartSession(ProductEntity product) {
        this.product = product;
        this.quantity = 1;
    }


    public void incrementQuantity() {
        this.quantity++;
    }

    public ProductEntity getProduct() {
        return product;
    }

    public void setProduct(ProductEntity product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "CartSession{" +
                "product=" + product +
                ", quantity=" + quantity +
                '}';
    }
}

