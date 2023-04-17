package br.unipar.trabalhogerenciamentolivrarias.model;

public class PagamentoDinheiro extends FormaPagamento{
    private double troco;
    private double notaEntregue;
    
    

    public PagamentoDinheiro(String nome, String descricao) {
        super(nome, descricao, false);
    }

    public PagamentoDinheiro(double troco, String nome, String descricao, double valorPago, double notaEntregue) {
        super(nome, descricao, valorPago, false);
        this.troco = troco;
        this.notaEntregue = notaEntregue;
    }

    public PagamentoDinheiro() {
    }

    public double getNotaEntregue() {
        return notaEntregue;
    }

    public void setNotaEntregue(double notaEntregue) {
        this.notaEntregue = notaEntregue;
    }

    public void calculoTroco(double valorPagar){
        double valor = this.notaEntregue - valorPagar;
        valor = Math.round(valor * 100.0) / 100.0;
                
        this.troco = valor;
        this.setValorPago(valorPagar);
    }
    
    public boolean precisaTroco(double valorCompra){
        double recebido = super.getValorPago();
        return recebido >= valorCompra;
    }
    

    public double getTroco() {
        return troco;
    }

    public void setTroco(double troco) {
        this.troco = troco;
    }

    @Override
    public String toString() {
        return "Pagamento Dinheiro{" + "troco=" + troco + ", notaEntregue=" + notaEntregue + ", descrição=" + super.getDescricao() + ", Valor pago=" + super.getValorPago() + '}';
    }

}
