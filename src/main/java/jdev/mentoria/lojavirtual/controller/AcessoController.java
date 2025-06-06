package jdev.mentoria.lojavirtual.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import jdev.mentoria.lojavirtual.model.Acesso;
import jdev.mentoria.lojavirtual.repository.AcessoRepository;
//import jdev.mentoria.lojavirtual.repository.AcessoRepository;
import jdev.mentoria.lojavirtual.service.AcessoService;

@Controller
@RestController
public class AcessoController {

	@Autowired
	private AcessoService acessoService;

	@Autowired
	private AcessoRepository acessoRepository;

	/* Criar um novo acesso: */

	@ResponseBody /* Poder dar um retorno da API */
	@PostMapping(value = "**/salvarAcesso") /* Mapeando a url para receber JSON */
	public ResponseEntity<Acesso> salvarAcesso(@RequestBody Acesso acesso) { /* Recebe o JSON e converte pra Objeto */

		Acesso acessoSalvo = acessoService.save(acesso);

		return new ResponseEntity<Acesso>(acessoSalvo, HttpStatus.OK);
	}
	
	

	/* Deletar um acesso: */

	@ResponseBody /* Poder dar um retorno da API */
	@PostMapping(value = "**/deleteAcesso") /* Mapeando a url para receber JSON */
	public ResponseEntity<?> deleteAcesso(@RequestBody Acesso acesso) { /* Recebe o JSON e converte pra Objeto */

		acessoRepository.deleteById(acesso.getId());

		return new ResponseEntity("Acesso Removido", HttpStatus.OK);
	}
	
	
	
	
	/*  Deletar um acesso por ID:  */

	@ResponseBody /* Poder dar um retorno da API */
	@DeleteMapping(value = "**/deleteAcessoPorId/{id}")
	public ResponseEntity<?> deleteAcessoPorId(@PathVariable("id") Long id) { 

		acessoRepository.deleteById(id);

		return new ResponseEntity("Acesso Removido",HttpStatus.OK);
	}
	
	
	
	/*  Obter um acesso por ID:  */

	@ResponseBody /* Poder dar um retorno da API */
	@GetMapping(value = "**/obterAcesso/{id}")
	public ResponseEntity<Acesso> obterAcesso(@PathVariable("id") Long id) { 
		 
		Acesso acesso = acessoRepository.findById(id).get();
/*		System.out.println("CHEGOU NO CONTROLLER! ID: " + id);  Olhar no console */
		
		return new ResponseEntity<Acesso>(acesso, HttpStatus.OK);
	}
	
	
	
	
	/*  Obter um acesso por descricao:  */

	@ResponseBody /* Poder dar um retorno da API */
	@GetMapping(value = "**/buscarPorDesc/{desc}")
	public ResponseEntity<List<Acesso>> buscarPorDesc(@PathVariable("desc") String desc) { 
		 
		List<Acesso> acesso = acessoRepository.buscarAcessoDesc(desc);
		
		return new ResponseEntity<List<Acesso>>(acesso, HttpStatus.OK);
	}
}
