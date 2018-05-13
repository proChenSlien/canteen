package com.sjto.api;

import com.sjto.controller.BaseController;
import com.sjto.domain.FamilyTiesInfo;
import com.sjto.dto.vo.FamilyTiesVo;
import com.sjto.service.BaseService;
import com.sjto.service.FamilyTiesInfoService;
import com.sjto.utils.Result;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/family/familyTies")
public class FamilyTiesInfoController extends BaseController<FamilyTiesInfo, Long> {

    @Autowired
    private FamilyTiesInfoService familyTiesInfoService;

    @Override
    protected BaseService<FamilyTiesInfo, Long> getService() {
        return familyTiesInfoService;
    }

    @ApiOperation("监护人添加")
    @PostMapping("/merge")
    public Result saveOrUpdate(@ModelAttribute FamilyTiesInfo entity) {
        /*RemoteUser user = getCurrentUser();
        if (user == null) {
            return  Result.createByErrorCodeMessage(ResultCode.NEED_LOGIN.getCode(), ResultCode.NEED_LOGIN.getDesc());
        }*/
        //entity.setUserId(user.getId);

        //添加之前要验证密码（调.net接口）

        getService().save(entity);
        return Result.createBySuccess("添加成功");
    }

    @ApiOperation("次票列表查询（后期可能会对次票配置多个场馆）")
    @PostMapping("/familyList/{id}")
    public Result findListFamily(@PathVariable Long id){
        List<FamilyTiesVo> current = familyTiesInfoService.findListFamily(id);

        return Result.createBySuccess(current);
    }



}
