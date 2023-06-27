package ibf.miniproject.ecommerce.repository;

import java.time.LocalDateTime;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import ibf.miniproject.ecommerce.model.OrderItem;

@Repository
public class OrderItemRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    private static final String SELECT_SQL = "select * from order_item";
    private static final String INSERT_SQL = "insert into order_item (image_url,quantity,unit_price, product_id) values (?, ?, ?, ?)";


    public Integer createOrderItem(OrderItem orderItem){
        KeyHolder generatHolder = new GeneratedKeyHolder();
        PreparedStatementCreator psc = new PreparedStatementCreator() {

            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                LocalDateTime currentTime= LocalDateTime.now();
                PreparedStatement ps = con.prepareStatement(INSERT_SQL, new String[] {"id"});
                ps.setString(1, orderItem.getImageUrl());
                ps.setInt(2, orderItem.getQuantity());
                ps.setDouble(3, orderItem.getUnitPrice());
                ps.setInt(4, orderItem.getProductId());
                return ps;
            }

            
        };
        jdbcTemplate.update(psc, generatHolder);
        Integer returnedId = generatHolder.getKey().intValue();
        return returnedId;
    }
    
}
