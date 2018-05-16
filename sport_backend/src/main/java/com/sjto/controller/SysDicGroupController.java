package com.sjto.controller;

import com.sjto.domain.SysDictionaryGroup;
import com.sjto.service.BaseService;
import com.sjto.service.SysDicGroupService;
import com.sjto.service.SysDictionaryService;
import com.sjto.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Description:
 * @Author: chenpeng
 * @Date: 2018/5/15  17:46
 */
@Api(description = "字典组后台请求接口列表")
@RestController
@RequestMapping("/manage/system/sysDictionaryGroup")
public class SysDicGroupController extends BaseController<SysDictionaryGroup, Long>{
    @Autowired
    private SysDicGroupService sysDicGroupService;
    @Autowired
    private SysDictionaryService sysDictionaryService;

    @Override
    protected BaseService<SysDictionaryGroup, Long> getService() {
        return sysDicGroupService;
    }

    @ApiOperation("删除字典组信息")
    @GetMapping("/deleteGAndD/{groupId}")
    public Result deleteGAndD(@PathVariable Long groupId) {
//        getService().deleteById(groupId);
        sysDicGroupService.deleteByGroupId(groupId);
        //级联删除字典组下的字典
        sysDictionaryService.deleteByGroupId(groupId);
        return Result.createBySuccess("删除成功");
    }
}
