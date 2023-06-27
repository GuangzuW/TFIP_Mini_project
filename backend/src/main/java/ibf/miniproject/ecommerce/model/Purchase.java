package ibf.miniproject.ecommerce.model;

import java.io.Serializable;
import java.util.Set;

public class Purchase implements Serializable{

    private Customer customer;
    private Address shippingAddress;
    private Orders order;
    private Set<OrderItem> orderItems;
    public Purchase() {
    }
    public Purchase(Customer customer, Address shippingAddress, Orders order, Set<OrderItem> orderItems) {
        this.customer = customer;
        this.shippingAddress = shippingAddress;
        this.order = order;
        this.orderItems = orderItems;
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
    public Orders getOrder() {
        return order;
    }
    public void setOrder(Orders order) {
        this.order = order;
    }
    public Set<OrderItem> getOrderItems() {
        return orderItems;
    }
    
    
}
