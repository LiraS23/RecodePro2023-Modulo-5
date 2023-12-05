package com.Modulo5.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Modulo5.entities.Pacote;
import com.Modulo5.repositories.PacoteRepository;

@Service
public class PacoteService {

	private final PacoteRepository pacoteRepository;

	@Autowired
	public PacoteService(PacoteRepository pacoteRepository) {
		this.pacoteRepository = pacoteRepository;
	}

	// Operação de Criação (Create)
	public Pacote cadastrarPacote(Pacote pacote) {
		return pacoteRepository.save(pacote);
	}

	// Operação de Leitura (Read)
	public List<Pacote> listarTodosPacotes() {
		return pacoteRepository.findAll();
	}

	public Optional<Pacote> buscarPorIdPacote(int idPacote) {
		return pacoteRepository.findById(idPacote);
	}

	// Operação de Atualização (Update)
	public Pacote atualizarPacote(Pacote pacote) {
		return pacoteRepository.save(pacote);
	}

	// Operação de Exclusão (Delete)
	public void excluirPacote(int idPacote) {
		pacoteRepository.deleteById(idPacote);
	}
}
