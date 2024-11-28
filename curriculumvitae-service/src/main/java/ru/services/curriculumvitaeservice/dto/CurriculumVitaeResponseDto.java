package ru.services.curriculumvitaeservice.dto;

public record CurriculumVitaeResponseDto(String name,
                                 String surname,
                                 Long country_id,
                                 String city) {
}