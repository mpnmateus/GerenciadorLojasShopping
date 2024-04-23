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
                    produto = new Produto(Teclado.leString("Digite o nome do produto: "),
                            Teclado.leInt("Digite o preço do produto: "));
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
