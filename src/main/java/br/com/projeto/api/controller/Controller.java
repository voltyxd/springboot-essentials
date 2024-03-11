package br.com.projeto.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
}
