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
        VipSingleGymcardInfo vipSingleGymcardInfo = this.getOne(id);
        if(vipSingleGymcardInfo == null){
            return Result.createByErrorMessage("没有找到信息");
        }
        Map map  = Maps.newHashMap();
        switch (vipSingleGymcardInfo.getAuthState()){
            case 1:
                map.put("status",AuthState.NO_AUTHED.getCode());
                map.put("msg",AuthState.NO_AUTHED.getMessage());
                return Result.createBySuccess(map);
            case 2:
                map.put("status",AuthState.IN_AUTHING.getCode());
                map.put("msg",AuthState.IN_AUTHING.getMessage());
                return Result.createBySuccess(map);
            case 3:
                map.put("status",AuthState.AUTHED.getCode());
                map.put("msg",AuthState.AUTHED.getMessage());
                return Result.createBySuccess(map);
            case 4:
                map.put("status",AuthState.FALSE_AUTH.getCode());
                map.put("msg",AuthState.FALSE_AUTH.getMessage());
                return Result.createBySuccess(map);
        }
        return Result.createByErrorMessage("认证状态异常");
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
