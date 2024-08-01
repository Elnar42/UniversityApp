package com.example.university.controller.app_controller;

import com.example.university.dto.UniversityDTO;
import com.example.university.entity.main_entities.University;
import com.example.university.service.app_service.MainService;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CacheConfig(cacheNames = "universities")
@RestController
@RequestMapping("/universities")
public class UniversityController extends MainController<UniversityDTO, Long, University> {
    public UniversityController(MainService<UniversityDTO, Long, University> service) {
        super(service);
    }


}
