package com.sjto.repository;

import com.sjto.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * TODO
 *
 * @author liufeng
 * @create 2017/7/28 13:50
 */
@Repository
public interface RoleRepository extends JpaRepository<Role,Long>{

}
