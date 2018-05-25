package com.cp.repository;

import com.cp.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

/**
 * @author: Slien
 * @Date: 2018-05-24 15:28
 */
@Repository
public interface OrderRepository extends JpaRepository<Order, Long>,QuerydslPredicateExecutor<Order> {
}
