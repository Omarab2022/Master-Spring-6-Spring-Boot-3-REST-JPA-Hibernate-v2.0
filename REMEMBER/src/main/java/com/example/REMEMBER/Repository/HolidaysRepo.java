package com.example.REMEMBER.Repository;


import com.example.REMEMBER.Model.Holiday;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class HolidaysRepo {


    private final JdbcTemplate jdbcTemplate ;


    @Autowired
    public HolidaysRepo(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public List<Holiday> findAllHolidays(){
        String sql = "SELECT * FROM HOLIDAYS";

        /*

        BeanPropertyRowMapper: This is a built-in implementation of the RowMapper interface
         provided by Spring Framework. It maps rows of a ResultSet to instances of
         a specified class (in this case, the Holiday class) based on matching property
          names with column names in the ResultSet.

        * */

        var rowMapper = BeanPropertyRowMapper.newInstance(Holiday.class);
        return jdbcTemplate.query(sql,rowMapper);
    }
}
