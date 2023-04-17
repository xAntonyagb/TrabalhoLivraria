package br.unipar.trabalhogerenciamentolivrarias.model;

import java.util.ArrayList;

public class Venda {
    private ArrayList<FormaPagamento> formaPagamento = new ArrayList<>();
    private ArrayList<Item> items = new ArrayList<>();
    private Cliente cliente;
    private double valorTotal;

    public Venda(Cliente cliente, double valorTotal) {
        this.cliente = cliente;
        this.valorTotal = valorTotal;
    }

    public Venda() {
    }
    
    public double calcularValorTotal(){
        double total = 0;
        for(int i = 0; i < items.size(); i++){
            total += items.get(i).getValorTotal();
        }
        return total;
    }
    
    public void addFormaPagamento(FormaPagamento forma){
        this.formaPagamento.add(forma);
    }
    
    public void addItem(Item novoItem){
        this.items.add(novoItem);
    }

    public ArrayList<FormaPagamento> getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(ArrayList<FormaPagamento> formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    @Override
    public String toString() {
        return "Venda{ \nForma Pagamento{\n" + formaPagamento + "}\nItems{\n" + items + "\n}\n\nCliente: " + cliente + "\n Valor Total: " + valorTotal + "\n}";
    }
}
