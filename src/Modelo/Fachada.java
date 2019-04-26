package Modelo;

public class Fachada {
	public static Tienda tienda;

	public static Tienda getInstance(String nombre) {
		if (tienda == null) {
			tienda = new Tienda();
			tienda.setNombre(nombre);
		}
		return tienda;
	}

	public Tienda getTienda() {
		return tienda;
	}

}
