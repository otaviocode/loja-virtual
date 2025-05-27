package jdev.mentoria.lojavirtual;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import jdev.mentoria.lojavirtual.controller.AcessoController;
import jdev.mentoria.lojavirtual.model.Acesso;

@SpringBootTest(classes = LojaVirtualMentoriaApplication.class)
class LojaVirtualMentoriaApplicationTests {

	@Autowired
	private AcessoController acessoController;

	/*
	 * @Autowired private AcessoService acessoService;
	 * 
	 * @Autowired private AcessoRepository acessoRepository;
	 * 
	 * @Test void contextLoads() {
	 * 
	 * Acesso acesso = new Acesso();
	 * 
	 * acesso.setDescricao("ROLE_ADMIN");
	 * 
	 * acessoRepository.save(acesso);
	 * 
	 * }
	 * 
	 * 
	 * @Test void contextLoads() {
	 * 
	 * Acesso acesso = new Acesso();
	 * 
	 * acesso.setDescricao("ROLE_ADMIN");
	 * 
	 * acessoService.save(acesso); }
	 */

	@Test
	void contextLoads() {

		Acesso acesso = new Acesso();

		acesso.setDescricao("ROLE_ADMIN");

		acessoController.salvarAcesso(acesso);
	}
}
