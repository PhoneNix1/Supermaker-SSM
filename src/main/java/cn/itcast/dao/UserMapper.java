package cn.itcast.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import cn.itcast.domain.User;
//持久层包括数据库表映射的User.java的JavaBean对象，并使用了MyBatis的注解映射了对应的SQL语句
public interface UserMapper {
    @Select("select * from tb_user where user_name=#{userName} and password=#{password} and role=#{role}")
    User findWithLoginAndPassword(@Param("userName")String userName,@Param("password")String password,@Param("role")Integer role);
}
