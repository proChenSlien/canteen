package com.sjto.service.impl;

import com.sjto.domain.FamilyTiesInfo;
import com.sjto.dto.vo.FamilyTiesVo;
import com.sjto.repository.FamilyTiesInfoRepository;
import com.sjto.service.FamilyTiesInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public List<FamilyTiesVo> findListFamily(Long id) {
        return repository.findListFamily(id);
    }
}
