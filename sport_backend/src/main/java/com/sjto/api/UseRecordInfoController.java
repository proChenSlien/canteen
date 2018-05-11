package com.sjto.api;

import com.sjto.controller.BaseController;
import com.sjto.domain.UseRecordInfo;
import com.sjto.dto.vo.UseRecordInfoVo;
import com.sjto.service.BaseService;
import com.sjto.service.UseRecordInfoService;
import com.sjto.utils.Result;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Description: 使用记录控制器
 * @Author: fanyongjiu
 * @Date: 18/5/11 18:46
 */
@RestController
@RequestMapping("/api/card/useRec")
public class UseRecordInfoController extends BaseController<UseRecordInfo, Long> {
    @Autowired
    private UseRecordInfoService useRecordInfoService;

    @Override
    protected BaseService<UseRecordInfo, Long> getService() {
        return useRecordInfoService;
    }

    @ApiOperation("查询收货地址列表")
    @GetMapping(value = "/getList")
    public Result getList(@RequestParam(defaultValue = "10") int size, @RequestParam(defaultValue = "1") int page) {
        Result result = Result.createBySuccess();
        //用户是否登录
//        RemoteUser user = getCurrentUser();
//        if (user == null) {
//            result = Result.error().setCode("401").setMsg("用户未登录");
//            return result;
//        }
        Long userId = 1L;
        List<UseRecordInfoVo> list = useRecordInfoService.getList(page, size, userId);
        return Result.createBySuccess(list);
    }
}
