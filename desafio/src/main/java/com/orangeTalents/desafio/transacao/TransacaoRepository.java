package com.orangeTalents.desafio.transacao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface TransacaoRepository extends CrudRepository<Transacao, String>{
	
	List<Transacao> findFirst10ByCartaoIdOrderByEfetivadaEmDesc(String id);

	void save(Cartao cartao);

	//void save(EventoDeTransacao eventoDeTransacao);
}
