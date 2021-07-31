package com.orangeTalents.desafio.mensagem;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class EventoDeTransacao {

	private String id;
    private BigDecimal valor;
    private EventoDeCartao cartao;
    private EventoDeEstabelecimento estabelecimento;
   
    private LocalDateTime efetivadaEm;
    
	public String getId() {
		return id;
	}
	public BigDecimal getValor() {
		return valor;
	}
	public EventoDeEstabelecimento getEstabelecimento() {
		return estabelecimento;
	}
	public EventoDeCartao getCartao() {
		return cartao;
	}
	public LocalDateTime getEfetivadaEm() {
		return efetivadaEm;
	}
    
    
}
