package com.sjto.repository;

import com.sjto.domain.FamilyTiesInfo;
import com.sjto.dto.vo.FamilyAndVipChild;
import com.sjto.dto.vo.FamilyTiesVo;
import com.sjto.dto.vo.VipSingleAndFamily;
import com.sjto.dto.vo.VipSingleGymcardInfoVo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FamilyTiesInfoRepository extends JpaRepository<FamilyTiesInfo, Long>, JpaSpecificationExecutor<FamilyTiesInfo> {

    @Query(value = "select new com.sjto.dto.vo.FamilyTiesVo(f.id, f.userId, f.shipName, f.phone, vs.authImgUrl" +
            ") from FamilyTiesInfo f " +
            "left join VipSingleGymcardInfo vs on f.userId = vs.userId " +
            "where f.sid = ?1")
    List<FamilyTiesVo> findListFamily(Long id);

    @Query(value = "select new com.sjto.dto.vo.FamilyAndVipChild(v.mainUserId) " +
            "from VipChildCardInfo v  " +
            "where v.id = ?1" )
    FamilyAndVipChild findChildMainUser(Long id);

    @Query(value = "select new com.sjto.dto.vo.VipSingleAndFamily(v.id " +
            ") from VipSingleGymcardInfo v " +
            "where v.userId = ?1 and v.status = 1")
    List<VipSingleAndFamily> userIdIsExist(Long id);
}
