package br.unipar.trabalhogerenciamentolivrarias.model;

public class Endereco {
    private String rua;
    private String bairro;
    private String numCasa;
    private String complemento;
    private Cidade cidade;

    public Endereco(String rua, String bairro, String numCasa, String complemento, Cidade cidade) {
        this.rua = rua;
        this.bairro = bairro;
        this.numCasa = numCasa;
        this.complemento = complemento;
        this.cidade = cidade;
    }

    public Endereco() {
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getNumCasa() {
        return numCasa;
    }

    public void setNumCasa(String numCasa) {
        this.numCasa = numCasa;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    @Override
    public String toString() {
        return "Endereco{" + "rua=" + rua + ", bairro=" + bairro + ", numCasa=" + numCasa + ", complemento=" + complemento + ", cidade=" + cidade + '}';
    }

    
}
