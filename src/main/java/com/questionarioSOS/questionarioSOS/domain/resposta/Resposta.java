package com.questionarioSOS.questionarioSOS.domain.resposta;

import com.questionarioSOS.questionarioSOS.domain.questao.Questao;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_resposta")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Resposta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String resposta;
    @ManyToOne
    @JoinColumn(name = "id_questao")
    private Questao questao;


    public Resposta(String resposta, Questao questao) {
        this.resposta = resposta;
        this.questao = questao;
    }
}
