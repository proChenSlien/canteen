package com.sjto.service.impl;

import com.sjto.domain.MemberPackages;
import com.sjto.repository.MemberPackagesRepository;
import com.sjto.service.MemberPackagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description: 会员充值套餐信息BLL层实现类
 * @Author: fanyongjiu
 * @Date: 18/5/12 9:29
 */
@Service("memberPackagesService")
public class MemberPackagesServiceImpl extends AbstractGenericServiceImpl<MemberPackages, Long> implements MemberPackagesService {
    @Autowired
    private MemberPackagesRepository repository;

    @Override
    public JpaRepository<MemberPackages, Long> getRepository() {
        return repository;
    }

    @Override
    public Boolean isExist(MemberPackages entity) {
        Long id = entity.getId();
        String title = entity.getTitle();
        if (id == null) {
            //不存在
            MemberPackages memberPackages = repository.findByTitle(title);
            return memberPackages != null;
        } else {
            //存在
            MemberPackages memberPackages = repository.findByTitleAndIdNot(title, id);
            return memberPackages != null;
        }
    }
}
