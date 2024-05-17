package gerenciadorlojasshopping.domain;

import javax.swing.*;

public class Loja {
    private String nome;
    private int quantidadeFuncionarios;
    private double salarioBaseFuncionario;
    private Endereco endereco;
    private Data dataFundacao;

    public Loja(String nome, int quantidadeFuncionarios){
        this.nome = nome;
        this.quantidadeFuncionarios = quantidadeFuncionarios;
        this.salarioBaseFuncionario = -1;
    }

    public Loja(String nome, int quantidadeFuncionarios, double salarioBaseFuncionario) {
        this(nome, quantidadeFuncionarios);
        this.salarioBaseFuncionario = salarioBaseFuncionario;
    }

    public Loja(String nome, int quantidadeFuncionarios, double salarioBaseFuncionario,
                Endereco endereco, Data dataFundacao) {
        this(nome, quantidadeFuncionarios, salarioBaseFuncionario);
        this.endereco = endereco;
        this.dataFundacao = dataFundacao;
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
    @Override
    public String toString(){
        return "Loja \nNome: "+ this.nome+ "\nQuantidade de Funcionários: "+ quantidadeFuncionarios
                + "\nSalário base dos Funcionários: "+ this.salarioBaseFuncionario+ "\nEndereço: "+ this.endereco+
                "\nData de Fundação: " + this.dataFundacao;
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
}
