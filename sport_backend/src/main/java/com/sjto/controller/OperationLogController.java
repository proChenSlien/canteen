package com.sjto.controller;

import com.sjto.domain.OperationLog;
import com.sjto.domain.User;
import com.sjto.service.BaseService;
import com.sjto.service.OperationLogService;
import com.sjto.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * @Description:日志
 * @Author: chenpeng
 * @Date: 2018/5/12  10:30
 */
@Api(description = "日志后台留痕接口列表")
@RestController
@RequestMapping("/manage/system/operationLog")
public class OperationLogController  extends BaseController<OperationLog, Long> {

    @Autowired
    private OperationLogService operationLogService;

    @Override
    protected BaseService<OperationLog, Long> getService() {
        return operationLogService;
    }

    @ApiOperation("日志留痕插入")
    @ApiImplicitParam(name = "entity", value = "日志留痕对象", required = true, dataType = "OperationLog")
    @PostMapping("/merge")
    public Result saveOrUpdate(@ModelAttribute OperationLog entity) {
        //获取登录用户
//        User user = getCurrentUser();
//        entity.setOperaId(user.getId());
        entity.setCreateTime(new Date());
        operationLogService.addOperationLog(entity);

        return Result.createBySuccess("添加成功");
    }


}
