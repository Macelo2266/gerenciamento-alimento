package com.araujo.Gerenciamento_Alimentos.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "alimentos")
public class Alimento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;


    private String nome;
    private String categoria;

    @Temporal(TemporalType.DATE)
    private Date validade;

    private int quantidade;
}
