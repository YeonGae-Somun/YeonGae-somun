package com.jpa.yeongaesomun.domain.entity.productExperience;

import com.jpa.yeongaesomun.domain.audit.Period;
import com.jpa.yeongaesomun.domain.entity.member.StartUp;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TBL_PRODUCT_EXPERIENCE")
@Getter @ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ProductExperience extends Period {
    @Id @GeneratedValue
    @EqualsAndHashCode.Include
    private Long id;
    @NotNull private String productExperienceName;
    @NotNull private String productExperiencePrice;
    private String productExperienceExplanation;



    @ManyToOne(fetch = FetchType.LAZY)
    private StartUp startUp;

    @Builder
    public ProductExperience(@NotNull String productExperienceName, @NotNull String productExperiencePrice, String productExperienceExplanation,StartUp startUp ) {
        this.productExperienceName = productExperienceName;
        this.productExperiencePrice = productExperiencePrice;
        this.productExperienceExplanation = productExperienceExplanation;
        this.startUp = startUp;
    }

}