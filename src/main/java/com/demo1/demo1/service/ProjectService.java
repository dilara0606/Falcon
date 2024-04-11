package com.demo1.demo1.service;

import com.demo1.demo1.filter.ProjectFilter;
import com.demo1.demo1.repository.ProjectDao;
import com.demo1.demo1.dto.ProjectDTO;
import com.demo1.demo1.mapper.ProjectMapper;
import com.demo1.demo1.entity.Projects;
import com.demo1.demo1.specification.ProjectSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {

    @Autowired
    ProjectDao projectDao;
    public List<ProjectDTO> getAllProjects(){
        return ProjectMapper.convertList(projectDao.findAll());
    }

    public ResponseEntity<String> addProject(Projects project) {
        ProjectMapper.convert(projectDao.save(project));
        return new ResponseEntity<>("success", HttpStatus.OK);
    }

    public ResponseEntity<String> deleteProject(Integer id) {
        projectDao.deleteById(id);
        return new ResponseEntity<>("success", HttpStatus.OK);
    }

    public ResponseEntity<String> updateProject(Projects project) {
        ProjectMapper.convert(projectDao.save(project));
        return new ResponseEntity<>("success", HttpStatus.OK);
    }

    public ProjectDTO getProjectByID(Integer id) {
            return ProjectMapper.convert(projectDao.findByid(id));
    }

    public List<ProjectDTO> searchProject(ProjectFilter filter){
        return ProjectMapper.convertList(projectDao.findAll(ProjectSpecification.filterByAll(filter)));
    }


}
