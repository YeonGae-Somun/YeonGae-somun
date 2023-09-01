package com.jpa.yeongaesomun.service.admin.adminUser;

import com.jpa.yeongaesomun.domain.entity.member.User;
import com.jpa.yeongaesomun.domain.entity.member.Search;
import com.jpa.yeongaesomun.repository.admin.adminUserRepository.AdminUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@RequiredArgsConstructor
public class AdminUserServiceImpl implements AdminUserService {
    private final AdminUserRepository adminUserRepository;

    @Override
    @Transactional
    public Page<User> getList(Pageable pageable, Search userSearch) {
        return adminUserRepository.findAllWithPaging(pageable, userSearch);
    }

    @Override
    @Transactional
    public User getUser(Long id) {
        final User user = toEntity(adminUserRepository.findById(id).orElseThrow(() ->{
            throw new RuntimeException();
        }));

        return user;
    }

    @Override
    @Transactional
    public void update(User user) {

    }

    @Override
    public void deleteAllById(List<Long> ids) {
        adminUserRepository.deleteAllById(ids);
    }
}
