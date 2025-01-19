package com.sbs.exam.qdsl.base;

import com.sbs.exam.qdsl.boundedContext.user.entity.SiteUser;
import com.sbs.exam.qdsl.boundedContext.user.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;
import java.util.List;

// @Configuration: @Bean과 함께 쓰여 bean에 붙어있는 메서드를 실행해서 객체를 만듦
// bean으로 만들어진 객체는 ioc컨테이너에 의해 관리된다
// @Profile({"dev","test"}): 이 클래스 안에 정의된 Bean들은 dev, test 모드에서만 실행됨
// Production(운영 환경, 라이브 서버)이 아니다
@Configuration
@Profile("test")
public class TestInitData {
  // CommandLineRunner : 앱 실행 직후 초기 데이터 세팅 및 초기화
  @Bean
  CommandLineRunner init(UserRepository userRepository) {
    return args -> {
      SiteUser u1 = SiteUser.builder()
          .username("user1")
          .password("{noop}1234")
          .email("user1@test.com")
          .build();

      SiteUser u2 = SiteUser.builder()
          .username("user2")
          .password("{noop}1234")
          .email("user2@test.com")
          .build();

      List<SiteUser> siteUsers = userRepository.saveAll(Arrays.asList(u1, u2));
    };
  }
}