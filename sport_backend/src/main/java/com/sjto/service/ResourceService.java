package com.sjto.service;

import com.sjto.domain.Resource;
import com.sjto.dto.AuthorityDto;

import java.util.List;

/**
 * TODO
 *
 * @author liufeng
 * @create 2017/7/28 15:19
 */
public interface ResourceService extends BaseService<Resource, String>  {

    void updateOrInsert(List<AuthorityDto> auths);

    List<Resource> getRoot();
}
