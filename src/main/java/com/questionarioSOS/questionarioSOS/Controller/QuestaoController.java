package com.questionarioSOS.questionarioSOS.Controller;

import com.questionarioSOS.questionarioSOS.domain.questao.DadosCriarQuestao;
import com.questionarioSOS.questionarioSOS.service.QuestaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/questao")
public class QuestaoController {
    @Autowired
    private QuestaoService questaoService;

    @PostMapping("/criar-questao")
    public ResponseEntity criarQuestao(@RequestBody DadosCriarQuestao dados){

        questaoService.criarQuestao(dados);

        return ResponseEntity.ok().body(new RespostaApi().sucesso("Questao criada"));
    }
    @DeleteMapping("/remover-questao/{id}")
    public ResponseEntity removerQuestao(@PathVariable Long id){
        questaoService.removerQuestao(id);

        return  ResponseEntity.ok().body(new RespostaApi().sucesso("Questao removida"));
    }
}
