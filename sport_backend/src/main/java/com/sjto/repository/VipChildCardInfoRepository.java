package com.sjto.repository;

import com.sjto.domain.VipChildCardInfo;
import com.sjto.dto.ro.VipChildCardInfoRo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
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

    @Query("select a from VipChildCardInfo a where a.status = 1 and a.mainUserId = ?1 or id in (select sid from FamilyTiesInfo b where b.userId = ?1)")
    List<VipChildCardInfo> queryByUserId(Long userId);

    @Query("select a from VipChildCardInfo a where a.id = ?1 and a.status = 1")
    VipChildCardInfo queryById(Long id);

    @Modifying
    @Query("update VipChildCardInfo o set o.authState=?2 where o.id = ?1")
    void updateAuthState(Long id, Integer authState);

}
