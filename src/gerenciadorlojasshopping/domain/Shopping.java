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

    @Override
    public String toString(){
        return String.format(
                "Shopping: \n[Nome = %s, Endereço = %s, \nLojas = %s]",
                this.nome, this.endereco, this.lojas
        );
    }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public Endereco getEndereco() { return endereco; }
    public void setEndereco(Endereco endereco) { this.endereco = endereco; }

    public Loja[] getLojas() { return lojas; }
    public void setLojas(Loja[] lojas) { this.lojas = lojas; }
}
