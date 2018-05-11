package com.sjto.service.impl;

import com.sjto.domain.UseRecordInfo;
import com.sjto.dto.vo.UseRecordInfoVo;
import com.sjto.repository.UseRecordInfoRepository;
import com.sjto.service.UseRecordInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description: 使用记录BLL层实现类
 * @Author: fanyongjiu
 * @Date: 18/5/11 18:42
 */
@Service("useRecordInfoService")
public class UseRecordInfoServiceImpl extends AbstractGenericServiceImpl<UseRecordInfo, Long> implements UseRecordInfoService {
    @Autowired
    private UseRecordInfoRepository repository;

    @Override
    public JpaRepository<UseRecordInfo, Long> getRepository() {
        return repository;
    }

    @Override
    public List<UseRecordInfoVo> getList(Integer page, Integer pageSize, Long userId) {
        PageRequest pageRequest = PageRequest.of(page - 1, pageSize);
        return repository.findAll(userId, pageRequest);
    }
}
