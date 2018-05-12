package com.sjto.controller;

import com.sjto.domain.User;
import com.sjto.service.BaseService;
import com.sjto.service.UserService;
import com.sjto.utils.PasswordHelper;
import com.sjto.utils.Result;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author : lf
 * @Date : 2017/6/26 15:11
 */
@RestController
@RequestMapping("/manage/user")
public class UserController extends BaseController<User, Long> {

    @Autowired
    private UserService userService;

    @ApiOperation("更新用户")
    @Override
    @PostMapping("/merge")
    public Result saveOrUpdate(User entity) {
        if (StringUtils.hasText(entity.getPassword())) {
            PasswordHelper.encryptPassword(entity);
        }
        getService().save(entity);
        return Result.createBySuccess();
    }

    @PostMapping("/roles")
    public Result setUserRoles(@RequestParam List<Long> roleIds, @RequestParam Long userId) {
        userService.setUserRoles(roleIds, userId);
        return Result.createBySuccess();
    }

    @Override
    protected BaseService<User, Long> getService() {
        return userService;
    }
}
