package com.jpa.yeongaesomun.repository.introduceRepository;

import com.jpa.yeongaesomun.domain.entity.introduce.Introduce;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IntroduceRepository extends JpaRepository<Introduce, Long>, IntroduceQueryDSL{
}
