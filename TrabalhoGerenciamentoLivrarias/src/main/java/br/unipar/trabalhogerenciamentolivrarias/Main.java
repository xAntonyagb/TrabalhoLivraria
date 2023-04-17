package br.unipar.trabalhogerenciamentolivrarias;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import br.unipar.trabalhogerenciamentolivrarias.model.*;

public class Main {

    public static void main(String[] args) {
        Pais brasil = new Pais("Brasil", "BR");
        Estado parana = new Estado("Paraná", "PR", brasil);
        
        Cidade toledo = new Cidade("Toledo", parana);
        Endereco editoraLB = new Endereco("Rua da Editora", "Jardim Boa Vista", "3592", null, toledo);
        Editora livroBom = new Editora("livroBom", editoraLB, "988953733");
        

        Cidade cascavel = new Cidade("Cascavel", parana);
        Endereco editoraLN = new Endereco("Rua da Edição", "Jardim Vista Diferente", "9812", "Perto do parque principal", cascavel);
        Editora livroNovo = new Editora("Livro Novo", editoraLN, "999361485");
        
        
        Autor robertoFG = new Autor("Roberto Frederico Gomes", "Masculino", "21/08/1986", brasil);
        Autor mariaTB = new Autor("Maria Tumberli Bisnaga", "Feminino", "08/03/1990", brasil);
        Autor larissaKS = new Autor("Larissa Katarina da Silva", "Feminino", "16/07/1982", brasil);
        
        
        Genero horror = new Genero("Horror", "É assustador");
        Genero romance = new Genero("Romance", "Uma história de amor");
        Genero fc = new Genero("Ficção Cientifica", "Uma história imaginária ficcional");
        Genero humor = new Genero("Humor", "Uma história com humor engraçado");
        
        
        Livro cj = new Livro("As Cronicas de Juninho", 2020, 357, livroNovo, 7, 25.0);
        ArrayList<Autor> autoresCJ = new ArrayList<>();
        autoresCJ.add(mariaTB);
        autoresCJ.add(larissaKS);
        cj.setAutores(autoresCJ);
        cj.addGenero(humor);
        
        Livro anc = new Livro ("Amor Não Compreendido", 2018, 523, livroBom, 12, 12.0);
        anc.addAutor(mariaTB);
        anc.addGenero(romance);
        
        Livro mmc = new Livro ("O Tenebroso Mundo De Claudio", 2016, 238, livroBom, 18, 18.0);
        ArrayList<Genero> generosMMC = new ArrayList<>();
        generosMMC.add(fc);
        generosMMC.add(horror);
        mmc.addAutor(robertoFG);
        
        Livro aom = new Livro ("Um Amor de Outro Mundo", 2021, 336, livroNovo, 3, 13.0);
        ArrayList<Autor> autoresAOM = new ArrayList<>();
        autoresAOM.add(robertoFG);
        autoresAOM.add(larissaKS);
        aom.setAutores(autoresAOM);
        
        aom.addGenero(fc);
        aom.addGenero(romance);
        
        
        Endereco endMargarete = new Endereco("Rua Feliz", "Jardim Margarita", "5550", "apt 2", toledo);
        Endereco endJulia = new Endereco("Rua Divertida", "Jardim Celegial", "6284", "3 quadras da livraria", toledo);
        Endereco endIgor = new Endereco("Rua Legal", "Jardim Dois Vizinhos", "4880", null, toledo);
        
        Cliente margarete = new Cliente(endMargarete, "Margarete", "988562483");
        Cliente julia = new Cliente(endJulia, "Julia", "988195846");
        Cliente igor = new Cliente(endIgor, "Igor", "999648232");
        
        
        PagamentoCredito credito = new PagamentoCredito("Cartão de Credito", "Pode ser pago em diversas parselas");
        PagamentoDinheiro dinheiro = new PagamentoDinheiro("Dinheiro", "Dinheiro a vista");
        FormaPagamento pix = new FormaPagamento("PIX", "Transação de dinheiro instantanea", true);

        //Listas
        
        ArrayList<Cliente> clientes = new ArrayList<>();
        clientes.add(margarete);
        clientes.add(julia);
        clientes.add(igor);
        
        ArrayList<Cidade> cidades = new ArrayList<>();
        cidades.add(toledo);
        cidades.add(cascavel);
        
        ArrayList<Estado> estados = new ArrayList<>();
        estados.add(parana);
        
        ArrayList<Pais> paises = new ArrayList<>();
        paises.add(brasil);
        
        ArrayList<Livro> livros = new ArrayList<>();
        livros.add(anc);
        livros.add(aom);
        livros.add(cj);
        livros.add(mmc);
        
        ArrayList<FormaPagamento> formasDePagamento = new ArrayList<>();
        formasDePagamento.add(credito);
        formasDePagamento.add(dinheiro);
        formasDePagamento.add(pix);
        
        //Menus
        
        int escolha = 0;
        do{
        //Cliente chegou
            int numCliente = JOptionPane.showOptionDialog(null, "Qual desses dos clientes é:",
                    "Um cliente chegou",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, listClienteToArrayNomes(clientes, "Novo Cliente"), null);
        //É um novo cliente
            if(numCliente == 0){
                cadastrarCliente(clientes, cidades, estados, paises);
                JOptionPane.showMessageDialog(null, "O endereço foi definido para: \n" + clientes.get(clientes.size()-1).getEndereco());
            }
        //Não é
            else{
                String[] opcoes = {"Tudo certo", "Atualizar"};
                int confirmarEndereco = JOptionPane.showOptionDialog(null, "Anderson percebe a presença do cliente e pergunta para confirmar seu endereço: \n" + clientes.get(numCliente-1).getEndereco(),
                    "Confirmar endereço",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoes, null);
                if(confirmarEndereco == 1){
                    clientes.get(numCliente-1).setEndereco(
                        cadastrarEndereco(cidades, estados, paises)
                    );
                    JOptionPane.showMessageDialog(null, "O endereço foi definido para: \n" + clientes.get(numCliente-1).getEndereco());
                }
            }
            
        //Escolher livros
            int escolhaLivro = 1;
            boolean primeiraVez = true;
            
            ArrayList<Item> itens = new ArrayList<>();
            
            while(escolhaLivro != livros.size()){
                
                ArrayList<String> nomes = new ArrayList<>();
                for(int x = 0; x < livros.size(); x++){
                    nomes.add(livros.get(x).getNome());
                }

                String[] arrayNomes = nomes.toArray(new String[nomes.size()]);

                if(primeiraVez){
                    String[] opcoes = new String[arrayNomes.length];
                    System.arraycopy(arrayNomes, 0, opcoes, 0, arrayNomes.length);
                    
                    escolhaLivro = JOptionPane.showOptionDialog(null, "Quais livros o cliente vai comprar:",
                    "O cliente se dirige até os livros",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoes, opcoes[0]);
                }
                else{
                    String[] opcoes = new String[arrayNomes.length + 1];
                    System.arraycopy(arrayNomes, 0, opcoes, 0, arrayNomes.length);
                    opcoes[opcoes.length - 1] = "Finalizar seleção";
                    
                    escolhaLivro = JOptionPane.showOptionDialog(null, "Quais livros o cliente vai comprar:",
                    "O cliente se dirige até os livros",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoes, opcoes[0]);
                }
                if(escolhaLivro != livros.size()){
                    int estoque = livros.get(escolhaLivro).getQtdEstoque();
                    
                    int qtd = Integer.parseInt(
                       JOptionPane.showInputDialog("Quantos desse livro você o cliente deseja levar? (" + estoque + " disponiveis)"));
                     
                    if(qtd <= estoque)
                         estoque = estoque - qtd;
                    else{
                        while(!(qtd <= estoque)){
                            qtd = Integer.parseInt(
                                    JOptionPane.showInputDialog("Quantidade insuficiente, insira outra quantia (até "+ estoque + ") :"));
                        }
                    }
                    Item novoItem = new Item(qtd, livros.get(escolhaLivro));
                        
                    itens.add(novoItem);
                    novoItem.getLivro().setQtdEstoque(estoque);
                }
               primeiraVez = false;
            };
            
            String itensString = "";
            for(int i = 0; i < itens.size(); i++){
                itensString += "Livro: " + itens.get(i).getLivro().getNome() + " - Qtd: " + itens.get(i).getQtd() + "\n";
            }
            JOptionPane.showMessageDialog(null, "Esses são os livros escolhidos: \n" + itensString);
            
            
            //Dar desconto
            
            JOptionPane.showMessageDialog(null, "O cliente vai até o caixa da livraria. Lá ele se depara com você, Anderson, e lhe pede um desconto..");
            
            for(int i = 0; i < itens.size(); i++){
                String livro = itens.get(i).getLivro().getNome();
                String qtd = Integer.toString(itens.get(i).getQtd()); 
                
                itens.get(i).setDesconto(
                    Double.parseDouble(
                        JOptionPane.showInputDialog("Você pega o livro: '"+ livro +"' ("+ qtd +" qtd), olha para o cliente e diz que vai aplicar um desconto de (%):" )
                    )
                );
                double total = arredondar(itens.get(i).calcularValorTotal());
                System.out.println(total);
                itens.get(i).setValorTotal(total);
                System.out.println(itens.get(i).getValorTotal());
                JOptionPane.showMessageDialog(null, "Com desconto esse item totaliza: "+ total);
            }
            
            
            //Declarando venda
            Venda novaVenda = new Venda();
            novaVenda.setCliente(clientes.get(numCliente));
            novaVenda.setItems(itens);
            novaVenda.setValorTotal(novaVenda.calcularValorTotal());
            
            //Pagamento
            
            ArrayList<String> nomes = new ArrayList<>();
            for(int x = 0; x < formasDePagamento.size(); x++){
                nomes.add(formasDePagamento.get(x).getNome());
            }
            String[] arrayNomes = nomes.toArray(new String[nomes.size()]);

            String[] pagamento = new String[arrayNomes.length + 1];
            System.arraycopy(arrayNomes, 0, pagamento, 0, arrayNomes.length);
            pagamento[pagamento.length - 1] = "Pagar com duas formas";
            
            int escolhaPagamento = JOptionPane.showOptionDialog(null, "Anderson rapidamente olha para o cliente e fala: \nO total fica: R$" + novaVenda.getValorTotal() + " como deseja pagar?",
                "Realizar o pagamento",
            JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, pagamento, pagamento[pagamento.length - 1]);
            
            
            //Dois pagamentos
            
            if(escolhaPagamento == pagamento.length-1){
                pagamento = new String[arrayNomes.length];
                System.arraycopy(arrayNomes, 0, pagamento, 0, arrayNomes.length);
                
                //primeiro pagamento
                int primeiroPagamento = JOptionPane.showOptionDialog(null, "Pagar primeiramente com qual forma:", "Primeiro pagamento",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, pagamento, pagamento[0]);
                
                //Credito
                if(primeiroPagamento == 0){
                    novaVenda.addFormaPagamento(credito);
                    credito.setValorPago( Double.parseDouble(JOptionPane.showInputDialog("Quanto deseja pagar com esse meio (Necessario: "+ novaVenda.getValorTotal() +"):")) );
                    credito.setNumeroParcelas( Integer.parseInt(JOptionPane.showInputDialog("Em quantas parcelas deseja fazer:")) );
                }
                //Dinheiro
                else if(primeiroPagamento == 1){
                    
                    novaVenda.addFormaPagamento(dinheiro);
                    //Escolher nota e valor a pagar
                    double vaiPagar = Double.parseDouble(JOptionPane.showInputDialog("Quanto deseja pagar em dinheiro (Necessario: "+ novaVenda.getValorTotal() +"):"));
                    
                    String[] opcoesNota = {"2.0", "5.0", "10.0", "20.0", "50.0", "100.0", "200.0"};
                    int nota = JOptionPane.showOptionDialog(null, "Qual nota o cliente te entrega:",
                    "Dar que nota:",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoesNota, opcoesNota[0]);
                    double notaD = Double.parseDouble(opcoesNota[nota]);
                    
                    
                    while(vaiPagar > notaD){
                        nota = JOptionPane.showOptionDialog(null, "A nota dada não cumpre com o valor sugerido pelo cliente, você explica para o cliente e pede uma quantia válida (" + vaiPagar +"):",
                        "Pagar corretamente",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoesNota, opcoesNota[0]);

                        notaD = Double.parseDouble(opcoesNota[nota]);
                    }
                    
                    dinheiro.setNotaEntregue(notaD);
                    
                    //troco
                    dinheiro.calculoTroco(vaiPagar);
                    
                    if(vaiPagar > 0.0){
                        JOptionPane.showMessageDialog(null, "Você extende a mão para o cliente e diz: 'Aqui seu troco', e lhe entrega R$ "+ dinheiro.getTroco());
                    }
                }
                else{
                    novaVenda.addFormaPagamento(pix);
                    pix.setValorPago( Double.parseDouble(JOptionPane.showInputDialog("Quanto deseja pagar com esse meio (Necessario: "+ novaVenda.getValorTotal() +"):")) );
                }
                
                
                
                
                
                
                double ultimoValorPago = novaVenda.getFormaPagamento().get(0).getValorPago();
                double valorRestante = novaVenda.getValorTotal() - ultimoValorPago;
                
                //Segundo pagamento
                int segundoPagamento = JOptionPane.showOptionDialog(null, "Com qual pagamento deseja pagar os "+ valorRestante +" restantes:", "Segundo pagamento",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, pagamento, pagamento[0]);


                //Credito
                if(segundoPagamento == 0){
                    novaVenda.addFormaPagamento(credito);
                    credito.setNumeroParcelas( Integer.parseInt(JOptionPane.showInputDialog("Em quantas parcelas deseja fazer:")) );
                }
                //Dinheiro
                else if(segundoPagamento == 1){
                    novaVenda.addFormaPagamento(dinheiro);

                    //Escolher nota e valor a pagar

                    String[] opcoesNota = {"2.0", "5.0", "10.0", "20.0", "50.0", "100.0", "200.0"};
                    int nota = JOptionPane.showOptionDialog(null, "É necessario pagar: "+ valorRestante +", Qual nota o cliente te entrega:",
                    "Dar que nota:",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoesNota, opcoesNota[0]);
                    double notaD = Double.parseDouble(opcoesNota[nota]);


                    while(valorRestante > notaD){
                        nota = JOptionPane.showOptionDialog(null, "A nota dada não cumpre com o valor necessário, você explica para o cliente e pede uma quantia válida (" + valorRestante +"):",
                        "Pagar corretamente",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoesNota, opcoesNota[0]);

                        notaD = Double.parseDouble(opcoesNota[nota]);
                    }

                    dinheiro.setNotaEntregue(notaD);

                    //troco
                    dinheiro.calculoTroco(valorRestante);

                    if(valorRestante > 0.0){
                        JOptionPane.showMessageDialog(null, "Você extende a mão para o cliente e diz: 'Aqui seu troco', e lhe entrega R$ "+ dinheiro.getTroco());
                    }
                }
                else{
                    novaVenda.addFormaPagamento(pix);
                    pix.setValorPago(valorRestante);
                    JOptionPane.showMessageDialog(null, "O cliente te transefere: "+ valorRestante + " no pix.");
                }
                
            }
            
            //Um pagamento
            else{
                //Credito
                if(escolhaPagamento == 0){
                    novaVenda.addFormaPagamento(credito);
                    credito.setValorPago( novaVenda.getValorTotal());
                    credito.setNumeroParcelas( Integer.parseInt(JOptionPane.showInputDialog("Em quantas parcelas deseja fazer:")) );
                }
                //Dinheiro
                else if(escolhaPagamento == 1){
                    
                    novaVenda.addFormaPagamento(dinheiro);
                    
                    //Escolher nota e valor a pagar
                    String[] opcoesNota = {"2.0", "5.0", "10.0", "20.0", "50.0", "100.0", "200.0"};
                    int nota = JOptionPane.showOptionDialog(null, "O cliente deve pagar R$"+ novaVenda.getValorTotal() +", Qual nota o cliente te entrega:",
                    "Dar que nota:",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoesNota, opcoesNota[0]);
                    double notaD = Double.parseDouble(opcoesNota[nota]);
                    
                    
                    while(novaVenda.getValorTotal() > notaD){
                        nota = JOptionPane.showOptionDialog(null, "A nota dada não cumpre com o valor sugerido pelo cliente, você explica para o cliente e pede uma quantia válida (" + novaVenda.getValorTotal() +"):",
                        "Pagar corretamente",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoesNota, opcoesNota[0]);

                        notaD = Double.parseDouble(opcoesNota[nota]);
                    }
                    
                    dinheiro.setNotaEntregue(notaD);
                    
                    //troco
                    dinheiro.calculoTroco(novaVenda.getValorTotal());
                    
                    if(dinheiro.getTroco() > 0.0){
                        JOptionPane.showMessageDialog(null, "Você extende a mão para o cliente e diz: 'Aqui seu troco', e lhe entrega R$ "+ dinheiro.getTroco());
                    }
                }
                else{
                    novaVenda.addFormaPagamento(pix);
                    JOptionPane.showMessageDialog(null, "O cliente te transefere: "+novaVenda.getValorTotal()+ " no pix.");
                    pix.setValorPago(novaVenda.getValorTotal());
                }
            }
            
            JOptionPane.showMessageDialog(null, "A venda termina e o cliente vai embora satisfeito.");
            JOptionPane.showMessageDialog(null, novaVenda);
            System.out.println(novaVenda);
           

            
        String[] opcoes = {"Sim", "Não"};
        escolha = JOptionPane.showOptionDialog(null, "Deseja fechar a biblioteca por hoje?",
            "Terminar o dia",
            JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoes, opcoes[0]);
        }while(escolha != 0);
    }
    
    
    private static String[] listClienteToArrayNomes (ArrayList<Cliente> transformar, String primeiraOpcao){
        ArrayList<String> nomes = new ArrayList<>();
        for(int x =0; x < transformar.size(); x++){
            nomes.add(transformar.get(x).getNome());
        }
 
        String[] ArrayNomes = nomes.toArray(new String[nomes.size()]);

        String[] opcoes = new String[ArrayNomes.length + 1];
        opcoes[0] = primeiraOpcao;
        System.arraycopy(ArrayNomes, 0, opcoes, 1, ArrayNomes.length);
        
        return opcoes;
    }
    
    private static String[] listCidadeToArrayNomes (ArrayList<Cidade> transformar, String primeiraOpcao){
        ArrayList<String> nomes = new ArrayList<>();
        for(int x =0; x < transformar.size(); x++){
            nomes.add(transformar.get(x).getNome());
        }
 
        String[] ArrayNomes = nomes.toArray(new String[nomes.size()]);

        String[] opcoes = new String[ArrayNomes.length + 1];
        opcoes[0] = primeiraOpcao;
        System.arraycopy(ArrayNomes, 0, opcoes, 1, ArrayNomes.length);
        
        return opcoes;
    }
    
    private static String[] listPaisToArrayNomes (ArrayList<Pais> transformar, String primeiraOpcao){
        ArrayList<String> nomes = new ArrayList<>();
        for(int x =0; x < transformar.size(); x++){
            nomes.add(transformar.get(x).getNome());
        }
 
        String[] ArrayNomes = nomes.toArray(new String[nomes.size()]);

        String[] opcoes = new String[ArrayNomes.length + 1];
        opcoes[0] = primeiraOpcao;
        System.arraycopy(ArrayNomes, 0, opcoes, 1, ArrayNomes.length);
        
        return opcoes;
    }
    
    private static String[] listEstadoToArrayNomes (ArrayList<Estado> transformar, String primeiraOpcao){
        ArrayList<String> nomes = new ArrayList<>();
        for(int x =0; x < transformar.size(); x++){
            nomes.add(transformar.get(x).getNome());
        }
 
        String[] ArrayNomes = nomes.toArray(new String[nomes.size()]);

        String[] opcoes = new String[ArrayNomes.length + 1];
        opcoes[0] = primeiraOpcao;
        System.arraycopy(ArrayNomes, 0, opcoes, 1, ArrayNomes.length);
        
        return opcoes;
    }

    private static void cadastrarCliente(ArrayList<Cliente> clientes, ArrayList<Cidade> listCidade, ArrayList<Estado> listEstados, ArrayList<Pais> listPaises){
        clientes.add(new Cliente(
        cadastrarEndereco(listCidade, listEstados, listPaises),
        JOptionPane.showInputDialog("Qual seu nome:"),
        JOptionPane.showInputDialog("Insira seu número de telefone:")
        ));
    }
    
    private static Endereco cadastrarEndereco(ArrayList<Cidade> listCidade, ArrayList<Estado> listEstados, ArrayList<Pais> listPaises){
        String rua = JOptionPane.showInputDialog("Insira sua Rua:");
        String bairro = JOptionPane.showInputDialog("Insira seu Bairro:");
        
        String complemento;
        String[] opcoes = {"Sim", "Não"};
        int temComplemento = JOptionPane.showOptionDialog(null, "Deseja inserir um complemento?",
                "Complemento",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoes, opcoes[1]);
        if(temComplemento == 0)
            complemento = JOptionPane.showInputDialog("Insira seu complemento:");
        else
            complemento = null;
        
        String numero = JOptionPane.showInputDialog("Insira o número da sua casa:");
        
        return new Endereco(
        rua,
        bairro,
        complemento,
        numero,
        inserirCidade(listCidade, listEstados, listPaises)
        );
    }
    
    private static Cidade inserirCidade(ArrayList<Cidade> listCidades, ArrayList<Estado> listEstados, ArrayList<Pais> listPaises){
        int temCidade = JOptionPane.showOptionDialog(null, "Cidade",
                "Selecione sua cidade",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, listCidadeToArrayNomes(listCidades, "Outra"), null);
        if(temCidade == 0)
            return cadastrarCidade(listCidades, listEstados, listPaises);
        else
            return listCidades.get(temCidade-1);
    }
    
    private static Cidade cadastrarCidade(ArrayList<Cidade> listCidades, ArrayList<Estado> listEstados, ArrayList<Pais> listPaises){
        String nome = JOptionPane.showInputDialog("Insira o nome da cidade:");
        Estado estado = inserirEstado(listEstados, listPaises);
        Cidade novaCidade = new Cidade (nome, estado);
        
        listCidades.add(novaCidade);
        return novaCidade;
    }
    
    private static Estado inserirEstado(ArrayList<Estado> listEstados, ArrayList<Pais> listPaises){
        int temEstado = JOptionPane.showOptionDialog(null, "Estado",
                "Selecione seu Estado",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, listEstadoToArrayNomes(listEstados, "Outro"), null);
        if(temEstado == 0)
            return cadastrarEstado(listEstados, listPaises);
        else
            return listEstados.get(temEstado-1);
    }
    
    private static Estado cadastrarEstado(ArrayList<Estado> listEstados, ArrayList<Pais> listPaises){
       String nome = JOptionPane.showInputDialog("Insira o nome do estado:");
       String abreviacao = JOptionPane.showInputDialog("Insira a abreviação do estado:");
       Pais pais = inserirPais(listPaises);
       Estado novoEstado = new Estado(nome, abreviacao, pais);
       
       listEstados.add(novoEstado);
       return novoEstado;
    }
    
    private static Pais inserirPais(ArrayList<Pais> listPaises){
        int temPais = JOptionPane.showOptionDialog(null, "País",
                "Selecione seu País",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, listPaisToArrayNomes(listPaises, "Outro"), null);
        if(temPais == 0)
            return cadastrarPais(listPaises);
        else
            return listPaises.get(temPais-1);
    }
    
    private static Pais cadastrarPais(ArrayList<Pais> listPaises){
        String nome = JOptionPane.showInputDialog("Insira o nome do país:");
        String abreviacao = JOptionPane.showInputDialog("Insira a abreviação do país:");
        Pais novoPais = new Pais(nome, abreviacao);
        
        listPaises.add(novoPais);
        return novoPais;
    }
    
    private static double arredondar(double valor){
       return Math.round(valor * 100.0) / 100.0;
    }
    
}
