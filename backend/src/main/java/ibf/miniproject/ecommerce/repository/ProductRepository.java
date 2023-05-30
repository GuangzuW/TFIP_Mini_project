package ibf.miniproject.ecommerce.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import ibf.miniproject.ecommerce.model.Product;
@Repository
public class ProductRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    private static final String SELECT_SQL = "select * from product";
    private static final String SELECTBYID_SQL = "select * from product where id = ?";
    private static final String INSERT_SQL = "insert into product (sku, name, description, image_url, active, units_in_stock,unit_price, category_id, date_created, last_updated) values (?,?,?,?,?,?,?,?,?,?)";
    private static final String UPDATE_SQL = "update product set sku = ?, name = ? , description = ?, image_url = ?, active = ?, units_in_stock = ?,unit_price = ?, category_id = ?, last_update=? where id = ?";
    private static final String DELETE_SQL = "delete from product where id = ?";
    private static final String SELECTBYCATEGORYID_SQL = "select * from product where category_id = ?";
    private static final String SELECTBYKEYWORD = "select * from product p where p.name like concat('%',?,'%') or p.description like concat('%',?,'%')";

    public List<Product> findAll() {
        return jdbcTemplate.query(SELECT_SQL, BeanPropertyRowMapper.newInstance(Product.class));
    }

    public Product findById(Integer id){
        return jdbcTemplate.queryForObject(SELECTBYID_SQL, BeanPropertyRowMapper.newInstance(Product.class), id);
    }

    public Integer createProduct(Product product){
        KeyHolder generatHolder = new GeneratedKeyHolder();
        PreparedStatementCreator psc = new PreparedStatementCreator() {

            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                LocalDateTime currentTime= LocalDateTime.now();
                PreparedStatement ps = con.prepareStatement(INSERT_SQL, new String[] {"id"});
                ps.setString(1, product.getSku());
                ps.setString(2, product.getName());
                ps.setString(3, product.getDescription());
                ps.setString(4, product.getImageUrl());
                ps.setBoolean(5, product.getActive());
                ps.setInt(6, product.getUnitsInStock());
                ps.setDouble(7, product.getUnitPrice());
                ps.setInt(8, product.getCategoryId());
                ps.setObject(9, currentTime);
                ps.setObject(10, currentTime);
                return ps;
            }
        };
        jdbcTemplate.update(psc, generatHolder);
        Integer returnedId = generatHolder.getKey().intValue();
        return returnedId;
    }

    public int updateProduct(Product product){
        return jdbcTemplate.update(UPDATE_SQL, product.getSku(), product.getName(),product.getDescription()
                                , product.getImageUrl(), product.getActive(), product.getUnitsInStock()
                                , product.getUnitPrice(), product.getCategoryId(), LocalDateTime.now(),product.getId());
    }

    public int deleteProduct(Integer id){
        return jdbcTemplate.update(DELETE_SQL, id);
    }

    public List<Product> findByCategoryId(Integer id){
        return jdbcTemplate.query(SELECTBYCATEGORYID_SQL, BeanPropertyRowMapper.newInstance(Product.class), id);
    }

    public List<Product> findByKeyword(String keyword){
        return jdbcTemplate.query(SELECTBYKEYWORD, BeanPropertyRowMapper.newInstance(Product.class), keyword, keyword);
    }
}
