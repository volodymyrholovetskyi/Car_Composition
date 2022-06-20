package com.holovetskyi.carcomposition.web;

import com.holovetskyi.carcomposition.application.port.CarInitializerUseCase;
import com.holovetskyi.carcomposition.domain.CarValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("admin")
public class AdminController {
    private final CarInitializerUseCase initializer;
    private CarValidator carValidator;

    @PostMapping("/initialization")
    public void initialize() {
        initializer.initialize();
    }
}
