package com.questionarioSOS.questionarioSOS.Controller;

import com.questionarioSOS.questionarioSOS.domain.DadosRemoverQuestoes;
import com.questionarioSOS.questionarioSOS.domain.questionario.DadosAdicionarQuestoes;
import com.questionarioSOS.questionarioSOS.domain.questionario.DadosIniciarFormulario;
import com.questionarioSOS.questionarioSOS.domain.questionario.Questionario;
import com.questionarioSOS.questionarioSOS.service.QuestionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/questionario")
public class QuestionarioController {

    @Autowired
    private QuestionarioService questionarioService;

    @PostMapping("/iniciar-questionario")
    public ResponseEntity iniciarQuestionario(@RequestBody DadosIniciarFormulario dados){

        questionarioService.iniciarFormulario(dados);

        return ResponseEntity.ok().body(new Resposta().sucesso("Questionario iniciado com sucesso"));
    }

    @PostMapping("/adicionar-questoes")
    public ResponseEntity adicionarQuestoes(@RequestBody DadosAdicionarQuestoes dados){

        questionarioService.adicionarQuestoes(dados);

        return ResponseEntity.ok().body(new Resposta().sucesso("Questoes adicionadas"));
    }
    @PostMapping("/remover-questoes")
    public ResponseEntity removerQuestoes(@RequestBody DadosRemoverQuestoes dados){

        questionarioService.removerQuestoes(dados);

        return ResponseEntity.ok().body("Questoes Removidas");
    }
    @DeleteMapping("/remover-questionario/{id}")
    public ResponseEntity removerQuestionario(@PathVariable Long id){
        questionarioService.removerQuestionario(id);

        return ResponseEntity.ok().body(new Resposta().sucesso("Questionario removido com sucesso"));
    }
}
