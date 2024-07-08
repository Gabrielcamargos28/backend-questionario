package com.questionarioSOS.questionarioSOS.domain.questao;

import com.questionarioSOS.questionarioSOS.domain.questionario.Questionario;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestaoRepository extends JpaRepository<Questao,Long> {

    @Transactional
    void deleteByQuestionario(Questionario questionario);
}
