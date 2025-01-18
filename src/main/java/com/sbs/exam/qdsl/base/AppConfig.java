package com.sbs.exam.qdsl.base;

import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// 설정 파일 = 규칙
@Configuration // @Configuration 해야 @Bean이 스캔이 됨
public class AppConfig {
  @Bean // 스프링 컨테이너에 Bean으로 등록된다.
  public JPAQueryFactory jpaQueryFactory(EntityManager entityManager) {
    return new JPAQueryFactory(entityManager);
  }
}
