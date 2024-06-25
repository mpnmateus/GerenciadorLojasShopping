package gerenciadorlojasshopping.test;

import gerenciadorlojasshopping.domain.*;

public class Principal_Menu_Completo {

    public static void main(String[] args) {

        Produto produto = null;
        Loja loja = null;
        Shopping shopping = null;

        int i = 0;
        while (i != 6) {
            System.out.println("\n");
            System.out.println("|-----------------------------------------|");
            System.out.println("|----------------MENU---------------------|");
            System.out.println("|-----------------------------------------|");
            System.out.println("|          (1) CRIAR UM SHOPPING          |");
            System.out.println("|          (2) CRIAR UMA LOJA             |");
            System.out.println("|             (3) remover uma loja        |");
            System.out.println("|          (4) CRIAR UM PRODUTO           |");
            System.out.println("|             (5) remover um produto      |");
            System.out.println("|          (6) SAIR                       |");
            System.out.println("|_________________________________________|");
            i = Teclado.leInt("\nDigite uma opção: ");

            switch (i) {

                //Cria um Shopping
                case 1:
                    int qntMaximaLojas = Teclado.leInt("\nDigite a quantidade máxima de Lojas que o Shopping pode ter: ");
                    String nomeShopping = Teclado.leString("Digite o nome do shopping: ");

                    System.out.println("Informe o endereço do Shopping (Nome da rua, Cidade, Estado, Pais, Cep, " +
                            "Numero e Complemento)");
                    String nomeRua = Teclado.leString();
                    String cidade = Teclado.leString();
                    String estado = Teclado.leString();
                    String pais = Teclado.leString();
                    String cep = Teclado.leString();
                    String numero = Teclado.leString();
                    String complemento = Teclado.leString();

                    Endereco enderecoShopping = new Endereco(nomeRua, cidade, estado, pais, cep, numero, complemento);

                    //Cria uma instância de shopping
                    shopping = new Shopping(nomeShopping, enderecoShopping, qntMaximaLojas);
                    break;

                //Cria uma loja dentro do shopping
                case 2:

                    //Verifica se há shopping para incluir lojas nele
                    if (shopping == null)
                        System.out.println("Tem de haver um shopping criado para incluir alguma loja.");
                    else {


                        String nomeLoja = Teclado.leString("Digite o nome da Loja: ");
                        int qntFuncionarios = Teclado.leInt("Digite a quantidade de funcionários: ");
                        int salarioBaseFuncionarios = Teclado.leInt("Digite o salário base dos funcionários: ");
                        int qntMaximaProdutos = Teclado.leInt("Digite a quantidade máxima de produtos que a " +
                                "loja poderá ter: ");

                        System.out.println("Informe dia, mês e ano da fundação da loja (dd mm aaaa)");
                        int diaFundacao = Teclado.leInt();
                        int mesFundacao = Teclado.leInt();
                        int anoFundacao = Teclado.leInt();
                        Data dataFundacao = new Data(diaFundacao, mesFundacao, anoFundacao);


                        Endereco enderecoLoja = new Endereco(shopping.getEndereco().getNomeDaRua(), shopping.getEndereco().getCidade(),
                                shopping.getEndereco().getEstado(), shopping.getEndereco().getPais(), shopping.getEndereco().getCep(),
                                shopping.getEndereco().getNumero(), shopping.getEndereco().getComplemento());

                        //Cria uma instância de loja
                        loja = new Loja(nomeLoja, qntFuncionarios, salarioBaseFuncionarios, enderecoLoja,
                                dataFundacao, qntMaximaProdutos);


                        if (shopping.insereLoja(loja)) {
                            System.out.println("Loja inserida com sucesso!");
                            System.out.println("\nO tamanho da loja é: " + loja.tamanhoDaLoja());
                            System.out.println("\n" + loja);
                        } else
                            System.out.println("Não há mais espaço para lojas no shopping.");

                        break;

                    }
                    break;

                //Remove uma loja dentro do shopping
                case 3:

                    boolean removeu = false;

                    while(!removeu) {

                        String nomeLojaParaRemover = Teclado.leString("\nDigite o nome da loja que quer remover: ");

                        if (shopping != null && shopping.removeLoja(nomeLojaParaRemover)) {
                            System.out.println("Loja " + nomeLojaParaRemover + " removida com sucesso");
                            removeu = true;
                        } else if (shopping != null && !shopping.removeLoja(nomeLojaParaRemover)) {
                            System.out.println("Loja não removida. Digite novamente.");
                        }
                    }
                    break;

                //Cria um Produto
                case 4:

                    String nomeProduto = Teclado.leString("Digite o nome do Produto: ");
                    int precoProduto = Teclado.leInt("Digite o preço do produto");

                    System.out.println("Informe dia, mês e ano de validade do produto (dd mm aaaa)");
                    int dia = Teclado.leInt();
                    int mes = Teclado.leInt();
                    int ano = Teclado.leInt();
                    Data dataValidade = new Data(dia, mes, ano);

                    //Cria uma instância de produto
                    produto = new Produto(nomeProduto, precoProduto, dataValidade);

                    if (loja == null)
                        System.out.println("Não há estoque disponível.");
                    else if (loja.insereProduto(produto)) {
                        System.out.println("Produto inserido com sucesso!");
                    } else
                        System.out.println("Não há mais espaço para produtos no estoque");

                    //Verifica se o produto está vencido na data de 20/10/2023 (OK)

                    Data dataReferencia = new Data(20, 10, 2023);
                    if (produto.estaVencido(dataReferencia)) {
                        System.out.println("\nPRODUTO VENCIDO");
                    } else {
                        System.out.println("\nPRODUTO NÃO VENCIDO");
                    }


                    System.out.println("Informações cadastradas no sistema!" +
                            "\nProduto: " + produto.getNome() + "\nPreço: R$ " + produto.getPreco() +
                            "\nData Validade:" + produto.getDataValidade());
                    break;


                //Sai do programa
                case 6:
                    System.out.println("\nVocê saiu do menu!");
                    break;
                default:
                    System.out.println("\nOpção inválida!");
            }

        }

        System.out.println("\n---------------- RESUMO ----------------------");
        if (shopping != null){
            System.out.println("\nEssas são as inforações do Shopping criado no sistema: ");
            System.out.println(shopping);
        } else {
            System.out.println("\n[x] Nenhum Shopping criado [x]");
        }

        if (loja != null ) {
            System.out.println("\nEssas são as informações da(s) loja(s) criada(s) no sistema: ");
            for (int num =0; i > shopping.getLojas().length; num++) {
                if (shopping.getLojas()[num] != null) {
                    System.out.println("Os produtos da loja " + shopping.getLojas()[num].getNome() + "são: ");
                    shopping.getLojas()[num].imprimeProdutos();
                }
            }


            System.out.println(loja);
        } else{
            System.out.println("\n[x] Nenhuma loja criada [x]");
        }

        if (produto != null ) {
            System.out.println("\nEssas são as informações do produto criado no sistema");
            System.out.println(produto);
        } else {
            System.out.println("\n[x] Nenhum produto criado [x]");
        }

    }
}


