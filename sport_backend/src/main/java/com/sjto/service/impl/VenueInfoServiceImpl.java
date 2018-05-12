package com.sjto.service.impl;

import com.sjto.domain.VenueInfo;
import com.sjto.repository.VenueInfoRepository;
import com.sjto.service.VenueInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service("venueInfoService")
public class VenueInfoServiceImpl extends AbstractGenericServiceImpl<VenueInfo, Long> implements VenueInfoService {

    @Autowired
    private VenueInfoRepository repository;

    @Override
    public JpaRepository<VenueInfo, Long> getRepository() {
        return repository;
    }
}
