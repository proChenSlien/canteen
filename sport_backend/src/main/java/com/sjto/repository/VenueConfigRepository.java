package com.sjto.repository;

import com.sjto.domain.VenueConfigure;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VenueConfigRepository extends JpaRepository<VenueConfigure,Long>,QuerydslPredicateExecutor<VenueConfigure> {

    @Query(value = "select id  from VenueConfigure " +
            "where kid = ?1 and oid = ?2")
    List<VenueConfigure> findVenueConfigure(Long kid, Long oid);

}
