package com.demo1.demo1.specification;

import com.demo1.demo1.filter.UsersProjectsFilter;
import com.demo1.demo1.entity.UsersProjects;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class UsersProjectsSpecification {
    public static Specification<UsersProjects> filterByAll(UsersProjectsFilter usersProjectsFilter){
        return (Root< UsersProjects > root, CriteriaQuery<?> query, CriteriaBuilder builder) -> {

            List<Predicate> predicates = new ArrayList<>();

            if (usersProjectsFilter.getUserName() != null ) {
                predicates.add(builder.like(root.get("users").get("name"), usersProjectsFilter.getUserName()));
            }

            if (usersProjectsFilter.getProjectName() != null ) {
                predicates.add(builder.like(root.get("projects").get("name"), usersProjectsFilter.getProjectName()));
            }

            return builder.and(predicates.toArray(new Predicate[0]));
        };
    }
}
