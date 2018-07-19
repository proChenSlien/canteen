package com.cp.api;

import com.cp.controller.BaseController;
import com.cp.domain.Order;
import com.cp.service.BaseService;
import com.cp.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: Slien
 * @Date: 2018-06-19 14:26
 */
@RestController
@RequestMapping("/api/order")
public class OrderApiController extends BaseController<Order, Long> {
    @Autowired
    private OrderService orderService;
    @Override
    protected BaseService<Order, Long> getService() {
        return orderService;
    }
}
