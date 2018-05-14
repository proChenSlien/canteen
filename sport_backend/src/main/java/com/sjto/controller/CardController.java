package com.sjto.controller;

import com.sjto.domain.Card;
import com.sjto.service.BaseService;
import com.sjto.service.CardService;
import com.sjto.utils.Result;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @ClassName CardController
 * @Author wangsai
 * @Date 2018/5/11 13:31
 **/
@RestController
@RequestMapping("/manage/system/card")
public class CardController extends BaseController<Card, Long> {

    @Autowired
    private CardService cardService;

    @Override
    @ApiOperation("更新或新增会员卡")
    @PostMapping("/merge")
    public Result saveOrUpdate(Card entity) {
        return cardService.saveOrUpdate(entity);
    }

    @Override
    public Result<Map> list(@RequestParam(defaultValue = "10") int size, @RequestParam(defaultValue = "1") int page, Card entity) {
        return cardService.queryList(size, page, entity);
    }

    @Override
    protected BaseService<Card, Long> getService() {
        return cardService;
    }
}
