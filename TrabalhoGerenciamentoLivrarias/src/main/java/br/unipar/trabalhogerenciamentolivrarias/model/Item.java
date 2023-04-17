
package br.unipar.trabalhogerenciamentolivrarias.model;

public class Item {
    private int qtd;
    private Livro livro;
    private double desconto;
    private double valorTotal;

    public Item(int qtd, Livro livro) {
        this.qtd = qtd;
        this.livro = livro;
        this.valorTotal = calcularValorTotal();
    }

    public Item(int qtd, Livro livro, double desconto, double valorTotal) {
        this.qtd = qtd;
        this.livro = livro;
        this.desconto = desconto;
        this.valorTotal = valorTotal;
    }

    public Item() {
    }
    
    
    
    public boolean isQtdValida(){
        return this.qtd <= livro.getQtdEstoque();
    }
    
    public double calcularValorTotal(){
        return calcularDescontoUnit() * qtd;
    }
    
    public double calcularDescontoUnit(){
        return (1 - this.desconto / 100) * livro.getPrecoVenda();
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public double getDesconto() {
        return desconto;
    }

    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    @Override
    public String toString() {
        return "Item{"+ "Livro = " + livro + ", Qtd = " + qtd + ", Valor = " + livro.getPrecoVenda() + ", Desconto = " + calcularDescontoUnit()+ " (" + desconto+ " % )" + ", Valor total de venda do item = " + valorTotal + '}';
    }
}
