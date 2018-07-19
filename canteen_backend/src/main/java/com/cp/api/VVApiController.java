package com.cp.api;

import com.cp.controller.BaseController;
import com.cp.domain.ValueVoucher;
import com.cp.service.BaseService;
import com.cp.service.ValueVoucherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: Slien
 * @Date: 2018-06-19 14:38
 */
@RestController
@RequestMapping("/api/valueVoucher")
public class VVApiController extends BaseController<ValueVoucher, Long> {

    @Autowired
    private ValueVoucherService valueVoucherService;
    @Override
    protected BaseService<ValueVoucher, Long> getService() {
        return valueVoucherService;
    }
}
