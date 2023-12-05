package com.Modulo5.entities;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Pedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int idPedido;
	
	@Column(nullable = false)
	private Date dataPedido;
	
	@Column(nullable = false)
	private int diariasPedido;
	
	@Column(nullable = false)
	private BigDecimal valorPedido;
	
	@ManyToOne
	@JoinColumn(name = "idPacote", nullable = false)
	private Pacote fk_pacote_idPacote;
	
	@ManyToOne
	@JoinColumn(name = "cpf", nullable = false)
	private Cliente fk_cliente_cpf;

	public Pedido(int idPedido, Date dataPedido, int diariasPedido, BigDecimal valorPedido, Pacote fk_pacote_idPacote,
			Cliente fk_cliente_cpf) {
		super();
		this.idPedido = idPedido;
		this.dataPedido = dataPedido;
		this.diariasPedido = diariasPedido;
		this.valorPedido = valorPedido;
		this.fk_pacote_idPacote = fk_pacote_idPacote;
		this.fk_cliente_cpf = fk_cliente_cpf;
	}

	public Pedido() {

	}

	public int getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}

	public Date getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(Date dataPedido) {
		this.dataPedido = dataPedido;
	}

	public int getDiariasPedido() {
		return diariasPedido;
	}

	public void setDiariasPedido(int diariasPedido) {
		this.diariasPedido = diariasPedido;
	}

	public BigDecimal getValorPedido() {
		return valorPedido;
	}

	public void setValorPedido(BigDecimal valorPedido) {
		this.valorPedido = valorPedido;
	}

	public Pacote getFk_pacote_idPacote() {
		return fk_pacote_idPacote;
	}

	public void setFk_pacote_idPacote(Pacote fk_pacote_idPacote) {
		this.fk_pacote_idPacote = fk_pacote_idPacote;
	}

	public Cliente getFk_cliente_cpf() {
		return fk_cliente_cpf;
	}

	public void setFk_cliente_cpf(Cliente fk_cliente_cpf) {
		this.fk_cliente_cpf = fk_cliente_cpf;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idPedido);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pedido other = (Pedido) obj;
		return idPedido == other.idPedido;
	}

}
