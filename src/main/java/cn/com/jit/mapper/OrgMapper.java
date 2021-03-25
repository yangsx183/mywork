package cn.com.jit.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface OrgMapper {
    void insertOrg(Map<String,String> map);

    List<Map<String,Object>> listOrg(Map<String,String> map);

    void updateOrg(Map<String,String> map);

    void deleteOrg(Map<String,String> map);
}
