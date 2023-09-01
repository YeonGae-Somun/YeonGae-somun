package com.jpa.yeongaesomun.repository.admin.adminUserRepository;

import com.jpa.yeongaesomun.domain.entity.member.Search;
import com.jpa.yeongaesomun.domain.entity.member.User;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

import static com.jpa.yeongaesomun.domain.entity.member.QUser.user;

@RequiredArgsConstructor
public class AdminUserQueryDSLImpl implements AdminUserQueryDSL {
    private final JPAQueryFactory query;

    @Override
    public Page<User> findAllWithPaging(Pageable pageable, Search userSearch) {
//        BooleanExpression userNameContains = userSearch.getKeyword() == null ? null : user.userName.contains(userSearch.getKeyword());
//        BooleanExpression userNicknameContains = userSearch.getType() == null ? null : user.userNickname.contains(userSearch.getType());
        BooleanExpression userContains = null;

        if(userSearch.getType() != null && userSearch.getKeyword() != null) {
            if(userSearch.getType().equals("name")) {
                userContains = user.userName.contains(userSearch.getKeyword());
            }
            else if(userSearch.getType().equals("nickname")) {
                userContains = user.userNickname.contains(userSearch.getKeyword());
            }
        }


        final List<User> users = query.select (
                    Projections.fields(
                            User.class,
                            user.id,
                            user.userName,
                            user.userNickname,
                            user.userBirthDate,
                            user.userCellPhone,
                            user.userEmail,
                            user.userGender,
                            user.userLoginType,
                            user.userPassword,
                            user.userReleaseDate
                    )
                ).from(user)
                .orderBy(user.id.desc())
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .where(userContains)
                .fetch();

        final Long count = query.select(user.count()).from(user).fetchOne();

        return new PageImpl<>(users, pageable, count);
    }

    @Override
    public Optional<User> findPostById(Long id) {
        return Optional.ofNullable(query.selectFrom(user).where(user.id.eq(id)).fetchOne());
    }


    @Override
    public void deleteByAdminMemberName(Long id) {
        query.delete(user).where(user.id.eq(id)).execute();
    }
}
