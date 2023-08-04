package com.jpa.yeongaesomun.repository.dayexperienceRepository;

import com.jpa.yeongaesomun.domain.entity.dayexperience.DayExperience;
import com.jpa.yeongaesomun.repository.introduceRepository.IntroduceQueryDSL;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DayExperienceReepository extends JpaRepository<DayExperience, Long>, DayExperienceQueryDSL {
}
