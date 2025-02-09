package com.questionarioSOS.questionarioSOS.domain.questao;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.questionarioSOS.questionarioSOS.domain.questionario.Questionario;
import com.questionarioSOS.questionarioSOS.domain.resposta.Resposta;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "tb_questao")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Questao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @Column(name = "comando", length = 1000)
    private String comando;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_questionario")
    private Questionario questionario;

    @OneToMany
    private Set<Resposta> respostas;

    public Questao(DadosCriarQuestao dados, Questionario questionario) {
        this.nome = dados.nome();
        this.comando = dados.comando();
        this.questionario = questionario;
    }
}
