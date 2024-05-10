package gerenciadorlojasshopping.test;

import gerenciadorlojasshopping.domain.Data;
import gerenciadorlojasshopping.domain.Loja;
import gerenciadorlojasshopping.domain.Produto;

public class Principal {

    public static void main(String[] args) {
        System.out.println("|-----------------------------------------|");
        System.out.println("|----------------MENU---------------------|");
        System.out.println("|-----------------------------------------|");
        System.out.println("|          (1) criar uma loja             |");
        System.out.println("|          (2) criar um produto           |");
        System.out.println("|          (3) sair                       |");
        System.out.println("|_________________________________________|");

        Produto produto = null;
        Loja loja = null;

        int i = 0;
        while (i != 3) {
            i = Teclado.leInt("\nDigite uma opção: ");

            switch (i) {
                case 1:
                    loja = new Loja(Teclado.leString("Digite o nome da Loja: "),
                            Teclado.leInt("Digite a quantidade de funcionários: "),
                            Teclado.leInt("Digite o salário base dos funcionários: "));
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

                    System.out.println("Informações cadastradas no sistema!+" +
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
        if (produto.estaVencido(new Data(20,10,2023))){
            System.out.println("\nPRODUTO VENCIDO!");
        } else {
            System.out.println("\nPRODUTO NÃO VENCIDO");
        }

    }
}
