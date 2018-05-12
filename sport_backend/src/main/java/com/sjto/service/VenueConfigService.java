package com.sjto.service;

import com.sjto.domain.VenueConfigure;

import java.util.List;

public interface VenueConfigService extends BaseService<VenueConfigure, Long>{

    List<VenueConfigure> findVenueConfigure(Long kid, Long oid);
}
