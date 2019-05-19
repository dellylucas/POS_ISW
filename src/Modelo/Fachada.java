package Modelo;

import ConexionBD.Dao_Fachada;

public class Fachada {
	public static Tienda tienda;

	public static Tienda getInstance(Persona persona) {
		if (tienda == null) {
			Dao_Fachada dao_fachada;
			tienda = new Tienda();
			dao_fachada = new Dao_Fachada();
			tienda = dao_fachada.Obtener(persona.getRol(), persona.getId());
		}
		return tienda;
	}

	public static Tienda getTienda() {
		return tienda;
	}


}
