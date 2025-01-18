package com.sbs.exam.qdsl.boundedContext.user.repository;

import com.sbs.exam.qdsl.boundedContext.user.entity.SiteUser;

// 인터페이스명은 리포지터리이름+자유롭게(ex. Custom)
public interface UserRepositoryCustom {
  SiteUser getQslUser(Long id);
}
