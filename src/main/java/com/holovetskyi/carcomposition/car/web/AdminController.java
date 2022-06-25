package com.holovetskyi.carcomposition.car.web;

import com.holovetskyi.carcomposition.car.application.CarInitializerService;
import com.holovetskyi.carcomposition.car.domain.Car;
import com.holovetskyi.carcomposition.car.infrastracter.repo.CarRepo;
import com.holovetskyi.carcomposition.car.web.dto.CreateFilenameDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping(value = "admin", produces = "application/json")
public class AdminController {
    private final CarInitializerService initializer;
    private final CarRepo carRepo;

    @PostMapping("/initialization")
    public void initialize() {
        initializer.initialize();
    }

    @GetMapping
    public List<Car> getCar(){

       return carRepo.init();
    }
}
