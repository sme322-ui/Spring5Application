package com.example.spring5application;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@SuppressWarnings("ALL")
public class User1 implements RowMapper<User1>,IUserDAO
{
    private int id;
    private String username;
    private String password;



    @Override
    public User1 mapRow(ResultSet resultSet, int i) throws SQLException {
        User1 user = new User1();
        user.setId(resultSet.getInt("id"));
        user.setUsername(resultSet.getString("username"));
        user.setPassword(resultSet.getString("password"));


        return user;
    }

    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void insert(User user) {
        String name = user.getName();
        int age = user.getAge();

        jdbcTemplate.update("INSERT INTO user (name,age) "
                + "VALUES('" + name + "'," + age + ")");
    }

    public User find(Integer id) {
        List rows = jdbcTemplate.queryForList(
                "SELECT * FROM user WHERE id=" + id.intValue());

        Iterator it = rows.iterator();
        if(it.hasNext()) {
            Map userMap = (Map) it.next();

            Integer i = new Integer(userMap.get("id").toString());
            String name = userMap.get("name").toString();
            Integer age =
                    new Integer(userMap.get("age").toString());

            User user = new User();
            user.setId(i);
            user.setName(name);
            user.setAge(age);

            return user;
        }

        return null;
    }
    private void setPassword(String password) {
        this.password = password;
    }

    private void setUsername(String username) {
        this.username = username;
    }


    private void setId(int id) {
        this.id = id;
    }
}
