package com.sbs.exam.qdsl.boundedContext.user.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.sbs.exam.qdsl.boundedContext.user.entity.QSiteUser;
import com.sbs.exam.qdsl.boundedContext.user.entity.SiteUser;
import lombok.RequiredArgsConstructor;

// 클래스명은 리포지터리명+Impl이 규칙
// QueryDSL의 구현체로 QueryDSL 관련 코드만 작성
@RequiredArgsConstructor // jpaQueryFactory를 요청이 있을 때마다 생성
public class UserRepositoryImpl implements UserRepositoryCustom{
  private final JPAQueryFactory jpaQueryFactory;
  @Override
  public SiteUser getQslUser(Long id) {
    /*
    SELECT *
    FROM site_user
    WHERE id = 1
    */
    QSiteUser siteUser = QSiteUser.siteUser;
    /*
    jpaQueryFactory
    .select(siteUser) // SELECT *
    .from(siteUser); // FROM site_user
    */
    return jpaQueryFactory
        .selectFrom(siteUser) // SELECT * FROM site_user
        .where(siteUser.id.eq(id)) // WHERE id = 1 // eq = equals
        .fetchOne(); // 단일 결과를 반환(없으면 null)
  }
}
