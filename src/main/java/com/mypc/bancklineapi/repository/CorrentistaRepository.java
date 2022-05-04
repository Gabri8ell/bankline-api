package com.mypc.bancklineapi.repository;

import com.mypc.bancklineapi.model.Correntista;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CorrentistaRepository extends JpaRepository<Correntista, Integer> {
}
