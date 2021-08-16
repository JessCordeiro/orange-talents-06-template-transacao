package com.orangeTalents.desafio.transacao;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.orangeTalents.desafio.mensagem.EventoDeEstabelecimento;

@Entity
public class Estabelecimento {
	
	@Id
    private Long id;
	
	private String nome;
	
	private String cidade;
	
	private String endereco;

	@Deprecated
	public Estabelecimento() {
		super();
		
	}

	public Estabelecimento(EventoDeEstabelecimento estabelecimento) {
		super();
		this.nome = estabelecimento.getNome();
		this.cidade = estabelecimento.getCidade();
		this.endereco = estabelecimento.getEndereco();
	}

	

	

	public String getNome() {
		return nome;
	}

	public String getCidade() {
		return cidade;
	}

	public String getEndereco() {
		return endereco;
	}
	
	
	
	
}
