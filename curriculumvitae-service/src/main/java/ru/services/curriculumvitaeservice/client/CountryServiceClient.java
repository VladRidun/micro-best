package ru.services.curriculumvitaeservice.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import ru.services.curriculumvitaeservice.dto.CountryResponseDto;

@Component
public class CountryServiceClient {
    @Autowired
    private RestTemplate restTemplate;

    public CountryResponseDto getCountry(Long countryCode) {
        return restTemplate.getForObject("http://COUNTRY-SERVICE"+"/country/" + countryCode, CountryResponseDto.class);
    }
}