package com.sjto.service.impl;

import com.sjto.domain.FamilyTiesInfo;
import com.sjto.domain.VipChildCardInfo;
import com.sjto.dto.vo.FamilyAndVipChild;
import com.sjto.dto.vo.FamilyTiesVo;
import com.sjto.dto.vo.VipSingleAndFamily;
import com.sjto.dto.vo.VipSingleGymcardInfoVo;
import com.sjto.repository.FamilyTiesInfoRepository;
import com.sjto.service.FamilyTiesInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName FamilyTiesInfoServiceImpl
 * @Description
 * @Author wangsai
 * @Date 2018/5/13 15:02
 **/
@Service("familyTiesInfoService")
public class FamilyTiesInfoServiceImpl extends AbstractGenericServiceImpl<FamilyTiesInfo, Long> implements FamilyTiesInfoService {

    @Autowired
    private FamilyTiesInfoRepository repository;

    @Override
    public JpaRepository<FamilyTiesInfo, Long> getRepository() {
        return repository;
    }

    @Override
    public List<Map<String, Object>> findListFamily(Long id) {
        List<Map<String, Object>> result = new ArrayList<>();

        List<FamilyTiesVo> list = repository.findListFamily(id);

        for (FamilyTiesVo item : list) {
            Map<String, Object> map = new HashMap<>();
            map.put("id", item.getId());
            map.put("userId", item.getUserId());
            map.put("shipName", item.getShipName());
            map.put("phone", item.getPhone());
            map.put("authImgUrl", item.getAuthImgUrl());
            result.add(map);
        }
        return result;
    }

    @Override
    public FamilyAndVipChild findChildMainUser(Long id) {
        return repository.findChildMainUser(id);
    }

    @Override
    public boolean userIdIsExist(Long id) {
        List<VipSingleAndFamily> list = repository.userIdIsExist(id);
        if(list.size() == 0){
            return false;
        }else {
            return true;
        }
    }


}
