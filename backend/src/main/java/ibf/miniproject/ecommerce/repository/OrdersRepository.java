package ibf.miniproject.ecommerce.repository;

import java.sql.PreparedStatement;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import ibf.miniproject.ecommerce.model.Orders;

@Repository
public class OrdersRepository {


    @Autowired
    JdbcTemplate jdbcTemplate;


    private static final String INSERT_SQL="insert into orders (order_tracking_number,total_price,total_quantity,customer_id,status, date_created, last_Updated) values (?,?,?,?,?,?,?)";
 
    private static final String SELECT_SQL="SELECT o.order_tracking_number, c.email FROM orders o JOIN customer c ON o.customer_id = c.id";

    public Integer createOrder(Orders order){
        KeyHolder genratedHolder = new GeneratedKeyHolder();
        PreparedStatementCreator psc = new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(java.sql.Connection con) throws java.sql.SQLException {
                PreparedStatement ps = con.prepareStatement(INSERT_SQL, new String[] {"id"});
                LocalDateTime currentTime= LocalDateTime.now();
                ps.setString(1, order.getOrderTrackingNumber());
                ps.setDouble(2, order.getTotalPrice());
                ps.setInt(3, order.getTotalQuantity());
                ps.setInt(4, order.getCustomerId());
                ps.setString(5, order.getStatus());
                ps.setDate(6, java.sql.Date.valueOf(currentTime.toLocalDate()));
                ps.setDate(7, java.sql.Date.valueOf(currentTime.toLocalDate()));
                return ps;
            }
        };
        jdbcTemplate.update(psc, genratedHolder);
        Integer returnedId = genratedHolder.getKey().intValue();
        return returnedId;
    }

    

    
}
