package com.mypc.bancklineapi.repository;

import com.mypc.bancklineapi.model.Correntista;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CorrentistaRepository extends JpaRepository<Correntista, Integer> {

    //public List<Correntista> findById(Integer idCorrentista);

}
