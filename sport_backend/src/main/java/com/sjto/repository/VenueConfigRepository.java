package com.sjto.repository;

import com.sjto.domain.VenueConfigure;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface VenueConfigRepository extends JpaRepository<VenueConfigure,Long>,QuerydslPredicateExecutor<VenueConfigure> {


}
