package com.demo1.demo1.controller;
import com.demo1.demo1.dto.ProjectDTO;
import com.demo1.demo1.filter.ProjectFilter;
import com.demo1.demo1.entity.Projects;
import com.demo1.demo1.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("project")
public class ProjectController {

    @Autowired
    ProjectService projectService;

    @GetMapping("allProjects")
    public List<ProjectDTO> getAllProjects(){
        return projectService.getAllProjects();
    }

    @PostMapping("add")
    public ResponseEntity<String> addProject(@RequestBody Projects project){
        return projectService.addProject(project);
    }

    @DeleteMapping
    public ResponseEntity<String> deleteProject(@RequestParam Integer id){
        return projectService.deleteProject(id);
    }

    @PutMapping
    public ResponseEntity<String> updateProject(@RequestBody Projects project){
        return projectService.updateProject(project);
    }

    @GetMapping("/{id}")
    public ProjectDTO getProjectByID(@PathVariable Integer id){
        return projectService.getProjectByID(id);
    }

    @GetMapping("search/project")
    public List<ProjectDTO> searchByName(@RequestBody ProjectFilter projectFilter){
        return projectService.searchProject(projectFilter);
    }
}
