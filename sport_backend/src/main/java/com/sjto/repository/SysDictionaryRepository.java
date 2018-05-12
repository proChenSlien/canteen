package com.sjto.repository;

import com.sjto.domain.SysDictionary;
import com.sjto.dto.vo.SysDictionaryVo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SysDictionaryRepository extends JpaRepository<SysDictionary,Long>,QuerydslPredicateExecutor<SysDictionary> {

    @Query(value = "select new com.sjto.dto.vo.SysDictionaryVo(sd.id, sd.val, sd.remark, sd.orderNum, sdg.groupName, sdg.groupRemark, sdg.orderNum) from SysDictionary sd " +
            "left join SysDictionaryGroup sdg on sdg.groupId = sd.groupId " +
            "where sd.id = ?1")
    SysDictionaryVo findDictionaryInfoById(Long id);
}
