package io.github.dubar_jeremy.linktree_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
public class LinktreeApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(LinktreeApiApplication.class, args);
	}

}
