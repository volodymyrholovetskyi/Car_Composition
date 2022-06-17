package com.holovetskyi.carcomposition.infrastracter.repo;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class CarRepo {

    @Value("${repo.filename}")
    String filename;


}
