package com.demo1.demo1.repository;

import com.demo1.demo1.entity.UsersProjects;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsersProjectsDao extends JpaRepository<UsersProjects, Integer>, JpaSpecificationExecutor<UsersProjects> {
    UsersProjects findByid(Integer id);

    List<UsersProjects> findByProjects_Id(Integer id);

    List<UsersProjects> findByUsers_Id(Integer id);

}
