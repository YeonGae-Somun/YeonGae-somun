package com.jpa.yeongaesomun.repository.dayexperienceRepository;

import com.jpa.yeongaesomun.domain.entity.dayexperience.DayExperience;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

import java.util.Optional;

public interface DayExperienceQueryDSL {
    public Page<DayExperience> findAllWithPaging(Pageable pageable);

    public Slice<DayExperience> findAllWithSlice(Pageable pageable);

    //    게시글 조회
    public Optional<DayExperience> findDayExperienceById(Long id);
}
