package com.questionarioSOS.questionarioSOS.domain.questionario;

import com.questionarioSOS.questionarioSOS.domain.questao.Questao;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "tb_questionario")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Questionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    @OneToMany(mappedBy = "questionario", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Questao> questoes;
    private Boolean finalizado;


    public Questionario(DadosIniciarFormulario dados) {
        this.nome = dados.nome();
        this.finalizado = false;
    }
}
