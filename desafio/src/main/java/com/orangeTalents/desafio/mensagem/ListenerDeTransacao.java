package com.orangeTalents.desafio.mensagem;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.orangeTalents.desafio.transacao.Cartao;
import com.orangeTalents.desafio.transacao.CartaoRepository;
import com.orangeTalents.desafio.transacao.Estabelecimento;
import com.orangeTalents.desafio.transacao.EstabelecimentoRepository;
import com.orangeTalents.desafio.transacao.Transacao;
import com.orangeTalents.desafio.transacao.TransacaoRepository;



@Component
public class ListenerDeTransacao {
	
	@Autowired
	TransacaoRepository repository;
	
	@Autowired
    private CartaoRepository cartaoRepository;
    @Autowired
    private EstabelecimentoRepository estabelecimentoRepository;
	
	@KafkaListener(topics = "${spring.kafka.topic.transactions}")
	@Transactional
    public void ouvir(EventoDeTransacao eventoDeTransacao) {
        System.out.println(eventoDeTransacao);
        
        /*repository.save(transacaoDto.toModel());
        System.out.println(transacaoDto.getId());
        System.out.println(transacaoDto.getEfetivadaEm());
        System.out.println(transacaoDto.getCartao().getNumero());
        System.out.println(transacaoDto.getCartao().getEmail());
        System.out.println(transacaoDto.getEstabelecimento().getCidade());
        System.out.println(transacaoDto.getEstabelecimento().getEndereco());
        System.out.println(transacaoDto.getEstabelecimento().getNome());
        System.out.println(transacaoDto.getValor());
        */
        
        Cartao cartao;
        cartao = new Cartao(eventoDeTransacao.getCartao());
        cartaoRepository.save(cartao);
       
        Estabelecimento estabelecimento;
        estabelecimento = new Estabelecimento(eventoDeTransacao.getEstabelecimento());
        estabelecimentoRepository.save(estabelecimento);
        
        Transacao novaTransacao = new Transacao(eventoDeTransacao, cartao, estabelecimento);
        repository.save(novaTransacao);
        System.out.println(novaTransacao);
    }
}
