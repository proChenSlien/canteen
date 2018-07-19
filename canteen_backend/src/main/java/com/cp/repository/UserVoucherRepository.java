package com.cp.repository;

import com.cp.domain.UserVoucher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

/**
 * @author: Slien
 * @Date: 2018-06-14 17:18
 */
@Repository
public interface UserVoucherRepository extends JpaRepository<UserVoucher, Long>,QuerydslPredicateExecutor<UserVoucher> {
    @Modifying
    @Query(value = "update UserVoucher set valid = 0 where id = ?1")
    void updateStaById(String id);

    @Query(value = "select new com.cp.dto.vo.UserVoucherVo(uv.id, ua.userName, v.vvName, uv.validTime, uv.validDays, uv.valid" +
            ") from UserVoucher uv " +
            "left join UserApi ua on ua.id = uv.userId " +
            " left join ValueVoucher v on v.id = uv.voucherId")
    Page getUserVoucherList(Pageable pageable);
}
