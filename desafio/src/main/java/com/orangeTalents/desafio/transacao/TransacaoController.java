package com.orangeTalents.desafio.transacao;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransacaoController {
	
		@Autowired
		TransacaoRepository repository;
		
	


	  @GetMapping(value = "/transacoes/{id}")
	  @Transactional
	  public ResponseEntity<?> listaTransacoes(@PathVariable("id") String id) {
		  
		  List<Transacao> transacao = repository.findFirst10ByCartaoIdOrderByEfetivadaEmDesc(id);
		  
		  if(transacao.isEmpty()) {
			  return ResponseEntity.notFound().build();
		  }
		  
	
		  
		/* List<Transacao> transacao = transacao.stream()
			  .map(Transacao::new)
				 .collect(Collectors.toList());*/
		  return ResponseEntity.ok(transacao); 
	 
	  }
}
