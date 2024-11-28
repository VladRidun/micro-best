package ru.services.countryservice.service;

import ru.services.countryservice.dto.CountryResponseDto;

public interface CountryService {
    CountryResponseDto getCountry(Long id);
}