package com.demo1.demo1.repository;

import com.demo1.demo1.entity.Projects;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectDao extends JpaRepository<Projects, Integer>,
        PagingAndSortingRepository<Projects, Integer>,
        JpaSpecificationExecutor<Projects> {

    Projects findByid(Integer id);
}
