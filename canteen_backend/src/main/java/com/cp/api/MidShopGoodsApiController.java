package com.cp.api;

import com.cp.controller.BaseController;
import com.cp.domain.MidShoppingGoods;
import com.cp.service.BaseService;
import com.cp.service.MidShopGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: Slien
 * @Date: 2018-06-19 14:36
 */
@RestController
@RequestMapping("/api/shopGoods")
public class MidShopGoodsApiController extends BaseController<MidShoppingGoods, Long> {
    @Autowired
    private MidShopGoodsService midShopGoodsService;
    @Override
    protected BaseService<MidShoppingGoods, Long> getService() {
        return midShopGoodsService;
    }
}
