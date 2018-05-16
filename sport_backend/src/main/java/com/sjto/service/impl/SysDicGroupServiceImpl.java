package com.sjto.service.impl;

import com.sjto.domain.SysDictionaryGroup;
import com.sjto.repository.SysDicGroupRepository;
import com.sjto.service.SysDicGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * @Description:
 * @Author: chenpeng
 * @Date: 2018/5/15  17:55
 */
@Service("sysDicGroupService")
public class SysDicGroupServiceImpl extends AbstractGenericServiceImpl<SysDictionaryGroup, Long> implements SysDicGroupService {

    @Autowired
    private SysDicGroupRepository repository;
    @Override
    public JpaRepository<SysDictionaryGroup, Long> getRepository() {
        return repository;
    }

    @Override
    @Transactional
    public void deleteByGroupId(Long groupId) {
        repository.deleteByGroupId(groupId);
    }
}
