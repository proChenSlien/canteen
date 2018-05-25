package com.cp.controller;

import com.cp.domain.Address;
import com.cp.service.AddressService;
import com.cp.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: Slien
 * @Date: 2018-05-24 11:27
 */
@RestController
@RequestMapping("/manage/address")
public class AddressController extends BaseController<Address, Long> {

    @Autowired
    private AddressService addressService;
    @Override
    protected BaseService<Address, Long> getService() {
        return addressService;
    }
}
