package com.sjto.repository;

import com.sjto.domain.FamilyTiesInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface FamilyTiesInfoRepository extends JpaRepository<FamilyTiesInfo, Long>, JpaSpecificationExecutor<FamilyTiesInfo> {

}
