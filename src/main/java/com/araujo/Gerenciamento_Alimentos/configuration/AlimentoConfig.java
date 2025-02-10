package com.araujo.Gerenciamento_Alimentos.configuration;

import com.araujo.Gerenciamento_Alimentos.model.Alimento;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Date;

@Configuration
public class AlimentoConfig {

    @Bean
    public Alimento alimento() {
        // Criando um objeto Alimento com dados de exemplo
        Alimento alimento = new Alimento();
        alimento.setId(1L);
        alimento.setNome("Arroz");
        alimento.setCategoria("Grão");
        alimento.setValidade(new Date());  // Data de validade atual
        alimento.setQuantidade(100);

        return alimento;
    }
}

