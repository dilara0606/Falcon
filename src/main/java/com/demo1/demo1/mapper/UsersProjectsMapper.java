package com.demo1.demo1.mapper;

import com.demo1.demo1.dto.UsersProjectsDTO;
import com.demo1.demo1.entity.UsersProjects;

import java.util.ArrayList;
import java.util.List;

public class UsersProjectsMapper {
    public static UsersProjectsDTO convert(UsersProjects usersProjects) {
        return UsersProjectsDTO.builder()
                .userDTO(UsersMapper.convertWithoutProjects(usersProjects.getUsers()))
                .projectDTO(ProjectMapper.convert(usersProjects.getProjects()))
                .build();
    }

    public static UsersProjectsDTO convertWithoutUser(UsersProjects usersProjects) {
        return UsersProjectsDTO.builder()
                .projectDTO(ProjectMapper.convert(usersProjects.getProjects()))
                .build();
    }

    public static List<UsersProjectsDTO> convertList(List<UsersProjects> usersProjectsList ){
        List<UsersProjectsDTO> usersProjectsDTOList = new ArrayList<>();
        for (UsersProjects usersProjects : usersProjectsList){
            usersProjectsDTOList.add(convert(usersProjects));
        }
        return usersProjectsDTOList;
    }

    public static List<UsersProjectsDTO> convertListWithoutUser(List<UsersProjects> usersProjectsList ){
        List<UsersProjectsDTO> usersProjectsDTOList = new ArrayList<>();
        for (UsersProjects usersProjects : usersProjectsList){
            usersProjectsDTOList.add(convertWithoutUser(usersProjects));
        }
        return usersProjectsDTOList;
    }

    public static UsersProjectsDTO convertWithTimeSpent(UsersProjects usersProjects) {
        return UsersProjectsDTO.builder()
                .userDTO(UsersMapper.convertWithoutProjects(usersProjects.getUsers()))
                .projectDTO(ProjectMapper.convert(usersProjects.getProjects()))
                .timeSpentList(TimeSpentMapper.convertListWithoutProjects(usersProjects.getTimeSpentList()))
                .build();
    }
}
