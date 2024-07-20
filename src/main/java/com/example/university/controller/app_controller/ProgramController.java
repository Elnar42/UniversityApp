package com.example.university.controller.app_controller;

import com.example.university.dto.ProgramDTO;
import com.example.university.entity.main_entities.Program;
import com.example.university.service.app_service.MainService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/programs")
public class ProgramController extends MainController<ProgramDTO, Long, Program> {

    public ProgramController(MainService<ProgramDTO, Long, Program> service) {
        super(service);
    }
}
