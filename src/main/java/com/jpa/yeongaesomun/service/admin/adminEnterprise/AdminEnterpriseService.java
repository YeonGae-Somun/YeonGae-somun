package com.jpa.yeongaesomun.service.admin.adminEnterprise;

import com.jpa.yeongaesomun.domain.entity.member.Enterprise;
import com.jpa.yeongaesomun.domain.entity.member.EnterpriseDTO;
import com.jpa.yeongaesomun.domain.entity.member.Search;
import com.jpa.yeongaesomun.domain.entity.notice.NoticeDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface AdminEnterpriseService {
    public void write(Enterprise enterprise);
    //    게시글 목록
//    public List<PostDTO> getList();
    public Page<Enterprise> getList(Pageable pageable, Search enterpriseSearch);

    //    게시글 조회
    public Optional<Enterprise> getEnterprise(Long id);

    public EnterpriseDTO getEnterpriseDTO(Long id);

    public void update(Enterprise enterprise);

    public void update(EnterpriseDTO enterpriseDTO);

    public void deleteAllById(List<Long> id);

    default Enterprise toEntity(Enterprise enterprise){
        return Enterprise.builder()
                .id(enterprise.getId())
                .eAddress(enterprise.getEAddress())
                .eBusinessNumber(enterprise.getEBusinessNumber())
                .eEmployeeCount(enterprise.getEEmployeeCount())
                .eFoundingDate(enterprise.getEFoundingDate())
                .eHomepage(enterprise.getEHomepage())
                .eMajor(enterprise.getEMajor())
                .build();
    }
}
