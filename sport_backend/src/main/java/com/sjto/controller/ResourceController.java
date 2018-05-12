package com.sjto.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.common.collect.Maps;
import com.sjto.domain.Resource;
import com.sjto.dto.AuthorityDto;
import com.sjto.dto.ResourceRoot;
import com.sjto.service.BaseService;
import com.sjto.service.ResourceService;
import com.sjto.utils.BeanMapper;
import com.sjto.utils.Result;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

/**
 *
 * @author : lf
 * @Date : 2017/6/26 15:11
 */
@RestController
@RequestMapping("/manage/resource")
public class ResourceController extends BaseController<Resource, String> {

    @Autowired
    private ResourceService resourceService;


    @ApiOperation("同步权限信息")
    @PostMapping("/sync")
    public Result syncResource(@RequestBody List<AuthorityDto> beanList){
        resourceService.updateOrInsert(beanList);
        return Result.createBySuccess();
    }

    @ApiOperation("获取资源树")
    @GetMapping("/root")
    public Result root() throws JsonProcessingException {
        List<Resource> resources = resourceService.getRoot();
        List<ResourceRoot> root = BeanMapper.mapList(resources, ResourceRoot.class);
        Map map = Maps.newHashMap();
        map.put("root", root);
        return Result.createBySuccess(map);
    }


    @Override
    protected BaseService getService() {
        return resourceService;
    }
}
