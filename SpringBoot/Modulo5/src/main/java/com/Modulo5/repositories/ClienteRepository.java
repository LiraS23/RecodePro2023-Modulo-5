package com.Modulo5.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Modulo5.entities.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
