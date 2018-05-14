package com.sjto.service.impl;

import com.sjto.domain.VenuePackages;
import com.sjto.dto.vo.VenueConfigVo;
import com.sjto.repository.VenuePackRepository;
import com.sjto.service.VenuePackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service("venuePackService")
public class VenuePackServiceImpl extends AbstractGenericServiceImpl<VenuePackages, Long> implements VenuePackService{

    @Autowired
    private VenuePackRepository repository;


    @Override
    public JpaRepository<VenuePackages, Long> getRepository() {
        return repository;
    }


    @Override
    public List<Map<String, Object>> queryVenuePackList() {
        List<Map<String, Object>> result = new ArrayList<>();

        List<VenueConfigVo> list = repository.queryVenuePackList();

        for (VenueConfigVo item : list) {
            Map<String, Object> map = new HashMap<>();
            map.put("id", item.getId());
            map.put("money", item.getMoney());
            map.put("title", item.getTitle());
            map.put("venueName", item.getVenueName());
            map.put("venueId", item.getVenueId());
            result.add(map);
        }

        return result;
    }

    @Override
    public List<Map<String, Object>> queryVenuePackMain() {
        List<Map<String, Object>> result = new ArrayList<>();

        List<VenueConfigVo> list = repository.queryVenuePackMain();

        for (VenueConfigVo item : list) {
            Map<String, Object> map = new HashMap<>();
            map.put("id", item.getId());
            map.put("money", item.getMoney());
            map.put("title", item.getTitle());
            map.put("venueName", item.getVenueName());
            map.put("venue_id", item.getVenueId());
            result.add(map);
        }
        return result;
    }

    @Override
    public List<VenuePackages> queryListConfigure() {
        return repository.queryListConfigure();
    }
}
