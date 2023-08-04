package com.jpa.yeongaesomun.service.introduce;

import com.jpa.yeongaesomun.domain.dto.introduce.IntroduceDTO;
import com.jpa.yeongaesomun.domain.dto.introduce.IntroduceSearch;
import com.jpa.yeongaesomun.domain.entity.introduce.Introduce;
import com.jpa.yeongaesomun.repository.introduceRepository.IntroduceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class IntroduceServiceImpl implements IntroduceService {
    private final IntroduceRepository introduceRepository;

    @Override
    public Page<IntroduceDTO> getList(Pageable pageable, IntroduceSearch introduceSearch) {
        return introduceRepository.findAll(pageable, introduceSearch);
    }


    @Override
    public IntroduceDTO getIntroduce(Long id) {
        final IntroduceDTO introduceDTO = toIntroduce(introduceRepository.findPostById(id).orElseThrow(() -> {
            throw new RuntimeException();
        }));

        return introduceDTO;
    }
}
