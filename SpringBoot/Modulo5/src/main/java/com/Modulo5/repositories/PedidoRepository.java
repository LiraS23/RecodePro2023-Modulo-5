package com.Modulo5.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Modulo5.entities.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Integer> {

}
