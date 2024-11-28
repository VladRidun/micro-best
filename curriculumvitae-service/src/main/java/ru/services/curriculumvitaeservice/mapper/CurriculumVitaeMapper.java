package ru.services.curriculumvitaeservice.mapper;

import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import ru.services.curriculumvitaeservice.dto.CurriculumVitaeRequestDto;
import ru.services.curriculumvitaeservice.dto.CurriculumVitaeResponseDto;
import ru.services.curriculumvitaeservice.model.CurriculumVitae;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        builder = @Builder(disableBuilder = true))
public interface CurriculumVitaeMapper {
    CurriculumVitaeResponseDto getDtoFromEntity(CurriculumVitae curriculumVitae);
    CurriculumVitae getEntityFromDto(CurriculumVitaeRequestDto dto);
}