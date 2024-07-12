package gerenciadorlojasshopping.test;

import gerenciadorlojasshopping.domain.*;

public class Principal_Menu_Completo {

    public static void main(String[] args) {

        Produto produto = null;
        Loja loja = null;
        Loja lojaAlimentacao = null;
        Loja lojaBijuteria = null;
        Loja lojaCosmetico = null;
        Loja lojaInformatica = null;
        Loja lojaVestuario = null;
        Shopping shopping = null;

        int i = 0;
        while (i != 11) {
            System.out.println("\n");
            System.out.println("|---------------------------------------------------------------------|");
            System.out.println("|-----------------------------------MENU------------------------------|");
            System.out.println("|---------------------------------------------------------------------|");
            System.out.println("|          (1)  Criar um Shopping                                     |");
            System.out.println("|          (2)  Inserir uma Loja                                      |");
            System.out.println("|          (3)  Remover uma Loja (de um shopping)                     |");
            System.out.println("|          (4)  Criar um Produto e inserir no estoque geral           |");
            System.out.println("|          (5)  Inserir um Produto em uma Loja                        |");
            System.out.println("|          (6)  Remover um Produto de uma Loja                        |");
            System.out.println("|          (7)  Listar todas as Lojas de um Shopping                  |");
            System.out.println("|          (8)  Listar todos os Produtos do estoque geral do Shopping |");
            System.out.println("|          (9)  Listar todos os Produtos de uma Loja de um Shopping   |");
            System.out.println("|          (10) Imprimir relatório do Shopping                        |");
            System.out.println("|          (11) Sair                                                  |");
            System.out.println("|_____________________________________________________________________|");
            i = Teclado.leInt("\nDigite uma opção: ");

            switch (i) {

                //CRIA UM SHOPPING
                case 1:

                    String nomeShopping = Teclado.leString("Digite o nome do shopping: ");
                    int qntMaximaLojas = Teclado.leInt("\nDigite a quantidade máxima de Lojas que o Shopping pode ter: ");
                    int quantMaximaProdutosEstoqueGeral = Teclado.leInt("Digite a quantidade máxima que o estoque geral de produtos do shopping suporta: ");

                    System.out.println("Informe o endereço do Shopping (Nome da rua, Cidade, Estado, Pais, Cep, " +
                            "Numero e Complemento)");
                    String nomeRuaShopping = Teclado.leString();
                    String cidadeShopping = Teclado.leString();
                    String estadoShopping = Teclado.leString();
                    String paisShopping = Teclado.leString();
                    String cepShopping = Teclado.leString();
                    String numeroShopping = Teclado.leString();
                    String complementoShopping = Teclado.leString();

                    Endereco enderecoShopping = new Endereco(nomeRuaShopping, cidadeShopping, estadoShopping,
                            paisShopping, cepShopping, numeroShopping, complementoShopping);

                    //Cria uma instância de shopping
                    shopping = new Shopping(nomeShopping, enderecoShopping, qntMaximaLojas, quantMaximaProdutosEstoqueGeral);
                    break;

                //CRIA UMA LOJA E INSERE DENTRO DO SHOPPING
                case 2:

                    //Verifica se há shopping para incluir lojas nele
                    if (shopping == null)
                        System.out.println("Tem de haver um shopping criado para incluir alguma loja.");
                    else {

                        System.out.println("\n");
                        System.out.println("|----------------------------------------------------------|");
                        System.out.println("|---------------------- TIPOS DE LOJA ---------------------|");
                        System.out.println("|----------------------------------------------------------|");
                        System.out.println("|          (1) Alimentação                                 |");
                        System.out.println("|          (2) Bijuteria                                   |");
                        System.out.println("|          (3) Cosmético                                   |");
                        System.out.println("|          (4) Informática                                 |");
                        System.out.println("|          (5) Vestuário                                   |");
                        System.out.println("|__________________________________________________________|");

                        int tipoLoja = Teclado.leInt("Digite o tipo da loja: ");

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

                        System.out.println("Informe o endereço da Matriz da Loja (Nome da rua, Cidade, Estado, Pais, Cep, " +
                                "Numero e Complemento)");
                        String nomeRuaLoja = Teclado.leString();
                        String cidadeLoja = Teclado.leString();
                        String estadoLoja = Teclado.leString();
                        String paisLoja = Teclado.leString();
                        String cepLoja = Teclado.leString();
                        String numeroLoja = Teclado.leString();
                        String complementoLoja = Teclado.leString();

                        Endereco enderecoLoja = new Endereco(nomeRuaLoja, cidadeLoja, estadoLoja, paisLoja,
                                cepLoja, numeroLoja, complementoLoja);

                        //Cria uma instância de loja à depender do tipo
                        switch (tipoLoja) {
                            case 1:
                                lojaAlimentacao = new Loja(nomeLoja, qntFuncionarios, salarioBaseFuncionarios, enderecoLoja,
                                        dataFundacao, qntMaximaProdutos);

                                if(shopping.insereLoja(lojaAlimentacao))
                                    System.out.println("Loja inserida com sucesso");
                                else
                                    System.out.println("Erro ao inserir a loja. Capacidade máxima atingida.");

                                System.out.println("\nO tamanho da loja é: " + lojaAlimentacao.tamanhoDaLoja());
                                break;

                            case 2:
                                lojaBijuteria = new Loja(nomeLoja, qntFuncionarios, salarioBaseFuncionarios, enderecoLoja,
                                        dataFundacao, qntMaximaProdutos);

                                if(shopping.insereLoja(lojaBijuteria))
                                    System.out.println("Loja inserida com sucesso");
                                else
                                    System.out.println("Erro ao inserir a loja. Capacidade máxima atingida.");

                                System.out.println("\nO tamanho da loja é: " + lojaBijuteria.tamanhoDaLoja());
                                break;

                            case 3:
                                lojaCosmetico = new Loja(nomeLoja, qntFuncionarios, salarioBaseFuncionarios, enderecoLoja,
                                        dataFundacao, qntMaximaProdutos);

                                if(shopping.insereLoja(lojaCosmetico))
                                    System.out.println("Loja inserida com sucesso");
                                else
                                    System.out.println("Erro ao inserir a loja. Capacidade máxima atingida.");

                                System.out.println("\nO tamanho da loja é: " + lojaCosmetico.tamanhoDaLoja());
                                break;

                            case 4:
                                lojaInformatica = new Loja(nomeLoja, qntFuncionarios, salarioBaseFuncionarios, enderecoLoja,
                                        dataFundacao, qntMaximaProdutos);

                                if(shopping.insereLoja(lojaInformatica))
                                    System.out.println("Loja inserida com sucesso");
                                else
                                    System.out.println("Erro ao inserir a loja. Capacidade máxima atingida.");

                                System.out.println("\nO tamanho da loja é: " + lojaInformatica.tamanhoDaLoja());
                                break;

                            case 5:
                                lojaVestuario = new Loja(nomeLoja, qntFuncionarios, salarioBaseFuncionarios, enderecoLoja,
                                        dataFundacao, qntMaximaProdutos);

                                if(shopping.insereLoja(lojaVestuario))
                                    System.out.println("Loja inserida com sucesso");
                                else
                                    System.out.println("Erro ao inserir a loja. Capacidade máxima atingida.");

                                System.out.println("\nO tamanho da loja é: " + lojaVestuario.tamanhoDaLoja());
                                break;

                        }
                        break;

                    }
                    break;


                //REMOVE UMA LOJA DE DENTRO DE UM SHOPPING
                case 3:

                    if (shopping == null){
                        System.out.println("Nenhum shopping criado");
                        break;
                    }
                    String nomeLojaRemover = Teclado.leString("Digite o nome da loja a ser removida: ");
                    if(shopping.removeLoja(nomeLojaRemover)) {
                        System.out.println("Loja removida com sucesso");
                    } else {
                        System.out.println("Erro ao remover a loja. Loja não encontrada.");
                    }
                    break;

                //LISTAR LOJAS DE UM SHOPPING
                case 4:
                    if (shopping == null) {
                        System.out.println("Nenhum shopping criado.");
                        break;
                    }
                    for (Loja lojaLista : shopping.getLojas()) {
                        if (lojaLista != null) {
                            System.out.println(loja.getNome()+ "| ");
                        }
                    }
                    break;


                //CRIA UM PRODUTO E INSERE NO ESTOQUE GERAL DO SHOPPING
                case 5:
                    if (shopping == null) {
                        System.out.println("Nenhum shopping criado.");
                        break;
                    }
                    String nomeProduto = Teclado.leString("Digite o nome do Produto: ");
                    int precoProduto = Teclado.leInt("Digite o preço do produto");

                    System.out.println("Informe dia, mês e ano de validade do produto (dd mm aaaa)");
                    int dia = Teclado.leInt();
                    int mes = Teclado.leInt();
                    int ano = Teclado.leInt();
                    Data dataValidade = new Data(dia, mes, ano);

                    //Cria uma instância de produto
                    produto = new Produto(nomeProduto, precoProduto, dataValidade);


                    //Verifica se o produto está vencido na data de 20/10/2023 (OK)
                    Data dataReferencia = new Data(20, 10, 2023);
                    if (produto.estaVencido(dataReferencia)) {
                        System.out.println("\nPRODUTO VENCIDO");
                    } else {
                        System.out.println("\nPRODUTO NÃO VENCIDO");
                    }

                    if (shopping.insereProdutoEstoque(produto)) {
                        System.out.println("Produto inserido no estoque geral com sucesso!");
                    } else {
                        System.out.println("Erro ao inserir o produto. Estoque geral cheio.");
                    }
                    break;


                //INSERE UM PRODUTO EM UMA LOJA
                case 6:
                    String nomeShoppingInsereProduto = Teclado.leString("Digite o nome do shopping na qual a loja está inserida: ");
                    String nomeLojaParaInserirProduto = Teclado.leString("Digite o nome da loja em que quer adicionar um produto: ");
                    String nomeProdutoInserirLoja = Teclado.leString("Digite o nome do produto que quer inserir: ");

                    Produto produtoParaInserir = null;

                    if(shopping != null && shopping.getEstoqueGeralProdutos() != null)
                        // Buscar produto pelo nome em um array de produtos previamente criado
                        for (Produto buscaProdRemover : shopping.getEstoqueGeralProdutos()) {
                            if (buscaProdRemover != null && buscaProdRemover.getNome().equalsIgnoreCase(nomeProdutoInserirLoja)) {
                                produtoParaInserir = buscaProdRemover;
                                break;
                            }
                        }

                    if (produtoParaInserir == null) {
                        System.out.println("Produto não encontrado no estoque geral.");
                        break;
                    }

                    if(shopping.getNome().equalsIgnoreCase(nomeShoppingInsereProduto)){
                        for(int j = 0; j < shopping.getLojas().length; j++)
                            if(shopping.getLojas()[j] != null && shopping.getLojas()[j].getNome().equalsIgnoreCase(nomeLojaParaInserirProduto))
                                if(shopping.getLojas()[j].insereProduto(produtoParaInserir)) {
                                    System.out.println("Produto inserido com sucesso no estoque da loja " + nomeLojaParaInserirProduto);
                                    shopping.removeProdutoEstoque(nomeProdutoInserirLoja);
                                } else
                                    System.out.println("Não foi possível inserir o produto na loja. Estoque Cheio!");
                    }
                    break;


                //REMOVE UM PRODUTO DE UMA LOJA
                case 7:

                    String nomeShoppingRemoveProduto = Teclado.leString("Digite o nome do shopping na qual a loja está inserida: ");
                    String nomeLojaParaRemoverProduto = Teclado.leString("Digite o nome da loja em que quer remover um produto: ");
                    String nomeProdutoRemoverLoja = Teclado.leString("Digite o nome do produto que quer remover: ");


                    if(shopping != null && shopping.getLojas() != null){ //Verifica se há um shopping e há, pelo menos, uma loja no seu array de lojas
                        if(shopping.getNome().equalsIgnoreCase(nomeShoppingRemoveProduto)){ //Verifica se há um shopping com o nome almejado
                            boolean produtoRemovido = false;

                            //Percorre as lojas do shopping
                            for (Loja buscaLojaRemover : shopping.getLojas()) { //Acessa o objeto de escopo local buscaLojaRemover em cada índice do array lojas (do shopping)
                                //Varrer as lojas do shopping procurando por seu nome
                                if (buscaLojaRemover != null && buscaLojaRemover.getNome().equalsIgnoreCase(nomeLojaParaRemoverProduto))
                                    if (buscaLojaRemover.removeProduto(nomeProdutoRemoverLoja)) {
                                        System.out.println("Produto removido com sucesso da loja.");
                                        produtoRemovido = true;
                                    } else
                                        System.out.println("Produto não encontrado na loja");
                                break; //assumindo que não há lojas com nome duplicado
                            }
                            if(!produtoRemovido)
                                System.out.println("Loja não encontrada.");


                        } else
                            System.out.println("Shopping não encontrado.");


                    } else
                        System.out.println("Shopping não inicializado corretamente ou sem lojas cadastradas no shopping.");
                    break;

                //Listar todos os Produtos do estoque geral de um Shopping
                //
                case 8:

                    String nomeLojaImprimir = Teclado.leString("Digite o nome da loja para a qual quer listar seus produtos: ");
                    boolean lojaEncontrada = false;

                    if (shopping != null && shopping.getLojas() != null){
                        for (Loja buscarLojaImprimir : shopping.getLojas()) {
                            if (buscarLojaImprimir != null && buscarLojaImprimir.getNome().equalsIgnoreCase(nomeLojaImprimir)) {
                                buscarLojaImprimir.imprimeProdutos();
                                lojaEncontrada = true;
                                break; // Parar a busca assim que encontrar a loja
                            }
                        }
                        if (!lojaEncontrada)
                            System.out.println("Loja não encontradda.");

                    } else
                        System.out.println("Shopping não inicializado corretamente ou sem lojas cadastradas.");
                    break;


                //LISTA TODOS OS PRODUTOS DE UMA LOJA DE UM SHOPPING
                case 9:

                    if (shopping == null) {
                        System.out.println("Nenhum shopping criado.");
                        break;
                    }
                    String nomeLojaParaListarProdutos = Teclado.leString("Digite o nome da loja da qual quer listar todos os produtos: ");
                    Loja lojaParaListarProdutos = null;
                    for (Loja lojaShopping : shopping.getLojas()) {
                        if (lojaShopping != null && lojaShopping.getNome().equalsIgnoreCase(nomeLojaParaListarProdutos)) {
                            lojaParaListarProdutos = lojaShopping;
                            break;
                        }
                    }
                    if (lojaParaListarProdutos == null) {
                        System.out.println("Loja não encontrada.");
                        break;
                    }
                    for (Produto produtoListar : lojaParaListarProdutos.getEstoqueProdutos()) {
                        if (produtoListar != null) {
                            System.out.println(produtoListar);
                        }
                    }
                    break;

                //IMPRIME RELATÓRIO DO SHOPPING
                case 10:

                    /**




                     **/

                //SAI DO PROGRAMA
                case 11:
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
            for (int num = 0; i < shopping.getLojas().length; num++) {
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


