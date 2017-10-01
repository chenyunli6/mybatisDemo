package com.yunli.mybatis.mybatisDemo.mapper;

import com.yunli.mybatis.mybatisDemo.UserProvider;
import com.yunli.mybatis.mybatisDemo.model.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {

    @Select("select * from users")
    List<User> findAll();

    @Select("select * from users where id = #{id}")
    User findOne(Integer id);

    @Insert("insert into users(name, salary) values (#{name}, #{salary})")
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id",
        before = false, resultType = Integer.class)
    void insert(User user);

    @Delete("delete from users where id = #{id}")
    void delete(Integer id);

//    @Update("update users set name = #{name}, salary = #{salary} where id = #{id}")
//    void update(User user);
    @UpdateProvider(type = UserProvider.class, method = "updateUser")
    Integer update(User user);
}
