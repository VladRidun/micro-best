package ru.services.countryservice.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.services.countryservice.dto.CountryResponseDto;
import ru.services.countryservice.mapper.CountryMapper;
import ru.services.countryservice.repository.CountryRepository;

@Service
@AllArgsConstructor
public class CountryServiceImpl implements CountryService {

    private CountryRepository countryRepository;
    private CountryMapper countryMapper;

    @Override
    public CountryResponseDto getCountry(Long id) {
        return countryMapper.fromEntityToDto(countryRepository.findById(id).orElse(null));
    }
}