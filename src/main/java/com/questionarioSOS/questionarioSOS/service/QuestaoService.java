package com.questionarioSOS.questionarioSOS.service;

import com.questionarioSOS.questionarioSOS.domain.questao.DadosCriarQuestao;
import com.questionarioSOS.questionarioSOS.domain.questao.Questao;
import com.questionarioSOS.questionarioSOS.domain.questao.QuestaoRepository;
import com.questionarioSOS.questionarioSOS.domain.questionario.Questionario;
import com.questionarioSOS.questionarioSOS.domain.questionario.QuestionarioRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestaoService {

    @Autowired
    private QuestaoRepository questaoRepository;
    @Autowired
    private QuestionarioRepository questionarioRepository;

    //Questao questao = questaoRepository.findById(dados.questaoId).orElseThrow(() -> new EntityNotFoundException("Questao não encontrada"))
    public void criarQuestao(DadosCriarQuestao dados){

        Questionario questionario = questionarioRepository.findById(dados.idQuestionario())
                .orElseThrow( () -> new EntityNotFoundException("Questionario não encontrado"));

        Questao questao = new Questao(dados, questionario);

        questaoRepository.save(questao);
    }
}
