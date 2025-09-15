package sistema_restaurante;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Saida_Relatorio relatorio = new Saida_Relatorio();
        Scanner sc = new Scanner(System.in);
        ArrayList<Pedido> listaPedidos = new ArrayList<>();
        ArrayList<Item> listaItens = new ArrayList<>();

        while (true) {
            System.out.println("=======Qual operação deseja realizar?=======");
            System.out.println("(0) Adicionar pedido");
            System.out.println("(1) Remover pedido");
            System.out.println("(2) Visualizar relatório de pedidos");
            System.out.println("(3) Sair");
            System.out.println("============================================");

            int validarPedido = sc.nextInt();
            sc.nextLine();
            
            switch (validarPedido) {

                case 0: // ADICIONAR PEDIDO
                    Pedido pedido = new Pedido();

                    System.out.println("Informe o nome do cliente:");
                    String nome = sc.nextLine();
                    pedido.setNomeCliente(nome);

                    while (true) {
                        System.out.println("Deseja adicionar um item? (s/n)");
                        char validarItem = sc.next().charAt(0);
                        sc.nextLine(); 

                        if (validarItem == 's') {
                            Item item = new Item();

                            System.out.println("Informe o nome do item:");
                            String nomeItem = sc.nextLine();
                            item.setNome(nomeItem);

                            System.out.println("Informe o valor do item:");
                            double preco = sc.nextDouble();
                            sc.nextLine(); 
                            item.setPreco(preco);

                            pedido.adicionarItem(item);

                        } else if (validarItem == 'n') {
                            System.out.println("Itens cadastrados:");
                            for (Item i : pedido.getListaItens()) {
                                System.out.println(" Item: " + i.getNome() + " - R$ " + i.getPreco());
                            }
                            break;
                        } else {
                            System.out.println("Entrada inválida, digite 's' ou 'n'.");
                        }
                    }

                    listaPedidos.add(pedido);
                    System.out.println("Pedido adicionado!");
                    break;

                case 1: // EXCLUIR PEDIDO
                    System.out.println("Pedidos cadastrados:");
                    for (Pedido p : listaPedidos) {
                        System.out.println("N°: " + p.getIdPedido() +" Nome: " + p.getNomeCliente());
                    }

                    System.out.println("Informe o ID do pedido que você deseja excluir:");
                    int idExcluir = sc.nextInt();

                    Pedido pedidoRMV = null;
                    for (Pedido p : listaPedidos) {
                        if (idExcluir == p.getIdPedido()) {
                            pedidoRMV = p;
                            break; 
                    }
                    }

                    if (pedidoRMV != null) {
                        listaPedidos.remove(pedidoRMV);
                        System.out.println("Pedido removido com sucesso!");
                    } else {
                        System.out.println("Pedido não encontrado.");
                    }
                    break;

                case 2: // VISUALIZAR RELATÓRIO
                    for (Pedido p : listaPedidos) {
                        relatorio.exibirRelatorio(p);
                    }
                    
                    break;

                case 3: // SAIR
                    System.out.println("Encerrando o sistema...");
                    sc.close();
                    return;

                default:
                    System.out.println("Opção inválida!");
            }
        }
    }
}
