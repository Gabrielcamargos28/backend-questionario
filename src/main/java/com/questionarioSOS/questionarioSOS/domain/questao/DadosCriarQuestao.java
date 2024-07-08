package com.questionarioSOS.questionarioSOS.domain.questao;

import com.questionarioSOS.questionarioSOS.domain.questionario.Questionario;
import jakarta.persistence.*;

public record DadosCriarQuestao(

        String nome,
        String comando,
        Long idQuestionario
){
}
