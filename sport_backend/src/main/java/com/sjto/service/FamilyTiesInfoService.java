package com.sjto.service;

import com.sjto.domain.FamilyTiesInfo;
import com.sjto.domain.VipChildCardInfo;
import com.sjto.dto.vo.FamilyAndVipChild;
import com.sjto.dto.vo.FamilyTiesVo;

import java.util.List;
import java.util.Map;

public interface FamilyTiesInfoService extends BaseService<FamilyTiesInfo, Long> {

    List<Map<String, Object>> findListFamily(Long id);

    FamilyAndVipChild findChildMainUser(Long id);
}
