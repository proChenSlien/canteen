package com.sjto.repository;

import com.sjto.domain.VenuePackages;
import com.sjto.dto.vo.VenueConfigVo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;
import java.util.List;





@Repository
public interface VenuePackRepository extends JpaRepository<VenuePackages,Long>,QuerydslPredicateExecutor<VenuePackages> {

    @Query(value = "select new com.sjto.dto.vo.VenueConfigVo(p.id, p.money, p.title, i.venueName, i.id) from VenuePackages p " +
            "left join VenueConfigure c on c.kid = p.id" +
            " left join VenueInfo i on c.oid=i.id")
    List<VenueConfigVo> queryVenuePackList();

    @Query(value = "select new com.sjto.dto.vo.VenueConfigVo(p.id, p.money, p.title, i.venueName, i.id) from VenuePackages p " +
            " left join VenueInfo i on p.oid=i.id")
    List<VenueConfigVo> queryVenuePackMain();

    @Query(value = "select v.id from VenueConfigure v")
    List<VenuePackages> querylist();
}
