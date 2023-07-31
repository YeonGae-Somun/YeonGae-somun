package com.jpa.yeongaesomun.entity.file;


import com.jpa.yeongaesomun.entity.productExperience.ProductExperience;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "TBL_PRODUCT_EXPERIENCE_FILE")
@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ProductExperienceFile extends File{


    @ManyToOne(fetch = FetchType.LAZY)
    private ProductExperience productExperience;

    @Builder
    public ProductExperienceFile(ProductExperience productExperience) {
        this.productExperience = productExperience;
    }
}
