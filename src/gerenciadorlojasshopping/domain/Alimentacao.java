package gerenciadorlojasshopping.domain;

public class Alimentacao extends Loja{
    private Data dataAlvara;

    public Alimentacao(String nome, int quantidadeFuncionarios, double salarioBaseFuncionario,
                       Endereco endereco, Data dataFundacao, Data dataAlvara){
        super(nome, quantidadeFuncionarios, salarioBaseFuncionario, endereco, dataFundacao);
        this.dataAlvara = dataAlvara;
    }

    //Construtor etapa4
    public Alimentacao(String nome, int quantidadeFuncionarios, double salarioBaseFuncionario,
                       Endereco endereco, Data dataFundacao, Data dataAlvara, int qntMaximaProdutos){
        super(nome, quantidadeFuncionarios, salarioBaseFuncionario, endereco, dataFundacao, qntMaximaProdutos);
        this.dataAlvara = dataAlvara;
    }

    @Override
    public String toString(){
        return super.toString() + "\nData do Alvará: " + this.dataAlvara;
    }

    public Data getDataAlvara() { return dataAlvara; }

    public void setDataAlvara(Data dataAlvara) { this.dataAlvara = dataAlvara; }
}
