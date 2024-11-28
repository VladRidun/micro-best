package ru.services.curriculumvitaeservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.services.curriculumvitaeservice.model.CurriculumVitae;

@Repository
public interface CurriculumVitaeRepository extends JpaRepository<CurriculumVitae, Long> {
    CurriculumVitae getByUuid(String uuid);
}