package cn.com.jit.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface UserMapper {
     void insertUser(Map<String,String> form);

     List<Map<String,Object>> userList(Map<String,String> form);

     void deleteUser(Map<String,String> form);

     void deleteUserDept(Map<String,String> form);

     void insertUserDept(Map<String,String> form);

     void updateUser(Map<String,String> form);

     void updateUserDept(Map<String,String> form);

}
