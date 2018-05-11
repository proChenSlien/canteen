package com.sjto.repository;

import com.sjto.domain.AdImgInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * @Description: 广告位图片信息DAO接口层
 * @Author: fanyongjiu
 * @Date: 18/5/11 16:11
 */
@Repository
public interface AdImgInfoRepository extends JpaRepository<AdImgInfo, Long>, JpaSpecificationExecutor<AdImgInfo> {
}