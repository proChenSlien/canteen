package com.sjto.repository;

import com.sjto.domain.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface CardReponsitory extends JpaRepository<Card, Long>,QuerydslPredicateExecutor<Card> {

}
