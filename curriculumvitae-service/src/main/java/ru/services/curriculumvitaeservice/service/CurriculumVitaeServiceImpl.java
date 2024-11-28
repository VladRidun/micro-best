package ru.services.curriculumvitaeservice.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.services.curriculumvitaeservice.dto.CurriculumVitaeRequestDto;
import ru.services.curriculumvitaeservice.dto.CurriculumVitaeResponseDto;
import ru.services.curriculumvitaeservice.mapper.CurriculumVitaeMapper;
import ru.services.curriculumvitaeservice.model.CurriculumVitae;
import ru.services.curriculumvitaeservice.repository.CurriculumVitaeRepository;

@Service
@AllArgsConstructor
public class CurriculumVitaeServiceImpl implements CurriculumVitaeService {

    private final CurriculumVitaeRepository curriculumVitaeRepository;
    private final CurriculumVitaeMapper curriculumVitaeMapper;


    @Override
    public CurriculumVitaeResponseDto getCvOfUser(String uuid) {
        return curriculumVitaeMapper.getDtoFromEntity(curriculumVitaeRepository.getByUuid(uuid));
    }

    @Override
    public CurriculumVitaeResponseDto save(CurriculumVitaeRequestDto curriculumVitaeDto) {
        CurriculumVitae curriculumVitae = curriculumVitaeMapper.getEntityFromDto(curriculumVitaeDto);
        return curriculumVitaeMapper.getDtoFromEntity(curriculumVitaeRepository.save(curriculumVitae));
    }
}