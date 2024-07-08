package com.questionarioSOS.questionarioSOS.service;

import com.questionarioSOS.questionarioSOS.domain.usuario.DadosCriarUsuario;
import com.questionarioSOS.questionarioSOS.domain.usuario.Usuario;
import com.questionarioSOS.questionarioSOS.domain.usuario.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;


    public void criarUsuario(DadosCriarUsuario dados){
        Usuario usuario = new Usuario(dados);

        usuarioRepository.save(usuario);
    }
}
