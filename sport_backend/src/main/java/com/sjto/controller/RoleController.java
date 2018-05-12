package com.sjto.controller;

import com.sjto.domain.Role;
import com.sjto.service.BaseService;
import com.sjto.service.RoleService;
import com.sjto.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 *
 * @author : lf
 * @Date : 2017/6/26 15:11
 */
@RestController
@RequestMapping("/manage/role")
public class RoleController extends BaseController<Role, Long> {

    @Autowired
    private RoleService roleService;

    @PostMapping("/auth")
    public Result auth(@RequestParam List<String> resourceIds, Long userId){
        roleService.correlateResource(resourceIds, userId);
        return Result.createBySuccess();
    }


    @Override
    protected BaseService getService() {
        return roleService;
    }
}
