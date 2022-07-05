package com.holovetskyi.carcomposition.car.application;

import com.holovetskyi.carcomposition.car.domain.Car;
import com.holovetskyi.carcomposition.car.domain.enums.EngineType;
import com.holovetskyi.carcomposition.car.infrastracter.repo.CarRepo;
import com.holovetskyi.carcomposition.car.web.dto.CriterionDto;
import com.holovetskyi.carcomposition.car.web.dto.BodyTypeAndPriceDto;
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

    public List<Car> sort(CriterionDto criterion) {

        return criterion.isDescending() ?
                switch (criterion.getCriterionType()) {
                    case POWER -> getAllCars().stream().sorted(compareByPower).toList();
                    case SIZE -> getAllCars().stream().sorted(compareBySize).toList();
                    default -> getAllCars().stream().map(Car::newCarWithSortedComponents).toList();
                } :
                switch (criterion.getCriterionType()) {
                    case POWER -> getAllCars().stream().sorted(compareByPowerDesc).toList();
                    case SIZE -> getAllCars().stream().sorted(compareBySizeDesc).toList();
                    default -> getAllCars().stream().map(Car::newCarWithSortedComponentsDesc).toList();
                };
    }

    /**
     *  Metoda zwraca kolekcję samochodów o określonym rodzaju nadwozia
     * przekazanym jako argument (CarBodyType) oraz o cenie z
     * przedziału <a, b>, gdzie a oraz b to kolejne argumenty metody.
     */

    public List<Car> filterByBodyTypeAndPriceFromTo(BodyTypeAndPriceDto bodyTypeAndPrice) {

        return getAllCars()
                .stream()
                .filter(car -> car.hasBeBodyType())
                .filter(car -> car.hasPriceBetween(bodyTypeAndPrice.getFrom(), bodyTypeAndPrice.getTo()))
                .toList();
    }

    /**
     * Metoda zwraca posortowaną alfabetycznie kolekcję modeli
     * samochodów, które posiadają typ silnika (EngineType) przekazany
     * jako argument metody.
     */

//    public List<Car> sortByModelAboutSpecificEngineDto(EngineType engineType) {
//        return getAllCars()
//                .stream()
//                .filter()
//    }


    private List<Car> getAllCars() {
        return carRepo.findAll();
    }
}
