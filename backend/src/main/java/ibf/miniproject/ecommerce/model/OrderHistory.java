package ibf.miniproject.ecommerce.model;

public class OrderHistory {
    
    private int orderId;
    private String orderTrackingNumber;
    private String customerName;
    private String productName;
    private int quantity;

    public OrderHistory() {
    }

    public OrderHistory(int orderId, String orderTrackingNumber, String customerName, String productName, int quantity) {
        this.orderId = orderId;
        this.orderTrackingNumber = orderTrackingNumber;
        this.customerName = customerName;
        this.productName = productName;
        this.quantity = quantity;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getOrderTrackingNumber() {
        return orderTrackingNumber;
    }

    public void setOrderTrackingNumber(String orderTrackingNumber) {
        this.orderTrackingNumber = orderTrackingNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
 
}
