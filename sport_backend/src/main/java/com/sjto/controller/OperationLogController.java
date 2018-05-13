package com.sjto.controller;

import com.sjto.domain.OperationLog;
import com.sjto.domain.User;
import com.sjto.service.BaseService;
import com.sjto.service.OperationLogService;
import com.sjto.utils.Result;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/manage/system/operationLog")
public class OperationLogController  extends BaseController<OperationLog, Long> {

    @Autowired
    private OperationLogService operationLogService;

    @Override
    protected BaseService<OperationLog, Long> getService() {
        return operationLogService;
    }

    @ApiOperation("添加")
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
