package com.sjto.service.impl;

import com.sjto.domain.VenuePackages;
import com.sjto.repository.VenuePackRepository;
import com.sjto.service.VenuePackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service("venuePackService")
public class VenuePackServiceImpl extends AbstractGenericServiceImpl<VenuePackages, Long> implements VenuePackService{

    @Autowired
    private VenuePackRepository repository;

    @Override
    public JpaRepository<VenuePackages, Long> getRepository() {
        return repository;
    }
}
