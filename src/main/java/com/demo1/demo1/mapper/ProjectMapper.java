package com.demo1.demo1.mapper;

import com.demo1.demo1.dto.ProjectDTO;
import com.demo1.demo1.entity.Projects;

import java.util.ArrayList;
import java.util.List;

public class ProjectMapper {
    public static ProjectDTO convert(Projects projects) {
        return ProjectDTO.builder()
                .name(projects.getName())
                .userDTO(UsersMapper.convertWithoutProjects(projects.getUsers()))
                .build();
    }

    public static ProjectDTO convertWithoutUsers(Projects projects) {
        return ProjectDTO.builder()
                .name(projects.getName())
                .build();
    }

    public static ProjectDTO convertWithoutProject(Projects projects) {
        return ProjectDTO.builder()
                .userDTO(UsersMapper.convertWithoutProjects(projects.getUsers()))
                .build();
    }

    public static List<ProjectDTO> convertList(List<Projects> projectsList ){
        List<ProjectDTO> projectDTOList = new ArrayList<>();
        for (Projects projects : projectsList){
            projectDTOList.add(convert(projects));
        }
        return projectDTOList;
    }

    public static List<ProjectDTO> convertListWithoutProject(List<Projects> projectsList ){
        List<ProjectDTO> projectDTOList = new ArrayList<>();
        for (Projects projects : projectsList){
            projectDTOList.add(convertWithoutProject(projects));
        }
        return projectDTOList;
    }

}
