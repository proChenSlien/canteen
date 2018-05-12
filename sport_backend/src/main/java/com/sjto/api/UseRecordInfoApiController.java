package com.sjto.api;

import com.sjto.controller.BaseController;
import com.sjto.domain.Card;
import com.sjto.domain.UseRecordInfo;
import com.sjto.dto.vo.UseRecordInfoVo;
import com.sjto.service.BaseService;
import com.sjto.service.CardService;
import com.sjto.service.UseRecordInfoService;
import com.sjto.utils.Result;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * @Description: 使用记录控制器
 * @Author: fanyongjiu
 * @Date: 18/5/11 18:46
 */
@RestController
@RequestMapping("/api/card/useRec")
public class UseRecordInfoApiController extends BaseController<UseRecordInfo, Long> {
    @Autowired
    private UseRecordInfoService useRecordInfoService;

    @Autowired
    private CardService cardService;

    @Override
    protected BaseService<UseRecordInfo, Long> getService() {
        return useRecordInfoService;
    }

    @ApiOperation("使用记录查询（APP）")
    @GetMapping(value = "/getList")
    public Result getList(@RequestParam(defaultValue = "10") int size, @RequestParam(defaultValue = "1") int page) {
        Result result = Result.createBySuccess();
        //用户是否登录
//        RemoteUser user = getCurrentUser();
//        if (user == null) {
//            result = Result.error().setCode("401").setMsg("用户未登录");
//            return result;
//        }
        Long userId = 1L;
        List<UseRecordInfoVo> list = useRecordInfoService.getList(page, size, userId);
        return Result.createBySuccess(list);
    }

    @ApiOperation("使用记录插入（APP）")
    @PostMapping(value = "/save")
    public Result save(@RequestParam Long cardId) {
        Result result = Result.createBySuccess();
        //用户是否登录
//        RemoteUser user = getCurrentUser();
//        if (user == null) {
//            result = Result.error().setCode("401").setMsg("用户未登录");
//            return result;
//        }
        Long userId = 1L;
        //校验卡是否存在
        Optional<Card> optional = cardService.findById(cardId);
        if (!optional.isPresent()) {
            result = Result.createByErrorMessage("卡信息不存在");
            return result;
        }
        UseRecordInfo useRecordInfo = new UseRecordInfo();
        useRecordInfo.setBeginTime(new Date());
        useRecordInfo.setEndTime(new Date());
        useRecordInfo.setPid(cardId);
        useRecordInfo.setUserId(userId);
        useRecordInfoService.save(useRecordInfo);
        return Result.createBySuccess();
    }

}
