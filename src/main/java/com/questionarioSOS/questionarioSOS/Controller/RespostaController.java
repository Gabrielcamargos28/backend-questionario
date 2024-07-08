package com.questionarioSOS.questionarioSOS.Controller;

import com.questionarioSOS.questionarioSOS.domain.questao.DadosRespostaQuestao;
import com.questionarioSOS.questionarioSOS.service.RespostaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/resposta")
public class RespostaController {

    @Autowired
    private RespostaService respostaService;

    @PostMapping("/responder-questao")
    public ResponseEntity responderQuestao(@RequestBody DadosRespostaQuestao dados){
        respostaService.responderQuestao(dados);
        return  ResponseEntity.ok().body(new RespostaApi().sucesso("Resposta Enviada"));
    }

    @DeleteMapping("/remover-resposta")
    public void removerResposta(@RequestParam Long id){
        respostaService.removerResposta(id);
    }
}
