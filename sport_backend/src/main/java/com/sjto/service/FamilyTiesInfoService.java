package com.sjto.service;

import com.sjto.domain.FamilyTiesInfo;
import com.sjto.dto.vo.FamilyTiesVo;

import java.util.List;

public interface FamilyTiesInfoService extends BaseService<FamilyTiesInfo, Long> {

    List<FamilyTiesVo> findListFamily(Long id);
}
