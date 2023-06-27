package ibf.miniproject.ecommerce.model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.OneToMany;

public class Customer {
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;

    @OneToMany(mappedBy = "customer")
    private Set<Orders> orders = new HashSet<>();

    public Customer() {
    }

    public Customer(Integer id, String firstName, String lastName, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email=email;
    }
    public Customer(Integer id, String firstName, String lastName, String email, Set<Orders> orders) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email=email;
        this.orders = orders;
    }

    public Customer(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email=email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public Set<Orders> getOrders() {
        return orders;
    }
    public void setOrders(Set<Orders> orders) {
        this.orders = orders;
    }

    public void add(Orders order) {
        if (order != null) {
            if (orders == null) {
                orders = new HashSet<>();
            }
            orders.add(order);
            order.setCustomer(this);
        }
    }
    
}
