package com.sjto.service;

import com.sjto.domain.VipSingleGymcardInfo;
import com.sjto.dto.ro.VipSingleGymcardInfoRo;
import com.sjto.enums.AuthState;
import com.sjto.utils.Result;

import java.util.Map;

/**
 * @ClassName VipSingleGymcardInfoService
 * @Description
 * @Author wangsai
 * @Date 2018/5/11 15:31
 **/
public interface VipSingleGymcardInfoService extends BaseService<VipSingleGymcardInfo,Long>{

    Result<Map> getAuthState(Long userId);

    Result<VipSingleGymcardInfoRo> queryVipCardInfo(Long userId, String loginName, Long phone);

    Result<VipSingleGymcardInfoRo> auth(String authImgUrl, Long userId);

    Result<VipSingleGymcardInfoRo> recharge(Integer days, Long userId);

    Result<VipSingleGymcardInfoRo> verify(Long id, Integer authState);

    Result<Map> queryAllVipCardInfoList(int page, int pageSize, VipSingleGymcardInfo entity);

    Result<VipSingleGymcardInfoRo> queryOne(Long id);
}
