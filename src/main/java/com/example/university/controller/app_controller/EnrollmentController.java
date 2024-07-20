package com.example.university.controller.app_controller;


import com.example.university.dto.EnrollmentDTO;
import com.example.university.entity.main_entities.Enrollment;
import com.example.university.service.app_service.MainService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/enrollments")
public class EnrollmentController extends MainController<EnrollmentDTO, Long, Enrollment> {
    public EnrollmentController(MainService<EnrollmentDTO, Long, Enrollment> service) {
        super(service);
    }
}
