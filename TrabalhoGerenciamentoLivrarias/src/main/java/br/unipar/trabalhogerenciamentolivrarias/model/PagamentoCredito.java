package br.unipar.trabalhogerenciamentolivrarias.model;

public class PagamentoCredito extends FormaPagamento{
    private int numeroParcelas;

    public PagamentoCredito(int numeroParcelas, String nome, String descricao, double valorPago) {
        super(nome, descricao, valorPago, true);
        this.numeroParcelas = numeroParcelas;
    }

    public PagamentoCredito(String nome, String descricao) {
        super(nome, descricao, true);
    }

    public PagamentoCredito() {
    }

    public int getNumeroParcelas() {
        return numeroParcelas;
    }

    public void setNumeroParcelas(int numeroParcelas) {
        this.numeroParcelas = numeroParcelas;
    }

    @Override
    public String toString() {
        return "Pagamento Credito{" + "numeroParcelas=" + numeroParcelas + ", descrição=" + super.getDescricao() + ", Valor pago=" + super.getValorPago() + '}';
    }

}
