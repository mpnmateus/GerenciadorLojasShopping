package gerenciadorlojasshopping.domain;

public class Produto {
    private String nome;
    private int preco;
    private Data dataValidade;
    private Data data;


    public Produto(String nome, int preco){
        this.nome = nome;
        this.preco = preco;
        dataValidade = new Data(10, 11, 2023);
        data = new Data(10, 2, 2024);
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
        return "Nome: "+ this.nome + ", Preco: " + this.preco;
    }

    public void setNome(String nome){ this.nome = nome; }
    public String getNome(){ return this.nome; }

    public void setPreco(int preco){ this.preco = preco; }
    public int getPreco(){ return this.preco; }

    public void setDataValidade(Data data){ this.data = data; }
    public Data getDataValidade(){ return this.data; }

    public void setData(Data data) {this.data = data; }
    public Data getData() { return this.data; }

}
