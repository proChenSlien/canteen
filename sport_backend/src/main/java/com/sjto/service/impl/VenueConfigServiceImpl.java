package com.sjto.service.impl;

import com.sjto.domain.VenueConfigure;
import com.sjto.repository.VenueConfigRepository;
import com.sjto.service.VenueConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("venueConfigService")
public class VenueConfigServiceImpl extends AbstractGenericServiceImpl<VenueConfigure, Long> implements VenueConfigService{

    @Autowired
    private VenueConfigRepository repository;



    @Override
    public JpaRepository<VenueConfigure, Long> getRepository() {
        return repository;
    }

    @Override
    public List<VenueConfigure> findVenueConfigure(Long kid, Long oid) {
        return repository.findVenueConfigure(kid, oid);
    }
}
