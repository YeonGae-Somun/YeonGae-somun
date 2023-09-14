package com.jpa.yeongaesomun.service.dayexperience;

// 문우람 - 일일체험

import com.jpa.yeongaesomun.domain.dto.dayexperience.DayExperienceDTO;
import com.jpa.yeongaesomun.domain.entity.dayexperience.DayExperience;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface DayExperienceService {
    //    게시글 목록
//    public List<PostDTO> getList();
    public Page<DayExperience> getList(Pageable pageable);

    //    게시글 조회
    public DayExperienceDTO getPost(Long id);

    public default DayExperienceDTO toDTO(DayExperience dayExperience) {
        return DayExperienceDTO.builder()
                .id(dayExperience.getId())
                .dayExperienceTitle(dayExperience.getDayExperienceTitle())
                .dayExperienceContent(dayExperience.getDayExperienceContent())
                .build();
    }
}
