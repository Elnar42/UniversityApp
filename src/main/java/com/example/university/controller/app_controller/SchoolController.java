package com.example.university.controller.app_controller;

import com.example.university.dto.SchoolDTO;
import com.example.university.entity.main_entities.School;
import com.example.university.service.app_service.MainService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/schools")
public class SchoolController extends MainController<SchoolDTO, Long, School> {
    public SchoolController(MainService<SchoolDTO, Long, School> service) {
        super(service);
    }
}

