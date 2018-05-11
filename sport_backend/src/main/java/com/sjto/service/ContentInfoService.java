package com.sjto.service;

import com.sjto.domain.ContentInfo;

/**
 * @Description: 内容说明信息Service接口层
 * @Author: fanyongjiu
 * @Date: 18/5/11 17:59
 */
public interface ContentInfoService extends BaseService<ContentInfo, Long> {
    ContentInfo getByType(String type);
}
