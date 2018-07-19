package com.cp.repository;

import com.cp.domain.ValueVoucher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

/**
 * @author: Slien
 * @Date: 2018-06-13 17:37
 */
@Repository
public interface VVRepository extends JpaRepository<ValueVoucher, Long>,QuerydslPredicateExecutor<ValueVoucher> {
    @Modifying
    @Query(value = "update ValueVoucher set valid = 0 where id = ?1")
    void updateStaById(String id);
}
