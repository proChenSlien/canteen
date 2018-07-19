package com.cp.service;

import com.cp.domain.UserVoucher;
import org.springframework.data.domain.Page;

/**
 * @author: Slien
 * @Date: 2018-06-14 17:13
 */
public interface UserVoucherService extends BaseService<UserVoucher, Long>{
    void updateStaById(String id);

    Page getUserVoucherList(Integer page, Integer pageSize);

}
