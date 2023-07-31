package com.jpa.yeongaesomun.entity.productExperience;


import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "TBL_PRODUCT_EXPERIENCE_FILE")
@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ProductExperienceFile {
    @Id
    @GeneratedValue
    @EqualsAndHashCode.Include
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private ProductExperience productExperience;

    @Builder
    public ProductExperienceFile(ProductExperience productExperience) {
        this.productExperience = productExperience;
    }
}
