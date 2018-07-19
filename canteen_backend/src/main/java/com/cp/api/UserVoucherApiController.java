package com.cp.api;

import com.cp.controller.BaseController;
import com.cp.domain.UserVoucher;
import com.cp.service.BaseService;
import com.cp.service.UserVoucherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: Slien
 * @Date: 2018-06-19 14:38
 */
@RestController
@RequestMapping("/api/userVoucher")
public class UserVoucherApiController extends BaseController<UserVoucher, Long> {

    @Autowired
    private UserVoucherService userVoucherService;
    @Override
    protected BaseService<UserVoucher, Long> getService() {
        return userVoucherService;
    }
}
