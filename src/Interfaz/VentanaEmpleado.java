package Interfaz;

import ConexionBD.DAO_Consultar;
import Modelo.Empleado;
import Modelo.Fachada;
import Modelo.Producto;
import Modelo.Proveedor;
import Modelo.Tienda;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaEmpleado extends JFrame implements ActionListener{
	private JMenuBar menu;
	private JMenu producto;
	private JMenu proveedores;
	private JMenu empleados;
	private JMenu contratos;
	private JMenu salir;
	private JMenuItem crearProducto;
	private JMenuItem consultarProducto;
	private JMenuItem modificarProducto;
	private JMenuItem eliminarProducto;

	private DAO_Consultar daoConsulta;
	private JMenuItem crearEmpleado;
	private JMenuItem consultarEmpleado;
	private JMenuItem modificarEmpleado;
	private JMenuItem eliminarEmpleado;

	private JMenuItem cerrarSesion;
	private JLabel label;
	private Tienda tienda = Fachada.getTienda();
	private JMenuItem CrearProveedor;
	private JMenuItem ConsultarProveedor;
	private JMenuItem EliminarProveedor;
	private JMenuItem modificarProveedor;

	public VentanaEmpleado(){
		super();

		this.setTitle("SuperMercado ALL RETAILER(Ventana Admin)");
		this.setSize(500, 400);
		this.setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.crearFondo();
		this.crearMenu();
		daoConsulta = new DAO_Consultar();
		tienda.setLstProductos(daoConsulta.Productos());
		tienda.setLstSEmpleados(daoConsulta.Empleados());
	}
	private void crearFondo() {
		label = new JLabel();
		label.setIcon(new ImageIcon(
				(ClassLoader.getSystemResource("Imagenes/ImagenVentanaAdministrador.jpg"))));
		label.setBounds(0, 0, 494, 350);
		getContentPane().add(label);
	}
	private void crearMenu() {
		menu = new JMenuBar();
		setJMenuBar(menu);

		producto = new JMenu("Inventario");
		menu.add(producto);

		contratos = new JMenu("Compras");
		menu.add(contratos);

		salir = new JMenu("Salir");
		salir.addActionListener(this);
		menu.add(salir);

		consultarProducto = new JMenuItem("Consultar Producto");
		consultarProducto.setIcon(new ImageIcon(
				(ClassLoader.getSystemResource("Imagenes/Consultar.png"))));
		consultarProducto.addActionListener(this);
		producto.add(consultarProducto);

}
	public void actionPerformed(ActionEvent e) {


		if(e.getSource()==consultarProducto){
			if(tienda.getLstProductos().isEmpty()){
				JOptionPane.showMessageDialog(null, "No Hay Ningun Producto Registrado");
			}else{
				ConsultarProductos ventana = new ConsultarProductos(3);
				ventana.setVisible(true);
				setVisible(false);
			}
		}


		if(e.getSource()==salir){
			VentanaPrincipal ventana = new VentanaPrincipal(Fachada.getTienda());
			ventana.setVisible(true);
			setVisible(false);
		}
	}
}
