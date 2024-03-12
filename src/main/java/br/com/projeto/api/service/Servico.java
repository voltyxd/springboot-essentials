package br.com.projeto.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.projeto.api.model.Mensagem;
import br.com.projeto.api.model.Pessoa;
import br.com.projeto.api.repository.Repositorio;

@Service
public class Servico {

    @Autowired
    private Mensagem mensagem;

    @Autowired
    private Repositorio repositorio;

    public ResponseEntity<?> cadastrar(Pessoa pessoa) {
        
        if (pessoa.getNome().isEmpty()) {
            mensagem.setMensagem("O nome precisa ser preenchido");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        } else if (pessoa.getIdade() < 0) {
            mensagem.setMensagem("Informe uma idade válida");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(repositorio.save(pessoa), HttpStatus.CREATED);
        }

    }

    
    
}
