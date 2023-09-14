package com.jpa.yeongaesomun.service.member;

import com.jpa.yeongaesomun.domain.domain.MemberDTO;
import com.jpa.yeongaesomun.domain.domain.OAuthAttributes;
import com.jpa.yeongaesomun.domain.entity.member.User;
import com.jpa.yeongaesomun.provider.MemberDetail;
import com.jpa.yeongaesomun.repository.memberRepository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.util.Collections;
import java.util.zip.Deflater;
@Service
@RequiredArgsConstructor
@Slf4j
public class MemberSerivceImpl implements MemberSerivce, OAuth2UserService<OAuth2UserRequest, OAuth2User> {
    private final MemberRepository memberRepository;
    private final HttpSession session;
    @Override
    public void join(MemberDTO memberDTO, PasswordEncoder passwordEncoder) {

    }

    @Override
    public void join(MemberDTO memberDTO) {

    }


    //    spring security에서 DBMS의 회원 정보를 가져올 때 사용될 메소드
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User member = memberRepository.findByUserEmail(username).orElseThrow(() -> new UsernameNotFoundException(username + " not found"));
        return MemberDetail.builder()
                .userEmail(member.getUserEmail())
                .userRole(member.getUserRole())
                .build();
    }

    @Override
    @Transactional
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
//        로그인 완료 후 정보를 담기 위한 준비
        OAuth2UserService<OAuth2UserRequest, OAuth2User> delegate = new DefaultOAuth2UserService();
//        로그인된 사용자의 정보 불러오기
        OAuth2User oAuth2User = delegate.loadUser(userRequest);

//        어떤 기업의 OAuth를 사용했는 지의 구분(naver, kakao, mac, facebook,...)
        String registrationId = userRequest.getClientRegistration().getRegistrationId();
        String userNameAttributeName = userRequest.getClientRegistration().getProviderDetails().getUserInfoEndpoint().getUserNameAttributeName();
        OAuthAttributes attributes = OAuthAttributes.of(registrationId, userNameAttributeName, oAuth2User.getAttributes());
        User member = saveOrUpdate(attributes);

        if(member.getId() == null){
            memberRepository.save(member);
        }else{
            member.update(attributes.getName(), attributes.getEmail());
        }

//        OAuth를 통해 전달받은 정보를 DTO로 변환하여 session에 저장
//        session에 객체를 저장하기 위해 직렬화 사용
//        다시 가져올 때에는 역직렬화를 통해 원본 객체를 생성
//        세션에 정보 한 개를 담아놓고 매번 SELECT 쿼리를 발생 시키는 것 보다
//        전체 정보를 담고 있는 객체를 세션에 저장하는 것이 성능상 좋다.
        session.setAttribute("member", new MemberDTO(member));
        log.info("==========================================");
        log.info(((MemberDTO)session.getAttribute("member")).getUserEmail());
        log.info("==========================================");

        return new DefaultOAuth2User(Collections.singleton(new SimpleGrantedAuthority(member.getUserRole().getSecurityRole())), attributes.getAttributes(), attributes.getNameAttributeKey());
    }

    @Transactional
    public User saveOrUpdate(OAuthAttributes attributes){
        User memberForSavingOrUpdating = memberRepository.findByUserEmail(attributes.getEmail())
                .map(user -> user.update(attributes.getName(),attributes.getEmail()))
                .orElse(attributes.toEntity());
        return memberForSavingOrUpdating;
    }
}
