package gerenciadorlojasshopping.domain;

import javax.swing.*;

public class Loja {
    private String nome;
    private int quantidadeFuncionarios;
    private int salarioBaseFuncionario;
    private Endereco endereco;
    private Data dataFundacao;

    public Loja(String nome, int quantidadeFuncionarios){
        this.nome = nome;
        this.quantidadeFuncionarios = quantidadeFuncionarios;
        /**
        this.endereco = new Endereco("Demétrio Ribeiro", "Porto Alegre",
                "RS", "Brasil", "90010-311", "1085", "01");
        this.dataFundacao = new Data(12, 10, 1928);
        **/
    }

    public Loja(String nome, int quantidadeFuncionarios, int salarioBaseFuncionario) {
        this(nome, quantidadeFuncionarios);
        this.salarioBaseFuncionario = salarioBaseFuncionario;
        this.setSalarioBaseFuncionario(-1);
    }

    public Loja(String nome, int quantidadeFuncionarios, int salarioBaseFuncionario,
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
        return "Nome: "+ this.nome+ ", Quantidade de Funcionários: "+ quantidadeFuncionarios
                + ", Salário base dos Funcionários: "+ this.salarioBaseFuncionario+ ", Endereço: "+ this.endereco+
                ", Data de Fundação: " + this.dataFundacao;
    }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public int getQuantidadeFuncionarios() { return quantidadeFuncionarios; }
    public void setQuantidadeFuncionarios(int quantidadeFuncionarios) { this.quantidadeFuncionarios = quantidadeFuncionarios; }

    public int getSalarioBaseFuncionario() { return salarioBaseFuncionario; }
    public void setSalarioBaseFuncionario(int salarioBaseFuncionario) { this.salarioBaseFuncionario = salarioBaseFuncionario; }

    public void setEndereco (Endereco endereco){ this.endereco = endereco; }
    public Endereco getEndereco (){ return this.endereco; }

    public Data getDataFundacao() { return dataFundacao; }
    public void setDataFundacao(Data dataFundacao) { this.dataFundacao = dataFundacao; }
}
