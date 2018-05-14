package com.sjto.controller;

import com.sjto.domain.SysDictionary;
import com.sjto.service.BaseService;
import com.sjto.service.SysDictionaryService;
import com.sjto.utils.Result;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/manage/system/sysDictionary")
public class SysDictionaryController extends BaseController<SysDictionary, Long> {
    @Autowired
    private SysDictionaryService sysDictionaryService;
    @Override
    protected BaseService<SysDictionary, Long> getService() {
        return sysDictionaryService;
    }

    @ApiOperation("字典查询")
    @ApiImplicitParams({ @ApiImplicitParam(dataType = "Long", name = "id", value = "字典编号", required = true)})
    @GetMapping("/findDictionaryInfo/{id}")
    public Result findDictionaryInfoById(@PathVariable Long id){
        Map<String, Object> map = sysDictionaryService.findDictionaryInfoById(id);
        if (map.size() == 0) {
            return Result.createByErrorMessage("未查询到该字典信息");
        }
        return Result.createBySuccess(map);
    }
}
