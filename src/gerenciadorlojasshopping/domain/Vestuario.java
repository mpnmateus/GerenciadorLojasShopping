package gerenciadorlojasshopping.domain;

public class Vestuario extends Loja {
    private boolean produtosImportados;

    public Vestuario(String nome, int quantidadeFuncionarios, double salarioBaseFuncionario,
                     Endereco endereco, Data dataFundacao, boolean produtosImportados) {
        super(nome, quantidadeFuncionarios, salarioBaseFuncionario, endereco, dataFundacao);
        this.produtosImportados = produtosImportados;
    }

    //Construtor etapa04
    public Vestuario(String nome, int quantidadeFuncionarios, double salarioBaseFuncionario,
                     Endereco endereco, Data dataFundacao, boolean produtosImportados, int qntMaximaProdutos) {
        super(nome, quantidadeFuncionarios, salarioBaseFuncionario, endereco, dataFundacao, qntMaximaProdutos);
        this.produtosImportados = produtosImportados;
    }

    public String toString(){
        return super.toString() + "\nProdutos importados: " + produtosImportados + "\n";
    }

    public boolean getProdutosImportados() { return produtosImportados; }
    public void setProdutosImportados(boolean produtosImportados) { this.produtosImportados = produtosImportados; }
}
