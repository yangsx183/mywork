package cn.com.jit.controller;

import cn.com.jit.service.UserService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/v1/user")
public class UserController {

    @Autowired
    UserService userService;

    @ResponseBody
    @RequestMapping("/userSynchronous")
    public Object userSynchronous(@RequestBody Map<String,String> map) {
        for(String key : map.keySet()){
            System.out.println("key-->"+key+",value-->"+map.get(key));
        }
        String type = map.get("type");
        if("add".equals(type)){
            userService.addUser(map);
        }else if("delete".equals(type)){
            userService.deleteUser(map);
        }
        return JSONObject.parse("{\"code\":\"0\",\"message\":\"success\"}");
    }

    @ResponseBody
    @RequestMapping("/userlist")
    public List<Map<String,Object>> userList(){
        return userService.userList();
    }

}
