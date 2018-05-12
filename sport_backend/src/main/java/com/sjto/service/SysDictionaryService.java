package com.sjto.service;

import com.sjto.domain.SysDictionary;

import java.util.Map;

public interface SysDictionaryService extends BaseService<SysDictionary, Long> {

    Map<String, Object> findDictionaryInfoById(Long id);

}
