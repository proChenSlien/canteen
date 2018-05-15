package com.sjto.service.impl;

import com.sjto.domain.SysDictionary;
import com.sjto.dto.vo.SysDictionaryVo;
import com.sjto.repository.SysDictionaryRepository;
import com.sjto.service.SysDictionaryService;
import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

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
}
