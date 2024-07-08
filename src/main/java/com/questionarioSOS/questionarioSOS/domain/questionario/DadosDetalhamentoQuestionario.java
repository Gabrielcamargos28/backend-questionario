package com.questionarioSOS.questionarioSOS.domain.questionario;

import com.questionarioSOS.questionarioSOS.domain.questao.Questao;

import java.util.Set;

public record DadosDetalhamentoQuestionario(
        Long id,
        String nome,
        Set<Questao> questoes
) {
    public DadosDetalhamentoQuestionario (Questionario questionario){
        this(
                questionario.getId(),
                questionario.getNome(),
                questionario.getQuestoes()
        );
    }
}
