package com.demo1.demo1.repository;

import com.demo1.demo1.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<Users, Integer>,
        PagingAndSortingRepository<Users, Integer>,
        JpaSpecificationExecutor<Users> {
    Users findByid(Integer id);

}
