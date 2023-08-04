package com.jpa.yeongaesomun.service.introduce;

import com.jpa.yeongaesomun.domain.dto.introduce.IntroduceDTO;
import com.jpa.yeongaesomun.domain.dto.introduce.IntroduceSearch;
import com.jpa.yeongaesomun.domain.entity.introduce.Introduce;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

// 문우람 - 관리자 페이지

public interface IntroduceService {
//    게시글 목록
    public Page<IntroduceDTO> getList(Pageable pageable, IntroduceSearch introduceSearch);

//    게시글 조회
    public IntroduceDTO getIntroduce(Long id);

    public default IntroduceDTO toIntroduce(Introduce introduce) {
        return IntroduceDTO.builder()
                .id(introduce.getId())
                .introduceTitle(introduce.getIntroduceBoardTitle())
                .introduceContent(introduce.getIntroduceBoardContent())
                .build();
    }
}
