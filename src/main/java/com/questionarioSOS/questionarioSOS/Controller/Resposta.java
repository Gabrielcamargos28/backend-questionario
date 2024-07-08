package com.questionarioSOS.questionarioSOS.Controller;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Resposta {

    private Boolean status;
    private String mensagem;


    public Resposta sucesso(String mensagem){
        Resposta resposta = new Resposta();
        resposta.setMensagem(mensagem);
        resposta.setStatus(true);
        return resposta;
    }
}
