package com.example.spring5application;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
@SuppressWarnings("ALL")
class UserDAO implements IUserDAO {
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
}