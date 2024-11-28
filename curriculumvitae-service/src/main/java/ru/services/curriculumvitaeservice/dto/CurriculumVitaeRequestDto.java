package ru.services.curriculumvitaeservice.dto;

public record CurriculumVitaeRequestDto(String name,
                                        String surname,
                                        Long country_id,
                                        String city) {
}