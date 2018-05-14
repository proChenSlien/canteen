package com.sjto.service;

import com.sjto.domain.VenuePackages;
import org.springframework.data.domain.Example;

import javax.jdo.annotations.Query;
import java.util.List;
import java.util.Map;

public interface VenuePackService extends BaseService<VenuePackages, Long>{


    List<Map<String, Object>> queryVenuePackList();

    List<Map<String, Object>> queryVenuePackMain();

    List<VenuePackages> queryListConfigure();
}