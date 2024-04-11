package com.demo1.demo1.service;

import com.demo1.demo1.filter.TimeSpentFilter;
import com.demo1.demo1.repository.TimeSpentDao;
import com.demo1.demo1.dto.TimeSpentDTO;
import com.demo1.demo1.mapper.TimeSpentMapper;
import com.demo1.demo1.entity.TimeSpent;
import com.demo1.demo1.specification.TimeSpentSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TimeSpentService {

    @Autowired
    TimeSpentDao timeSpentDao;
    public List<TimeSpentDTO> getAll(int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        Page<TimeSpent> timeSpentPage = timeSpentDao.findAll(pageable);
        return TimeSpentMapper.convertList(timeSpentPage.toList());
    }

    public ResponseEntity<String> add(TimeSpent timeSpent) {
        TimeSpentMapper.convert(timeSpentDao.save(timeSpent));
        return new ResponseEntity<>("success", HttpStatus.OK);
    }

    public ResponseEntity<String> delete(Integer id) {
        timeSpentDao.deleteById(id);
        return new ResponseEntity<>("success", HttpStatus.OK);
    }

    public ResponseEntity<String> update(TimeSpent timeSpent) {
        TimeSpentMapper.convert(timeSpentDao.save(timeSpent));
        return new ResponseEntity<>("success", HttpStatus.OK);
    }

    public TimeSpentDTO getByID(Integer id) {
        return TimeSpentMapper.convert(timeSpentDao.findByid(id));
    }

    public List<TimeSpentDTO> searchTimeSpent(TimeSpentFilter timeSpentFilter){
        return TimeSpentMapper.convertList(timeSpentDao.findAll(TimeSpentSpecification.searchTimeSpent(timeSpentFilter)));
    }
}
