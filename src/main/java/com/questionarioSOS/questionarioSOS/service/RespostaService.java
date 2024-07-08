package com.questionarioSOS.questionarioSOS.service;

import com.questionarioSOS.questionarioSOS.domain.questao.DadosRespostaQuestao;
import com.questionarioSOS.questionarioSOS.domain.questao.Questao;
import com.questionarioSOS.questionarioSOS.domain.questao.QuestaoRepository;
import com.questionarioSOS.questionarioSOS.domain.questionario.Questionario;
import com.questionarioSOS.questionarioSOS.domain.questionario.QuestionarioRepository;
import com.questionarioSOS.questionarioSOS.domain.resposta.Resposta;
import com.questionarioSOS.questionarioSOS.domain.resposta.RespostaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RespostaService {

    @Autowired
    private RespostaRepository respostaRepository;
    @Autowired
    private QuestaoRepository questaoRepository;
    @Autowired
    private QuestionarioRepository questionarioRepository;

    public void responderQuestao(DadosRespostaQuestao dados){
        Questao questao = questaoRepository.findById(dados.idQuestao())
                .orElseThrow( () -> new EntityNotFoundException("Questao não encontrada"));
        Resposta resposta = new Resposta(dados.resposta(), questao);

        respostaRepository.save(resposta);
    }
    public void removerResposta(Long id){
        Resposta resposta = respostaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Resposta não encontrada"));

        respostaRepository.delete(resposta);
    }
}
