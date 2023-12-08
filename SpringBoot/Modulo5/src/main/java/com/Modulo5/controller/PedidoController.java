package com.Modulo5.controller;

import com.Modulo5.entities.Cliente;
import com.Modulo5.entities.Pacote;
import com.Modulo5.entities.Pedido;
import com.Modulo5.services.ClienteService;
import com.Modulo5.services.PacoteService;
import com.Modulo5.services.PedidoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
public class PedidoController {

	private final PedidoService pedidoService;

	@Autowired
	private ClienteService clienteService; // Certifique-se de ter um serviço para alunos
	@Autowired
	private PacoteService pacoteService; // Certifique-se de ter um serviço para cursos

	@GetMapping("/obter-cpfENomeClientes")
	@ResponseBody
	public Map<String, List<?>> obterCpfENomeClientes() {
		List<Cliente> clientes = clienteService.listarTodosClientes();

		Map<String, List<?>> result = new HashMap<>();
		result.put("cpfs", clientes.stream().map(Cliente::getCpf).collect(Collectors.toList()));
		result.put("nomes", clientes.stream().map(Cliente::getNome).collect(Collectors.toList()));

		return result;
	}

	@GetMapping("/obter-idPacotes-e-destinos")
	@ResponseBody
	public Map<String, List<?>> obterIdPacotesEDestinos() {
		List<Pacote> pacotes = pacoteService.listarTodosPacotes();

		Map<String, List<?>> result = new HashMap<>();
		result.put("idsPacotes", pacotes.stream().map(Pacote::getIdPacote).collect(Collectors.toList()));
		result.put("destinos", pacotes.stream().map(Pacote::getDestino).collect(Collectors.toList()));
		result.put("valoresDiaria", pacotes.stream().map(Pacote::getValorDiaria).collect(Collectors.toList()));

		return result;
	}

	@Autowired
	public PedidoController(PedidoService pedidoService) {
		this.pedidoService = pedidoService;
	}

	@GetMapping("/pedidos.html")
	public String listarPedidos(Model model) {
		List<Pedido> pedidos = pedidoService.listarTodosPedidos();
		model.addAttribute("pedidos", pedidos);
		return "pedidos.html"; // Nome da página HTML para listar pedidos
	}

	@PostMapping("/cadastrar-pedido")
	public String cadastrarPedido(Pedido pedido, Model model) {
		Pedido pedidoCadastrado = pedidoService.cadastrarPedido(pedido);
		model.addAttribute("pedido", pedidoCadastrado);
		return "redirect:/pedidos.html?sucesso=true"; // Redireciona para a página "pedidos" com o parâmetro de sucesso
	}

	@DeleteMapping("/excluir-pedido/{idPedido}")
	public ResponseEntity<Void> excluirPedido(@PathVariable int idPedido) {
		pedidoService.excluirPedido(idPedido);
		return ResponseEntity.ok().build();
	}

	@GetMapping("/editar-pedido/{idPedido}")
	@ResponseBody
	public Pedido obterPedidoParaEdicao(@PathVariable int idPedido) {
		return pedidoService.buscarPorIdPedido(idPedido).orElseThrow();
	}
	
	@PostMapping("/editar-pedido")
	public String ediarPedido(Pedido pedido, Model model) {
		Pedido pedidoCadastrado = pedidoService.cadastrarPedido(pedido);
		model.addAttribute("pedido", pedidoCadastrado);
		return "redirect:/pedidos.html?sucesso=true"; // Redireciona para a página "pedidos" com o parâmetro de sucesso
	}
}
