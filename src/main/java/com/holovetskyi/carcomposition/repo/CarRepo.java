package com.holovetskyi.carcomposition.repo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

@Repository
public class CarRepo {

    @Value("${repo.filename}")
    String filename;


}
