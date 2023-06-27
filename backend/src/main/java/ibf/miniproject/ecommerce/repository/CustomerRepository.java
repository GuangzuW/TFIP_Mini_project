package ibf.miniproject.ecommerce.repository;

import ibf.miniproject.ecommerce.model.Customer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    private static final String SELECT_SQL = "select * from customer";
    private static final String INSERT_SQL = "insert into customer (first_name, last_name, email) values (?, ?, ?)";

    public List<Customer> findAll() {
        return jdbcTemplate.query(SELECT_SQL, BeanPropertyRowMapper.newInstance(Customer.class));
    }

    public Integer createCustomer(Customer customer) {
        return jdbcTemplate.update(INSERT_SQL, customer.getFirstName(), customer.getLastName(), customer.getEmail());
    }
    
}
