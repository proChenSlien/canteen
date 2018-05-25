package com.cp.controller;

import com.cp.domain.UserApi;
import com.cp.service.ApiUserService;
import com.cp.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: Slien
 * @Date: 2018-05-24 10:19
 */
@RestController
@RequestMapping("/manage/apiUser")
public class ApiUserController extends BaseController<UserApi, Long>{

    @Autowired
    private ApiUserService apiUserService;
    @Override
    protected BaseService<UserApi, Long> getService() {
        return apiUserService;
    }
}
