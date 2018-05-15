package com.sjto.api;

import com.sjto.controller.BaseController;
import com.sjto.domain.FamilyTiesInfo;
import com.sjto.domain.User;
import com.sjto.domain.VipChildCardInfo;
import com.sjto.dto.vo.FamilyAndVipChild;
import com.sjto.dto.vo.FamilyTiesVo;
import com.sjto.service.BaseService;
import com.sjto.service.FamilyTiesInfoService;
import com.sjto.service.VipChildCardInfoService;
import com.sjto.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @Description:监护人
 * @Author: chenpeng
 * @Date: 2018/5/13  15:30
 */
@Api(description = "监护人前台接口列表")
@RestController
@RequestMapping("/api/family/familyTies")
public class FamilyTiesInfoApiController extends BaseController<FamilyTiesInfo, Long> {

    @Autowired
    private FamilyTiesInfoService familyTiesInfoService;


    @Override
    protected BaseService<FamilyTiesInfo, Long> getService() {
        return familyTiesInfoService;
    }

    @ApiOperation("监护人添加")
    @ApiImplicitParam(name = "entity", value = "监护人与亲子关系实体对象", required = true, dataType = "FamilyTiesInfo")
    @PostMapping("/merge")
    public Result saveOrUpdate(@ModelAttribute FamilyTiesInfo entity) {
        /*RemoteUser user = getCurrentUser();
        if (user == null) {
            return  Result.createByErrorCodeMessage(ResultCode.NEED_LOGIN.getCode(), ResultCode.NEED_LOGIN.getDesc());
        }*/

        //添加之前要验证密码（调.net接口）

        //校验输入的账户是否存在
        boolean flag = false;
        flag = familyTiesInfoService.userIdIsExist(entity.getUserId());
        if(flag){
            getService().save(entity);
        }else{
            return Result.createByErrorMessage("该账户不存在，请检查！");
        }
        return Result.createBySuccess("添加成功");
    }

    @ApiOperation("亲密圈列表查询")
    @ApiImplicitParams({ @ApiImplicitParam(dataType = "Long", name = "sid", value = "亲密卡实体编号", required = true)})
    @PostMapping("/familyList/{sid}")
    public Result findListFamily(@PathVariable Long sid){
        List<Map<String, Object>> current = familyTiesInfoService.findListFamily(sid);
        return Result.createBySuccess(current);
    }

    @ApiOperation("监护人删除")
    @ApiImplicitParams({ @ApiImplicitParam(dataType = "Long", name = "id", value = "监护人与亲密卡关系主键", required = true),
            @ApiImplicitParam(dataType = "Long", name = "sid", value = "亲密卡实体编号", required = true)})
    @PostMapping("/deleteFamily")
    public Result deleteFamily(Long id, Long sid){
        //删除之前判断是否为主体监护人
        User user = new User();//临时，需要删除该行
        user.setId(123L);//临时，需要删除该行

        //获取当前登陆人userid
        /*RemoteUser user = getCurrentUser();
        if (user == null) {
            return  Result.createByErrorCodeMessage(ResultCode.NEED_LOGIN.getCode(), ResultCode.NEED_LOGIN.getDesc());
        }*/
        FamilyAndVipChild familyAndVipChild = familyTiesInfoService.findChildMainUser(sid);
        if(familyAndVipChild.getMainUserId() == user.getId()){
            getService().deleteById(id);
        }else{
            return Result.createByErrorMessage("非主体监护人没有删除权限");
        }

        return Result.createBySuccess("成功删除");
    }





}
