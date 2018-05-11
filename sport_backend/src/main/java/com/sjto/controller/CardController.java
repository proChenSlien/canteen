package com.sjto.controller;

import com.sjto.domain.Card;
import com.sjto.service.BaseService;
import com.sjto.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    protected BaseService<Card, Long> getService() {
        return cardService;
    }
}
