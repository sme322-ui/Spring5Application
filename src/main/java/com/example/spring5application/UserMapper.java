package com.example.spring5application;

import org.hibernate.usertype.UserType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class UserMapper implements RowMapper<User> , PreparedStatementSetter {
    private final String name;
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public UserMapper() {
        name = new String();
    }

    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        User user = new User();
        user.setId(rs.getLong("ID"));
        user.setName(rs.getString("USERNAME"));
        user.setAge(rs.getInt("age"));

        return user;
    }
    @Test
    @DisplayName("find-all-users-test")
    void findAllUsersTest() {
        String sql = "SELECT * FROM USER";
        List<User> users = jdbcTemplate.query(sql, new UserMapper());
        assertTrue(users.size() == 12);
        users.forEach(System.err::println); // just to print  in red color
    }
    String sql = "SELECT * FROM USER";
    private UserType type;
    private UserType userType;
    List<User> users = jdbcTemplate.query(sql,
            new UserType[] { userType },
            new int[] { Types.VARCHAR },
            new BeanPropertyRowMapper(User.class));


    @Override
    public void setValues(PreparedStatement ps) throws SQLException {
        ps.setString(1, name);
        ps.setString(2, type.toString());
    }
}