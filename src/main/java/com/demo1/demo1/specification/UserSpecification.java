package com.demo1.demo1.specification;

import com.demo1.demo1.filter.UserFilter;
import com.demo1.demo1.entity.Users;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class UserSpecification  {
    public static Specification<Users> searchUser(UserFilter userFilter) {
        return (Root < Users > root, CriteriaQuery < ?>query, CriteriaBuilder builder) -> {

            List<Predicate> predicates = new ArrayList<>();

            if (userFilter.getName() != null && !userFilter.getName().isEmpty()) {
                predicates.add(builder.like(builder.lower(root.get("name")),
                        "%" + userFilter.getName().toLowerCase() + "%"));
            }

            if (userFilter.getSurname() != null && !userFilter.getSurname().isEmpty()) {
                predicates.add(builder.like(builder.lower(root.get("surname")),
                        "%" + userFilter.getSurname().toLowerCase() + "%"));
            }

            return builder.and(predicates.toArray(new Predicate[0]));
        };
    }
}
