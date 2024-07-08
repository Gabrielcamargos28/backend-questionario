package com.questionarioSOS.questionarioSOS.domain.usuario;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_usuario")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String senha;
    private String email;
    private String telefone;

    public Usuario(DadosCriarUsuario dados) {
        this.nome = dados.nome();
        this.senha = dados.senha();
        this.email = dados.email();
        this.telefone = dados.telefone();
    }
}
