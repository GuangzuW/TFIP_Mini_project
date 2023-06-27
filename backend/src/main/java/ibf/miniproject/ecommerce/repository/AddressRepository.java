package ibf.miniproject.ecommerce.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ssl.SslBundleProperties.Key;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import ibf.miniproject.ecommerce.model.Address;

@Repository
public class AddressRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    private static final String INSERT_SQL = "insert into address (block_number, street_name, unit_number, country, post_code) values (?, ?, ?, ?, ?)";

    public Integer createAddress(Address shippingAddress){
        KeyHolder generatHolder = new GeneratedKeyHolder();
        PreparedStatementCreator psc = new PreparedStatementCreator() {

            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                PreparedStatement ps = con.prepareStatement(INSERT_SQL, new String[] {"id"});
                ps.setString(1, shippingAddress.getBlockNumber());
                ps.setString(2, shippingAddress.getStreetName());
                ps.setString(3, shippingAddress.getUnitNumber());
                ps.setString(4, shippingAddress.getCountry());
                ps.setInt(5, shippingAddress.getPostCode());
                return ps;
            }

        };
        jdbcTemplate.update(psc, generatHolder);
        Integer returnedId = generatHolder.getKey().intValue();
        return returnedId;
        
    }
    
}



    // public Integer createProduct(Product product){
    //     KeyHolder generatHolder = new GeneratedKeyHolder();
    //     PreparedStatementCreator psc = new PreparedStatementCreator() {

    //         @Override
    //         public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
    //             LocalDateTime currentTime= LocalDateTime.now();
    //             PreparedStatement ps = con.prepareStatement(INSERT_SQL, new String[] {"id"});
    //             ps.setString(1, product.getSku());
    //             ps.setString(2, product.getName());
    //             ps.setString(3, product.getDescription());
    //             ps.setString(4, product.getImageUrl());
    //             ps.setBoolean(5, product.getActive());
    //             ps.setInt(6, product.getUnitsInStock());
    //             ps.setDouble(7, product.getUnitPrice());
    //             ps.setInt(8, product.getCategoryId());
    //             ps.setObject(9, currentTime);
    //             ps.setObject(10, currentTime);
    //             return ps;
    //         }
    //     };
    //     jdbcTemplate.update(psc, generatHolder);
    //     Integer returnedId = generatHolder.getKey().intValue();
    //     return returnedId;
    // }
