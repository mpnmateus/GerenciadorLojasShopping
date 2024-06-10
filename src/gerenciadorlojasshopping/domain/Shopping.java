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

    public boolean insereLoja(Loja loja){
        boolean inseriu = false;
        for (int i = 0; i < lojas.length; i++)
            if (lojas[i] == null){
                lojas[i] = loja;
                inseriu = true;
                break;
            }
        return inseriu;
    }

    public boolean removeLoja(String nomeLoja){
        boolean removeu = false;
        for (int i = 0; i < lojas.length; i++)
            if (lojas[i].getNome().equalsIgnoreCase(nomeLoja)){
                lojas[i] = null;
                removeu = true;
            }
        return removeu;
    }

    public int quantidadeLojasPorTipo(String tipoLoja){
        int qntLojas = 0;
        boolean tipoValido = false;

        if (tipoLoja.equalsIgnoreCase("Alimentacao")){
            tipoValido = true;
            for (int i = 0; i < lojas.length; i++)
                if (lojas[i] instanceof Alimentacao)
                    qntLojas++;
        } else if (tipoLoja.equalsIgnoreCase("Bijuteria")) {
            tipoValido = true;
            for (int i = 0; i < lojas.length; i++)
                if (lojas[i] instanceof Bijuteria)
                    qntLojas++;
        } else if (tipoLoja.equalsIgnoreCase("Cosmetico")) {
            tipoValido = true;
            for (int i = 0; i < lojas.length; i++)
                if (lojas[i] instanceof Cosmetico)
                    qntLojas++;
        } else if (tipoLoja.equalsIgnoreCase("Informatica")) {
            tipoValido = true;
            for (int i = 0; i < lojas.length; i++)
                if (lojas[i] instanceof Informatica)
                    qntLojas++;
        }  else if (tipoLoja.equalsIgnoreCase("Vestuario")) {
            tipoValido = true;
            for (int i = 0; i < lojas.length; i++)
                if (lojas[i] instanceof Vestuario)
                    qntLojas++;
        }
        if (!tipoValido)
            return -1;

        return qntLojas;
    }

    @Override
    public String toString(){
        return String.format(
                "Shopping: \n[Nome = %s, \nEndereço = %s, \nLojas = %s]",
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
