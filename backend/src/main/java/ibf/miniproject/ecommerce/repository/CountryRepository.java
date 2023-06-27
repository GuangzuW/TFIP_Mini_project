package ibf.miniproject.ecommerce.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import ibf.miniproject.ecommerce.model.Country;

@Repository
public class CountryRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    private static final String SELECT_SQL = "select * from country";
    private static final String SELECT_BY_ID_SQL = "select * from country where id = ?";

    public List<Country> findAll() {
        return jdbcTemplate.query(SELECT_SQL, BeanPropertyRowMapper.newInstance(Country.class));
    }

    public Country findById(Integer id) {
        return jdbcTemplate.queryForObject(SELECT_BY_ID_SQL, BeanPropertyRowMapper.newInstance(Country.class), id);
    }
    
}
