package com.sbs.exam.qdsl.boundedContext.user.controller;

import com.sbs.exam.qdsl.boundedContext.user.entity.SiteUser;
import com.sbs.exam.qdsl.boundedContext.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // Controller 대신 ResponseBody 포함된 RestController 사용
@RequiredArgsConstructor
public class UserController {
  private final UserRepository userRepository;
  @RequestMapping("/user/{id}") // @PathVariable를 통해 { }에 id가 들어감
  public SiteUser user(@PathVariable Long id) {
    return userRepository.getQslUser(id);
  }
}