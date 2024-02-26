package com.example.demo.repository;

import com.example.demo.model.Address;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class AddressRepository {
    private JdbcTemplate jdbcTemplate;

    public AddressRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Address findById(Integer id) {
        String sql = "SELECT * FROM address WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new RowMapper<Address>() {
            @Override
            public Address mapRow(ResultSet result, int rowNum) throws SQLException {
                Address address = new Address();
                address.setId(result.getInt("id"));
                address.setStreet(result.getString("street"));
                address.setNumber(result.getInt("number"));
                address.setPostcode(result.getString("postcode"));
                return address;
            }
        });
    }
}
