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
            System.out.println("|----------------------------------------------------------|");
            System.out.println("|-------------------------------MENU-----------------------|");
            System.out.println("|----------------------------------------------------------|");
            System.out.println("|          (1) CRIAR UM SHOPPING                           |");
            System.out.println("|          (2) CRIAR UMA LOJA                              |");
            System.out.println("|             (3) Inserir uma loja (em um shopping)        |");
            System.out.println("|             (4) Remover uma loja (de um shopping)        |");
            System.out.println("|             (5) Listar lojas de um shopping              |");
            System.out.println("|          (6) CRIAR UM PRODUTO                            |");
            System.out.println("|             (7) Inserir um produto (em uma loja)         |");
            System.out.println("|             (8) remover um produto (de uma loja)         |");
            System.out.println("|             (9) Listar produtos de uma loja              |");
            System.out.println("|          (10) IMPRIMIR RELATORIO                         |");
            System.out.println("|          (11) SAIR                                       |");
            System.out.println("|__________________________________________________________|");
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

                //CRIA UMA LOJA
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

                //INSERE UMA LOJA DENTRO DE UM SHOPPING
                case 3:

                    String nomeShoppingInserirLoja = Teclado.leString("Digite o nome do shopping no qual quer inserir uma loja: ");
                    String nomeLojaInserir = Teclado.leString("Digite o nome da loja que quer inserir no shopping " + nomeShoppingInserirLoja + ": ");

                    Loja lojaInserir = null;

                    //Atribui um objeto do tipo Loja para a variável lojaInserir if TRUE
                    if (shopping != null && shopping.getLojas() != null){ //garante que tem shopping inicializado e alguma loja no array lojas
                        // Buscar loja pelo nome em um array de lojas previamente criado
                        for (Loja buscaLoja : shopping.getLojas()){
                            if (buscaLoja != null && buscaLoja.getNome().equalsIgnoreCase(nomeLojaInserir)) {
                                lojaInserir = buscaLoja; //Se encontra o nome procurado, atribui o elemento buscaLoja ao objeto lojaInserir (para poder passar por parâmetro no insereLoja(lojaInserir)
                                break; //Sai do laço
                            }
                        }
                    }
                    if (lojaInserir == null)
                        System.out.println("Loja não encontrada");

                    if(shopping != null && shopping.getNome().equalsIgnoreCase(nomeShoppingInserirLoja)){
                        for(int j = 0; j < shopping.getLojas().length; j++)
                            if(shopping.getLojas()[j] != null && shopping.getLojas()[j].getNome().equalsIgnoreCase(nomeLojaInserir))
                                if(shopping.insereLoja(lojaInserir))
                                    System.out.println("Loja inserida com sucesso no Shopping " + nomeShoppingInserirLoja);
                                else
                                    System.out.println("Não foi possível inserir a loja no shopping. Não há mais espaço!");
                    }
                    break;


                //REMOVE UMA LOJA DE DENTRO DE UM SHOPPING
                case 4:

                    String nomeShoppingRemoveLoja = Teclado.leString("Digite o nome do shopping na qual a loja está inserida: ");
                    String nomeLojaParaRemover = Teclado.leString("Digite o nome da loja em que quer remover um produto: ");

                    if(shopping != null && shopping.getLojas() != null){ //Verifica se há um shopping e há, pelo menos, uma loja no seu array de lojas
                        if(shopping.getNome().equalsIgnoreCase(nomeShoppingRemoveLoja)){ //Verifica se há um shopping com o nome almejado
                            boolean lojaRemovida = false;

                            //Percorre as lojas do shopping
                            for (Loja buscaLojaRemoverShopping : shopping.getLojas()) { //Acessa o objeto de escopo local buscaLojaRemover em cada índice do array lojas (do shopping)
                                //Procura um objeto do tipo Loja no array getLojas(). Achando, verifica se o nome condiz
                                if (buscaLojaRemoverShopping != null && buscaLojaRemoverShopping.getNome().equalsIgnoreCase(nomeLojaParaRemover))
                                    if (shopping.removeLoja(nomeLojaParaRemover)) {
                                        System.out.println("Loja removida com sucesso do shopping " + nomeShoppingRemoveLoja + ".");
                                        lojaRemovida = true;
                                    } else
                                        System.out.println("Loja não encontrada no shopping " + nomeShoppingRemoveLoja + ".");
                                break; //assumindo que não há lojas com nome duplicado
                            }
                            if(!lojaRemovida)
                                System.out.println("Loja não encontrada.");


                        } else
                            System.out.println("Shopping não encontrado.");


                    } else
                        System.out.println("Shopping não inicializado corretamente ou sem lojas cadastradas no shopping.");
                    break;

                //LISTAR LOJAS DE UM SHOPPING
                case 5:
                    /**




                     **/


                //CRIA UM PRODUTO
                case 6:

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


                    //Insere produto criado no estoque geral de algum shopping
                    String nomeShoppingIncluirNoEstoque = Teclado.leString("Digite o nome do shopping para escoar esse produto para seu estoque geral");
                    if (shopping != null)
                        if(shopping.getNome().equalsIgnoreCase(nomeShoppingIncluirNoEstoque))
                            if(shopping.insereProdutoEstoque(produto))
                                System.out.println("Produto incluído no estoque geral do shopping " + nomeShoppingIncluirNoEstoque + " com sucesso!");
                            else
                                System.out.println("Erro! Estoque geral do shopping" + nomeShoppingIncluirNoEstoque + " lotado");

                    //Imprime informações do produto criado
                    System.out.println("Informações cadastradas no sistema!" +
                            "\nProduto: " + produto.getNome() + "\nPreço: R$ " + produto.getPreco() +
                            "\nData Validade:" + produto.getDataValidade());
                    break;


                //INSERE UM PRODUTO EM UMA LOJA
                case 7:
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
                case 8:

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


                //LISTAR PRODUTOS DE UMA LOJA
                case 9:

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


                //IMPRIMIR RELATORIO
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


