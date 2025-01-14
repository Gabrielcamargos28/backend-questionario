package com.questionarioSOS.questionarioSOS.Controller;

import com.questionarioSOS.questionarioSOS.domain.questionario.DadosRemoverQuestoes;
import com.questionarioSOS.questionarioSOS.domain.questionario.DadosAdicionarQuestoes;
import com.questionarioSOS.questionarioSOS.domain.questionario.DadosDetalhamentoQuestionario;
import com.questionarioSOS.questionarioSOS.domain.questionario.DadosIniciarFormulario;
import com.questionarioSOS.questionarioSOS.service.QuestionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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

        return ResponseEntity.ok().body(new RespostaApi().sucesso("Questionario iniciado com sucesso"));
    }

    @PutMapping("/adicionar-questoes")
    public ResponseEntity adicionarQuestoes(@RequestBody DadosAdicionarQuestoes dados){

        questionarioService.adicionarQuestoes(dados);

        return ResponseEntity.ok().body(new RespostaApi().sucesso("Questoes adicionadas"));
    }
    @PostMapping("/remover-questoes")
    public ResponseEntity removerQuestoes(@RequestBody DadosRemoverQuestoes dados){

        questionarioService.removerQuestoes(dados);

        return ResponseEntity.ok().body("Questoes Removidas");
    }
    @DeleteMapping("/remover-questionario/{id}")
    public ResponseEntity removerQuestionario(@PathVariable Long id){
        questionarioService.removerQuestionario(id);

        return ResponseEntity.ok().body(new RespostaApi().sucesso("Questionario removido com sucesso"));
    }
    @GetMapping("/listar")
    public ResponseEntity listarQuestionarios(@PageableDefault(size = 10) Pageable paginacao){
        Page<DadosDetalhamentoQuestionario> page =  questionarioService.listarQuestionarios(paginacao);

        return ResponseEntity.ok().body(page);
    }
}
