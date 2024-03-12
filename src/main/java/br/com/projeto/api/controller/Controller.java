package br.com.projeto.api.controller;

import java.util.List;

import javax.validation.Valid;

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

import br.com.projeto.api.model.Cliente;
import br.com.projeto.api.model.Pessoa;
import br.com.projeto.api.repository.Repositorio;
import br.com.projeto.api.service.Servico;

@RestController
public class Controller {

    @Autowired
    private Repositorio repositorio;

    @Autowired
    private Servico servico;

    @PostMapping("/api")
    public ResponseEntity<?> cadastrar(@RequestBody Pessoa pessoa) {
        return servico.cadastrar(pessoa);
    }

    @GetMapping("/api")
    public ResponseEntity<?> buscar() {
        return servico.buscar();
    }

    @GetMapping("/api/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable int id) {
        return servico.buscarPorId(id);
    }

    @PutMapping("/api")
    public ResponseEntity<?> editar(@RequestBody Pessoa pessoa) {
        return servico.editar(pessoa);
    }

    @DeleteMapping("/api/{id}")
    public ResponseEntity<?> remover(@PathVariable int id) {
        return servico.remover(id);
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

    
    @PostMapping("/cliente")
    public void cliente(@Valid @RequestBody Cliente cliente) {
        
    }
}
