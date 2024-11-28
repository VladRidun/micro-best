package ru.services.curriculumvitaeservice.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.services.curriculumvitaeservice.client.CountryServiceFeignClient;
import ru.services.curriculumvitaeservice.dto.CountryResponseDto;
import ru.services.curriculumvitaeservice.dto.CurriculumVitaeRequestDto;
import ru.services.curriculumvitaeservice.dto.CurriculumVitaeResponseDto;
import ru.services.curriculumvitaeservice.service.CurriculumVitaeService;

@RestController
@AllArgsConstructor
@RequestMapping("/cvs")
public class CurriculumVitaeController {
    private final CurriculumVitaeService curriculumVitaeService;
    private final CountryServiceFeignClient countryServiceFeignClient;

    @GetMapping("/{id}")
    ResponseEntity<CurriculumVitaeResponseDto> getById(@PathVariable(name = "id") String uuid) {
        CurriculumVitaeResponseDto curriculumVitaeResponseDto = curriculumVitaeService.getCvOfUser(uuid);
        return new ResponseEntity<>(curriculumVitaeResponseDto, HttpStatus.OK);
    }

    @GetMapping("/country/{id}")
    ResponseEntity<CountryResponseDto> getByCountryId(@PathVariable(name = "id") Long id) {
        CountryResponseDto countryResponseDto = countryServiceFeignClient.getCountry(id);
        return new ResponseEntity<>(countryResponseDto, HttpStatus.OK);
    }

    @PostMapping
    ResponseEntity<CurriculumVitaeResponseDto> save(@RequestBody CurriculumVitaeRequestDto curriculumVitaeDto) {
        CurriculumVitaeResponseDto curriculumVitaeDtoResult = curriculumVitaeService.save(curriculumVitaeDto);
        return new ResponseEntity<>(curriculumVitaeDtoResult, HttpStatus.OK);
    }
}