package com.sjto.repository;

import com.sjto.domain.VipSingleGymcardInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import java.util.Date;

/**
 * @ClassName VipSingleGymcardInfoReponsitory
 * @Description
 * @Author wangsai
 * @Date 2018/5/11 15:34
 **/
@Repository
public interface VipSingleGymcardInfoReponsitory extends JpaRepository<VipSingleGymcardInfo,Long>,QuerydslPredicateExecutor<VipSingleGymcardInfo> {

    Boolean existsByUserId(Long userId);

    @Query("select o from VipSingleGymcardInfo o where o.userId=?1 and o.status = 1")
    VipSingleGymcardInfo findByUserId(Long userId);

    @Modifying
    @Query("update VipSingleGymcardInfo o set o.authState=?2 where o.id = ?1")
    void updateAuthState(Long id, Integer authState);
}
