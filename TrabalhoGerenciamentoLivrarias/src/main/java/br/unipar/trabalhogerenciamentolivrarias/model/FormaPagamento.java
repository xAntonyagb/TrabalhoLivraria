package br.unipar.trabalhogerenciamentolivrarias.model;

import javax.swing.JOptionPane;

public class FormaPagamento {
    private String nome;
    private String descricao;
    private boolean transacaoOnline;
    private double valorPago;
    
    public FormaPagamento(String nome, String descricao, boolean transacaoOnline) {
        this.nome = nome;
        this.descricao = descricao;
        this.transacaoOnline = transacaoOnline;
    }

    public FormaPagamento(String nome, String descricao, double valorPago, boolean transacaoOnline) {
        this.nome = nome;
        this.descricao = descricao;
        this.valorPago = validarPagamento(valorPago);
        this.transacaoOnline = transacaoOnline;
    }

    public FormaPagamento() {
    }
    
    public double validarPagamento(double pagamento){
        if(pagamento < 0){
            double novoPagamento = pagamento;
            do{
               novoPagamento = Double.parseDouble(
                       JOptionPane.showInputDialog("Pagamento abaixo ou igual a 0, porfavor pague um valor válido:")
               );
            }while(novoPagamento > 0);
            return novoPagamento;
        }
        return pagamento;
    }

    public boolean isTransacaoOnline() {
        return transacaoOnline;
    }

    public void setTransacaoOnline(boolean transacaoOnline) {
        this.transacaoOnline = transacaoOnline;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }


    public double getValorPago() {
        return valorPago;
    }

    public void setValorPago(double valorPago) {
        this.valorPago = validarPagamento(valorPago);
    }
    
    @Override
    public String toString() {
        return "FormaPagamento{" + "nome=" + nome + ", descricao=" + descricao + ", transacaoOnline=" + transacaoOnline + ", valorPago=" + valorPago + "}\n";
    }
    
}
