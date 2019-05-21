package Modelo;

import java.util.List;

public class Factura {
private String nombre;
private String telefono;
private String id;
private String IdUsuario;
private List<Compra> Productos;
private int totalCompra;




public Factura() {
	super();
}
public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public String getTelefono() {
	return telefono;
}
public void setTelefono(String telefono) {
	this.telefono = telefono;
}
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getIdUsuario() {
	return IdUsuario;
}
public void setIdUsuario(String idUsuario) {
	IdUsuario = idUsuario;
}
public List<Compra> getProductos() {
	return Productos;
}
public void setProductos(List<Compra> productos) {
	Productos = productos;
}
public int getTotalCompra() {
	return totalCompra;
}
public void setTotalCompra(int totalCompra) {
	this.totalCompra = totalCompra;
}


}
