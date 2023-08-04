package com.jpa.yeongaesomun.repository.introduceRepository;

import com.jpa.yeongaesomun.domain.dto.introduce.IntroduceDTO;
import com.jpa.yeongaesomun.domain.dto.introduce.IntroduceSearch;
import com.jpa.yeongaesomun.domain.entity.introduce.Introduce;
import static com.jpa.yeongaesomun.domain.entity.introduce.QIntroduce.introduce;

import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class IntroduceQueryDSLImpl implements IntroduceQueryDSL {
    private final JPAQueryFactory query;


    @Override
    public Page<IntroduceDTO> findAll(Pageable pageable, IntroduceSearch introduceSearch) {
        BooleanExpression introduceTitleContains = introduceSearch.getIntroduceTitle() == null ? null : introduce.introduceBoardTitle.contains(introduceSearch.getIntroduceTitle());
        BooleanExpression introduceContentContains = introduceSearch.getIntroduceContent() == null ? null : introduce.introduceBoardContent.contains(introduceSearch.getIntroduceContent());



        final List<IntroduceDTO> introduces = query.select(
                Projections.fields(
                    IntroduceDTO.class,
                        introduce.id,
                        introduce.introduceBoardTitle,
                        introduce.introduceBoardContent
                )
        ).from(introduce)
                .fetch();

        final long count = query.select(introduce.count()).from(introduce).fetchOne();

        return new PageImpl<>(introduces, pageable, count);
    }

    @Override
    public Optional<Introduce> findPostById(Long id) {
        return Optional.ofNullable(query.selectFrom(introduce).where(introduce.id.eq(id)).fetchOne());
    }
}
