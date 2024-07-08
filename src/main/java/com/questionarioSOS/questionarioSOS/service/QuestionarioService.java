package com.questionarioSOS.questionarioSOS.service;

import com.questionarioSOS.questionarioSOS.domain.DadosRemoverQuestoes;
import com.questionarioSOS.questionarioSOS.domain.questao.Questao;
import com.questionarioSOS.questionarioSOS.domain.questao.QuestaoRepository;
import com.questionarioSOS.questionarioSOS.domain.questionario.DadosAdicionarQuestoes;
import com.questionarioSOS.questionarioSOS.domain.questionario.DadosIniciarFormulario;
import com.questionarioSOS.questionarioSOS.domain.questionario.Questionario;
import com.questionarioSOS.questionarioSOS.domain.questionario.QuestionarioRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;

public class QuestionarioService {

    @Autowired
    private QuestionarioRepository questionarioRepository;
    @Autowired
    private QuestaoRepository questaoRepository;


    public void iniciarFormulario(DadosIniciarFormulario dados){
        Questionario questionario = new Questionario(dados);
        questionarioRepository.save(questionario);
    }
    public void adicionarQuestoes(DadosAdicionarQuestoes dados){
        Questionario questionario = questionarioRepository.findById(dados.idQuestionario())
                .orElseThrow( () -> new EntityNotFoundException("Questionario não encontrado"));

        Set<Questao> questoesRecebidas = new HashSet<Questao>();
        Set<Questao> questoesAdicionar = questionario.getQuestoes();

        for (Long questaoId : dados.idQuestoes()){
            Questao questao = questaoRepository.findById(questaoId).orElseThrow(()-> new EntityNotFoundException("Questao não encontrada"));
            questoesRecebidas.add(questao);
        }
        questoesAdicionar.addAll(questoesRecebidas);
        questionario.setQuestoes(questoesAdicionar);

        questionarioRepository.save(questionario);
    }

    public void removerQuestoes(DadosRemoverQuestoes dados){
        Questionario questionario = questionarioRepository.findById(dados.idQuestionario())
                .orElseThrow( () -> new EntityNotFoundException("Questionario não encontrado"));

        Set<Questao> questoesRecebidas = new HashSet<Questao>();
        Set<Questao> questoesRemover = questionario.getQuestoes();

        for (Long questaoId : dados.idQuestoesRemover()){
            Questao questao = questaoRepository.findById(questaoId).orElseThrow(()-> new EntityNotFoundException("Questao não encontrada"));
            questoesRecebidas.add(questao);
        }
        questoesRemover.addAll(questoesRecebidas);
        questionario.setQuestoes(questoesRemover);

        questionarioRepository.save(questionario);
    }

    public void deleteQuestionario(Long id){
        Questionario questionario = questionarioRepository.findById(id).orElseThrow( () -> new EntityNotFoundException("Questionario não encontrado"));
        questaoRepository.deleteByQuestionario(questionario);

        questionarioRepository.delete(questionario);
    }
}
