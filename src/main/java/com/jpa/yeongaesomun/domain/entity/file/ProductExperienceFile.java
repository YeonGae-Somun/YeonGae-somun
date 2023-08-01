package com.jpa.yeongaesomun.domain.entity.file;


import com.jpa.yeongaesomun.domain.entity.productExperience.ProductExperience;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "TBL_PRODUCT_EXPERIENCE_FILE")
@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@PrimaryKeyJoinColumn(name = "FILE_ID")
public class ProductExperienceFile extends File{


    @ManyToOne(fetch = FetchType.LAZY)
    private ProductExperience productExperience;

    @Builder
    public ProductExperienceFile(ProductExperience productExperience) {
        this.productExperience = productExperience;
    }
}
