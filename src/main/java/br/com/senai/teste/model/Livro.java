package br.com.senai.teste.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity 
@Table(name = "Livros")
public class Livro {
    @Id 
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;

    private String titulo; 
    private String autor;
    private int anoPublicacao;

    public Livro() {
    }
    public Livro( int anoPublicacao, String titulo, String autor){
        this.anoPublicacao = anoPublicacao;
        this.titulo = titulo;
        this.autor = autor;
        
    }


    public int getId(){
        return id;
    }


    public String GetTitulo(String titulo){
        return titulo;
    }
    public void setTitulo(){
        this.titulo = titulo;;
    }

     public String getAutor(String autor) {
                return autor;
}
    public void setAutor(){
        this.autor = autor;
    }
        public int getAnoPublicacao(int anoPublicacao){
        return  anoPublicacao;
    }
    public void setAnoPublicacao(){
        this.anoPublicacao = anoPublicacao;
    }

}


