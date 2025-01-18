package com.sbs.exam.qdsl;

import com.sbs.exam.qdsl.boundedContext.user.entity.SiteUser;
import com.sbs.exam.qdsl.boundedContext.user.repository.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class QdslApplicationTests {
	@Autowired
	private UserRepository userRepository;

	@Test
	@DisplayName("회원 생성")
	void t1() { // {noop}1234 <- 비밀번호를 암호화하지 않도록(암호화는 {bcrypt}1234, id는 알아서 증가되기 때문에 null
		SiteUser u1 = new SiteUser(null, "user1", "{noop}1234", "user1@test.com");
		SiteUser u2 = new SiteUser(null, "user2", "{noop}1234", "user2@test.com");

		userRepository.saveAll(Arrays.asList(u1, u2));
	}

	@Test
	@DisplayName("1번 회원을 Qsl로 가져오기")
	void t2() {
		// SELECT * FROM site_user WHERE id = 1;
		SiteUser u1 = userRepository.getQslUser(1L);

		assertThat(u1.getId()).isEqualTo(1L); // id가 1인지 확인
		assertThat(u1.getUsername()).isEqualTo("user1");
		assertThat(u1.getPassword()).isEqualTo("{noop}1234");
		assertThat(u1.getEmail()).isEqualTo("user1@test.com");


	}
}
