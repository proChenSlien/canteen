package com.sjto.repository;

import com.sjto.domain.VenuePackages;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

<<<<<<< HEAD
import java.util.List;


=======
>>>>>>> 0e72ffeb9dad37ab9113ff80bd5808d26ba29c02
@Repository
public interface VenuePackRepository extends JpaRepository<VenuePackages,Long>,QuerydslPredicateExecutor<VenuePackages> {

    @Query(value = "select p.id, p.money, p.title, i.venueName from VenuePackages p " +
            "left join VenueConfigure c on c.kid = p.id" +
            " left join VenueInfo i on c.oid=i.id")
    List<VenuePackages> queryVenuePackList();

    @Query(value = "select p.id, p.money, p.title, i.venueName from VenuePackages p " +
            " left join VenueInfo i on p.oid=i.id")
    List<VenuePackages> queryVenuePackMain();
}
