package com.orangeTalents.desafio.transacao;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.orangeTalents.desafio.mensagem.EventoDeTransacao;

@Entity
public class Transacao {
	
	 @Id
	 private String id;
	 
	 private BigDecimal valor;
	 
	 @ManyToOne
	 private Cartao cartao;
	 
	 @ManyToOne
	 private Estabelecimento estabelecimento;
	 

	 
	 private LocalDateTime efetivadaEm;

	@Deprecated 
	public Transacao() {
		super();
		
	}

	

	public Transacao(EventoDeTransacao eventoDeTransacao, Cartao cartao, Estabelecimento estabelecimento) {
		super();
		this.id = eventoDeTransacao.getId();
		this.valor = eventoDeTransacao.getValor();
		this.cartao = cartao;
		this.estabelecimento = estabelecimento;
		this.efetivadaEm = eventoDeTransacao.getEfetivadaEm();
	}



	



	public String getId() {
		return id;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public Estabelecimento getEstabelecimento() {
		return estabelecimento;
	}

	public Cartao getCartao() {
		return cartao;
	}

	public LocalDateTime getEfetivadaEm() {
		return efetivadaEm;
	}
	 
	
	 
	 
}
