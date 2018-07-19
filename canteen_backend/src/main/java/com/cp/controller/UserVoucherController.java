package com.cp.controller;

import com.cp.domain.UserVoucher;
import com.cp.service.BaseService;
import com.cp.service.UserVoucherService;
import com.cp.utils.Result;
import com.google.common.collect.Maps;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author: Slien
 * @Date: 2018-06-14 17:08
 */
@RestController
@RequestMapping("/manage/userVoucher")
public class UserVoucherController extends BaseController<UserVoucher, Long> {

    @Autowired
    private UserVoucherService userVoucherService;
    @Override
    protected BaseService<UserVoucher, Long> getService() {
        return userVoucherService;
    }

    @ApiOperation("删除优惠券")
    @GetMapping("/deleteVoucher/{id}")
    public Result delete(@PathVariable String id) {
        userVoucherService.updateStaById(id);
        return Result.createBySuccess("删除成功");
    }

    @ApiOperation("查询优惠券列表")
    @GetMapping("/uvlist")
    public Result userVoucherList(@RequestParam(defaultValue = "10") int size, @RequestParam(defaultValue = "1") int page) {
        Page current = userVoucherService.getUserVoucherList(page, size);
        Map map = Maps.newHashMap();
        map.put("page", current);
        return Result.createBySuccess(map);
    }
}
