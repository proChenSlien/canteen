package com.sjto.service;

import com.sjto.dto.ro.VipChildCardInfoRo;
import com.sjto.dto.vo.VipChildCardInfoVo;
import com.sjto.utils.Result;
import java.util.List;
import java.util.Map;

/**
 * @ClassName VipChildCardInfoService
 * @Description
 * @Author wangsai
 * @Date 2018/5/12 17:55
 **/
public interface VipChildCardInfoService {

    Result<List<VipChildCardInfoRo>> queryByUserId(Long userId);

    Result<VipChildCardInfoRo> queryVipCardInfo(Long userId, Long id);

    Result<Map> getAuthState(Long id);

    Result<VipChildCardInfoRo> add(Long userId, VipChildCardInfoVo info);

    Result<VipChildCardInfoRo> recharge(Integer days, Long id);
}
