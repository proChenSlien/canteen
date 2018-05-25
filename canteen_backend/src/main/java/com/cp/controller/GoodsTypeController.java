package com.cp.controller;

import com.cp.domain.GoodsType;
import com.cp.service.BaseService;
import com.cp.service.GoodsTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: Slien
 * @Date: 2018-05-24 14:35
 */
@RestController
@RequestMapping("/manage/goodsType")
public class GoodsTypeController extends BaseController<GoodsType, Long> {

    @Autowired
    private GoodsTypeService goodsTypeService;

    @Override
    protected BaseService<GoodsType, Long> getService() {
        return goodsTypeService;
    }
}
