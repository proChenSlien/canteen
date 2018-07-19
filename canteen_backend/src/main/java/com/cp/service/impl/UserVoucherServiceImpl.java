package com.cp.service.impl;

import com.cp.domain.UserVoucher;
import com.cp.repository.UserVoucherRepository;
import com.cp.service.UserVoucherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * @author: Slien
 * @Date: 2018-06-14 17:14
 */
@Service
public class UserVoucherServiceImpl extends AbstractGenericServiceImpl<UserVoucher, Long> implements UserVoucherService {
    @Autowired
    private UserVoucherRepository repository;
    @Override
    public JpaRepository<UserVoucher, Long> getRepository() {
        return repository;
    }

    @Override
    @Transactional
    public void updateStaById(String id) {
        repository.updateStaById(id);
    }

    @Override
    public Page getUserVoucherList(Integer page, Integer pageSize) {
        PageRequest pageRequest = PageRequest.of(page - 1, pageSize);
        return repository.getUserVoucherList(pageRequest);
    }
}
