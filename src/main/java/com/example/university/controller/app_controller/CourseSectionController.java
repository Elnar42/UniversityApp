package com.example.university.controller.app_controller;


import com.example.university.dto.CourseSectionDTO;
import com.example.university.entity.main_entities.CourseSection;
import com.example.university.service.app_service.MainService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/coursesSections")

public class CourseSectionController extends MainController<CourseSectionDTO, Long, CourseSection> {
    public CourseSectionController(MainService<CourseSectionDTO, Long, CourseSection> service) {
        super(service);
    }
}
