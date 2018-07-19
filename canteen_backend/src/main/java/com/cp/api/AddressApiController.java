package com.cp.api;

import com.cp.controller.BaseController;
import com.cp.domain.Address;
import com.cp.service.AddressService;
import com.cp.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: Slien
 * @Date: 2018-06-19 14:33
 */
@RestController
@RequestMapping("/api/address")
public class AddressApiController extends BaseController<Address, Long> {
    @Autowired
    private AddressService addressService;
    @Override
    protected BaseService<Address, Long> getService() {
        return addressService;
    }
}
