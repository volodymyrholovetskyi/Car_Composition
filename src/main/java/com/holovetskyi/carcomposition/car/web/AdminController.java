package com.holovetskyi.carcomposition.car.web;

import com.holovetskyi.carcomposition.car.application.CarInitializerService;
import com.holovetskyi.carcomposition.car.web.dto.CreateFilenameDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;



@RestController
@RequiredArgsConstructor
@RequestMapping("admin")
public class AdminController {
    private final CarInitializerService initializer;

    @PostMapping("/initialization")
    public void initialize(@Valid @RequestBody CreateFilenameDto filenameDto) {
        initializer.initialize(filenameDto);
    }
}
