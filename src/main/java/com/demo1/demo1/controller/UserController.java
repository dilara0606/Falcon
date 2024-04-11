package com.demo1.demo1.controller;

import com.demo1.demo1.dto.UserDTO;
import com.demo1.demo1.filter.UserFilter;
import com.demo1.demo1.entity.Users;
import com.demo1.demo1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/allUsers")
    public List<UserDTO> getAllUser(){
        return userService.getAllUser();
    }

    @GetMapping("/add")
    public String addUser(Model model){
        //return userService.addUser(user);
        Users users = new Users();
        model.addAttribute("user", users);
        return "add_user";
    }

    @PostMapping("")
    public String saveUser(@ModelAttribute("user") Users users){
        userService.addUser(users);
        return "redirect:/users";
    }

    @DeleteMapping
    public ResponseEntity<String> deleteUser(@RequestParam Integer id){
        return userService.deleteUser(id);
    }

    @PutMapping
    public ResponseEntity<String> updateUser(@RequestBody Users user){
        return userService.updateUser(user);
    }

    @GetMapping("/{id}")
    public UserDTO getUserByID(@PathVariable Integer id){
        return userService.getUserByID(id);
    }

    @GetMapping("allProjects/{id}")
    public UserDTO  getProjectsByID(@PathVariable Integer id){
        return userService.getProjectsByID(id);
    }

    @PostMapping("search/user")
    public List<UserDTO> searchByName(@RequestBody UserFilter userFilter){
        return userService.searchUser(userFilter);
    }

}
