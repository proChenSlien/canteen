package com.sjto.repository;

import com.sjto.domain.FamilyTiesInfo;
import com.sjto.dto.vo.FamilyTiesVo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FamilyTiesInfoRepository extends JpaRepository<FamilyTiesInfo, Long>, JpaSpecificationExecutor<FamilyTiesInfo> {

    @Query(value = "select new com.sjto.dto.vo.FamilyTiesVo(f.id, f.userId, f.shipName, f.phone, vs.authImgUrl" +
            ") from FamilyTiesInfo f " +
            "left join VipSingleGymcardInfo vs on f.userid = vs.userId " +
            "where f.id = ?1")
    List<FamilyTiesVo> findListFamily(Long id);
}
