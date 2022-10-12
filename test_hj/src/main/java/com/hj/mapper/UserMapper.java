package com.hj.mapper;


import com.hj.pojo.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
//只有加了这个注解才表示了 mybatis 的一个类
@Repository
//被spring 整合
public interface UserMapper {


    List<User> queryUserList();

    @Select( "select * from user where test.id=id")
    User querUserById(Integer id);

    @Delete("delete from user where id=#{id}")
    int delUserById(@Param("id")int id);

    @Insert("insert into user(id,namne,pwd) value(#{id},#{namne},#{pwd})")
    int addUser(@Param("id")Integer id,@Param("namne")String namne,@Param("pwd")String pwd);

    @Update("update user set namne=#{namne},pwd=#{pwd} where id=#{id}")
    int updataUserById(@Param("id")Integer id,@Param("namne")String namne,@Param("pwd")String pwd);
}
