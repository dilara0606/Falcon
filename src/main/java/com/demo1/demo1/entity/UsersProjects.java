package com.demo1.demo1.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "users_projects")
public class UsersProjects {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "user_id" , referencedColumnName = "id")
    private Users users;

    @ManyToOne
    @JoinColumn(name = "project_id", referencedColumnName = "id")
    private Projects projects;

    @OneToMany(mappedBy = "users_projects")
    private List<TimeSpent> timeSpentList;
}
