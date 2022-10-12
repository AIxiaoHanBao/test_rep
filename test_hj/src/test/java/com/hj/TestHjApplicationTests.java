package com.hj;

import com.hj.mapper.UserMapper;
import com.hj.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
public class TestHjApplicationTests {


    @Autowired
    UserMapper userMapper;

    @Test
    public void contextLoads() {
        User user = new User();
        for (int i = 0; i < 10; i++) {
            user.setId(i);
            user.setNamne("芜湖"+i);
            user.setPwd("123");
            userMapper.addUser(user.getId(),user.getNamne(),user.getPwd());
        }

    }

}
