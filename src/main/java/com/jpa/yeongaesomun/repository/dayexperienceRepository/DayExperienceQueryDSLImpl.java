package com.jpa.yeongaesomun.repository.dayexperienceRepository;

import com.jpa.yeongaesomun.domain.dto.dayexperience.DayExperienceDTO;
import com.jpa.yeongaesomun.domain.dto.dayexperience.DayExperienceSearch;
import com.jpa.yeongaesomun.domain.entity.dayexperience.DayExperience;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import static com.jpa.yeongaesomun.domain.entity.dayexperience.QDayExperience.dayExperience;

import java.util.Optional;

@RequiredArgsConstructor
public class DayExperienceQueryDSLImpl implements DayExperienceQueryDSL {
    private final JPAQueryFactory query;

    @Override
    public Page<DayExperienceDTO> findAllWithReplyCount(Pageable pageable, DayExperienceSearch dayExperienceSearch) {
        BooleanExpression dayExperienceTitleContains = dayExperienceSearch.getDayExperienceTitle() == null ? null : dayExperience.dayExperienceTitle.contains(dayExperienceSearch.getDayExperienceTitle());
        BooleanExpression dayExperienceContentContains = dayExperienceSearch.getDayExperienceContent() == null ? null : dayExperience.dayExperienceContent.contains(dayExperienceSearch.getDayExperienceContent());
//        BooleanExpression replyContEqual =
//                dayExperienceSearch.getReplyCount() == null ? null :
//                        JPAExpressions
//                        .select()

        return null;
    }

    @Override
    public Optional<DayExperience> findPostById(Long id) {
        return Optional.empty();
    }
}
