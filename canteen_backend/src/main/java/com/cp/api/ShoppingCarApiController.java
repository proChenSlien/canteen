package com.cp.api;

import com.cp.controller.BaseController;
import com.cp.domain.ShoppingCar;
import com.cp.service.BaseService;
import com.cp.service.ShoppingCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: Slien
 * @Date: 2018-06-19 14:37
 */
@RestController
@RequestMapping("/api/shoppingCar")
public class ShoppingCarApiController extends BaseController<ShoppingCar, Long> {
    @Autowired
    private ShoppingCarService shoppingCarService;
    @Override
    protected BaseService<ShoppingCar, Long> getService() {
        return shoppingCarService;
    }
}
