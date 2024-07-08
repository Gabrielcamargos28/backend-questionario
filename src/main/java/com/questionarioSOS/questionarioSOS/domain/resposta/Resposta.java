package com.questionarioSOS.questionarioSOS.domain.resposta;

import com.questionarioSOS.questionarioSOS.domain.questao.Questao;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_questionario")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Resposta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Questao questao;
}
