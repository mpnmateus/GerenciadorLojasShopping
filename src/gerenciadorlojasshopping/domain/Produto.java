package gerenciadorlojasshopping.domain;

public class Produto {
    private String nome;
    private int preco;
    private Data dataValidade;


    public Produto(String nome, int preco){
        this.nome = nome;
        this.preco = preco;
    }

    public Produto (String nome, int preco, Data dataValidade){
        this(nome, preco);
        this.dataValidade = dataValidade;
    }


    public boolean estaVencido(Data data){
        if (data.getAno() > dataValidade.getAno())
            return true;
        else if (data.getAno() < dataValidade.getAno())
            return false;
        else {
            if (data.getMes() > dataValidade.getMes())
                return true;
            else if (data.getMes() < dataValidade.getMes())
                return false;
            else {
                if (data.getDia() > dataValidade.getDia())
                    return true;
                else
                    return false;
            }
        }
    }

    @Override //para ter ctz que está sobreescrevendo
    public String toString(){
        return String.format(
                "Produto: [Nome = %s, Preço = %d, DataValidade = %s]",
                this.nome, this.preco, this.dataValidade
        );
    }

    public void setNome(String nome){ this.nome = nome; }
    public String getNome(){ return this.nome; }

    public void setPreco(int preco){ this.preco = preco; }
    public int getPreco(){ return this.preco; }

    public void setDataValidade(Data dataValidade){ this.dataValidade = dataValidade; }
    public Data getDataValidade(){ return this.dataValidade; }


}
