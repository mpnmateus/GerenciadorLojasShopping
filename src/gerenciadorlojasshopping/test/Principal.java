package gerenciadorlojasshopping.test;

import com.sun.source.tree.UsesTree;
import gerenciadorlojasshopping.domain.*;

public class Principal {

    public static void main(String[] args) {

        Produto produto = null;
        Loja loja = null;

        int i = 0;
        while (i != 3) {
            System.out.println("\n");
            System.out.println("|-----------------------------------------|");
            System.out.println("|----------------MENU---------------------|");
            System.out.println("|-----------------------------------------|");
            System.out.println("|          (1) criar uma loja             |");
            System.out.println("|          (2) criar um produto           |");
            System.out.println("|          (3) sair                       |");
            System.out.println("|_________________________________________|");
            i = Teclado.leInt("\nDigite uma opção: ");

            switch (i) {
                case 1:

                    String nomeLoja = Teclado.leString("Digite o nome da Loja: ");
                    int qntFuncionarios = Teclado.leInt("Digite a quantidade de funcionários: ");
                    int salarioBaseFuncionarios = Teclado.leInt("Digite o salário base dos funcionários: ");

                    System.out.println("Informe dia, mês e ano da fundação da loja (dd mm aaaa)");
                    int diaFundacao = Teclado.leInt();
                    int mesFundacao = Teclado.leInt();
                    int anoFundacao = Teclado.leInt();
                    Data dataFundacao = new Data(diaFundacao, mesFundacao, anoFundacao);

                    System.out.println("Informe o endereço da loja (Nome da rua, Cidade, Estado, Pais, Cep, " +
                            "Numero e Complemento)");
                    String nomeRua = Teclado.leString();
                    String cidade = Teclado.leString();
                    String estado = Teclado.leString();
                    String pais = Teclado.leString();
                    String cep = Teclado.leString();
                    String numero = Teclado.leString();
                    String complemento = Teclado.leString();

                    Endereco enderecoLoja = new Endereco(nomeRua, cidade, estado, pais, cep, numero, complemento);

                    loja = new Loja(nomeLoja, qntFuncionarios, salarioBaseFuncionarios, enderecoLoja, dataFundacao);



                    break;
                case 2:
                    String nomeProduto = Teclado.leString("Digite o nome da Produto: ");
                    int precoProduto = Teclado.leInt("Digite o preço do produto");

                    System.out.println("Informe dia, mês e ano de validade do produto (dd mm aaaa)");
                    int dia = Teclado.leInt();
                    int mes = Teclado.leInt();
                    int ano = Teclado.leInt();
                    Data dataValidade = new Data(dia, mes, ano);

                    produto = new Produto(nomeProduto, precoProduto, dataValidade);


                    //Verifica se o produto está vencido na data de 20/10/2013 (OK)
                    if (produto != null) {
                        Data dataReferencia = new Data(20, 10, 2023);
                        if (produto.estaVencido(dataReferencia)) {
                            System.out.println("\nPRODUTO VENCIDO");
                        } else {
                            System.out.println("\nPRODUTO NÃO VENCIDO");
                        }
                    }

                    System.out.println("Informações cadastradas no sistema!" +
                            "\nProduto: "+produto.getNome()+"\nPreço:"+produto.getPreco()+
                            "\nData Validade:"+produto.getDataValidade());
                    break;
                case 3:
                    System.out.println("\nVocê saiu do menu!");
                    break;
                default:
                    System.out.println("\nOpção inválida!");
            }

        }

        if (loja != null ) {
            System.out.println("\nEssas são as informações da loja criada no sistema: ");
            System.out.println(loja.toString());
        } else{
            System.out.println("\nNenhuma loja criada.");
        }

        if (produto != null ) {
            System.out.println("\nEssas são as informações do produto criado no sistema");
            System.out.println(produto.toString());
        } else {
            System.out.println("\nNenhum produto criado.");
        }

    }
}
