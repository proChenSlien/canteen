package com.sjto.service.impl;

import com.sjto.domain.SysDictionary;
import com.sjto.dto.vo.SysDictionaryVo;
import com.sjto.repository.SysDictionaryRepository;
import com.sjto.service.SysDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service("sysDictionaryService")
public class SysDictionaryServiceImpl extends AbstractGenericServiceImpl<SysDictionary, Long> implements SysDictionaryService {

    @Autowired
    private SysDictionaryRepository repository;

    @Override
    public JpaRepository<SysDictionary, Long> getRepository() {
        return repository;
    }


    @Override
    public Map<String, Object> findDictionaryInfoById(Long id) {
        SysDictionaryVo sysDictionaryVo = repository.findDictionaryInfoById(id);
        if (sysDictionaryVo==null) {
            return null;
        }
        Map<String, Object> result = new HashMap<>();
        result.put("sd_id", sysDictionaryVo.getSd_id());
        result.put("sd_val", sysDictionaryVo.getSd_val());
        result.put("sd_remark", sysDictionaryVo.getSd_remark());
        result.put("sd_orderNum", sysDictionaryVo.getSd_orderNum());
        result.put("sdg_groupName", sysDictionaryVo.getSdg_groupName());
        result.put("sdg_groupRemark", sysDictionaryVo.getSdg_groupRemark());
        result.put("sdg_orderNum", sysDictionaryVo.getSd_orderNum());

        return result;
    }
}
