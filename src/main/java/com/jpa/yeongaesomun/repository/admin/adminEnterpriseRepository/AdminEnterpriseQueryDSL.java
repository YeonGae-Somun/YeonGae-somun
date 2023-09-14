package com.jpa.yeongaesomun.repository.admin.adminEnterpriseRepository;

import com.jpa.yeongaesomun.domain.entity.member.Enterprise;
import com.jpa.yeongaesomun.domain.entity.member.EnterpriseDTO;
import com.jpa.yeongaesomun.domain.entity.member.Search;
import com.jpa.yeongaesomun.domain.entity.notice.NoticeDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface AdminEnterpriseQueryDSL {
    public Page<Enterprise> findAllWithPaging(Pageable pageable, Search search);

    //    이름 수정
    public void updateById(Enterprise enterprise);

    //    상품 목록
    public List<Enterprise> findAll();

    public Optional<EnterpriseDTO> findEnterpriseDTOById(Long id);

    //    이름으로 상품 삭제(이름은 포함이 아닌 같은 지 검사)
    public void deleteByAdminEnterpriseName(Long id);
}
