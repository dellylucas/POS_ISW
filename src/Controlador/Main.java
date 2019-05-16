package Controlador;

import ConexionBD.Conexion;
import ConexionBD.Dao_Fachada;
import Interfaz.VentanaPrincipal;
import Modelo.Fachada;

public class Main {
		
		public static void main(String[] args) {
			new Conexion();
			VentanaPrincipal login = new VentanaPrincipal();
			login.setVisible(true);
		}
	}