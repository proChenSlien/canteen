package com.sjto.repository;

import com.sjto.domain.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface CardReponsitory extends JpaRepository<Card, Long>,QuerydslPredicateExecutor<Card> {

    @Modifying
    @Query("update Card set name=?1, type=?2, status=?3, bgImgUrl=?4, updateTime=?5 where id=?6")
    void update(String name, Integer type, Integer status,String bgImgUrl, Date updateTime, Long id);
}
