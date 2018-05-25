package com.cp.controller;

import com.cp.domain.Order;
import com.cp.service.BaseService;
import com.cp.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: Slien
 * @Date: 2018-05-24 15:23
 */
@RestController
@RequestMapping("/manage/order")
public class OrderController extends BaseController<Order, Long>{
    @Autowired
    private OrderService orderService;
    @Override
    protected BaseService<Order, Long> getService() {
        return orderService;
    }
}
