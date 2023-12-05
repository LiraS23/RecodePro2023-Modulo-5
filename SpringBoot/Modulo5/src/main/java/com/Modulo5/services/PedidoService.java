package com.Modulo5.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Modulo5.entities.Pedido;
import com.Modulo5.repositories.PedidoRepository;

@Service
public class PedidoService {

	private final PedidoRepository pedidoRepository;

	@Autowired
	public PedidoService(PedidoRepository pedidoRepository) {
		this.pedidoRepository = pedidoRepository;
	}

	// Operação de Criação (Create)
	public Pedido cadastrarPedido(Pedido pedido) {
		return pedidoRepository.save(pedido);
	}

	// Operação de Leitura (Read)
	public List<Pedido> listarTodosPedidos() {
		return pedidoRepository.findAll();
	}

	public Optional<Pedido> buscarPorIdPedido(int idPedido) {
		return pedidoRepository.findById(idPedido);
	}

	// Operação de Atualização (Update)
	public Pedido atualizarPedido(Pedido pedido) {
		return pedidoRepository.save(pedido);
	}

	// Operação de Exclusão (Delete)
	public void excluirPedido(int idPedido) {
		pedidoRepository.deleteById(idPedido);
	}
}
