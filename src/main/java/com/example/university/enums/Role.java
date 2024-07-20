package com.example.university.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.List;
import java.util.Set;

@Getter
@RequiredArgsConstructor
public enum Role {
    STUDENT(
            Set.of(
                    Permission.VIEW_COURSES,
                    Permission.VIEW_ENROLLMENT,
                    Permission.VIEW_GRADE,
                    Permission.VIEW_SECTION
            )
    ),
    PROFESSOR(
            Set.of(
                    Permission.VIEW_COURSES,
                    Permission.VIEW_STUDENT,
                    Permission.UPDATE_GRADE,
                    Permission.UPDATE_SECTION,
                    Permission.UPDATE_COURSE
            )
    ),
    MANAGER(
            Set.of(
                    Permission.DELETE_COURSE,
                    Permission.ADD_COURSE,
                    Permission.VIEW_TEACHERS,
                    Permission.VIEW_SCHOOL,
                    Permission.VIEW_PROFESSOR,
                    Permission.VIEW_ENROLLMENT,
                    Permission.ADD_PROFESSOR,
                    Permission.VIEW_SECTION,
                    Permission.VIEW_STUDENT,
                    Permission.ADD_STUDENT,
                    Permission.UPDATE_COURSE,
                    Permission.UPDATE_ENROLLMENT,
                    Permission.UPDATE_TEACHER
            )
    ),
    ADMIN(
            Set.of(
                    Permission.values()
            )
    );


    private final Set<Permission> permissions;

    public List<SimpleGrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> list = new java.util.ArrayList<>(getPermissions()
                .stream()
                .map(role -> new SimpleGrantedAuthority(role.getPermission()))
                .toList());
        list.add(new SimpleGrantedAuthority(this.name()));
        return list;

    }
}

