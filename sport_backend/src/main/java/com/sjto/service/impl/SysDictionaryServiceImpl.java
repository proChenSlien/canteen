package com.sjto.service.impl;

import com.sjto.domain.SysDictionary;
import com.sjto.dto.vo.SysDictionaryVo;
import com.sjto.repository.SysDictionaryRepository;
import com.sjto.service.SysDictionaryService;
import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("sysDictionaryService")
public class SysDictionaryServiceImpl extends AbstractGenericServiceImpl<SysDictionary, Long> implements SysDictionaryService {

    @Autowired
    private SysDictionaryRepository repository;

    @Override
    public JpaRepository<SysDictionary, Long> getRepository() {
        return repository;
    }


    @Override
    public List<SysDictionaryVo> findDictionaryInfoByGroupId(Long id) {
        List<SysDictionaryVo> queryList = repository.findDictionaryInfoByGroupId(id);
        if (queryList == null) {
            return null;
        }
        return queryList;
    }

    @Override
    public Map<String, Object> findDictionaryInfoById(Long id) {
        SysDictionaryVo sysDictionaryVo = repository.findDictionaryInfoById(id);
        if (sysDictionaryVo==null) {
            return null;
        }
        Map<String, Object> result = new HashMap<>();
        result.put("sd_id", sysDictionaryVo.getSd_id());
        result.put("sd_val", sysDictionaryVo.getValue());
        result.put("sd_remark", sysDictionaryVo.getLabel());
        result.put("sd_orderNum", sysDictionaryVo.getSd_orderNum());
        result.put("sdg_groupName", sysDictionaryVo.getSdg_groupName());
        result.put("sdg_groupRemark", sysDictionaryVo.getSdg_groupRemark());
        result.put("sdg_orderNum", sysDictionaryVo.getSd_orderNum());

        return result;
    }

    @Override
    public List<Map<String, Object>> findDictionaryList() {
        List<Map<String, Object>> result = new ArrayList<>();

        List<SysDictionaryVo> list = repository.findDictionaryList();

        for (SysDictionaryVo item : list) {
            Map<String, Object> map = new HashMap<>();
            map.put("sd_id", item.getSd_id());
            map.put("sd_val", item.getValue());
            map.put("sd_remark", item.getLabel());
            map.put("sd_orderNum", item.getSd_orderNum());
            map.put("sdg_groupName", item.getSdg_groupName());
            map.put("sdg_groupRemark", item.getSdg_groupRemark());
            result.add(map);
        }
        return result;
    }
}
