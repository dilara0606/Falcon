package com.demo1.demo1.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Integer password;
    private String surname;

    @OneToMany(mappedBy = "users", fetch = FetchType.EAGER)
    private List<UsersProjects> usersProjectsList;

}
