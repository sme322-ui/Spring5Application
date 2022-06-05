package com.example.spring5application;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

@SuppressWarnings("ALL")
@SpringBootTest
class Spring5ApplicationTests {
    @Autowired
    private JdbcTemplate jdbcTemplate1;
    private UserRepository userService;


    @Test
    public void createUserTable() throws Exception{
        String sql = "CREATE TABLE `user` (\n"+
                     "`username` varchar(100) DEFAULT NULL,\n"+
                     "`password` varchar(100) DEFAULT NULL,\n"+
                     "PRIMARY KEY(`id`) \n"+
                     ")ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;\n"+
                     "\n";
        jdbcTemplate1.execute(sql);
    }
    @Test
    public void saveUserTest() throws Exception{
        String sql = "INSERT INTO user(USERNAME,PASSWORD) VALUES('longzhiran','123456')";
        int rows = jdbcTemplate1.update(sql);
        System.out.print(rows);
    }
    @Test
    public void getUserByName() throws Exception{
        String name = "longzhiran";
        String sql = "SELECT * FROM user WHERE USERNAME = ?";

        List<User> list = jdbcTemplate1.query(
                "SELECT * FROM user WHERE USERNAME = ?",
                new UserMapper());

        for(User user1:list){
            System.out.println(user1);

        }
    }
    @Test
    public void testUsingModifingAnnotation(){
        userService.updateUserEmailByName("longzhonghua","363694485@qq.com");
    }

    @Test
    void contextLoads() {
    }

}
