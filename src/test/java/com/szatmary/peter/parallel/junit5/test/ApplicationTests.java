package com.szatmary.peter.parallel.junit5.test;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
class ApplicationTests {

	@Autowired
	private TestUtils testUtils;

	@Test
	public void test1() {
		log.info("test 1 starts");
		testUtils.waitForSeconds(2);
		log.info("test 1 done");
	}

	@Test
	public void test2() {
		log.info("test 2 starts");
		testUtils.waitForSeconds(2);
		log.info("test 2 done");
	}

	@Test
	public void test3() {
		log.info("test 3 starts");
		testUtils.waitForSeconds(2);
		log.info("test 3 done");
	}
}
