package br.com.projeto.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.projeto.api.model.Pessoa;
import br.com.projeto.api.repository.Repositorio;

@RestController
public class Controller {

    @Autowired
    private Repositorio repositorio;

    @PostMapping("/api")
    public Pessoa cadastrar(@RequestBody Pessoa pessoa) {
        return repositorio.save(pessoa);
    }

    @GetMapping("/api")
    public List<Pessoa> buscar() {
        return repositorio.findAll();
    }

    @GetMapping("/api/{id}")
    public Pessoa buscarPorId(@PathVariable int id) {
        return repositorio.findById(id);
    }

    @PutMapping("/api")
    public Pessoa editar(@RequestBody Pessoa pessoa) {
        return repositorio.save(pessoa);
    }

    @DeleteMapping("/api/{id}")
    public void remover(@PathVariable int id) {
        Pessoa pessoaEncontrada = repositorio.findById(id);

        repositorio.delete(pessoaEncontrada);
    }

    @GetMapping("/api/contador")
    public long contador() {
        return repositorio.count();
    }

    @GetMapping("/api/ordenarNomes")
    public List<Pessoa> ordenarNomes() {
        return repositorio.findByOrderByNomeDesc();
    }

    @GetMapping("/api/ordenarNomes2")
    public List<Pessoa> ordenarNomes2() {
        return repositorio.findByNomeOrderByIdade("Ana");
    }

    @GetMapping("/api/nomeContem/{termo}")
    public List<Pessoa> nomeContem(@PathVariable String termo) {
        return repositorio.findByNomeContaining(termo);
    }

    @GetMapping("/api/iniciaCom/{termo}")
    public List<Pessoa> iniciaCom(@PathVariable String termo) {
        return repositorio.findByNomeStartsWith(termo);
    }

    @GetMapping("/api/terminaCom/{termo}")
    public List<Pessoa> terminaCom(@PathVariable String termo) {
        return repositorio.findByNomeEndsWith(termo);
    }

    @GetMapping("/api/somaIdades")
    public int somaIdades() {
        return repositorio.somaIdades();
    }

    @GetMapping("/api/idadeMaiorIgual/{idade}")
    public List<Pessoa> idadeMaiorIgual(@PathVariable int idade) {
        return repositorio.idadeMaiorIgual(idade);
    }
    
    @GetMapping("")
    public String mensagem() {
        return "Hello World!";
    }

    @GetMapping("/boasVindas")
    public String boasVindas() {
        return "Seja bem vindo(a)";
    }

    @GetMapping("/boasVindas/{nome}")
    public String boasVindas(@PathVariable String nome) {
        return "Seja bem vindo(a) " + nome;
    }

    @PostMapping("/pessoa")
    public Pessoa pessoa(@RequestBody Pessoa p) {
        return p;
    }

    @GetMapping("/status")
    public ResponseEntity<?> status() {
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
