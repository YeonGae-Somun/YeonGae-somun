package com.jpa.yeongaesomun.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "TBL_PRODUCT_EXPERIENCE")
@Getter @ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ProductExperience {
    @Id @GeneratedValue
    @EqualsAndHashCode.Include
    private Long id;
    @NotNull private String productExperienceName;
    @NotNull private String productExperiencePrice;
    private String productExperienceExplanation;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE,mappedBy = "productExperience")
    private List<ProductExperienceParticipant> participants = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE,mappedBy = "productExperience")
    private List<ProductExperienceFile> productExperienceFiles = new ArrayList<>();

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