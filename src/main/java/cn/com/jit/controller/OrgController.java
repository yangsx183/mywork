package cn.com.jit.controller;

import cn.com.jit.service.OrgService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping("/v1/org")
public class OrgController {
    @Autowired
    OrgService orgService;

    @ResponseBody
    @RequestMapping("/orgSynchronous")
    public Object orgSynchronous(@RequestBody Map<String,String> map) {

        for(String key : map.keySet()){
            System.out.println("key-->"+key+",value-->"+map.get(key));
        }

        String type = map.get("type");

        if("add".equals(type)){
            orgService.addOrg(map);
        }else if("delete".equals(type)){
            orgService.deleteOrg(map);
        }
        return JSONObject.parse("{\"code\":\"0\",\"message\":\"success\"}");
    }

}
