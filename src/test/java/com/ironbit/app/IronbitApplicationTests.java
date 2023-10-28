package com.ironbit.app;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class IronbitApplicationTests {

	@Test
	void testMainMethod() {
        String[] args = {};
        IronbitApplication.main(args);
	}
}