package com.orangeTalents.desafio.transacao;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.orangeTalents.desafio.mensagem.EventoDeCartao;

@Entity
public class Cartao {
	
	@Id
	private String id;
	
	private String email;

	@Deprecated
	public Cartao() {
		super();
	
	}




	public Cartao(EventoDeCartao cartao) {
		super();
		this.id = cartao.getId();
		this.email = cartao.getEmail();
	}



	public String getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}



	
	
	
	
}
