package com.sjto.repository;

import com.sjto.domain.VipChildCardInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @ClassName VipChildCardInfoRepository
 * @Description
 * @Author wangsai
 * @Date 2018/5/12 17:58
 **/
@Repository
public interface VipChildCardInfoRepository extends JpaRepository<VipChildCardInfo,Long>,QuerydslPredicateExecutor<VipChildCardInfo> {

    @Query(nativeQuery = true,value = "select a.* from vip_child_card_info a, family_ties_info b where a.id = b.sid and b.user_id = ?1 and a.status = 1")
    List<VipChildCardInfo> queryByUserId(Long userId);

    @Query(nativeQuery = true,value = "select a.* from vip_child_card_info a, family_ties_info b where a.id = b.sid and b.user_id = ?1 and a.id = ?2 and a.status = 1")
    VipChildCardInfo queryByUserIdAndId(Long userId, Long id);
}
