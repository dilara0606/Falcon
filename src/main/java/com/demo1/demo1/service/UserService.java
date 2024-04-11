package com.demo1.demo1.service;

import com.demo1.demo1.filter.UserFilter;
import com.demo1.demo1.mapper.UsersMapper;
import com.demo1.demo1.repository.UserDao;
import com.demo1.demo1.dto.UserDTO;
import com.demo1.demo1.entity.Users;
import com.demo1.demo1.specification.UserSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import java.util.List;


@Service
public class UserService {

    @Autowired
    UserDao userDao;
    @Autowired
    UsersProjectsService usersProjectsService;

    public List<UserDTO> getAllUser(){
        return UsersMapper.convertList(userDao.findAll());
    }

    public ResponseEntity<UserDTO> addUser(Users user) {
        userDao.save(user);
        return new ResponseEntity<>(UsersMapper.convertWithoutProjects(user), HttpStatus.OK);
    }

    public ResponseEntity<String> deleteUser(Integer id) {
        userDao.deleteById(id);
        return new ResponseEntity<>("success", HttpStatus.OK);
    }

    public ResponseEntity<String> updateUser(Users user) {
        UsersMapper.convertWithoutProjects(userDao.save(user));
        return new ResponseEntity<>("success", HttpStatus.OK);
    }

    public UserDTO getUserByID(Integer id) {
        return UsersMapper.convertWithoutProjects(userDao.findByid(id));
    }

    public UserDTO getProjectsByID(Integer id){
        return UsersMapper.convert(userDao.findByid(id));
    }

    public List<UserDTO> searchUser(UserFilter filter){
        return UsersMapper.convertListWithProjects(userDao.findAll(UserSpecification.searchUser(filter)));
    }

    public UserDTO findOne(Integer id) {
        return UsersMapper.convert(userDao.findByid(id));
    }
}
