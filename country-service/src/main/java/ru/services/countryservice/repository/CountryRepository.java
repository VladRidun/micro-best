package ru.services.countryservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.services.countryservice.model.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {
}