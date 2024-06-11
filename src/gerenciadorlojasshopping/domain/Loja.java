package gerenciadorlojasshopping.domain;

import javax.swing.*;

public class Loja {
    private String nome;
    private int quantidadeFuncionarios;
    private double salarioBaseFuncionario;
    private Endereco endereco;
    private Data dataFundacao;
    private Produto [] estoqueProdutos;

    //Construtor 2 parâmetros validadorEtapa1 - Loja1
    public Loja(String nome, int quantidadeFuncionarios){
        this.nome = nome;
        this.quantidadeFuncionarios = quantidadeFuncionarios;
        this.salarioBaseFuncionario = -1;
    }

    //Construtor 3 parâmetros validadorEtapa1 - Loja2
    public Loja(String nome, int quantidadeFuncionarios, double salarioBaseFuncionario) {
        this.nome = nome;
        this.quantidadeFuncionarios = quantidadeFuncionarios;
        this.salarioBaseFuncionario = salarioBaseFuncionario;
    }

    //Construtor 5 parâmetros validadorEtapa2 - Loja2
    public Loja(String nome, int quantidadeFuncionarios, double salarioBaseFuncionario,
                Endereco endereco, Data dataFundacao) {
        this(nome, quantidadeFuncionarios, salarioBaseFuncionario);
        this.endereco = endereco;
        this.dataFundacao = dataFundacao;
    }

    //Construtor 4 parâmetros validadorEtapa3 - Loja1
    public Loja(String nome, int quantidadeFuncionarios, Endereco endereco, Data dataFundacao) {
        this.nome = nome;
        this.quantidadeFuncionarios = quantidadeFuncionarios;
        this.salarioBaseFuncionario = -1;
        this.endereco = endereco;
        this.dataFundacao = dataFundacao;
    }

    //Construtor 5 parâmetros validadorEtapa4 - Loja1
    public Loja(String nome, int quantidadeFuncionarios, Endereco endereco, Data dataFundacao,
                int qntMaximaProdutos) {
        this.nome = nome;
        this.quantidadeFuncionarios = quantidadeFuncionarios;
        this.salarioBaseFuncionario = -1;
        this.endereco = endereco;
        this.dataFundacao = dataFundacao;
        int i = qntMaximaProdutos;
        this.estoqueProdutos = new Produto [i];
    }

    //Construtor 6 parâmetros validadorEtapa4 - Loja2
    public Loja(String nome, int quantidadeFuncionarios, double salarioBaseFuncionario,
                Endereco endereco, Data dataFundacao, int qntMaximaProdutos) {
        this(nome, quantidadeFuncionarios, salarioBaseFuncionario);
        this.endereco = endereco;
        this.dataFundacao = dataFundacao;
        int i = qntMaximaProdutos;
        this.estoqueProdutos = new Produto [i];
    }


    public double gastosComSalario(){
        if (salarioBaseFuncionario == -1)
            return -1;
        else
            return quantidadeFuncionarios * salarioBaseFuncionario;
    }

    public char tamanhoDaLoja(){
        if (quantidadeFuncionarios < 10){
            return 'P';
        } else if (quantidadeFuncionarios >= 10 && quantidadeFuncionarios <= 30){
            return 'M';
        } else if (quantidadeFuncionarios >= 31) {
            return 'G';
        } else {
            return ' ';
        }
    }

    //imprime produtos do array
    public void imprimeProdutos(){
        for (int i = 0; i < estoqueProdutos.length; i++){
            System.out.println("Produto " + i + ":" + estoqueProdutos[i]);
        }
    }

    public boolean insereProduto (Produto p){
        boolean achou = false;
        for (int i = 0; i < estoqueProdutos.length; i++)
            if (estoqueProdutos[i] == null) {
                estoqueProdutos[i] = p;
                achou = true;
                break;
            }
        return achou;
    }

    public boolean removeProduto(String nomeProduto){
        boolean removeu = false;
        for (int i = 0; i < estoqueProdutos.length; i++)
            if (estoqueProdutos[i].getNome().equalsIgnoreCase(nomeProduto)){
                estoqueProdutos[i] = null;
                removeu = true;
                break;
            }
        return removeu;
    }

    @Override
    public String toString(){
        return String.format(
                "Loja: \n[Nome = %s, Quantidade de Funcionários = %d, Salário base dos Funcionários = %f, Endereço = %s, \nData de fundação = %s, \nEstoque de Produtos = %s]",
                this.nome, this.quantidadeFuncionarios, this.salarioBaseFuncionario, this.endereco, this.dataFundacao, this.estoqueProdutos
        );
    }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public int getQuantidadeFuncionarios() { return quantidadeFuncionarios; }
    public void setQuantidadeFuncionarios(int quantidadeFuncionarios) { this.quantidadeFuncionarios = quantidadeFuncionarios; }

    public double getSalarioBaseFuncionario() { return salarioBaseFuncionario; }
    public void setSalarioBaseFuncionario(double salarioBaseFuncionario) { this.salarioBaseFuncionario = salarioBaseFuncionario; }

    public void setEndereco (Endereco endereco){ this.endereco = endereco; }
    public Endereco getEndereco (){ return this.endereco; }

    public Data getDataFundacao() { return dataFundacao; }
    public void setDataFundacao(Data dataFundacao) { this.dataFundacao = dataFundacao; }

    public Produto[] getEstoqueProdutos() { return estoqueProdutos; }
    public void setEstoqueProdutos(Produto[] estoqueProdutos) { this.estoqueProdutos = estoqueProdutos; }
}
