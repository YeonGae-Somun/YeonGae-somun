package com.jpa.yeongaesomun.repository.dayexperienceRepository;

import com.jpa.yeongaesomun.domain.dto.dayexperience.DayExperienceDTO;
import com.jpa.yeongaesomun.domain.dto.dayexperience.DayExperienceSearch;
import com.jpa.yeongaesomun.domain.entity.dayexperience.DayExperience;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface DayExperienceQueryDSL {
    public Page<DayExperienceDTO> findAllWithReplyCount(Pageable pageable, DayExperienceSearch postSearch);

    //    게시글 조회
    public Optional<DayExperience> findDayExperienceById(Long id);
}
