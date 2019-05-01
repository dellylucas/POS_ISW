package Interfaz;


import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import ConexionBD.DAO_Consultar;
import Modelo.Empleado;
import Modelo.Fachada;
import Modelo.Producto;
import Modelo.Proveedor;
import Modelo.Tienda;


public class VentanaAdministrador extends JFrame implements ActionListener{
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
	
	public VentanaAdministrador(){
		super();
		this.setTitle("SuperMercado ALL RETAILER(Ventana Admin)");
		this.setSize(500, 400);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
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
		
		proveedores = new JMenu("Proveedores");
		menu.add(proveedores);
		

		CrearProveedor = new JMenuItem("Crear ");
		CrearProveedor.setIcon(new ImageIcon(
		(ClassLoader.getSystemResource("Imagenes/Crear.png"))));
		CrearProveedor.addActionListener(this);
		proveedores.add(CrearProveedor);
		
		ConsultarProveedor = new JMenuItem("Consultar ");
		ConsultarProveedor.setIcon(new ImageIcon(
		(ClassLoader.getSystemResource("Imagenes/Consultar.png"))));
		ConsultarProveedor.addActionListener(this);
		proveedores.add(ConsultarProveedor);
		
		modificarProveedor = new JMenuItem("Modificar ");
		modificarProveedor.setIcon(new ImageIcon(
		(ClassLoader.getSystemResource("Imagenes/Modificar.png"))));
		modificarProveedor.addActionListener(this);
		proveedores.add(modificarProveedor);
		
		EliminarProveedor = new JMenuItem("Eliminar ");
		EliminarProveedor.setIcon(new ImageIcon(
		(ClassLoader.getSystemResource("Imagenes/Borrar.png"))));
		EliminarProveedor.addActionListener(this);
		proveedores.add(EliminarProveedor);
		
		empleados = new JMenu("Empleados");
		menu.add(empleados);
		
		contratos = new JMenu("Compras");
		menu.add(contratos);
		
		salir = new JMenu("Salir");
		salir.addActionListener(this);
		menu.add(salir);
		
		crearProducto = new JMenuItem("Crear Producto");
		crearProducto.setIcon(new ImageIcon(
		(ClassLoader.getSystemResource("Imagenes/Crear.png"))));
		crearProducto.addActionListener(this);
		producto.add(crearProducto);
		
		consultarProducto = new JMenuItem("Consultar Producto");
		consultarProducto.setIcon(new ImageIcon(
		(ClassLoader.getSystemResource("Imagenes/Consultar.png"))));
		consultarProducto.addActionListener(this);
		producto.add(consultarProducto);
		
		modificarProducto = new JMenuItem("Modificar Producto");
		modificarProducto.setIcon(new ImageIcon(
		(ClassLoader.getSystemResource("Imagenes/Modificar.png"))));
		modificarProducto.addActionListener(this);
		producto.add(modificarProducto);
		
		eliminarProducto = new JMenuItem("Eliminar Productos");
		eliminarProducto.setIcon(new ImageIcon(
		(ClassLoader.getSystemResource("Imagenes/Borrar.png"))));
		eliminarProducto.addActionListener(this);
		producto.add(eliminarProducto);

		
		crearEmpleado = new JMenuItem("Crear");
		crearEmpleado.setIcon(new ImageIcon(
		(ClassLoader.getSystemResource("Imagenes/Crear.png"))));
		crearEmpleado.addActionListener(this);
		empleados.add(crearEmpleado);
		
		consultarEmpleado = new JMenuItem("Consultar");
		consultarEmpleado.setIcon(new ImageIcon(
		(ClassLoader.getSystemResource("Imagenes/Consultar.png"))));
		consultarEmpleado.addActionListener(this);
		empleados.add(consultarEmpleado);
		
		modificarEmpleado = new JMenuItem("Modificar");
		modificarEmpleado.setIcon(new ImageIcon(
		(ClassLoader.getSystemResource("Imagenes/Modificar.png"))));
		modificarEmpleado.addActionListener(this);
		empleados.add(modificarEmpleado);
		
		eliminarEmpleado= new JMenuItem("Eliminar");
		eliminarEmpleado.setIcon(new ImageIcon(
		(ClassLoader.getSystemResource("Imagenes/Borrar.png"))));
		eliminarEmpleado.addActionListener(this);
		empleados.add(eliminarEmpleado);
		
	}


	public void actionPerformed(ActionEvent e) {
	Producto productos = new Producto();
	Proveedor proveedor = new Proveedor();
	
	
	if(e.getSource()==CrearProveedor){
		CrearProveedores ventana = new CrearProveedores(proveedor);
		ventana.setVisible(true);
		setVisible(false);
	}
	
	if(e.getSource()==crearEmpleado){
		CrearEmpleado ventana = new CrearEmpleado();
		ventana.setVisible(true);
		setVisible(false);
	}

    if(e.getSource()==crearProducto){
			CrearProducto ventana = new CrearProducto(productos);
			ventana.setVisible(true);
			setVisible(false);
		}
		
		if(e.getSource()==consultarProducto){
			if(tienda.getLstProductos().isEmpty()){
				JOptionPane.showMessageDialog(null, "No Hay Ningun Producto Registrado");
			}else{
				ConsultarProductos ventana = new ConsultarProductos(2);
				ventana.setVisible(true);
				setVisible(false);
			}
		}
		
		if(e.getSource()==modificarProducto){
			if(tienda.getLstProductos().isEmpty()){
				JOptionPane.showMessageDialog(null, "No Hay Ningun Producto Registrado");
			}else{
				ModificarProducto ventana = new ModificarProducto();
				ventana.setVisible(true);
				setVisible(false);
			}
		}
		
		if(e.getSource()==eliminarProducto){
			if(tienda.getLstProductos().isEmpty()){
				JOptionPane.showMessageDialog(null, "No Hay Ningun Producto Registrado");
			}else{
				EliminarProducto ventana = new EliminarProducto();
				ventana.setVisible(true);
				setVisible(false);
			}
		}

						
						if(e.getSource()==ConsultarProveedor){
							if(tienda.getLstProveedor().isEmpty()){
								JOptionPane.showMessageDialog(null, "No Hay Ningun Proveedor Registrado");
							}else{
								ConsultarProveedor ventana = new ConsultarProveedor();
								ventana.setVisible(true);
								setVisible(false);
							}
						}
						
						if(e.getSource()==modificarProveedor){
							if(tienda.getLstProveedor().isEmpty()){
								JOptionPane.showMessageDialog(null, "No Hay Ningun Proveedor Registrado");
							}else{
								ModificarProveedor ventana = new ModificarProveedor();
								ventana.setVisible(true);
								setVisible(false);
							}
						}
						
						if(e.getSource()==EliminarProveedor){
							if(tienda.getLstProveedor().isEmpty()){
								JOptionPane.showMessageDialog(null, "No Hay Ningun Proveedor Registrado");
							}else{
								EliminarProveedor ventana = new EliminarProveedor();
								ventana.setVisible(true);
								setVisible(false);
							}
						}
						
					if(e.getSource()==consultarEmpleado){
							if(tienda.getLstSEmpleados().isEmpty()){
								JOptionPane.showMessageDialog(null, "No Hay Ningun Empleado Registrado");
							}else{
								ConsultarEmpleado ventana = new ConsultarEmpleado();
								ventana.setVisible(true);
								setVisible(false);
							}
						}
						
						if(e.getSource()==modificarEmpleado){
							if(tienda.getLstSEmpleados().isEmpty()){
								JOptionPane.showMessageDialog(null, "No Hay Ningun Empleado Registrado");
							}else{
								ModificarEmpleado ventana = new ModificarEmpleado();
								ventana.setVisible(true);
								setVisible(false);
							}
						}
						
						
						if(e.getSource()==eliminarEmpleado){
							if(tienda.getLstSEmpleados().isEmpty()){
								JOptionPane.showMessageDialog(null, "No Hay Ningun Proveedor Registrado");
							}else{
								EliminarEmpleado ventana = new EliminarEmpleado();
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
			
			
		
//	proveedores.addActionListener(new ActionListener() {
//		public void actionPerformed(ActionEvent e) {
//			
//		}
//	


