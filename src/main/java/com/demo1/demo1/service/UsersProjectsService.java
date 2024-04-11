package com.demo1.demo1.service;

import com.demo1.demo1.filter.UsersProjectsFilter;
import com.demo1.demo1.repository.UsersProjectsDao;
import com.demo1.demo1.dto.UsersProjectsDTO;
import com.demo1.demo1.mapper.UsersProjectsMapper;
import com.demo1.demo1.entity.UsersProjects;
import com.demo1.demo1.specification.UsersProjectsSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersProjectsService {

    @Autowired
    UsersProjectsDao usersProjectsDao;
    public List<UsersProjectsDTO> getAll() {
            return UsersProjectsMapper.convertList(usersProjectsDao.findAll());
    }

    public ResponseEntity<String> add(UsersProjects usersProjects) {
        UsersProjectsMapper.convert(usersProjectsDao.save(usersProjects));
        return new ResponseEntity<>("success", HttpStatus.OK);
    }

    public ResponseEntity<String> delete(Integer id) {
        usersProjectsDao.deleteById(id);
        return new ResponseEntity<>("success", HttpStatus.OK);
    }

    public ResponseEntity<String> update(UsersProjects usersProjects) {
        UsersProjectsMapper.convert(usersProjectsDao.save(usersProjects));
        return new ResponseEntity<>("success", HttpStatus.OK);
    }

    public UsersProjectsDTO getByid(Integer id) {
            return UsersProjectsMapper.convert(usersProjectsDao.findByid(id));
    }

    public List<UsersProjectsDTO> getByproject(Integer projectId){
        return UsersProjectsMapper.convertList(usersProjectsDao.findByProjects_Id(projectId));
    }

    public List<UsersProjectsDTO> getByuser(Integer userId) {
        return UsersProjectsMapper.convertList(usersProjectsDao.findByUsers_Id(userId));
    }

    public UsersProjectsDTO getByidWithTimeSpent(Integer id) {
        return UsersProjectsMapper.convertWithTimeSpent(usersProjectsDao.findByid(id));
    }

    public List<UsersProjectsDTO> searchUsersProjects(UsersProjectsFilter usersProjectsFilter) {
        return UsersProjectsMapper.convertList(usersProjectsDao.findAll(UsersProjectsSpecification.filterByAll(usersProjectsFilter)));
    }
}
