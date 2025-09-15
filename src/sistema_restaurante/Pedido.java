package sistema_restaurante;
import java.util.ArrayList;

public class Pedido {	
	private static int count=1;
	public Pedido() {
		super();
		this.idPedido = count++;
	}

	private int idPedido;
	private String nomeCliente;
	private ArrayList<Item> listaItens = new ArrayList<>();
	
	public int getIdPedido() {
		return idPedido;
	}
	public String getNomeCliente() {
		return nomeCliente;
	}
	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}
	public ArrayList<Item> getListaItens() {
		return listaItens;
	}
	public void setListaItens(ArrayList<Item> listaItens) {
		this.listaItens = listaItens;
	}
	public void adicionarItem(Item item) {
	    listaItens.add(item);
	}
	public Double totalPreco(ArrayList<Item> listaItens) {
		Double total=0.0;
		for (Item i:listaItens ) {
			total+=i.getPreco();
		}
		return total;
	}
	
	

}
