package com.sjto.repository;

import com.sjto.domain.ConversionRecord;
import com.sjto.dto.vo.ConversionRecordVo;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Description: 兑换信息DAO接口层
 * @Author: fanyongjiu
 * @Date: 18/5/12 11:04
 */
@Repository
public interface ConversionRecordRepository extends JpaRepository<ConversionRecord, Long>, JpaSpecificationExecutor<ConversionRecord> {

}
