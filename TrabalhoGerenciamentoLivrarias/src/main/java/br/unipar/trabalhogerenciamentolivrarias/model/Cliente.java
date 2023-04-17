package br.unipar.trabalhogerenciamentolivrarias.model;

public class Cliente {
    private Endereco endereco;
    private String nome;
    private String telefone;
    
    public Cliente(Endereco endereco, String nome, String telefone) {
        this.endereco = endereco;
        this.nome = nome;
        this.telefone = telefone;
    }
    
    public Cliente() {
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return "Cliente{" + "endereco=" + endereco + ", nome=" + nome + ", telefone=" + telefone + '}';
    }
}
