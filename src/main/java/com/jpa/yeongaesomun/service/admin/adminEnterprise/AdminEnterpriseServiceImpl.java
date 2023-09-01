package com.jpa.yeongaesomun.service.admin.adminEnterprise;

import com.jpa.yeongaesomun.domain.entity.member.Enterprise;
import com.jpa.yeongaesomun.domain.entity.member.EnterpriseDTO;
import com.jpa.yeongaesomun.domain.entity.member.Search;
import com.jpa.yeongaesomun.domain.entity.notice.NoticeDTO;
import com.jpa.yeongaesomun.repository.admin.adminEnterpriseRepository.AdminEnterpriseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AdminEnterpriseServiceImpl implements AdminEnterpriseService {
    private final AdminEnterpriseRepository adminEnterpriseRepository;


    @Override
    @Transactional
    public void write(Enterprise enterprise) {
        adminEnterpriseRepository.save(toEntity(enterprise));
    }

    @Override
    @Transactional
    public Page<Enterprise> getList(Pageable pageable, Search enterpriseSearch) {
        return adminEnterpriseRepository.findAllWithPaging(pageable, enterpriseSearch);
    }


    @Override
    @Transactional
    public Optional<Enterprise> getEnterprise(Long id) {
        return adminEnterpriseRepository.findById(id);
    }

    @Override
    @Transactional
    public EnterpriseDTO getEnterpriseDTO(Long id) {
        return adminEnterpriseRepository.findEnterpriseDTOById(id).orElseThrow(RuntimeException::new);
    }

    @Override
    @Transactional
    public void update(Enterprise enterprise) {
        adminEnterpriseRepository.updateById(toEntity(enterprise));
    }

    @Override
    public void update(EnterpriseDTO enterpriseDTO) {
        adminEnterpriseRepository.findById(enterpriseDTO.getId()).ifPresent(enterprise -> {
            enterprise.setEBusineesName(enterpriseDTO.getEBusineesName());
            enterprise.setEManager(enterpriseDTO.getEManager());
            enterprise.setEContent(enterpriseDTO.getEContent());
        });
    }

    @Override
    public void deleteAllById(List<Long> ids) {
        adminEnterpriseRepository.deleteAllById(ids);
    }
}
