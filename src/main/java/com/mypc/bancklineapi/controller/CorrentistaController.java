package com.mypc.bancklineapi.controller;

import com.mypc.bancklineapi.dto.NovoCorrentista;
import com.mypc.bancklineapi.model.Correntista;
import com.mypc.bancklineapi.repository.CorrentistaRepository;
import com.mypc.bancklineapi.service.CorrentistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("correntistas")
public class CorrentistaController {
    @Autowired
    private CorrentistaRepository correntistaRepository;

    @Autowired
    private CorrentistaService service;

    @GetMapping
    public List<Correntista> findAll(){
        return correntistaRepository.findAll();
    }

    @GetMapping("/{idCorrentista}")
    public Optional<Correntista> findAll(@PathVariable("idCorrentista") Integer idCorrentista){
        return correntistaRepository.findById(idCorrentista);
    }

    @PostMapping
    public void save(@RequestBody NovoCorrentista novoCorrentista){
        service.save(novoCorrentista);
    }

    @RequestMapping(value = "/correntistas/{idCorrentista}", method = RequestMethod.DELETE)
    public void deleteById(@PathVariable Integer idCorrentista){
        correntistaRepository.deleteById(idCorrentista);
    }
}
