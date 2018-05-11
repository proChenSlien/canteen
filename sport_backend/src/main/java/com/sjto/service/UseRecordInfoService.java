package com.sjto.service;

import com.sjto.domain.UseRecordInfo;
import com.sjto.dto.vo.UseRecordInfoVo;

import java.util.List;

/**
 * @Description: 使用记录Service接口层
 * @Author: fanyongjiu
 * @Date: 18/5/11 18:41
 */
public interface UseRecordInfoService extends BaseService<UseRecordInfo, Long> {
    List<UseRecordInfoVo> getList(Integer page, Integer pageSize, Long userId);
}
