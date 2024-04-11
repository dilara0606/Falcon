package com.demo1.demo1.repository;

import com.demo1.demo1.entity.TimeSpent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TimeSpentDao extends JpaRepository<TimeSpent, Integer>, JpaSpecificationExecutor<TimeSpent>, PagingAndSortingRepository<TimeSpent, Integer>{
    TimeSpent findByid(Integer id);

}
