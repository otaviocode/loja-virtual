package jdev.mentoria.lojavirtual.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jdev.mentoria.lojavirtual.model.Acesso;
import jdev.mentoria.lojavirtual.repository.AcessoRepository;

@Service
public class AcessoService {

	@Autowired
	private AcessoRepository acessoRepository;

	public List<Acesso> findAll() {
		return acessoRepository.findAll();
	}

	public Optional<Acesso> findById(Long id) {
		return acessoRepository.findById(id);
	}

	public Acesso save(Acesso acesso) {
		return acessoRepository.save(acesso);
	}

	public void deleteById(Long id) {
		acessoRepository.deleteById(id);
	}
}
