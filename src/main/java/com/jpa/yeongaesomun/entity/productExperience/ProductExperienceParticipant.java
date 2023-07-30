package com.jpa.yeongaesomun.entity.productExperience;

import com.jpa.yeongaesomun.entity.User;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "TBL_PRODUCT_EXPERIENCE_PARTICIPANT")
@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ProductExperienceParticipant {
    @Id @GeneratedValue
    @EqualsAndHashCode.Include
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    private ProductExperience productExperience;

    @Builder

    public ProductExperienceParticipant(User user, ProductExperience productExperience) {
        this.user = user;
        this.productExperience = productExperience;
    }


}
