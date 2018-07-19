package com.cp.service.impl;

import com.cp.domain.ValueVoucher;
import com.cp.repository.VVRepository;
import com.cp.service.ValueVoucherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * @author: Slien
 * @Date: 2018-06-13 17:35
 */
@Service
public class ValueVoucherServiceImpl extends AbstractGenericServiceImpl<ValueVoucher, Long> implements ValueVoucherService {
    @Autowired
    private VVRepository repository;
    @Override
    public JpaRepository<ValueVoucher, Long> getRepository() {
        return repository;
    }

    @Override
    @Transactional
    public void updateStaById(String id) {
        repository.updateStaById(id);
    }
}
