package com.mypc.bancklineapi.controller;

import com.mypc.bancklineapi.dto.NovaMovimentacao;
import com.mypc.bancklineapi.model.Movimentacao;
import com.mypc.bancklineapi.repository.CorrentistaRepository;
import com.mypc.bancklineapi.repository.MovimentacaoRepository;
import com.mypc.bancklineapi.service.MovimentacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("movimentacoes")
public class MovimentacaoController {
    @Autowired
    private MovimentacaoRepository movimentacaoRepository;

    @Autowired
    private MovimentacaoService service;

    @GetMapping
    public List<Movimentacao> findAll(){
        return movimentacaoRepository.findAll();
    }

    @PostMapping
    public void save(@RequestBody NovaMovimentacao novaMovimentacao){
        service.save(novaMovimentacao);
    }


}
