package com.cp.repository;

import com.cp.domain.Goods;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

/**
 * @author: Slien
 * @Date: 2018-05-24 14:27
 */
@Repository
public interface GoodsRepository extends JpaRepository<Goods, Long>,QuerydslPredicateExecutor<Goods> {
}
