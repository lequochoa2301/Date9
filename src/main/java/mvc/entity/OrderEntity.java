package mvc.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "orders")
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int ID;

    @Column(name = "OrderDate")
    private LocalDate OrderDate;

    @Column(name = "CustomerName")
    private String CustomerName;

    @Column(name = "CustomerAddress")
    private String CustomerAddress;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderDetailEntity> orderDetailEntityList;

    public OrderEntity() {
    }

    public OrderEntity(int ID, String customerName, String customerAddress) {
        this.ID = ID;
        CustomerName = customerName;
        CustomerAddress = customerAddress;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public LocalDate getOrderDate() {
        return OrderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        OrderDate = orderDate;
    }

    public String getCustomerName() {
        return CustomerName;
    }

    public void setCustomerName(String customerName) {
        CustomerName = customerName;
    }

    public String getCustomerAddress() {
        return CustomerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        CustomerAddress = customerAddress;
    }

    public List<OrderDetailEntity> getOrderDetailEntityList() {
        return orderDetailEntityList;
    }

    public void setOrderDetailEntityList(List<OrderDetailEntity> orderDetailEntityList) {
        this.orderDetailEntityList = orderDetailEntityList;
    }

    @Override
    public String toString() {
        return "OrderEntity{" +
                "ID=" + ID +
                ", OrderDate=" + OrderDate +
                ", CustomerName='" + CustomerName + '\'' +
                ", CustomerAddress='" + CustomerAddress + '\'' +
                ", orderDetailEntityList=" + orderDetailEntityList +
                '}';
    }
}

