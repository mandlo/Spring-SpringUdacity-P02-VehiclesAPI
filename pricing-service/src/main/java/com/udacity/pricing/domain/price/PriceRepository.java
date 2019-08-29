package com.udacity.pricing.domain.price;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource
public interface PriceRepository extends JpaRepository<Price, Long> {

    //@CrossOrigin(origins = "http://localhost:8080/cars")
    Price getOne(@Param("vehicleId") Long vehicleId);
}
