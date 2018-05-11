package com.sjto.repository;

import com.sjto.domain.VenuePackages;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface VenuePackRepository extends JpaRepository<VenuePackages,Long>,QuerydslPredicateExecutor<VenuePackages> {

}
