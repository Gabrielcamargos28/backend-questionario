package com.questionarioSOS.questionarioSOS.Controller;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RespostaApi {

    private Boolean status;
    private String mensagem;


    public RespostaApi sucesso(String mensagem){
        RespostaApi respostaApi = new RespostaApi();
        respostaApi.setMensagem(mensagem);
        respostaApi.setStatus(true);
        return respostaApi;
    }
}
