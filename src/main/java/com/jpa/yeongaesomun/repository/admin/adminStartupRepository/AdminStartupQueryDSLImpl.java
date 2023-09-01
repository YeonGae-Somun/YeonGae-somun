package com.jpa.yeongaesomun.repository.admin.adminStartupRepository;

import com.jpa.yeongaesomun.domain.entity.member.Enterprise;
import com.jpa.yeongaesomun.domain.entity.member.Search;
import com.jpa.yeongaesomun.domain.entity.member.StartUp;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;

import static com.jpa.yeongaesomun.domain.entity.member.QEnterprise.enterprise;
import static com.jpa.yeongaesomun.domain.entity.member.QStartUp.startUp;

@RequiredArgsConstructor
public class AdminStartupQueryDSLImpl implements AdminStartupQueryDSL {
    private final JPAQueryFactory query;

    @Override
    public Page<StartUp> findAllWithPaging(Pageable pageable, Search search) {
        BooleanExpression startupContains = null;

        if(search.getType() != null && search.getKeyword() != null) {
            if(search.getType().equals("sBusinessName")) {
                startupContains = startUp.sBusinessName.contains(search.getKeyword());
            }
            else if(search.getType().equals("smajor")) {
                startupContains = startUp.sMajor.contains(search.getKeyword());
            }
            else if(search.getType().equals("shomepage")) {
                startupContains = startUp.sHomepage.contains(search.getKeyword());
            }
        }

        final List<StartUp> startUps = query.select (
                Projections.fields(
                        StartUp.class,
                        startUp.id,
                        startUp.sBusinessNumber,
                        startUp.sBusinessName,
                        startUp.sManager,
                        startUp.sHomepage,
                        startUp.sAddress,
                        startUp.sMajor,
                        startUp.sEmployeeCount
                )
        ).from(startUp)
                .orderBy(startUp.id.desc())
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .where(startupContains)
                .fetch();

        final Long count = query.select(startUp.count()).from(startUp).fetchOne();

        return new PageImpl<>(startUps, pageable, count);
    }

    @Override
    public void updateById(StartUp startUp) {

    }

    @Override
    public void deleteByAdminEnterpriseName(Long id) {
        query.delete(enterprise).where(enterprise.id.eq(id)).execute();
    }
}
