package com.sjto.service.impl;

import com.google.common.collect.Maps;
import com.sjto.domain.VipSingleGymcardInfo;
import com.sjto.enums.AuthState;
import com.sjto.repository.VipSingleGymcardInfoReponsitory;
import com.sjto.service.VipSingleGymcardInfoService;
import com.sjto.utils.Result;
import com.sjto.utils.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.Map;
import java.util.Optional;

/**
 * @ClassName VipSingleGymcardInfoServiceImpl
 * @Description
 * @Author wangsai
 * @Date 2018/5/11 15:32
 **/
@Service("vipSingleGymcardInfoService")
public class VipSingleGymcardInfoServiceImpl extends AbstractGenericServiceImpl<VipSingleGymcardInfo, Long> implements VipSingleGymcardInfoService {

    @Autowired
    private VipSingleGymcardInfoReponsitory  reponsitory;

    public Result<Map> getAuthState(Long id){
        Optional<VipSingleGymcardInfo> optional= findById(id);
        if(!optional.isPresent()){
            return Result.createBySuccess(AuthState.NO_AUTHED.toMap());
        }
        VipSingleGymcardInfo vipSingleGymcardInfo = optional.get();
        switch (vipSingleGymcardInfo.getAuthState()){
            case 2:
                return Result.createBySuccess(AuthState.IN_AUTHING.toMap());
            case 3:
                return Result.createBySuccess(AuthState.AUTHED.toMap());
            case 4:
                return Result.createBySuccess(AuthState.FALSE_AUTH.toMap());
            default:
                return Result.createByErrorMessage("非法的认证信息");
        }
    }

    @Override
    @Transactional
    public Result<VipSingleGymcardInfo> saveOrUpdate (VipSingleGymcardInfo vipSingleGymcardInfo){
        vipSingleGymcardInfo.setUpdateTime(new Date());
        Long id = vipSingleGymcardInfo.getId();
        try {
            if((id != null && !findById(id).isPresent()) || id == null){// 如果ID为空 或者数据不存在
                vipSingleGymcardInfo.setCreateTime(new Date());
                return Result.createBySuccess(reponsitory.save(vipSingleGymcardInfo));
            }
            // TODO
            //reponsitory.update();
        }catch (Exception e){
            e.printStackTrace();
            return Result.createByErrorCodeMessage(ResultCode.EXCEPTION.getCode(),ResultCode.EXCEPTION.getDesc());
        }
        return Result.createBySuccess(vipSingleGymcardInfo);
    }
    @Override
    public JpaRepository<VipSingleGymcardInfo, Long> getRepository() {
        return reponsitory;
    }
}
