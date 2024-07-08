package com.questionarioSOS.questionarioSOS.domain.resposta;

import com.questionarioSOS.questionarioSOS.domain.questao.Questao;
import com.questionarioSOS.questionarioSOS.domain.usuario.Usuario;
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
    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;


    public Resposta(String resposta, Questao questao, Usuario usuario) {
        this.resposta = resposta;
        this.questao = questao;
        this.usuario = usuario;
    }
}
