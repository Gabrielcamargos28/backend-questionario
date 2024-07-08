package com.questionarioSOS.questionarioSOS.domain;

import java.util.Set;

public record DadosRemoverQuestoes(
        Long idQuestionario,
        Set<Long> idQuestoesRemover
) {
}
