package com.demo1.demo1.specification;

import com.demo1.demo1.filter.TimeSpentFilter;
import com.demo1.demo1.entity.TimeSpent;
import jakarta.persistence.criteria.*;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class TimeSpentSpecification {

    public static Specification<TimeSpent> searchTimeSpent(TimeSpentFilter timeSpentFilter) {
        return (Root< TimeSpent > root, CriteriaQuery<?> query, CriteriaBuilder builder) -> {

            List<Predicate> predicates = new ArrayList<>();

            if (timeSpentFilter.getTimes() != null ) {
                predicates.add(builder.equal(root.get("times"), timeSpentFilter.getTimes()));
            }

            if (timeSpentFilter.getDate() != null ) {
                predicates.add(builder.like(root.get("date").as(String.class), timeSpentFilter.getDate().toString()));
            }

            if (timeSpentFilter.getUserName() != null && !timeSpentFilter.getUserName().isEmpty()) {
                predicates.add(builder.like(builder.lower(root.get("users_projects").get("users").get("name")),
                        "%" + timeSpentFilter.getUserName().toLowerCase() + "%"));
            }

            if (timeSpentFilter.getUserSurname() != null && !timeSpentFilter.getUserSurname().isEmpty()) {
                predicates.add(builder.like(builder.lower(root.get("users_projects").get("users").get("surname")),
                        "%" + timeSpentFilter.getUserSurname().toLowerCase() + "%"));
            }

            if (timeSpentFilter.getProjectName() != null && !timeSpentFilter.getProjectName().isEmpty() ) {
                predicates.add(builder.like(root.get("users_projects").get("projects").get("name"), timeSpentFilter.getProjectName()));
            }

            return builder.and(predicates.toArray(new Predicate[0]));
        };
    }
}
