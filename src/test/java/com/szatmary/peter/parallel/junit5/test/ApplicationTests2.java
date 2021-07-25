package com.szatmary.peter.parallel.junit5.test;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
class ApplicationTests2 {

	@Autowired
	private TestUtils testUtils;

	@Test
	public void test4() {
		log.info("test 4 starts");
		testUtils.waitForSeconds(2);
		log.info("test 4 done");
	}

	@Test
	public void test5() {
		log.info("test 5 starts");
		testUtils.waitForSeconds(2);
		log.info("test 5 done");
	}

	@Test
	public void test6() {
		log.info("test 6 starts");
		testUtils.waitForSeconds(2);
		log.info("test 6 done");
	}
}
