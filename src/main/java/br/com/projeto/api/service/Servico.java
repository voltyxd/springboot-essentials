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

    // Método para cadastrar pessoas
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

    // Método para buscar pessoas
    public ResponseEntity<?> buscar() {
        return new ResponseEntity<>(repositorio.findAll(), HttpStatus.OK);
    }

    // Método para buscar pessoa por id
    public ResponseEntity<?> buscarPorId(int id) {
        if (repositorio.findById(id) == null) {
            mensagem.setMensagem("Pessoa com Id " + id +  " não existe no banco de dados");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(repositorio.findById(id), HttpStatus.OK);
        }
    }

    // Método para editar dados
    public ResponseEntity<?> editar(Pessoa pessoa) {
        if (repositorio.findById(pessoa.getId()) == null) {
            mensagem.setMensagem("Id informado não existe.");
            return new ResponseEntity<>(mensagem, HttpStatus.NOT_FOUND);
        } else if (pessoa.getNome().isEmpty()) {
            mensagem.setMensagem("É necessário informar um nome");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        } else if (pessoa.getIdade() < 0) {
            mensagem.setMensagem("Informe uma idade válida");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(repositorio.save(pessoa), HttpStatus.OK);
        }
    }
    
}
