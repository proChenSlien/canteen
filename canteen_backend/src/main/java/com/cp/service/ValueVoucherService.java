package com.cp.service;

import com.cp.domain.ValueVoucher;

/**
 * @author: Slien
 * @Date: 2018-06-13 17:27
 */
public interface ValueVoucherService extends BaseService<ValueVoucher, Long>{
    void updateStaById(String id);
}
