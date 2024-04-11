package com.demo1.demo1.controller;

import com.demo1.demo1.dto.UsersProjectsDTO;
import com.demo1.demo1.filter.UsersProjectsFilter;
import com.demo1.demo1.entity.UsersProjects;
import com.demo1.demo1.service.UsersProjectsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("users_projects")
public class UserProjectController {
    @Autowired
    UsersProjectsService usersProjectsService;

    @GetMapping("all")
    public List<UsersProjectsDTO> getAll(){
        return usersProjectsService.getAll();
    }

    @PostMapping("add")
    public ResponseEntity<String> add(@RequestBody UsersProjects usersProjects){
        return usersProjectsService.add(usersProjects);
    }

    @DeleteMapping
    public ResponseEntity<String> delete(@RequestParam Integer id){
        return usersProjectsService.delete(id);
    }

    @PutMapping
    public ResponseEntity<String> update(@RequestBody UsersProjects usersProjects){
        return usersProjectsService.update(usersProjects);
    }

    @GetMapping("/{id}")
    public UsersProjectsDTO getByid(@PathVariable Integer id){
        return usersProjectsService.getByid(id);
    }

    @GetMapping("allUsers/{projectId}")
    public List<UsersProjectsDTO> getByproject(@PathVariable Integer projectId){
        return usersProjectsService.getByproject(projectId);
    }

    @GetMapping("allProjects/{userId}")
    public List<UsersProjectsDTO> getByuser(@PathVariable Integer userId){
        return usersProjectsService.getByuser(userId);
    }

    @GetMapping("time_spent/{id}")
    public UsersProjectsDTO getByidWithTimeSpent(@PathVariable Integer id){
        return usersProjectsService.getByidWithTimeSpent(id);
    }

    @GetMapping("/search")
    public List<UsersProjectsDTO> searchUsersProjects(@RequestBody UsersProjectsFilter usersProjectsFilter){
        return usersProjectsService.searchUsersProjects(usersProjectsFilter);
    }

}
