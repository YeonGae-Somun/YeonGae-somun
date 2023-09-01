package com.jpa.yeongaesomun.service.admin.adminUser;

import com.jpa.yeongaesomun.domain.entity.member.User;
import com.jpa.yeongaesomun.domain.entity.member.Search;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface AdminUserService {
    //    게시글 목록
//    public List<PostDTO> getList();
    public Page<User> getList(Pageable pageable, Search userSearch);

    //    게시글 조회
    public User getUser(Long id);

    public void update(User user);

    public void deleteAllById(List<Long> id);

    default User toEntity(User user){
        return User.builder()
                .id(user.getId())
                .userEmail(user.getUserEmail())
                .userNickname(user.getUserNickname())
                .userCellPhone(user.getUserCellPhone())
                .userName(user.getUserName())
                .userPassword(user.getUserPassword())
                .memberGender(user.getUserGender())
                .memberLoginType(user.getUserLoginType())
                .memberRole(user.getUserRole())
                .memberStatus(user.getUserStatus())
                .memberType(user.getUserType())
                .build();
    }
}
