package com.example.university.controller.app_controller;

import com.example.university.dto.FacultyDTO;
import com.example.university.entity.main_entities.Faculty;
import com.example.university.service.app_service.MainService;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CacheConfig(cacheNames = "faculties")
@RestController
@RequestMapping("/faculties")
public class FacultyController extends MainController<FacultyDTO, Long, Faculty> {
    public FacultyController(MainService<FacultyDTO, Long, Faculty> service) {
        super(service);
    }
}
