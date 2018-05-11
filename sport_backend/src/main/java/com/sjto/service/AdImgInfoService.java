package com.sjto.service;

import com.sjto.domain.AdImgInfo;

import java.util.List;
import java.util.Map;

/**
 * @Description: 广告位图片信息Service接口层
 * @Author: fanyongjiu
 * @Date: 18/5/11 16:08
 */
public interface AdImgInfoService extends BaseService<AdImgInfo, Long> {
    Map<String, Object> getImgInfo(Long id);

    List<Map<String, Object>> getList();
}
