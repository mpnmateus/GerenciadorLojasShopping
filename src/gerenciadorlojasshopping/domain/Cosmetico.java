package gerenciadorlojasshopping.domain;

public class Cosmetico extends Loja {
    private double taxaComercializacao;

    public Cosmetico(String nome, int quantidadeFuncionarios, double salarioBaseFuncionario,
                     Endereco endereco, Data dataFundacao, double taxaComercializacao) {
        super(nome, quantidadeFuncionarios, salarioBaseFuncionario, endereco, dataFundacao);
        this.taxaComercializacao = taxaComercializacao;
    }

    //Construtor etapa4
    public Cosmetico(String nome, int quantidadeFuncionarios, double salarioBaseFuncionario,
                     Endereco endereco, Data dataFundacao, double taxaComercializacao, int qntMaximaProdutos) {
        super(nome, quantidadeFuncionarios, salarioBaseFuncionario, endereco, dataFundacao, qntMaximaProdutos);
        this.taxaComercializacao = taxaComercializacao;
    }

    @Override
    public String toString(){
        return super.toString()+ "\nTaxa de Comercialização: "+this.taxaComercializacao;
    }

    public double getTaxaComercializacao() { return taxaComercializacao; }
    public void setTaxaComercializacao(double taxaComercializacao) { this.taxaComercializacao = taxaComercializacao; }
}
