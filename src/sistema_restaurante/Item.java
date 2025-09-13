package sistema_restaurante;

public class Item {
	private static int count=1;
	public Item() {
		super();
		this.idItem = count++;
	}
	
	
	private int idItem;
	private String nome;
	private Double preco;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Double getPreco() {
		return preco;
	}
	public void setPreco(Double preco) {
		this.preco = preco;
	}
	public int getIdItem() {
		return idItem;
	}
	
}
