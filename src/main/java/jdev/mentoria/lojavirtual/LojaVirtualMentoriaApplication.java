package jdev.mentoria.lojavirtual;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EntityScan(basePackages = "jdev.mentoria.lojavirtual.model")
@ComponentScan(basePackages = { "jdev.*" })
@EnableJpaRepositories(basePackages = { "jdev.mentoria.lojavirtual.repository" })
@EnableTransactionManagement
public class LojaVirtualMentoriaApplication {

	/* Hello World testing */
	public static void main(String[] args) {
		SpringApplication.run(LojaVirtualMentoriaApplication.class, args);
		System.out.println(new BCryptPasswordEncoder().encode("123"));//
	}

}
