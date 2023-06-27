package ibf.miniproject.ecommerce.model;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class OrderItem {
    private Integer id;
    private String imageUrl;
    private Integer quantity;
    private Double unitPrice;
    private Integer productId;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Orders orders;

    public OrderItem() {
    }
    public OrderItem(Integer id, String imageUrl, Integer quantity, Double unitPrice, Integer productId, Orders orders) {
        this.id = id;
        this.imageUrl = imageUrl;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.productId = productId;
        this.orders = orders;
    }

    public OrderItem(Integer id, String imageUrl, Integer quantity, Double unitPrice,Integer productId) {
        this.id = id;
        this.imageUrl = imageUrl;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.productId = productId;
    }

    public OrderItem(String imageUrl, Integer quantity, Double unitPrice, Integer productId) {
        this.imageUrl = imageUrl;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.productId = productId;
    }

    public Integer getId() {
        return id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }


    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Orders getOrders() {
        return orders;
    }
    public void setOrders(Orders orders) {
        this.orders = orders;
    }
}
