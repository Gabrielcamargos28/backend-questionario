package com.questionarioSOS.questionarioSOS.domain.questao;

public record DadosRespostaQuestao(
        Long idQuestao,
        String resposta,
        Long idUsuario
) {
}
