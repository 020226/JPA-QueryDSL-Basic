package com.sbs.exam.qdsl.boundedContext.user.repository;

import com.sbs.exam.qdsl.boundedContext.user.entity.SiteUser;
import org.springframework.data.jpa.repository.JpaRepository;

// JPA 관련 담당 ex. findBy~
public interface UserRepository extends JpaRepository<SiteUser, Long>, UserRepositoryCustom { // SiteUser: 이름, Long: id 타입
}
