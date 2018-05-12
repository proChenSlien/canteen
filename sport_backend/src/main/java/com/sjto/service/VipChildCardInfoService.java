package com.sjto.service;

import com.sjto.domain.VipChildCardInfo;
import com.sjto.utils.Result;

import java.util.List;

/**
 * @ClassName VipChildCardInfoService
 * @Description
 * @Author wangsai
 * @Date 2018/5/12 17:55
 **/
public interface VipChildCardInfoService {

    Result<VipChildCardInfo> queryByUserId(Long userId);

}
