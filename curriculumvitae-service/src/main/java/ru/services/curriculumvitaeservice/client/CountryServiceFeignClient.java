package ru.services.curriculumvitaeservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.services.curriculumvitaeservice.dto.CountryResponseDto;

@FeignClient(name = "COUNTRY-SERVICE")
public interface CountryServiceFeignClient {

    @GetMapping("/country/{countryId}")
    CountryResponseDto getCountry(@PathVariable  Long countryId);
}