package com.sjto.service.impl;

import com.sjto.domain.Resource;
import com.sjto.domain.Role;
import com.sjto.domain.User;
import com.sjto.repository.ResourceRepository;
import com.sjto.repository.RoleRepository;
import com.sjto.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO
 *
 * @author liufeng
 * @create 2017/7/28 15:18
 */
@Service
public class RoleServiceImpl extends AbstractGenericServiceImpl<Role, Long> implements RoleService {

    @Autowired
    private RoleRepository repository;

    @Autowired
    private ResourceRepository resourceRepository;


    @Override
    public JpaRepository<Role, Long> getRepository() {
        return repository;
    }



    @Override
    public void correlateResource(List<String> resourceIds, Long userId) {
        Role role = repository.getOne(userId);
        List<Resource> selected = resourceRepository.findAllById(resourceIds);
        role.setResources(selected);
        repository.save(role);
    }

}
