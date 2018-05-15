package com.sjto.service;

import com.sjto.domain.SysDictionary;
import com.sjto.dto.vo.SysDictionaryVo;
import java.util.List;
import java.util.Map;

public interface SysDictionaryService extends BaseService<SysDictionary, Long> {

    List<SysDictionaryVo> findDictionaryInfoByGroupId(Long id);

    Map<String, Object> findDictionaryInfoById(Long id);

    List<Map<String, Object>> findDictionaryList();

}
