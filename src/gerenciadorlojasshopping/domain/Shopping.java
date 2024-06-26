package gerenciadorlojasshopping.domain;

public class Shopping {
    private String nome;
    private Endereco endereco;
    private Loja [] lojas;
    private Produto [] estoqueGeralProdutos;

    public Shopping (String nome, Endereco endereco, int qntMaximaLojas){
        this.nome = nome;
        this.endereco = endereco;
        this.lojas = new Loja[qntMaximaLojas];
    }

    public Shopping (String nome, Endereco endereco, int qntMaximaLojas, int qntMaximaProdutosEstoqueGeral){
        this.nome = nome;
        this.endereco = endereco;
        this.lojas = new Loja[qntMaximaLojas];
        this.estoqueGeralProdutos = new Produto[qntMaximaProdutosEstoqueGeral];
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
        int contadorLoja = 0;
        boolean removeu = false;

        //Contar quantas lojas são null
        for (int i = 0; i < lojas.length; i++){
            if (lojas[i] == null)
                contadorLoja++;
        }

        //Verificar se todas lojas são null
        if (contadorLoja == lojas.length){
            System.out.println("Sem lojas cadastradas");
            return removeu;
        }

        //Remover Loja
        for (int i = 0; i < lojas.length; i++)
            if (lojas[i] != null && lojas[i].getNome().equalsIgnoreCase(nomeLoja)){
                lojas[i] = null;
                removeu = true;
                break;
            }
        return removeu;
    }

    public boolean insereProdutoEstoque(Produto p){
        boolean achou = false;
        for (int i = 0; i < estoqueGeralProdutos.length; i++)
            if (estoqueGeralProdutos[i] == null) {
                estoqueGeralProdutos[i] = p;
                achou = true;
                break;
            }
        return achou;
    }

    public boolean removeProdutoEstoque(String nomeProduto){
        boolean removeu = false;
        // Remover o produto
        for (int i = 0; i < estoqueGeralProdutos.length; i++)
            if (estoqueGeralProdutos[i] != null && estoqueGeralProdutos[i].getNome().equalsIgnoreCase(nomeProduto)){
                estoqueGeralProdutos[i] = null;
                removeu = true;
                break;
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

    public Informatica lojaSeguroMaisCaro(){
        Informatica lojaMaisCara = null;
        double maiorSeguro = Double.MIN_VALUE;

        for (int i = 0; i < lojas.length; i++) {
            if (lojas[i] instanceof Informatica) {
                Informatica lojaInformatica = (Informatica) lojas[i];
                if (lojaInformatica.getSeguroEletronicos() > maiorSeguro) {
                    maiorSeguro = lojaInformatica.getSeguroEletronicos();
                    lojaMaisCara = lojaInformatica;
                }
            }
        }
        return lojaMaisCara;
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

    public Produto[] getEstoqueGeralProdutos() { return estoqueGeralProdutos; }
    public void setEstoqueGeralProdutos(Produto[] estoqueGeralProdutos) { this.estoqueGeralProdutos = estoqueGeralProdutos; }
}
