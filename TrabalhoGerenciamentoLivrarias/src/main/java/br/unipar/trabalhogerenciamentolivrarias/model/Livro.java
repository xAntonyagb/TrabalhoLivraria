package br.unipar.trabalhogerenciamentolivrarias.model;

import java.util.ArrayList;

public class Livro {
    private String nome;
    private int anoLancamento;
    private int numPaginas;
    private ArrayList<Autor> autores = new ArrayList<>();
    private ArrayList<Genero> generos = new ArrayList<>();
    private Editora editora;
    private int qtdEstoque;
    private double precoVenda;

    public Livro() {
    }

    public Livro(String nome, int anoLancamento, int numPaginas, Editora editora, int qtdEstoque, double precoVenda) {
        this.nome = nome;
        this.anoLancamento = anoLancamento;
        this.numPaginas = numPaginas;
        this.editora = editora;
        this.qtdEstoque = qtdEstoque;
        this.precoVenda = precoVenda;
    }
    
    public void addAutor(Autor autor){
        this.autores.add(autor);
    }
    
    public void addGenero(Genero genero){
        this.generos.add(genero);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(int anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    public int getNumPaginas() {
        return numPaginas;
    }

    public void setNumPaginas(int numPaginas) {
        this.numPaginas = numPaginas;
    }

    public ArrayList<Autor> getAutores() {
        return autores;
    }

    public void setAutores(ArrayList<Autor> autores) {
        this.autores = autores;
    }

    public ArrayList<Genero> getGeneros() {
        return generos;
    }

    public void setGeneros(ArrayList<Genero> generos) {
        this.generos = generos;
    }

    public Editora getEditora() {
        return editora;
    }

    public void setEditora(Editora editora) {
        this.editora = editora;
    }

    public int getQtdEstoque() {
        return qtdEstoque;
    }

    public void setQtdEstoque(int qtdEstoque) {
        this.qtdEstoque = qtdEstoque;
    }

    public double getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(double precoVenda) {
        this.precoVenda = precoVenda;
    }

    @Override
    public String toString() {
        return "Nome Livro: "+ nome + "\nAno de Lancamento: " + anoLancamento + "\nNumero de Paginas: " + numPaginas + "\nAutores: " + autores + "\n\nGeneros: " + generos + "\n\nEditora: " + editora + "\nQuantidade em Estoque: " + qtdEstoque + "\nPreço de Venda: " + precoVenda + '}';
    }
    
    
}
