package Modelo;

public class Compra {
	private Producto producto;
	private int cantidad;
	private int ValorTotal;
	private int TiendaId;
	
	public Compra(Producto producto, int cantidad, int valorTotal, int tienda) {
		super();
		this.producto = producto;
		this.cantidad = cantidad;
		this.ValorTotal = valorTotal;
		this.TiendaId = tienda;
	}
	public int getTiendaId() {
		return TiendaId;
	}
	public void setTiendaId(int tiendaId) {
		TiendaId = tiendaId;
	}
	public Producto getProducto() {
		return producto;
	}
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public int getValorTotal() {
		return ValorTotal;
	}
	public void setValorTotal(int valorTotal) {
		ValorTotal = valorTotal;
	}
	
}
