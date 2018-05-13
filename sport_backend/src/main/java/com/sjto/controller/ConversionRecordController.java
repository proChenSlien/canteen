package com.sjto.controller;

import com.sjto.domain.ConversionRecord;
import com.sjto.service.BaseService;
import com.sjto.service.ConversionRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * @Description: 兑换信息控制器
 * @Author: fanyongjiu
 * @Date: 18/5/13 11:46
 */
@RestController
@RequestMapping("/manage/conversion/record")
public class ConversionRecordController extends BaseController<ConversionRecord, Long> {
    @Autowired
    private ConversionRecordService conversionRecordService;

    @Override
    protected BaseService<ConversionRecord, Long> getService() {
        return conversionRecordService;
    }
}
