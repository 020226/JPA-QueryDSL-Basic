package com.sbs.exam.qdsl.boundedContext.user.repository;

import com.sbs.exam.qdsl.boundedContext.user.entity.SiteUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

// 인터페이스명은 리포지터리이름+자유롭게(ex. Custom)
public interface UserRepositoryCustom {
  SiteUser getQslUser(Long id);

  long getQslCount();

  SiteUser getQslUserOrderByIdAscOne();

  List<SiteUser> getQslUserOrderByIdAsc();

  List<SiteUser> searchQsl(String kw);

  Page<SiteUser> searchQsl(String kw, Pageable pageable);

  List<SiteUser> getQslUserByInterestKeyword(String keyword);
}