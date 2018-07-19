package com.cp.api;

import com.cp.controller.BaseController;
import com.cp.domain.Goods;
import com.cp.service.BaseService;
import com.cp.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: Slien
 * @Date: 2018-06-19 14:34
 */
@RestController
@RequestMapping("/api/goods")
public class GoodsApiController extends BaseController<Goods, Long> {
    @Autowired
    private GoodsService goodsService;

    @Override
    protected BaseService<Goods, Long> getService() {
        return goodsService;
    }
}
