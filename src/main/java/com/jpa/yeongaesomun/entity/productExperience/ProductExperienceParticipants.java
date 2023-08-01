package com.jpa.yeongaesomun.entity.productExperience;

import com.jpa.yeongaesomun.audit.Period;
import com.jpa.yeongaesomun.entity.member.User;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "TBL_PRODUCT_E_PARTICIPANTS")
@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ProductExperienceParticipants extends Period {
    @Id @GeneratedValue
    @EqualsAndHashCode.Include
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    private ProductExperience productExperience;

    @Builder
    public ProductExperienceParticipants(User user, ProductExperience productExperience) {
        this.user = user;
        this.productExperience = productExperience;
    }


}
