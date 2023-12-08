package com.Modulo5.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.Modulo5.entities.Cliente;
import com.Modulo5.services.ClienteService;

import java.util.List;

@Controller
public class ClienteController {

    private final ClienteService clienteService;

    @Autowired
    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping("/cliente.html")
    public String listarClientes(Model model) {
        List<Cliente> clientes = clienteService.listarTodosClientes();
        model.addAttribute("clientes", clientes);
        return "cliente.html"; // Nome da página HTML para listar clientes
    }

    @PostMapping("/cadastrar-cliente")
    public String cadastrarCliente(Cliente cliente, Model model) {
        Cliente clienteCadastrado = clienteService.cadastrarCliente(cliente);
        model.addAttribute("cliente", clienteCadastrado);
        return "redirect:/cliente.html?sucesso=true"; // Redireciona para a página "clientes" com o parâmetro de sucesso
    }

    @DeleteMapping("/excluir-cliente/{cpf}")
    public ResponseEntity<Void> excluirCliente(@PathVariable Long cpf) {
        clienteService.excluirCliente(cpf);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/editar-cliente/{cpf}")
    @ResponseBody
    public Cliente obterClienteParaEdicao(@PathVariable Long cpf) {
        return clienteService.buscarPorCPF(cpf).orElseThrow();
    }
}
