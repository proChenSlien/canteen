package com.sjto.service.impl;

import com.sjto.domain.OperationLog;
import com.sjto.repository.OperationLogRepository;
import com.sjto.service.OperationLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service("operationLogService")
public class OperationLogServiceImpl extends AbstractGenericServiceImpl<OperationLog, Long> implements OperationLogService {

    @Autowired
    private OperationLogRepository repository;

    @Override
    public JpaRepository<OperationLog, Long> getRepository() {
        return repository;
    }

    @Override
    public void addOperationLog(OperationLog entity) {
        super.save(entity);
    }
}
