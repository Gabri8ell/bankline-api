package com.mypc.bancklineapi.service;

import com.mypc.bancklineapi.dto.NovaMovimentacao;
import com.mypc.bancklineapi.model.Correntista;
import com.mypc.bancklineapi.model.Movimentacao;
import com.mypc.bancklineapi.model.MovimentacaoTipo;
import com.mypc.bancklineapi.repository.CorrentistaRepository;
import com.mypc.bancklineapi.repository.MovimentacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class MovimentacaoService {
    @Autowired
    private MovimentacaoRepository movimentacaoRepository;

    @Autowired
    private CorrentistaRepository correntistaRepository;

    public void save(NovaMovimentacao novaMovimentacao){
        Movimentacao movimentacao = new Movimentacao();

        Double valorMovimentacao = novaMovimentacao.getValor();
        if(novaMovimentacao.getTipo() == MovimentacaoTipo.DESPESA){
            valorMovimentacao *= - 1;
        }
        movimentacao.setDataHora(LocalDateTime.now());
        movimentacao.setDescricao(novaMovimentacao.getDescricao());
        movimentacao.setTipo(novaMovimentacao.getTipo());
        movimentacao.setIdConta(novaMovimentacao.getIdConta());
        movimentacao.setValor(valorMovimentacao);

        Correntista correntista = correntistaRepository.findById(movimentacao.getIdConta()).orElse(null);
        if(correntista != null){
            correntista.getConta().setSaldo(correntista.getConta().getSaldo() + valorMovimentacao);
        }

        movimentacaoRepository.save(movimentacao);

    }
}
