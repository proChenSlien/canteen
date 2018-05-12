package com.sjto.service;

import com.sjto.domain.SysButtonInfo;

/**
 * @Description: 按钮信息Service接口层
 * @Author: fanyongjiu
 * @Date: 18/5/11 11:17
 */
public interface SysButtonInfoService extends BaseService<SysButtonInfo, Long> {
    /**
     * 按钮信息
     *
     * @param type 按钮类型
     * @return
     */
    SysButtonInfo getOneByType(String type);
}
