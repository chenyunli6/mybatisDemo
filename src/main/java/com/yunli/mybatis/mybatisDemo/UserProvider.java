package com.yunli.mybatis.mybatisDemo;

import com.yunli.mybatis.mybatisDemo.model.User;
import org.apache.ibatis.jdbc.SQL;

public class UserProvider {
    public String updateUser(User user) {
        return new SQL() {
            {
               UPDATE("users");
               if (null != user.getName()) {
                   SET("name = #{name}");
               }
               if (null != user.getSalary()) {
                   SET("salary = #{salary}");
               }
               WHERE("id = #{id}");
            }
        }.toString();
    }
}
