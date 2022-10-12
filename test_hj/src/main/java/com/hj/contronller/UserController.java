package com.hj.contronller;

import com.hj.mapper.UserMapper;
import com.hj.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin  //跨域注解

public class UserController {
    @Autowired
    private UserMapper userMapper;
    @ResponseBody
    @GetMapping("/queryUserList")
    public List<User> queryUserList(){
        List<User> users = userMapper.queryUserList();
        for (User user : users) {
            System.out.println(user);
        }
        return users;
    }

    @GetMapping("/delUser")
    public int delUser(Integer id){
        int i = userMapper.delUserById(id);
        if (i!=0) System.out.println("删除成功");
        System.out.println("我是ID"+id);
        return i;
    }

    @PostMapping("/addUser")
    public Map<String,Object> addUser(@RequestBody User user) {
        Map<String, Object> map = new HashMap<>();
        try {
            int i = userMapper.addUser(user.getId(), user.getNamne(), user.getPwd());
            if (i != 0) {

                map.put("msg", "芜湖");
                map.put("attr","0");
                return map;

            }
        } catch (Exception e) {
            map.put("msg", "主键不能重复!");
            map.put("attr","1");
            return map;
        }
        return map;
    }

    @PostMapping("/editUser")
    public Map<String,Object> editUser(@RequestBody User user){
        Map<String, Object> map = new HashMap<>();

        int i = userMapper.updataUserById(user.getId(), user.getNamne(), user.getPwd());
        if (i!=0){
            map.put("msg","修改成功");
        }else {
            map.put("msg","出错了");
        }
        return map;
    }



}
