package br.unipar.trabalhogerenciamentolivrarias.model;

public class Estado {
    private String nome;
    private String abreviacao;
    private Pais pais;

    public Estado() {
    }

    public Estado(String nome, String abreviacao, Pais pais) {
        this.nome = nome;
        this.abreviacao = abreviacao;
        this.pais = pais;
    }

    public String getNome() {
        return nome;
    }

    public String getAbreviacao() {
        return abreviacao;
    }

    public Pais getPais() {
        return pais;
    }

    @Override
    public String toString() {
        return "Estado{" + "nome=" + nome + ", abreviacao=" + abreviacao + ", pais=" + pais + '}';
    }
}
