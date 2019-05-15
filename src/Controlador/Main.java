package Controlador;

import ConexionBD.Conexion;
import ConexionBD.Dao_Fachada;
import Interfaz.VentanaPrincipal;
import Modelo.Fachada;

public class Main {
		
		public static void main(String[] args) {
			String nombreTienda;
			new Conexion();

			Dao_Fachada dao = new Dao_Fachada();
			nombreTienda=dao.Obtener();
			Fachada.getInstance().setNombre(nombreTienda);
			VentanaPrincipal login = new VentanaPrincipal(Fachada.tienda);
			login.setVisible(true);

		}
	}