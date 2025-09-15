package sistema_restaurante;

public class Saida_Relatorio {
	public void exibirRelatorio(Pedido pedido) {
		System.out.println("=========================================================");
		System.out.println("			Vanille Café		");
		System.out.println("Pedido N°:"+ pedido.getIdPedido());
		System.out.println("Nome do cliente:"+ pedido.getNomeCliente());
		System.out.println("Itens:");
		for (Item i : pedido.getListaItens()) {
            System.out.println("Item: " + i.getNome() + " - R$ " + i.getPreco());
        }
		System.out.println("\n________________________________________________________");
		System.out.println("Total $:"+ pedido.totalPreco(pedido.getListaItens()));
		System.out.println("=========================================================");
	}
}
