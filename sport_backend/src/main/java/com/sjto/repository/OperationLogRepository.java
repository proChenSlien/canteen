package com.sjto.repository;

import com.sjto.domain.OperationLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface OperationLogRepository extends JpaRepository<OperationLog,Long>,QuerydslPredicateExecutor<OperationLog> {


}
