package com.sjto.service;

import com.sjto.domain.VenuePackages;
import org.springframework.data.domain.Example;

import javax.jdo.annotations.Query;
import java.util.List;

public interface VenuePackService extends BaseService<VenuePackages, Long>{


    List<VenuePackages> queryVenuePackList();

    List<VenuePackages> queryVenuePackMain();
}