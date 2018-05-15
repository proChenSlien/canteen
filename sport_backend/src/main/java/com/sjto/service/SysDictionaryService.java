package com.sjto.service;

import com.sjto.domain.SysDictionary;
import com.sjto.dto.vo.SysDictionaryVo;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Map;

public interface SysDictionaryService extends BaseService<SysDictionary, Long> {

    List<SysDictionaryVo> findDictionaryInfoByGroupId(Long id);

    Map<String, Object> findDictionaryInfoById(Long id);

    Page findDictionaryList(Integer page, Integer pageSize);

}
