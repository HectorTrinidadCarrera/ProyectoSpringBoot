package com.edticsa.demoCrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edticsa.demoCrud.models.Country;


public interface CountryRepository extends JpaRepository<Country, String> {

}
