package com.mypc.bancklineapi.repository;

import com.mypc.bancklineapi.model.Movimentacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovimentacaoRepository extends JpaRepository<Movimentacao, Integer> {
}
