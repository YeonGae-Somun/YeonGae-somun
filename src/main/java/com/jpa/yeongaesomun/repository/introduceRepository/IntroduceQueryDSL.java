package com.jpa.yeongaesomun.repository.introduceRepository;

import com.jpa.yeongaesomun.domain.dto.introduce.IntroduceDTO;
import com.jpa.yeongaesomun.domain.dto.introduce.IntroduceSearch;
import com.jpa.yeongaesomun.domain.entity.introduce.Introduce;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

// 문우람 - 관리자페이지

public interface IntroduceQueryDSL {

//    게시글 목록
    public Page<IntroduceDTO> findAll(Pageable pageable, IntroduceSearch introduceSearch);

//    게시글 조회
    public Optional<Introduce> findPostById(Long id);
}
