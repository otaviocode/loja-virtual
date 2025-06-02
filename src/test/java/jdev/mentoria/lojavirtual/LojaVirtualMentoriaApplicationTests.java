package jdev.mentoria.lojavirtual;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.DefaultMockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import jdev.mentoria.lojavirtual.controller.AcessoController;
import jdev.mentoria.lojavirtual.model.Acesso;
import jdev.mentoria.lojavirtual.repository.AcessoRepository;
import junit.framework.TestCase;

@SpringBootTest(classes = LojaVirtualMentoriaApplication.class)
class LojaVirtualMentoriaApplicationTests extends TestCase {

	@Autowired
	private AcessoController acessoController;

	@Autowired
	private AcessoRepository acessoRepository; 

	@Autowired
	private WebApplicationContext wac;
		
		/* Teste de salvar com Mockito */
		
		@Test
		public void testRestApiCadastroAcesso() throws JsonProcessingException, Exception {
			
			DefaultMockMvcBuilder builder = MockMvcBuilders.webAppContextSetup(this.wac);
			MockMvc mockMvc = builder.build();
			
			Acesso acesso = new Acesso();
			
			acesso.setDescricao("ROLE_TEST_CRIAR_CADASTRO_MOCKITO");
			
			ObjectMapper objectMapper = new ObjectMapper();
			
			ResultActions retornoApi = mockMvc
					.perform(MockMvcRequestBuilders.post("/salvarAcesso")
					.content(objectMapper.writeValueAsString(acesso))
					.accept(org.springframework.http.MediaType.APPLICATION_JSON)
					.contentType(org.springframework.http.MediaType.APPLICATION_JSON));
			
			System.out.println("Descricao: " + acesso.getDescricao());
			System.out.println("Retorno da API: " + retornoApi.andReturn().getResponse().getContentAsString());
			
			/*Conveter o retorno da API para um objeto de acesso*/
			
			Acesso objetoRetorno = objectMapper
					.readValue(retornoApi.andReturn().getResponse().getContentAsString(), Acesso.class);
			
			/* Alguns testes com JUnit: */
			
			assertEquals(acesso.getDescricao(), objetoRetorno.getDescricao());
		}
		
		
		
		
		/* Teste de deletar com Mockito */
		@Test
		public void testRestApiDeleteAcesso() throws JsonProcessingException, Exception {
			DefaultMockMvcBuilder builder = MockMvcBuilders.webAppContextSetup(this.wac);
			MockMvc mockMvc = builder.build();
			
			Acesso acesso = new Acesso();
			
			acesso.setDescricao("ROLE_TEST_DELETE_ACESSO");
			
			acesso = acessoRepository.save(acesso);
			
			ObjectMapper objectMapper = new ObjectMapper();
			
			ResultActions retornoApi = mockMvc
					.perform(MockMvcRequestBuilders.post("/deleteAcesso")
					.content(objectMapper.writeValueAsString(acesso))
					.accept(org.springframework.http.MediaType.APPLICATION_JSON)
					.contentType(org.springframework.http.MediaType.APPLICATION_JSON));
			
			System.out.println("Descricao: " + acesso.getDescricao());
			System.out.println("Retorno da API: " + retornoApi.andReturn().getResponse().getContentAsString());
			System.out.println("Status de retorno da API: " + retornoApi.andReturn().getResponse().getStatus());
			
			/* Alguns testes com JUnit: */
			
			assertEquals("Acesso Removido", retornoApi.andReturn().getResponse().getContentAsString());
			assertEquals(200, retornoApi.andReturn().getResponse().getStatus());
			
		}
		
		
		
		/* Teste de deletar pelo id com Mockito */
		@Test
		public void testRestoApiDeletePorIDAcesso() throws JsonProcessingException, Exception {
			DefaultMockMvcBuilder builder = MockMvcBuilders.webAppContextSetup(this.wac);
			MockMvc mockMvc = builder.build();
			
			Acesso acesso = new Acesso();
			
			acesso.setDescricao("ROLE_TESTE_DELETE_ID");
			
			acesso = acessoRepository.save(acesso);
			
			ObjectMapper objectMapper = new ObjectMapper();
			
			ResultActions retornoApi = mockMvc
					.perform(MockMvcRequestBuilders.delete("/deleteAcessoPorId/" + acesso.getId())
					.content(objectMapper.writeValueAsString(acesso))
					.accept(org.springframework.http.MediaType.APPLICATION_JSON)
					.contentType(org.springframework.http.MediaType.APPLICATION_JSON));
			
			System.out.println("Descricao: " + acesso.getDescricao());
			System.out.println("Retorno da API: " + retornoApi.andReturn().getResponse().getContentAsString());
			System.out.println("Status de Retorno da API: " + retornoApi.andReturn().getResponse().getStatus());
			
			/* Alguns testes com JUnit: */
			
			assertEquals("Acesso Removido", retornoApi.andReturn().getResponse().getContentAsString());
			assertEquals(200, retornoApi.andReturn().getResponse().getStatus());
			
		}

}
