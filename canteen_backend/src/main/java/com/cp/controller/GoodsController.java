package com.cp.controller;

import com.cp.domain.Goods;
import com.cp.service.BaseService;
import com.cp.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: Slien
 * @Date: 2018-05-24 14:21
 */
@RestController
@RequestMapping("/manage/goods")
public class GoodsController extends BaseController<Goods, Long> {
    @Autowired
    private GoodsService goodsService;

    @Override
    protected BaseService<Goods, Long> getService() {
        return goodsService;
    }
}
