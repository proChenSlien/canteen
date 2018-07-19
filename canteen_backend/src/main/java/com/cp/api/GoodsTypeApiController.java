package com.cp.api;

import com.cp.controller.BaseController;
import com.cp.domain.GoodsType;
import com.cp.service.BaseService;
import com.cp.service.GoodsTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: Slien
 * @Date: 2018-06-19 14:34
 */
@RestController
@RequestMapping("/api/goodsType")
public class GoodsTypeApiController extends BaseController<GoodsType, Long> {

    @Autowired
    private GoodsTypeService goodsTypeService;

    @Override
    protected BaseService<GoodsType, Long> getService() {
        return goodsTypeService;
    }
}
