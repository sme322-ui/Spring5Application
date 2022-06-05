package com.example.spring5application;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import javax.annotation.Resource;
import java.util.List;
import static org.junit.Assert.assertTrue;
@SpringBootTest
public class UserControllerTest {

    @Resource(name = "jdbcTemplate")
    private JdbcTemplate jdbcTemplate;

    @Test
    public void createUserTable() throws Exception{
        String sql = "CREATE TABLE `user` (\n"+
                     "`username` varchar(100) DEFAULT NULL,\n"+
                     "`password` varchar(100) DEFAULT NULL,\n"+
                     ") ENGINE=lnnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;\n"+
                     "\n";
            jdbcTemplate.execute(sql);
    }
   @Test
   public void saveUserTest() throws Exception{
        String sql = "INSERT INTO user(USERNAME,PASSWORD) VALUES('longzhiran','123456')";
        int rows = jdbcTemplate.update(sql);
        System.out.print(rows);
    }
    @Test
    public void getUserByName() throws Exception{
        String name = "longzhiran";
        String sql = "SELECT * FROM user WHERE USERNAME= ?";
        List<User1> list = jdbcTemplate.query(sql,new User1(),new Object[]{name});

        for(User1 user:list){
            System.out.println(user);
        }


    }
    @Test
    @DisplayName("find-all-users-test")
   public void findAllUsersTest() {
        String sql = "SELECT * FROM USER";
        List<User> users = jdbcTemplate.query(sql, new UserMapper());
        assertTrue(users.size() == 12);
        users.forEach(System.err::println); // just to print  in red color
    }

}
