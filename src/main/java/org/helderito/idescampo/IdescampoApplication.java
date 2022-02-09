package org.helderito.idescampo;


import org.helderito.idescampo.infrastruture.repository.CustomJpaRepositoryImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(repositoryBaseClass = CustomJpaRepositoryImpl.class)
public class IdescampoApplication {

	public static void main(String[] args) {
		SpringApplication.run(IdescampoApplication.class, args);
	}

}
