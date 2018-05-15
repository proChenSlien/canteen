package com.sjto.repository;

import com.sjto.domain.SysDictionaryGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

/**
 * @Description:
 * @Author: chenpeng
 * @Date: 2018/5/15  17:58
 */
@Repository
public interface SysDicGroupRepository extends JpaRepository<SysDictionaryGroup, Long>, QuerydslPredicateExecutor<SysDictionaryGroup> {
}
