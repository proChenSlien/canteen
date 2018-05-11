package com.sjto.repository;

import com.sjto.domain.ContentInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * @Description: 内容说明信息DAO接口层
 * @Author: fanyongjiu
 * @Date: 18/5/11 17:57
 */
@Repository
public interface ContentInfoRepository extends JpaRepository<ContentInfo, Long>, JpaSpecificationExecutor<ContentInfo> {
    ContentInfo findByType(String type);
}
