package com.jpa.yeongaesomun.repository.admin.adminEnterpriseRepository;

import com.jpa.yeongaesomun.domain.entity.member.Enterprise;
import com.jpa.yeongaesomun.domain.entity.member.EnterpriseDTO;
import com.jpa.yeongaesomun.domain.entity.member.Search;
import com.jpa.yeongaesomun.domain.entity.member.User;
import com.jpa.yeongaesomun.domain.entity.notice.NoticeDTO;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

import static com.jpa.yeongaesomun.domain.entity.member.QEnterprise.enterprise;
import static com.jpa.yeongaesomun.domain.entity.notice.QNotice.notice;

@RequiredArgsConstructor
public class AdminEnterpriseQueryDSLImpl implements AdminEnterpriseQueryDSL {
    private final JPAQueryFactory query;

    @Override
    public Page<Enterprise> findAllWithPaging(Pageable pageable, Search enterpriseSearch) {
        BooleanExpression enterpriseContains = null;

        if(enterpriseSearch.getType() != null && enterpriseSearch.getKeyword() != null) {
            if(enterpriseSearch.getType().equals("ebusinessname")) {
                enterpriseContains = enterprise.eBusineesName.contains(enterpriseSearch.getKeyword());
            }
            else if(enterpriseSearch.getType().equals("emajor")) {
                enterpriseContains = enterprise.eMajor.contains(enterpriseSearch.getKeyword());
            }
            else if(enterpriseSearch.getType().equals("elocation")) {
                enterpriseContains = enterprise.eLocation.contains(enterpriseSearch.getKeyword());
            }
        }

        final List<Enterprise> enterprises = query.select (
            Projections.fields(
                    Enterprise.class,
                    enterprise.id,
                    enterprise.eBusinessNumber,
                    enterprise.eBusineesName,
                    enterprise.eManager,
                    enterprise.eHomepage,
                    enterprise.eAddress,
                    enterprise.eMajor,
                    enterprise.eLocation,
                    enterprise.eEmployeeCount
            )
        ).from(enterprise)
                .orderBy(enterprise.id.desc())
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .where(enterpriseContains)
                .fetch();

        final Long count = query.select(enterprise.count()).from(enterprise).fetchOne();

        return new PageImpl<>(enterprises, pageable, count);
    }


    @Override
    public void updateById(Enterprise enterprise) {
//        query.update(QEnterprise.enterprise).set(QEnterprise.enterprise.en, product.getProductName())
//                .set(QProduct.product.productPrice, product.getProductPrice())
//                .set(QProduct.product.productStock, product.getProductStock())
//                .where(QProduct.product.id.eq(product.getId())).execute();
    }

    @Override
    public List<Enterprise> findAll() {
        final List<Enterprise> enterprises = query.select(enterprise).from(enterprise).fetch();
        return enterprises;
    }

    @Override
    public Optional<EnterpriseDTO> findEnterpriseDTOById(Long id) {
        return Optional.ofNullable(query.select(
                Projections.fields(
                        EnterpriseDTO.class,
                        enterprise.id,
                        enterprise.eBusineesName,
                        enterprise.eManager,
                        enterprise.eContent


                )
        ).from(enterprise)
                .where(enterprise.id.eq(id)).fetchOne());
    }

    @Override
    public void deleteByAdminEnterpriseName(Long id) {
        query.delete(enterprise).where(enterprise.id.eq(id)).execute();
    }
}
