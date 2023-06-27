package ibf.miniproject.ecommerce.model;

import jakarta.persistence.CascadeType;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

public class Orders implements Serializable{

    private Integer id;
    private String orderTrackingNumber;
    private Double totalPrice;
    private Integer totalQuantity;
    private Integer customerId;
    private Integer shippingAddressId;
    private String status;
    @CreationTimestamp
    private Date dateCreated;
    @UpdateTimestamp
    private Date lastUpdated;


    @OneToMany(cascade = CascadeType.ALL,mappedBy = "orders")
    private Set<OrderItem> orderItem = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "shipping_address_id",referencedColumnName = "id")
    private Address shippingAddress;

    public Orders() {
    }

    public Orders (String orderTrackingNumber, Double totalPrice, Integer totalQuantity, Integer customerId,Integer shippingAddressId,
            String status, Date dateCreated, Date lastUpdated) {
        this.orderTrackingNumber = orderTrackingNumber;
        this.totalPrice = totalPrice;
        this.totalQuantity = totalQuantity;
        this.customerId = customerId;
        this.shippingAddressId = shippingAddressId;
        this.status = status;
        this.dateCreated = dateCreated;
        this.lastUpdated = lastUpdated;
    }
    public Orders(Integer id, String orderTrackingNumber, Double totalPrice, Integer totalQuantity, Integer customerId,Integer shippingAddressId,
            String status, Date dateCreated, Date lastUpdated, Customer customer, Address shippingAddress,
            Set<OrderItem> orderItem) {
        this.id = id;
        this.orderTrackingNumber = orderTrackingNumber;
        this.totalPrice = totalPrice;
        this.totalQuantity = totalQuantity;
        this.customerId = customerId;
        this.shippingAddressId = shippingAddressId;
        this.status = status;
        this.dateCreated = dateCreated;
        this.lastUpdated = lastUpdated;
        this.customer = customer;
        this.shippingAddress = shippingAddress;
        this.orderItem = orderItem;
    }
 

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getOrderTrackingNumber() {
        return orderTrackingNumber;
    }
    public Integer getShippingAddressId() {
        return shippingAddressId;
    }
    public void setShippingAddressId(Integer shippingAddressId) {
        this.shippingAddressId = shippingAddressId;
    }
    public void setOrderTrackingNumber(String orderTrackingNumber) {
        this.orderTrackingNumber = orderTrackingNumber;
    }
    public Double getTotalPrice() {
        return totalPrice;
    }
    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }
    public Integer getTotalQuantity() {
        return totalQuantity;
    }
    public void setTotalQuantity(Integer totalQuantity) {
        this.totalQuantity = totalQuantity;
    }
    public Integer getCustomerId() {
        return customerId;
    }
    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public Date getDateCreated() {
        return dateCreated;
    }
    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }
    public Date getLastUpdated() {
        return lastUpdated;
    }
    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }
    public Customer getCustomer() {
        return customer;
    }
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    public Address getShippingAddress() {
        return shippingAddress;
    }
    public void setShippingAddress(Address shippingAddress) {
        this.shippingAddress = shippingAddress;
    }
    public Set<OrderItem> getOrderItem() {
        return orderItem;
    }
    public void setOrderItem(Set<OrderItem> orderItem) {
        this.orderItem = orderItem;
    }


    public void add(OrderItem item) {
        if (item != null) {
            if (orderItem == null) {
                orderItem = new HashSet<>();
            }
            orderItem.add(item);
            item.setOrders(this);
        }
    }

    
    
}
