package com.questionarioSOS.questionarioSOS.service;

import com.questionarioSOS.questionarioSOS.domain.DadosRemoverQuestoes;
import com.questionarioSOS.questionarioSOS.domain.questao.Questao;
import com.questionarioSOS.questionarioSOS.domain.questao.QuestaoRepository;
import com.questionarioSOS.questionarioSOS.domain.questionario.*;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class QuestionarioService {

    @Autowired
    private QuestionarioRepository questionarioRepository;
    @Autowired
    private QuestaoRepository questaoRepository;


    public void iniciarFormulario(DadosIniciarFormulario dados){
        try {
            Questionario questionario = new Questionario(dados);
            questionarioRepository.save(questionario);
        }catch (RuntimeException e){
            new RuntimeException("Ocorreu um erro ao iniciar o questionario");
        }

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

    public void removerQuestionario(Long id){
        Questionario questionario = questionarioRepository.findById(id).orElseThrow( () -> new EntityNotFoundException("Questionario não encontrado"));
        questaoRepository.deleteByQuestionario(questionario);

        questionarioRepository.delete(questionario);
    }
    public Page<DadosDetalhamentoQuestionario> listarQuestionarios(@PageableDefault(size = 10) Pageable paginacao){
        Page<DadosDetalhamentoQuestionario> page = questionarioRepository.findAll(paginacao).map(DadosDetalhamentoQuestionario::new);
        return page;
    }
}
