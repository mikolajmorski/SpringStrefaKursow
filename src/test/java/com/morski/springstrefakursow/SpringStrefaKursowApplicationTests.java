package com.morski.springstrefakursow;

import com.morski.springstrefakursow.domain.Knight;
import com.morski.springstrefakursow.domain.repository.InMemoryKnightRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class SpringStrefaKursowApplicationTests {

	@Autowired
	Knight knight;
	@Autowired
    InMemoryKnightRepository inMemoryKnightRepository;

	@Test
	void contextLoads() {
	}
	@Test
	public void testCastle() {
		String expected = "Znajduje sie tu zamek o nazwie: Castle Black. Zamieszkały przez rycerza: Rycerz o imieniu Lancelot (30). Zadanie: Uratuj ksiezniczke";
		assertEquals(expected, inMemoryKnightRepository.toString());
	}


}
