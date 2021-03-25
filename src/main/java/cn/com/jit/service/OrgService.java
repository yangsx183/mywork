package cn.com.jit.service;

import cn.com.jit.mapper.OrgMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class OrgService {
    @Autowired
    OrgMapper orgMapper;

    public void addOrg(Map<String,String> map){
        Map<String,String> form = new HashMap<>();
        if(CollectionUtils.isEmpty(map)){
            return;
        }else{
            //封装OU_DEPT数据
            form.put("DEPT_ID",map.get("orgId"));
            form.put("DEPT_NAME",map.get("orgName"));
            form.put("DEPT_CODE",map.get("orgCode"));
            form.put("PARENT",map.get("orgPid"));
            form.put("STATUS","10");
            form.put("ORG_ID","root");
            form.put("CREATE_USER","admin");
            form.put("MODIFY_USER","admin");
        }
        List<Map<String,Object>> orgList = orgMapper.listOrg(form);
        if(CollectionUtils.isEmpty(orgList)){
            //列表为空或者长度为0--插入
            orgMapper.insertOrg(form);
        }else{
            //更新
            orgMapper.updateOrg(form);
        }
    }

    public void deleteOrg(Map<String,String> map){
        map.put("DEPT_ID",map.get("orgId"));
        orgMapper.deleteOrg(map);
    }
}
