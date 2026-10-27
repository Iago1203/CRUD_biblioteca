package br.com.senai.teste.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.senai.teste.dto.EmprestimoRequest;
import br.com.senai.teste.model.Emprestimo;
import br.com.senai.teste.service.EmprestimoService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/emprestimos")

public class EmprestimoController {
    private final EmprestimoService emprestimoService;

    public EmprestimoController(EmprestimoService emprestimoService) {
        this.emprestimoService = emprestimoService;
    }

    @GetMapping
    public ResponseEntity<List<Emprestimo>> listar() {
        List<Emprestimo> emprestimos = emprestimoService.listar();
        return ResponseEntity.ok(emprestimos);
    }

    @PostMapping
    public ResponseEntity<Emprestimo> cadastrar(@Valid @RequestBody EmprestimoRequest dados) {
        Integer alunoId = dados.getAlunoId();
        Integer livroId = dados.getLivroId();

        LocalDate dataPrevistaDevolucao = dados.getDataPrevistaDevolucao();

        if (alunoId == null || livroId == null
                || dataPrevistaDevolucao == null) {
            return ResponseEntity.badRequest().build();
        }

        Optional<Emprestimo> emprestimo = emprestimoService.cadastrar(alunoId, livroId, dataPrevistaDevolucao);

        if (emprestimo.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(emprestimo.get());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Emprestimo> buscarPorId(@PathVariable Integer id) {
        Optional<Emprestimo> emprestimo = emprestimoService.bucarPorId(id);
        if (emprestimo.isPresent()) {
            return ResponseEntity.ok(emprestimo.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PatchMapping("/{id}/devolucao")

    public ResponseEntity<Emprestimo> devolver(
            @PathVariable Integer id) {
        Optional<Emprestimo> emprestimo = emprestimoService.devolver(id);

        if (emprestimo.isPresent()) {
            return ResponseEntity.ok(emprestimo.get());
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/ativos")
    public ResponseEntity<List<Emprestimo>> listarAtivos() {

        List<Emprestimo> emprestimos = emprestimoService.listarAtivos();

        return ResponseEntity.ok(emprestimos);
    }

    @GetMapping("/alunos/{alunoId}")
    public ResponseEntity<List<Emprestimo>> listarPorAluno(
            @PathVariable Integer alunoId) {

        List<Emprestimo> emprestimos = emprestimoService.listarPorAluno(alunoId);
        return ResponseEntity.ok(emprestimos);
    }

    @GetMapping("/livros/{livroId}")
    public ResponseEntity<List<Emprestimo>> listarPorLivros(
            @PathVariable Integer livroId) {

        List<Emprestimo> emprestimos = emprestimoService.listarPorLivros(livroId);
        return ResponseEntity.ok(emprestimos);
    }


    @GetMapping("/atrasados")
public ResponseEntity<List<Emprestimo>> 
    listarAtrasados() {
    
    List<Emprestimo> emprestimos = emprestimoService.listarAtrasados();
    
    return ResponseEntity.ok(emprestimos);
}

  @GetMapping("alunos/{Id}/atrasados")
public ResponseEntity<List<Emprestimo>>
    listarAtrasadosPorAluno(@PathVariable Integer Id) {
    
    List<Emprestimo> emprestimos = emprestimoService.listarAtrasadosPorAluno(Id);
    
    return ResponseEntity.ok(emprestimos);
}


}
