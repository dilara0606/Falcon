package com.demo1.demo1.mapper;

import com.demo1.demo1.dto.UserDTO;
import com.demo1.demo1.entity.Users;

import java.util.ArrayList;
import java.util.List;

public class UsersMapper {

    public static UserDTO convertWithoutProjects(Users users) {

        return UserDTO.builder()
                .name(users.getName())
                .surname(users.getSurname())
                .build();
    }

   public static UserDTO convert(Users users) {

        return UserDTO.builder()
                .name(users.getName())
                .surname(users.getSurname())
                .usersProjectsDTOList(UsersProjectsMapper.convertListWithoutUser(users.getUsersProjectsList()))
                .build();
    }

    public static List<UserDTO> convertList(List<Users> usersList ){
        List<UserDTO> usersDTOList = new ArrayList<>();
        for (Users users : usersList){
            usersDTOList.add(convertWithoutProjects(users));
        }
        return usersDTOList;
    }

    public static List<UserDTO> convertListWithProjects(List<Users> usersList ){
        List<UserDTO> usersDTOList = new ArrayList<>();
        for (Users users : usersList){
            usersDTOList.add(convert(users));
        }
        return usersDTOList;
    }

}
