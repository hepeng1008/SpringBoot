package com.example.demo.dao;

import com.example.demo.restful.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void create(String name, Integer age) {
        jdbcTemplate.update("insert into USER(NAME,age) values (?,?)",name,age);
    }

    @Override
    public void deleteByName(String name) {
        jdbcTemplate.update("delete from USER where name=?",name);
    }

    @Override
    public Integer getUserCount() {
        return jdbcTemplate.queryForObject("select count(1) from user",Integer.class);
    }

    @Override
    public List<User> getAllUsers() {
        return jdbcTemplate.query("select * from user", new RowMapper<User>() {
            @Nullable
            @Override
            public User mapRow(ResultSet resultSet, int i) throws SQLException {
                User u = new User(); //一定要new
                u.setName(resultSet.getString("name"));
                u.setId(resultSet.getLong("id"));
                return u;
            }
        });
    }

    @Override
    public void deleteAllUsers() {
        jdbcTemplate.update("delete from USER ");
    }
}
