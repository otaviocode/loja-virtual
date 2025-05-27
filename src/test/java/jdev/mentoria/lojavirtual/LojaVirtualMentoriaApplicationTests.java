package jdev.mentoria.lojavirtual;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import jdev.mentoria.lojavirtual.model.Acesso;

@SpringBootTest(classes = LojaVirtualMentoriaApplication.class)
class LojaVirtualMentoriaApplicationTests {

	@Test
	void contextLoads() {

		Acesso acesso = new Acesso();

		acesso.setDescricao("ROLE_ADMIN");

	}

}
