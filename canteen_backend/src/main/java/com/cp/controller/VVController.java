package com.cp.controller;

import com.cp.domain.ValueVoucher;
import com.cp.service.BaseService;
import com.cp.service.ValueVoucherService;
import com.cp.utils.Result;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: Slien
 * @Date: 2018-06-13 17:14
 */
@RestController
@RequestMapping("/manage/valueVoucher")
public class VVController extends BaseController<ValueVoucher, Long>{

    @Autowired
    private ValueVoucherService valueVoucherService;
    @Override
    protected BaseService<ValueVoucher, Long> getService() {
        return valueVoucherService;
    }

    @ApiOperation("删除优惠券")
    @GetMapping("/deleteVoucher/{id}")
    public Result delete(@PathVariable String id) {
        valueVoucherService.updateStaById(id);
        return Result.createBySuccess("删除成功");
    }
}
