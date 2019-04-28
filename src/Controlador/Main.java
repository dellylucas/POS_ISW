package Controlador;

import javax.swing.JOptionPane;

import ConexionBD.Conexion;
import ConexionBD.DAO_Consultar;
import Interfaz.VentanaPrincipal;
import Modelo.Fachada;
import ConexionBD.DAO_Crear;

	public class Main {
		
		public static void main(String[] args) {
			String nombreTienda;
			Conexion conex = new Conexion();
			DAO_Consultar dao = new DAO_Consultar(conex.getConnection());
			nombreTienda=dao.ObtenerFachada();
			Fachada.getInstance().setNombre(nombreTienda);
			VentanaPrincipal login = new VentanaPrincipal(Fachada.tienda);
			login.setVisible(true);

		}
	}