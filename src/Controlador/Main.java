package Controlador;

import javax.swing.JOptionPane;

import ConexionBD.Conexion;
import Interfaz.VentanaPrincipal;
import Modelo.Fachada;
import ConexionBD.DAO_Crear;

	public class Main {
		
		public static void main(String[] args) {
			String nombreTienda;
			Conexion conex = new Conexion();
			DAO_Crear dao = new DAO_Crear(conex.getConnection());
			nombreTienda=dao.ObtenerFachada();
			Fachada.getInstance().setNombre(nombreTienda);
			VentanaPrincipal login = new VentanaPrincipal(Fachada.tienda);
			login.setVisible(true);

		}
	}