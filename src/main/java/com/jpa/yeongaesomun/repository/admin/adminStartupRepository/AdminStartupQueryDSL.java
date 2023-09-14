package com.jpa.yeongaesomun.repository.admin.adminStartupRepository;

import com.jpa.yeongaesomun.domain.entity.member.Search;
import com.jpa.yeongaesomun.domain.entity.member.StartUp;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AdminStartupQueryDSL {
    public Page<StartUp> findAllWithPaging(Pageable pageable, Search search);

    //    이름 수정
    public void updateById(StartUp startUp);

    //    이름으로 상품 삭제(이름은 포함이 아닌 같은 지 검사)
    public void deleteByAdminEnterpriseName(Long id);
}
