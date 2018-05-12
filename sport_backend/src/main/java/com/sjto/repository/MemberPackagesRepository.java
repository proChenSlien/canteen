package com.sjto.repository;

import com.sjto.domain.MemberPackages;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * @Description: 会员充值套餐信息DAO接口层
 * @Author: fanyongjiu
 * @Date: 18/5/12 9:32
 */
@Repository
public interface MemberPackagesRepository extends JpaRepository<MemberPackages, Long>, JpaSpecificationExecutor<MemberPackages> {
}
