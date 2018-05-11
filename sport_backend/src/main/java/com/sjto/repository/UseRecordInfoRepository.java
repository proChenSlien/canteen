package com.sjto.repository;

import com.sjto.domain.UseRecordInfo;
import com.sjto.dto.vo.UseRecordInfoVo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @Description: 使用记录DAO接口层
 * @Author: fanyongjiu
 * @Date: 18/5/11 18:40
 */
@Repository
public interface UseRecordInfoRepository extends JpaRepository<UseRecordInfo, Long>, JpaSpecificationExecutor<UseRecordInfo> {
    @Query("select new com.sjto.dto.vo.UseRecordInfoVo(c.name,uri.beginTime,uri.endTime) from UseRecordInfo uri inner join Card c on uri.pid=c.id where uri.userId= ?1 order by uri.id desc")
    List<UseRecordInfoVo> findAll(Long userId,Pageable pageable);
}
