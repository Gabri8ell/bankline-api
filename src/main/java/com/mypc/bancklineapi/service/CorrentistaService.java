package com.mypc.bancklineapi.service;

import com.mypc.bancklineapi.dto.NovoCorrentista;
import com.mypc.bancklineapi.model.Conta;
import com.mypc.bancklineapi.model.Correntista;
import com.mypc.bancklineapi.repository.CorrentistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
@Service
public class CorrentistaService {
    @Autowired
    private CorrentistaRepository repository;
    public void save(NovoCorrentista novoCorrentista){
        Correntista correntista = new Correntista();
        correntista.setCpf(novoCorrentista.getCpf());
        correntista.setNome(novoCorrentista.getNome());

        Conta conta = new Conta();
        conta.setSaldo(0.0);
        conta.setNumero(new Date().getTime());

        correntista.setConta(conta);
        repository.save(correntista);

    }
}
