package com.holovetskyi.carcomposition.car.application;

import com.holovetskyi.carcomposition.car.domain.Car;
import com.holovetskyi.carcomposition.car.infrastracter.repo.CarRepo;
import com.holovetskyi.carcomposition.car.web.dto.SortCriterionDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.holovetskyi.carcomposition.car.domain.CarUtils.*;

@Service
@RequiredArgsConstructor
public class CarService {

    private final CarRepo carRepo;

    /**
     * Metoda zwraca kolekcję samochodów posortowaną według kryterium
     * podanego jako argument. Metoda powinna umożliwiać sortowanie
     * według ilości komponentów, mocy silnika oraz rozmiaru opony.
     * Dodatkowo metoda powinna umożliwiać sortowanie rosnąco oraz
     * malejąco.
     */

    public List<Car> sort(SortCriterionDto criterion) {

        var sortCriterion = new SortCriterion().toSortCriterion(criterion);

        return sortCriterion.ascending ?
                switch (sortCriterion.sortType) {
                    case POWER -> getCars().stream().sorted(compareByPower).toList();
                    case SIZE -> getCars().stream().sorted(compareBySize).toList();
                    default -> getCars().stream().map(Car::newCarWithSortedComponents).toList();
                } :
                switch (sortCriterion.sortType) {
                    case POWER -> getCars().stream().sorted(compareByPowerDesc).toList();
                    case SIZE -> getCars().stream().sorted(compareBySizeDesc).toList();
                    default -> getCars().stream().map(Car::newCarWithSortedComponentsDesc).toList();
                };

    }


    private List<Car> getCars() {
        return carRepo.getAllCars();
    }
}
