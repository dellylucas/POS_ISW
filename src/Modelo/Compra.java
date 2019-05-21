package Modelo;

public class Compra {
	private Producto producto;
	private String cantidad;
	private String ValorTotal;
	
	public Compra(Producto producto, String cantidad, String valorTotal) {
		super();
		this.producto = producto;
		this.cantidad = cantidad;
		ValorTotal = valorTotal;
	}
	public Producto getProducto() {
		return producto;
	}
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	public String getCantidad() {
		return cantidad;
	}
	public void setCantidad(String cantidad) {
		this.cantidad = cantidad;
	}
	public String getValorTotal() {
		return ValorTotal;
	}
	public void setValorTotal(String valorTotal) {
		ValorTotal = valorTotal;
	}
	
}
