package cn.com.jit.service;

import cn.com.jit.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserService {

    @Autowired
    UserMapper userMapper;

    /**
     * 新增或更新用户
     * @param map
     */
    public void addUser(Map<String, String> map){
        Map<String,String> form = new HashMap<>();
        if(CollectionUtils.isEmpty(map)){
            return;
        }else{
            //封装OU_USER数据
            form.put("USER_ID",map.get("userId"));
            form.put("USER_NAME",map.get("name"));
            form.put("LOGIN_NAME",map.get("username"));
            form.put("USER_CODE",map.get("userCode"));
            form.put("PASSWORD","e10adc3949ba59abbe56e057f20f883e");
            form.put("START_DATE","2000-01-01");
            form.put("END_DATE","2099-12-31");
            form.put("STATUS","10");
            form.put("GENDER","1");
            form.put("PHONE",map.get("mobilePhone"));
            form.put("MOBILE",map.get("mobilePhone"));
            form.put("EMAIL",map.get("email"));
            //form.put("MODIFY_DATE","10");
            form.put("MODIFY_USER","admin");
            form.put("CREATE_USER","admin");

            form.put("DEPT_ID",map.get("orgId"));
        }
        List<Map<String, Object>> userList = userMapper.userList(map);
        if(CollectionUtils.isEmpty(userList)){
            //添加用户
            userMapper.insertUser(form);
            //添加用户部门关系
            userMapper.insertUserDept(form);
        }else{
            //更新用户
            userMapper.updateUser(form);
            //更新用户部门关系
            userMapper.updateUserDept(form);
        }
    }

    /**
     * 删除用户
     * @param map
     */
    public void deleteUser(Map<String, String> map){
        map.put("USER_ID",map.get("userId"));
        //删除用户
        userMapper.deleteUser(map);
        //删除用户部门关系
        userMapper.deleteUserDept(map);
    }


    public List<Map<String, Object>> userList() {
        return userMapper.userList(null);
    }
}
