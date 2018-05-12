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

    @Modifying
    @Query("update VipSingleGymcardInfo set cid=?1, userId=?2, authImgUrl=?3, updateTime=?4 where id=?5")
    void update();

    Boolean existsByUserId(Long userId);

    VipSingleGymcardInfo findByUserId(Long userId);

}
