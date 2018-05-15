package com.sjto.repository;

import com.sjto.domain.SysDictionary;
import com.sjto.dto.vo.SysDictionaryVo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SysDictionaryRepository extends JpaRepository<SysDictionary, Long>, QuerydslPredicateExecutor<SysDictionary> {

    @Query(value = "select new com.sjto.dto.vo.SysDictionaryVo(sd.id, sd.val, sd.remark, sd.orderNum) from SysDictionary sd " +
            "where sd.groupId = ?1 and sd.status = 1")
    List<SysDictionaryVo> findDictionaryInfoByGroupId(Long id);

    /**
     * 查询所有字典值
     * @return
     */
    List<SysDictionary> findAll();

    @Query(value = "select new com.sjto.dto.vo.SysDictionaryVo(sd.id, sd.val, sd.remark, sd.orderNum, sdg.groupName, sdg.groupRemark, sdg.orderNum) from SysDictionary sd " +
            "left join SysDictionaryGroup sdg on sdg.groupId = sd.groupId " +
            "where sd.id = ?1")
    SysDictionaryVo findDictionaryInfoById(Long id);


    @Query(value = "select new com.sjto.dto.vo.SysDictionaryVo(sd.id, sd.val, sd.remark, sd.orderNum, sdg.groupName, sdg.groupRemark, sdg.orderNum) from SysDictionary sd " +
            "left join SysDictionaryGroup sdg on sdg.groupId = sd.groupId " +
            "where sd.status = 1 ")
    List<SysDictionaryVo> findDictionaryList();
}
