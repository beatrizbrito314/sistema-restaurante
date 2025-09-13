package sistema_restaurante;
import java.util.ArrayList;
import java.util.Scanner;
public class Main {
	
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		ArrayList<Pedido> listaPedidos=new ArrayList<>();
		while(true) {
			System.out.println("Deseja registrar um pedido? s/n");
			char validarPedido= sc.next().charAt(0);
			if(validarPedido=='s' || validarPedido=='S') 
			{
				Pedido pedido=new Pedido();
				System.out.println("Informe o nome do cliente:");
				pedido.setNomeCliente(sc.next());
				//cadastrar item
				Item item=new Item();
				System.out.println("Informe o nome do item:");
				item.setNome(sc.next());
				System.out.println("Informe o preço do item:");
				item.setPreco(sc.nextDouble());
				pedido.adicionarItem(item);
				System.out.println("O item " + item.getNome() + " foi adiciona à lista");
				
				//editar a lista
				for (Item i : pedido.getListaItens()) {
				    System.out.println(i.getNome() + "- R$" + i.getPreco() );
				}
					System.out.println("Deseja adicionar um novo item a lista? s/n");
					char addItem= sc.next().charAt(0);
					if(addItem=='s' || addItem=='S') {
						while(true) {
							Item item2 = new Item();
							System.out.println("Informe o nome do item:");
							item2.setNome(sc.next());
							System.out.println("Informe o preço do item:");
							item2.setPreco(sc.nextDouble());
							pedido.adicionarItem(item2);
							System.out.println("Deseja adicionar um novo item a lista? s/n");
							addItem=sc.next().charAt(0);;
							if(addItem=='n' || addItem=='N') {
								break;
							}
						}
						
						
					}
					//arrumar a comparacao
					System.out.println("Deseja remover um item da lista? s/n");
					char rmvItem = sc.next().charAt(0);

					if (rmvItem == 's' || rmvItem == 'S') {
					    while (true) {
					        System.out.println("Itens atuais do pedido:");
					        for (Item i : pedido.getListaItens()) {
					            System.out.println("ID: " + i.getIdItem() + " Nome: " + i.getNome() + " - R$ " + i.getPreco());
					        }

					        System.out.println("Informe o ID do item que deseja remover:");
					        int idItem = sc.nextInt();

					        Item itemParaRemover = null;
					        for (Item i : pedido.getListaItens()) {
					            if (idItem == i.getIdItem()) {
					                itemParaRemover = i;
					                break;
					            }
					        }

					        if (itemParaRemover != null) {
					            pedido.removerItem(itemParaRemover);
					            System.out.println("Item removido com sucesso!");
					        } else {
					            System.out.println("Item não encontrado.");
					        }

					        System.out.println("Deseja remover outro item da lista? s/n");
					        rmvItem = sc.next().charAt(0);
					        if (rmvItem == 'n' || rmvItem == 'N') {
					            break;
					        }
					    }
					   
					}
					 listaPedidos.add(pedido);
			}else if(validarPedido=='n' || validarPedido=='N') {
				break;
			}else {
				System.out.println("Por favor, informe uma entrada válida!");
			}
			}
				Saida_Relatorio relatorio=new Saida_Relatorio();
			for(Pedido pedido: listaPedidos) {
				 relatorio.exibirRelatorio(pedido);
				
			}
		}
	
	}


