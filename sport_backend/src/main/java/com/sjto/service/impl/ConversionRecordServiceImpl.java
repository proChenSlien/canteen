package com.sjto.service.impl;

import com.sjto.domain.ConversionRecord;
import com.sjto.dto.vo.ConversionRecordVo;
import com.sjto.repository.ConversionRecordRepository;
import com.sjto.service.ConversionRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description: 兑换信息BLL层实现类
 * @Author: fanyongjiu
 * @Date: 18/5/12 11:01
 */
@Service("conversionRecordService")
public class ConversionRecordServiceImpl extends AbstractGenericServiceImpl<ConversionRecord, Long> implements ConversionRecordService {
    @Autowired
    private ConversionRecordRepository repository;
    
    @Override
    public JpaRepository<ConversionRecord, Long> getRepository() {
        return repository;
    }
}
