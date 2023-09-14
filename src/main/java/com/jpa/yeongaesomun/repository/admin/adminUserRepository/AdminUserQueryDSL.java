package com.jpa.yeongaesomun.repository.admin.adminUserRepository;

import com.jpa.yeongaesomun.domain.entity.member.User;
import com.jpa.yeongaesomun.domain.entity.member.Search;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface AdminUserQueryDSL {

    //찾기 서비스
    public Page<User> findAllWithPaging(Pageable pageable, Search userSearch);

    //    게시글 조회
    public Optional<User> findPostById(Long id);

    //    이름으로 상품 삭제(이름은 포함이 아닌 같은 지 검사)
    public void deleteByAdminMemberName(Long id);

}
