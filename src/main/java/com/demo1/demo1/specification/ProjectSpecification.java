package com.demo1.demo1.specification;

import com.demo1.demo1.filter.ProjectFilter;
import com.demo1.demo1.entity.Projects;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class ProjectSpecification {

    public static Specification<Projects> filterByAll(ProjectFilter projectFilter) {

        return (Root < Projects > root,CriteriaQuery<?> query, CriteriaBuilder builder) -> {

            List<Predicate> predicates = new ArrayList<>();

            if (projectFilter.getName() != null && !projectFilter.getName().isEmpty()) {
                predicates.add(builder.like(builder.lower(root.get("name")), "%" + projectFilter.getName().toLowerCase() + "%"));
            }

            if (projectFilter.getResponsibleUser() != null) {
                predicates.add(builder.like(root.get("users").get("name"),  projectFilter.getResponsibleUser()));
            }

            return builder.and(predicates.toArray(new Predicate[0]));
        };
    }
}
