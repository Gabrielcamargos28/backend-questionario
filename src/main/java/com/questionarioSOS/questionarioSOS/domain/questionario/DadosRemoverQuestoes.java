package com.questionarioSOS.questionarioSOS.domain.questionario;

import java.util.Set;

public record DadosRemoverQuestoes(
        Long idQuestionario,
        Set<Long> idQuestoesRemover
) {
}
