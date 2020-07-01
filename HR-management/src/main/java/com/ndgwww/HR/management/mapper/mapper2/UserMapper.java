package com.ndgwww.HR.management.mapper.mapper2;
import com.ndgwww.HR.management.pojo.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;


@Mapper
public interface UserMapper {
    @Results(id="UserResult",value = {
            @Result(property = "username", column = "username",jdbcType= JdbcType.VARCHAR),
            @Result(property = "password", column = "password",jdbcType=JdbcType.VARCHAR),
            @Result(property = "email", column = "email",jdbcType=JdbcType.VARCHAR),
    })
    @Select("select * from management  where email = #{email}")
     //@ResultMap(value="UserResult")
    User Email(@Param("email") String email);


    @Select("select * from management  where username = #{username}")
        //@ResultMap(value="UserResult")
    User Login(@Param("username") String username);


    @Insert("insert into management value ( #{username},#{password},#{email})")
        @ResultMap(value="UserResult")
    Integer Zhuce(@Param("username") String username, @Param("password") String password, @Param("email") String email);


}
