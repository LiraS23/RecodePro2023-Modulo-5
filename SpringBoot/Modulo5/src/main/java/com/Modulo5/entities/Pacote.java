package com.Modulo5.entities;

import java.math.BigDecimal;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Pacote {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int idPacote;
	
	@Column(nullable = false)
	private String destino;
	
	@Column(nullable = false)
	private BigDecimal valorDiaria;
	
	public Pacote(int idPacote, String destino, BigDecimal valorDiaria) {
		super();
		this.idPacote = idPacote;
		this.destino = destino;
		this.valorDiaria = valorDiaria;
	}
	
	

	public Pacote() {
		
	}



	public int getIdPacote() {
		return idPacote;
	}

	public void setIdPacote(int idPacote) {
		this.idPacote = idPacote;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public BigDecimal getValorDiaria() {
		return valorDiaria;
	}

	public void setValorDiaria(BigDecimal valorDiaria) {
		this.valorDiaria = valorDiaria;
	}



	@Override
	public int hashCode() {
		return Objects.hash(idPacote);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pacote other = (Pacote) obj;
		return idPacote == other.idPacote;
	}
	
}
