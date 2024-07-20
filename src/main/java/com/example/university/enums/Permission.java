package com.example.university.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Permission {
    // View permissions
    VIEW_COURSES("course::view"),
    VIEW_TEACHERS("teacher::view"),
    VIEW_STUDENT("student::view"),
    VIEW_UNIVERSITY("university::view"),
    VIEW_SCHOOL("school::view"),
    VIEW_PROGRAM("program::view"),
    VIEW_PROFESSOR("professor::view"),
    VIEW_ENROLLMENT("enrollment::view"),
    VIEW_SECTION("section::view"),
    VIEW_GRADE("grade::view"),

    // Add permissions
    ADD_COURSE("course::add"),
    ADD_TEACHER("teacher::add"),
    ADD_STUDENT("student::add"),
    ADD_PROGRAM("program::add"),
    ADD_SECTION("section::add"),
    ADD_PROFESSOR("professor::add"),
    ADD_ENROLLMENT("enrollment::add"),
    ADD_UNIVERSITY("university::add"),
    ADD_SCHOOL("school::add"),

    // Update permissions
    UPDATE_COURSE("course::update"),
    UPDATE_TEACHER("teacher::update"),
    UPDATE_STUDENT("student::update"),
    UPDATE_PROGRAM("program::update"),
    UPDATE_SECTION("section::update"),
    UPDATE_PROFESSOR("professor::update"),
    UPDATE_ENROLLMENT("enrollment::update"),
    UPDATE_UNIVERSITY("university::update"),
    UPDATE_SCHOOL("school::update"),
    UPDATE_GRADE("grade::update"),

    // Delete permissions
    DELETE_COURSE("course::delete"),
    DELETE_TEACHER("teacher::delete"),
    DELETE_STUDENT("student::delete"),
    DELETE_PROGRAM("program::delete"),
    DELETE_SECTION("section::delete"),
    DELETE_PROFESSOR("professor::delete"),
    DELETE_ENROLLMENT("enrollment::delete"),
    DELETE_UNIVERSITY("university::delete"),
    DELETE_SCHOOL("school::delete");

    private final String permission;
}
