package com.sjto.service.impl;

import com.sjto.domain.SysButtonInfo;
import com.sjto.repository.SysButtonInfoRepository;
import com.sjto.service.SysButtonInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

/**
 * @Description: 按钮信息Service接口层
 * @Author: fanyongjiu
 * @Date: 18/5/11 11:35
 */
@Service("sysButtonInfo")
public class SysButtonInfoServiceImpl extends AbstractGenericServiceImpl<SysButtonInfo, Long> implements SysButtonInfoService {

    @Autowired
    private SysButtonInfoRepository repository;

    @Override
    public JpaRepository<SysButtonInfo, Long> getRepository() {
        return repository;
    }
}
