package com.mypc.bancklineapi.controller;

import com.mypc.bancklineapi.dto.NovaMovimentacao;
import com.mypc.bancklineapi.model.Movimentacao;
import com.mypc.bancklineapi.repository.CorrentistaRepository;
import com.mypc.bancklineapi.repository.MovimentacaoRepository;
import com.mypc.bancklineapi.service.MovimentacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("/{idConta}")
    public List<Movimentacao> findAll(@PathVariable("idConta") Integer idConta){
        return movimentacaoRepository.findByIdConta(idConta);

    }

    @PostMapping
    public void save(@RequestBody NovaMovimentacao novaMovimentacao){
        service.save(novaMovimentacao);
    }

    //@DeleteMapping("/idConta")
    @RequestMapping(value = "/movimentacoes/{idConta}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Integer idConta){
         movimentacaoRepository.deleteById(idConta);
    }
}
