package jdev.mentoria.lojavirtual.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jdev.mentoria.lojavirtual.model.Acesso;
import jdev.mentoria.lojavirtual.service.AcessoService;

@RestController
@RequestMapping("/acessos")
public class AcessoController {

	@Autowired
	private AcessoService acessoService; // Injeta o Service, não o Repository

	// Listar todos
	@GetMapping
	public List<Acesso> listarTodos() {
		return acessoService.findAll(); // Agora vai funcionar!
	}

	// Buscar por ID
	@GetMapping("/{id}")
	public ResponseEntity<Acesso> buscarPorId(@PathVariable Long id) {
		return acessoService.findById(id).map(acesso -> ResponseEntity.ok(acesso))
				.orElse(ResponseEntity.notFound().build());
	}

	// Criar novo
	@PostMapping
	public ResponseEntity<Acesso> criar(@RequestBody Acesso acesso) {
		Acesso novoAcesso = acessoService.save(acesso);
		return ResponseEntity.status(HttpStatus.CREATED).body(novoAcesso);
	}

	// Deletar
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Long id) {
		acessoService.deleteById(id);
		return ResponseEntity.noContent().build();
	}
}
