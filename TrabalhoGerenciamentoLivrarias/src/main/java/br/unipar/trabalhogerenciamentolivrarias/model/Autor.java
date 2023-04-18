package br.unipar.trabalhogerenciamentolivrarias.model;

public class Autor {
    private String nome;
    private String sexo;
    private String dataNascimento;
    private Pais nacionalidade;

    public Autor() {
    }

    public Autor(String nome, String sexo, String dataNascimento, Pais nacionalidade) {
        this.nome = nome;
        this.sexo = sexo;
        this.dataNascimento = dataNascimento;
        this.nacionalidade = nacionalidade;
    }

    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSexo() {
        return sexo;
    }

    public void setGenero(String sexo) {
        this.sexo = sexo;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Pais getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(Pais nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    @Override
    public String toString() {
        return "\nAutor{" + "nome=" + nome + ", Sexo=" + sexo + ", dataNascimento=" + dataNascimento + ", nacionalidade=" + nacionalidade + "}";
    }

    
    
    
}
