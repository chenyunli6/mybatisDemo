package com.yunli.mybatis.mybatisDemo.resource;

import com.yunli.mybatis.mybatisDemo.model.User;
import com.yunli.mybatis.mybatisDemo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserResource {
    @Autowired
    private UserMapper userMapper;

    @GetMapping("/users")
    public List<User> getAll() {
        return userMapper.findAll();
    }

    @PostMapping("/users")
    public List<User> addUser(User user) {
        userMapper.insert(user);
        return userMapper.findAll();
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable("id") Integer id) {
        User user = userMapper.findOne(id);
        if(null != user){
            userMapper.delete(id);
        }
    }

    @PatchMapping("/users/{id}")
    public Integer updateUser(User user) {
        User oldUser = userMapper.findOne(user.getId());
        if(null != oldUser){
            return userMapper.update(user);
        }
        return 0;
    }
}
