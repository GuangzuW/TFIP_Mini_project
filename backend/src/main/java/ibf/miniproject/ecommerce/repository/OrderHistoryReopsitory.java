package ibf.miniproject.ecommerce.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import ibf.miniproject.ecommerce.model.OrderHistory;

@Repository
public class OrderHistoryReopsitory {

    @Autowired
    JdbcTemplate jdbcTemplate;


    final static String sqlQuery = "SELECT o.id, o.order_tracking_number, c.first_name, p.name, oi.quantity " +
                                    "FROM orders AS o " +
                                    "JOIN customer AS c ON o.id = c.id " +
                                    "JOIN order_item AS oi ON o.id = oi.id " +
                                    "JOIN product AS p ON oi.product_id = p.id;";


    public List<OrderHistory> getOrderHistory(){
        List<OrderHistory> orderHistory = jdbcTemplate.query(sqlQuery, (rs, rowNum) -> {
            OrderHistory orderHistoryObj = new OrderHistory();
            orderHistoryObj.setOrderId(rs.getInt("id"));
            orderHistoryObj.setOrderTrackingNumber(rs.getString("order_tracking_number"));
            orderHistoryObj.setCustomerName(rs.getString("first_name"));
            orderHistoryObj.setProductName(rs.getString("name"));
            orderHistoryObj.setQuantity(rs.getInt("quantity"));
            return orderHistoryObj;
        });
        return orderHistory;
    }
    
    
}
