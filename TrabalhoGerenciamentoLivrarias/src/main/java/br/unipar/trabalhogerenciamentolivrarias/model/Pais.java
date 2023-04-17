package br.unipar.trabalhogerenciamentolivrarias.model;

public class Pais {
    private String nome;
    private String abreviacao;

    public Pais(String nome, String abreviacao) {
        this.nome = nome;
        this.abreviacao = abreviacao;
    }

    public Pais() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAbreviacao() {
        return abreviacao;
    }

    public void setAbreviacao(String abreviacao) {
        this.abreviacao = abreviacao;
    }

    @Override
    public String toString() {
        return "Pais{" + "nome=" + nome + ", abreviacao=" + abreviacao + '}';
    }

}
