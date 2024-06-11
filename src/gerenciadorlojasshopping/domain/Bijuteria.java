package gerenciadorlojasshopping.domain;

public class Bijuteria extends Loja{
    private double metaVendas;

    public Bijuteria(String nome, int quantidadeFuncionarios, double salarioBaseFuncionario,
                     Endereco endereco, Data dataFundacao, double metaVendas){
        super(nome, quantidadeFuncionarios, salarioBaseFuncionario, endereco, dataFundacao);
        this.metaVendas = metaVendas;
    }

    //Construtor etapa 4
    public Bijuteria(String nome, int quantidadeFuncionarios, double salarioBaseFuncionario,
                     Endereco endereco, Data dataFundacao, double metaVendas, int qntMaximaProdutos){
        super(nome, quantidadeFuncionarios, salarioBaseFuncionario, endereco, dataFundacao, qntMaximaProdutos);
        this.metaVendas = metaVendas;
    }


    @Override
    public String toString(){
        return super.toString() + "\nMeta de Vendas: " + this.metaVendas;
    }

    public double getMetaVendas() { return metaVendas; }
    public void setMetaVendas(double metaVendas) { this.metaVendas = metaVendas; }
}
