package ru.services.countryservice.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.services.countryservice.dto.CountryResponseDto;
import ru.services.countryservice.service.CountryService;

@RestController
@AllArgsConstructor
@RequestMapping("/country")
public class CountryController {
    private final CountryService countryService;

    @GetMapping("/{id}")
    ResponseEntity<CountryResponseDto> getById(@PathVariable(name = "id") Long id) {
        CountryResponseDto countryResponseDto = countryService.getCountry(id);
        return new ResponseEntity<>(countryResponseDto, HttpStatus.OK);
    }
}