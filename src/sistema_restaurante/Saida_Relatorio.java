package sistema_restaurante;

public class Saida_Relatorio {
	public void exibirRelatorio(Pedido pedido) {
		System.out.println("=========================================================");
		System.out.println("\n			Restaurante			");
		System.out.println("\n Pedido N°:"+ pedido.getIdPedido());
		System.out.println("\n Nome do cliente:"+ pedido.getNomeCliente());
		System.out.println("\n Itens:");
		for (Item i : pedido.getListaItens()) {
            System.out.println(" \n ID: " + i.getIdItem() + " Nome: " + i.getNome() + " - R$ " + i.getPreco());
        }
		System.out.println("---------------------------------------------------------");
		System.out.println("\n Total $:"+ pedido.totalPreco(pedido.getListaItens()));
		System.out.println("=========================================================");
	}
}
