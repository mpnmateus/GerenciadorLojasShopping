package gerenciadorlojasshopping.domain;

public class Shopping {
    private String nome;
    private Endereco endereco;
    private Loja [] lojas;

    public Shopping (String nome, Endereco endereco, int qntMaximaLojas){
        this.nome = nome;
        this.endereco = endereco;
        this.lojas = new Loja[qntMaximaLojas];
    }

}
