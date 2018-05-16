package com.sjto.service;

import com.sjto.domain.VipChildCardInfo;
import com.sjto.dto.ro.VipChildCardInfoRo;
import com.sjto.dto.ro.VipSingleGymcardInfoRo;
import com.sjto.dto.vo.VipChildCardInfoVo;
import com.sjto.utils.Result;
import org.springframework.data.domain.Page;

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

    Result<VipChildCardInfoRo> queryOne(Long id);

    Result<Map> getAuthState(Long id);

    Result<VipChildCardInfoRo> add(Long userId, VipChildCardInfoVo info);

    Result<VipChildCardInfoRo> recharge(Integer days, Long id);

    Result<VipChildCardInfoRo> auth(String authImgUrl, Long id);

    Result<Map> queryList(Integer page, Integer pageSize, VipChildCardInfo entity);

    Result<VipChildCardInfoRo> verify(Long id, Integer authState);
}
