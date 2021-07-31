package com.orangeTalents.desafio.transacao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartaoRepository extends CrudRepository<Cartao,String>{

	Optional<Cartao> findById(String id);

}
