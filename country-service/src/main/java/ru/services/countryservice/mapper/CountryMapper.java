package ru.services.countryservice.mapper;

import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import ru.services.countryservice.dto.CountryResponseDto;
import ru.services.countryservice.model.Country;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        builder = @Builder(disableBuilder = true))
public interface CountryMapper {

    Country fromDtoToEntity(Country requestDto);

    CountryResponseDto fromEntityToDto(Country entity);
}