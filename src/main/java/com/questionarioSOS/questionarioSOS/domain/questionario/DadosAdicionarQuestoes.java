package com.questionarioSOS.questionarioSOS.domain.questionario;

import java.util.Set;

public record DadosAdicionarQuestoes(
        Long idQuestionario,
        Set<Long> idQuestoes
) {
}
