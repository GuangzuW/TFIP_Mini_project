package ibf.miniproject.ecommerce.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import ibf.miniproject.ecommerce.model.ProductCategory;

@Repository
public class ProductCategoryRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    private static final String SELECT_SQL = "select * from product_category";
    private static final String INSERT_SQL = "insert into product_category (category_name) values (?)";
    private static final String UPDATE_SQL = "update product_category set category_name = ? where id = ?";
    

    public List<ProductCategory> findAll() {
        return jdbcTemplate.query(SELECT_SQL, BeanPropertyRowMapper.newInstance(ProductCategory.class));
    }

    public Integer createProductCategory(String categoryName){
        KeyHolder generatedKeyHolder = new GeneratedKeyHolder();
        PreparedStatementCreator psc = new PreparedStatementCreator() {

            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                PreparedStatement ps= con.prepareStatement(INSERT_SQL, new String[] {"id"});
                ps.setString(1, categoryName);
                return ps;
            }
            
        };
        jdbcTemplate.update(psc, generatedKeyHolder);
        Integer returnedId = generatedKeyHolder.getKey().intValue();
        return returnedId;
    }

    public int updateProductCategory(Integer id, String categoryName){
        return jdbcTemplate.update(UPDATE_SQL, categoryName, id);
    }

    public int deleteProductCategory(Integer id){
        return jdbcTemplate.update("delete from product_category where id = ?", id);
    }
}
