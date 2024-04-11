package com.demo1.demo1.controller;

import com.demo1.demo1.dto.TimeSpentDTO;
import com.demo1.demo1.filter.TimeSpentFilter;
import com.demo1.demo1.entity.TimeSpent;
import com.demo1.demo1.service.TimeSpentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("time_spent")
public class TimeSpentController {
    @Autowired
    TimeSpentService timeSpentService;

    @GetMapping("all")
    public List<TimeSpentDTO> getAll(@RequestParam int pageNumber, @RequestParam int pageSize){
        return timeSpentService.getAll(pageNumber, pageSize);
    }

    @PostMapping("add")
    public ResponseEntity<String> add(@RequestBody TimeSpent timeSpent){
        return timeSpentService.add(timeSpent);
    }

    @DeleteMapping
    public ResponseEntity<String> delete(@RequestParam Integer id){
        return timeSpentService.delete(id);
    }

    @PutMapping
    public ResponseEntity<String> update(@RequestBody TimeSpent timeSpent){
        return timeSpentService.update(timeSpent);
    }

    @GetMapping("/{id}")
    public TimeSpentDTO getByID(@PathVariable Integer id){
        return timeSpentService.getByID(id);
    }

    @PostMapping("search/timeSpent")
    public List<TimeSpentDTO> searchTimeSpent(@RequestBody TimeSpentFilter timeSpentFilter){
        return timeSpentService.searchTimeSpent(timeSpentFilter);
    }
}
