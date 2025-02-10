package com.araujo.Gerenciamento_Alimentos.repository;


import com.araujo.Gerenciamento_Alimentos.model.Alimento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlimentoRepository extends JpaRepository <Alimento, Long>{
    List<Alimento>findByValidadeBefore(java.util.Date data);

}