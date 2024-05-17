package gerenciadorlojasshopping.domain;

public class Vestuario extends Loja {
    private boolean produtosImportados;

    public Vestuario(String nome, int quantidadeFuncionarios, double salarioBaseFuncionario,
                     Endereco endereco, Data dataFundacao, boolean produtosImportados) {
        super(nome, quantidadeFuncionarios, salarioBaseFuncionario, endereco, dataFundacao);
        this.produtosImportados = produtosImportados;
    }

    public String toString(){
        return super.toString() + "\nProdutos importados: " + produtosImportados + "\n";
    }

    public boolean isProdutosImportados() { return produtosImportados; }
    public void setProdutosImportados(boolean produtosImportados) { this.produtosImportados = produtosImportados; }
}