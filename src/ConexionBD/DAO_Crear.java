package ConexionBD;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import Modelo.Fachada;

public class DAO_Crear {
	private Connection conex ;
	public DAO_Crear(Connection conn) {
		this.conex = conn;
	}
	
	@SuppressWarnings("null")
	public String ObtenerFachada() {
		String nombre="Ninguno";
		ResultSet resultSet = null;

		try {
			Statement GetFachada = conex.createStatement();
			 resultSet = GetFachada.executeQuery("SELECT top 1 nombre FROM TIENDA WHERE id !=0");
			
            while (resultSet.next()) {
                 nombre =  resultSet.getString(1);
            }

		} catch (SQLException e) {

			JOptionPane.showMessageDialog(null, e.getMessage());
		} catch (NullPointerException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		return nombre;
	}

	/*public String ObtenerUsers() {ww
		String nombre="Ninguno";
		ResultSet resultSet = null;

		try {
			Statement GetFachada = conex.createStatement();
			 resultSet = GetFachada.executeQuery("SELECT top 1 nombre FROM TIENDA WHERE id !=0");
			
            while (resultSet.next()) {
                 nombre =  resultSet.getString(1);
            }

		} catch (SQLException e) {

			JOptionPane.showMessageDialog(null, e.getMessage());
		} catch (NullPointerException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		return nombre;
	}*/
	/*
	public void crearMedicoDAO(Medicos medico) {
		Conexion conex = new Conexion();
		try {
			Statement estatuto = conex.getConnection().createStatement();
			estatuto.executeUpdate(
			"INSERT INTO medicos (IdentificacionMedico, NombreCentroMedico, NombreMedico, ApellidoMedico,"
			+ "TelefonoMedico) VALUES ('"
			+ medico.getIdentificacion() + "' , '" 
			+ a.getNombreCentroMedico() + "' , '"
			+ medico.getNombreMedico() + "' , '" 
			+ medico.getApellidoMedico() + "' , '" 
			+ medico.getTelefonoMedico() + "')");
			estatuto.close();
			conex.desconectar();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void crearEspecialidadDAO(Especialidad especialidad,Medicos medico) {
		Conexion conex = new Conexion();
		try {
			Statement estatuto = conex.getConnection().createStatement();
			estatuto.executeUpdate(
			"INSERT INTO especialidad (NombreEspecialidad, IdentificacionMedico) VALUES ('"
			+ especialidad.getNombreEspecialidad() + "' , '" 
			+ medico.getIdentificacion()+ "')");
			estatuto.close();
			conex.desconectar();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void crearDisponibilidadDAO(Disponibilidad dispo, Medicos medico) {
		Conexion conex = new Conexion();
		try {
			Statement estatuto = conex.getConnection().createStatement();
			estatuto.executeUpdate(
			"INSERT INTO disponibilidad (FechaDisponibilidad, IdentificacionMedico, HoraInicio, HoraFin) VALUES ('"
			+ dispo.getFecha()+ "' , '" 
			+ medico.getIdentificacion()+ "' , '" 
			+ dispo.getHora_inicio()+ "' , '"
			+ dispo.getHora_fin() + "')");
			estatuto.close();
			conex.desconectar();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public void crearServicioDAO(Servicios servicio) {
		Conexion conex = new Conexion();
		try {
			Statement estatuto = conex.getConnection().createStatement();
			estatuto.executeUpdate(
			"INSERT INTO servicios (NombreServicio, NombreCentroMedico, DescripcionServicio, ComplejidadServicio, "
			+ "DuracionServicio, CostoServicio) VALUES ('"
			+ servicio.getNombreServicio() + "', '" 
			+ a.getNombreCentroMedico() + "' , '"
			+ servicio.getDescripcionServicio() + "', '" 
			+ servicio.getComplejidadServicio() + "', '" 
			+ servicio.getDuracionServicio() + "', '" 
			+ servicio.getCostoServicio() +  "')");			
			estatuto.close();
			conex.desconectar();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void crearEpsDAO(Eps eps) {
		Conexion conex = new Conexion();
		try {
			Statement estatuto = conex.getConnection().createStatement();
			estatuto.executeUpdate(
			"INSERT INTO eps (NombreEps, NombreCentroMedico, MunicipioEps, DireccionEps,"
			+ "TelefonoEps) VALUES ('"
			+ eps.getNombreEps() + "' , '" 
			+ a.getNombreCentroMedico() + "' , '"
			+ eps.getMunicipioEps() + "' , '" 
			+ eps.getDireccionEps() + "' , '" 
			+ eps.getTelefonoEps() + "')");
			estatuto.close();
			conex.desconectar();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void crearClienteDAO(Cliente cliente) {
		Conexion conex = new Conexion();
		try {
			Statement estatuto = conex.getConnection().createStatement();
			estatuto.executeUpdate(
			"INSERT INTO clientes (IdentificacionCliente, NombreCentroMedico, NombreCliente, ApellidoCliente,"
			+ "EdadCliente, TelefonoCliente, CitaMedico, CitaServicio, FechaCita, HoraInicioCita, HoraFinCita,"
			+ "PrecioCita) VALUES ('"
			+ cliente.getIdentificacionCliente() + "' , '" 
			+ a.getNombreCentroMedico() + "' , '"
			+ cliente.getNombreCliente() + "' , '" 
			+ cliente.getApellidoCliente() + "' , '" 
			+ cliente.getEdadCliente() + "' , '" 
			+ cliente.getTelefonoCliente() + "' , '" 
			+ cliente.getCitaMedico() + "' , '" 
			+ cliente.getCitaServicio() + "' , '" 
			+ cliente.getFechaCita() + "' , '" 
			+ cliente.getHoraInicioCita() + "' , '" 
			+ cliente.getHoraFinCita() + "' , '" 
			+ cliente.getPrecioCita() + "')");
			estatuto.close();
			conex.desconectar();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}*/
}
