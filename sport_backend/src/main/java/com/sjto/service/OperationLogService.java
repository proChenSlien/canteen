package com.sjto.service;

import com.sjto.domain.OperationLog;

public interface OperationLogService extends BaseService<OperationLog, Long> {

    void addOperationLog(OperationLog entity);

}
