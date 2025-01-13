package com.dbs.springsandbox;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class SandboxApplicationTests {
	private final ApplicationContext context;

	public SandboxApplicationTests(ApplicationContext context) {
		this.context = context;
	}

	@Test
	void contextLoads() {
		// DataSource
		assertThat(context.getBean("dataSource")).isNotNull();

		// CacheConfig
		assertThat(context.getBean("defaultCache")).isNotNull();
		assertThat(context.getBean("cacheManager")).isNotNull();
	}
}
