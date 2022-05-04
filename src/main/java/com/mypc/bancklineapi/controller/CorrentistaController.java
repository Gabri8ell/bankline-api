package com.mypc.bancklineapi.controller;

import com.mypc.bancklineapi.dto.NovoCorrentista;
import com.mypc.bancklineapi.model.Correntista;
import com.mypc.bancklineapi.repository.CorrentistaRepository;
import com.mypc.bancklineapi.service.CorrentistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/correntistas")
public class CorrentistaController {
    @Autowired
    private CorrentistaRepository repository;

    @Autowired
    private CorrentistaService service;

    @GetMapping
    public List<Correntista> findAll(){
        return repository.findAll();
    }

    @PostMapping
    public void save(@RequestBody NovoCorrentista novoCorrentista){
        service.save(novoCorrentista);
    }
}
