package mvc.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "products")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "ID")
    private int ID;

    @Column(name = "ProductName")
    private String ProductName;

    @Column(name = "ProductDescription")
    private String ProductDescription;

    @Column(name = "UnitPrice")
    private double UnitPrice;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<OrderDetailEntity> orderDetailEntityList;

    public ProductEntity() {
    }

    public ProductEntity(int ID, String productName, String productDescription, double unitPrice) {
        this.ID = ID;
        ProductName = productName;
        ProductDescription = productDescription;
        UnitPrice = unitPrice;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String productName) {
        ProductName = productName;
    }

    public String getProductDescription() {
        return ProductDescription;
    }

    public void setProductDescription(String productDescription) {
        ProductDescription = productDescription;
    }

    public double getUnitPrice() {
        return UnitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        UnitPrice = unitPrice;
    }

    public List<OrderDetailEntity> getOrderDetailEntityList() {
        return orderDetailEntityList;
    }

    public void setOrderDetailEntityList(List<OrderDetailEntity> orderDetailEntityList) {
        this.orderDetailEntityList = orderDetailEntityList;
    }

    @Override
    public String toString() {
        return "ProductEntity{" +
                "ID=" + ID +
                ", ProductName='" + ProductName + '\'' +
                ", ProductDescription='" + ProductDescription + '\'' +
                ", UnitPrice=" + UnitPrice +
                ", orderDetailEntityList=" + orderDetailEntityList +
                '}';
    }
}

