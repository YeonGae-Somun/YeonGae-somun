package com.jpa.yeongaesomun.service.dayexperience;

import com.jpa.yeongaesomun.domain.dto.dayexperience.DayExperienceDTO;
import com.jpa.yeongaesomun.domain.dto.dayexperience.DayExperienceSearch;
import com.jpa.yeongaesomun.repository.dayexperienceRepository.DayExperienceReepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class DayExperienceServiceImpl implements DayExperienceService {
    private final DayExperienceReepository dayExperienceReepository;

    @Override
    public Page<DayExperienceDTO> getList(Pageable pageable, DayExperienceSearch dayExperienceSearch) {
        return dayExperienceReepository.findAllWithReplyCount(pageable, dayExperienceSearch);
    }

    @Override
    public DayExperienceDTO getPost(Long id) {
        final DayExperienceDTO dayExperienceDTO = toDTO(dayExperienceReepository.findDayExperienceById(id).orElseThrow(() ->{
            throw new RuntimeException();
        }));

//        reply 쓰는곳
//        dayExperienceDTO.setReplyCount();
        return dayExperienceDTO;
    }
}
