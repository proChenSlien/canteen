package com.sjto.service.impl;

import com.sjto.domain.VipChildCardInfo;
import com.sjto.repository.VipChildCardInfoRepository;
import com.sjto.service.VipChildCardInfoService;
import com.sjto.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

/**
 * @ClassName VipChildCardInfoServiceImpl
 * @Description
 * @Author wangsai
 * @Date 2018/5/12 17:55
 **/
@Service("vipChildCardInfoService")
public class VipChildCardInfoServiceImpl extends AbstractGenericServiceImpl<VipChildCardInfo, Long> implements VipChildCardInfoService {

    @Autowired
    private VipChildCardInfoRepository repository;

    @Override
    public JpaRepository<VipChildCardInfo, Long> getRepository() {
        return repository;
    }

    @Override
    public Result<VipChildCardInfo> queryByUserId(Long userId) {

        return null;
    }
}
