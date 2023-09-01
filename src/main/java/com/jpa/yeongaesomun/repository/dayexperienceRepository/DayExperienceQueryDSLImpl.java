package com.jpa.yeongaesomun.repository.dayexperienceRepository;

import com.jpa.yeongaesomun.domain.entity.dayexperience.DayExperience;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.*;

import java.util.List;
import java.util.Optional;

import static com.jpa.yeongaesomun.domain.entity.dayexperience.QDayExperience.dayExperience;

@RequiredArgsConstructor
public class DayExperienceQueryDSLImpl implements DayExperienceQueryDSL {
    private final JPAQueryFactory query;

//    @Override
//    public Page<DayExperienceDTO> findAllWithSlice(Pageable pageable, DayExperienceSearch dayExperienceSearch) {
//        BooleanExpression dayExperienceTitleContains = dayExperienceSearch.getDayExperienceTitle() == null ? null : dayExperience.dayExperienceTitle.contains(dayExperienceSearch.getDayExperienceTitle());
//        BooleanExpression dayExperienceContentContains = dayExperienceSearch.getDayExperienceContent() == null ? null : dayExperience.dayExperienceContent.contains(dayExperienceSearch.getDayExperienceContent());
////        BooleanExpression replyContEqual =
////                dayExperienceSearch.getReplyCount() == null ? null :
////                        JPAExpressions
////                        .select()
//
//        return null;
//    }

    @Override
    public Page<DayExperience> findAllWithPaging(Pageable pageable) {
        final List<DayExperience> dayExperiences = query.select(dayExperience).from(dayExperience)
                .orderBy(dayExperience.id.desc())
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        final Long count = query.select(dayExperience.count()).from(dayExperience).fetchOne();

        return new PageImpl<>(dayExperiences, pageable, count);
    }

    @Override
    public Slice<DayExperience> findAllWithSlice(Pageable pageable) {
        final List<DayExperience> dayExperiences = query.selectFrom(dayExperience)
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize() + 1)
                .fetch();

        boolean hasNext = false;

        if(dayExperiences.size() > pageable.getPageSize()) {
            hasNext = true;
            dayExperiences.remove(pageable.getPageSize());
        }

        return new SliceImpl<>(dayExperiences, pageable, hasNext);
    }

    @Override
    public Optional<DayExperience> findDayExperienceById(Long id) {
        return Optional.empty();
    }
}
