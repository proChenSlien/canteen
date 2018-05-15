package com.sjto.service;

import com.sjto.domain.SysDictionary;
import com.sjto.dto.vo.SysDictionaryVo;
import java.util.List;

public interface SysDictionaryService extends BaseService<SysDictionary, Long> {

    List<SysDictionaryVo> findDictionaryInfoByGroupId(Long id);

}
