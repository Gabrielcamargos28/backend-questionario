package com.questionarioSOS.questionarioSOS.service;

import com.questionarioSOS.questionarioSOS.domain.questao.DadosCriarQuestao;
import com.questionarioSOS.questionarioSOS.domain.questao.Questao;
import com.questionarioSOS.questionarioSOS.domain.questao.QuestaoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestaoService {

    @Autowired
    private QuestaoRepository questaoRepository;

    //Questao questao = questaoRepository.findById(dados.questaoId).orElseThrow(() -> new EntityNotFoundException("Questao não encontrada"))
    public void criarQuestao(DadosCriarQuestao dados){
        Questao questao = new Questao(dados);
    }
}
