package com.demo1.demo1.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
@Entity
@Table(name = "time_spent")
public class TimeSpent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Date date;
    private Integer times;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UsersProjects users_projects;
}
