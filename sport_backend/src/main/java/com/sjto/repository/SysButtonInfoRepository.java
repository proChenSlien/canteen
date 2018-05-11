package com.sjto.repository;

import com.sjto.domain.SysButtonInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

/**
 * @Description: 按钮信息DAO接口层
 * @Author: fanyongjiu
 * @Date: 18/5/11 11:12
 */
public interface SysButtonInfoRepository extends JpaRepository<SysButtonInfo,Long>,QuerydslPredicateExecutor<SysButtonInfo> {

}
