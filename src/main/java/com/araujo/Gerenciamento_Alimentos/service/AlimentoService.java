package com.araujo.Gerenciamento_Alimentos.service;

import com.araujo.Gerenciamento_Alimentos.model.Alimento;
import com.araujo.Gerenciamento_Alimentos.repository.AlimentoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class AlimentoService {

    private final AlimentoRepository alimentoRepository;

    public AlimentoService(AlimentoRepository alimentoRepository) {
        this.alimentoRepository = alimentoRepository;
    }


    public List<Alimento> listarTodos(){
        return alimentoRepository.findAll();
    }
    public Optional<Alimento>buscarPorID(Long id){
        return alimentoRepository.findById(id);
    }

    public Alimento salvar (Alimento alimento){
        return alimentoRepository.save(alimento);
    }
    public void excluir(Long id){
        alimentoRepository.deleteById(id);
    }

}
