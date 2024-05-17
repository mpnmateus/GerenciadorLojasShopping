package gerenciadorlojasshopping.domain;

public class Informatica extends Loja{
    private double seguroEletronicos;

    public Informatica(String nome, int quantidadeFuncionarios, double salarioBaseFuncionario,
                       Endereco endereco, Data dataFundacao, double seguroEletronicos){
        super(nome, quantidadeFuncionarios, salarioBaseFuncionario, endereco, dataFundacao);
        this.seguroEletronicos = seguroEletronicos;
    }

    public String toString(){
        return super.toString() + "Valor do seguro de Eletrônicos: " + this.seguroEletronicos;
    }

    public double getSeguroEletronicos() { return seguroEletronicos; }
    public void setSeguroEletronicos(double seguroEletronicos) { this.seguroEletronicos = seguroEletronicos; }
}
