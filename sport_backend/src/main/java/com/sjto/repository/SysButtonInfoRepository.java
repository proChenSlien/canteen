package com.sjto.repository;

import com.sjto.domain.SysButtonInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

/**
 * @Description: 按钮信息DAO接口层
 * @Author: fanyongjiu
 * @Date: 18/5/11 11:12
 */
@Repository
public interface SysButtonInfoRepository extends JpaRepository<SysButtonInfo, Long>, JpaSpecificationExecutor<SysButtonInfo> {
    /**
     * 按钮信息
     *
     * @param type
     * @return
     */
    SysButtonInfo findByType(String type);

    SysButtonInfo findByTypeAndIdNot(String type, Long id);

}
