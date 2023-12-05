package com.Modulo5.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Modulo5.entities.Cliente;
import com.Modulo5.repositories.ClienteRepository;

@Service
public class ClienteService {

	private final ClienteRepository clienteRepository;

	@Autowired
	public ClienteService(ClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;
	}

	// Operação de Criação (Create)
	public Cliente cadastrarCliente(Cliente cliente) {
		return clienteRepository.save(cliente);
	}

	// Operação de Leitura (Read)
	public List<Cliente> listarTodosClientes() {
		return clienteRepository.findAll();
	}

	public Optional<Cliente> buscarPorCPF(Long cpf) {
		return clienteRepository.findById(cpf);
	}

	// Operação de Atualização (Update)
	public Cliente atualizarCliente(Cliente cliente) {
		return clienteRepository.save(cliente);
	}

	// Operação de Exclusão (Delete)
	public void excluirCliente(Long cpf) {
		clienteRepository.deleteById(cpf);
	}
}
