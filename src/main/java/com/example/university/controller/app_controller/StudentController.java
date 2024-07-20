package com.example.university.controller.app_controller;

import com.example.university.dto.StudentDTO;
import com.example.university.entity.main_entities.Student;
import com.example.university.service.app_service.MainService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/students")
public class StudentController extends MainController<StudentDTO, Long, Student> {


    public StudentController(MainService<StudentDTO, Long, Student> service) {
        super(service);
    }
}
