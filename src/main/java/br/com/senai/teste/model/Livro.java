package br.com.senai.teste.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "livros")
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Min  ( value = 1, message = "O ano dePublicação deve ser maior que zero ")
    private int anoPublicacao;
    @NotBlank (message = "O titulo é obrigatório")
    private String titulo;
    @NotBlank (message =  "O autor é obrigatorio")
    private String autor;
    

    public Livro() {
    }

    public Livro(int anoPublicacao, String titulo, String autor) {
        this.anoPublicacao = anoPublicacao;
        this.titulo = titulo;
        this.autor = autor;

    }

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getAnoPublicacao() {
        return anoPublicacao;
    }

    public void setAnoPublicacao(int anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }

}
