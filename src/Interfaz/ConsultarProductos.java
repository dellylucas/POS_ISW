package Interfaz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Modelo.Fachada;
import Modelo.Producto;
import Modelo.Tienda;

public class ConsultarProductos extends JFrame implements ActionListener{
	
	private JButton btnVolver;
	private JLabel idProducto;
	private JLabel nombreProducto;
	private JLabel precioIngreso;
	private JLabel cantidadProducto;
	private JLabel precioVenta;
	private JLabel fechaDeVencimineto;
	private JLabel fechaIngreso;
	private JTextField txtIdProducto;
	private JTextField txtNombreProducto;
	private JTextField txtCantidadProducto;
	private JTextField txtPrecioIngreso;
	private JTextField txtFechaIngreso;
	private JComboBox listaProductos;
	private JTextField txtPrecioVenta;
	private JTextField txtFechaVencimiento;
	private Producto producto = new Producto();
    private Tienda tienda = Fachada.getTienda();
	private int rolid;

	public ConsultarProductos(int rol){
		super();
		this.setTitle("Consultar Productos");
		this.setSize(460, 350);
		this.setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.crearEtiquetas();
		this.crearIngresoDatos();
		this.crearBotones();
		this.rolid=rol;
	}
	
	private void crearEtiquetas() {
		this.idProducto=new JLabel();
		this.idProducto.setText("ID");
		this.idProducto.setBounds(10, 43, 70, 35);
		getContentPane().add(idProducto);
		
		this.nombreProducto=new JLabel();
		this.nombreProducto.setText("Nombre");
		this.nombreProducto.setBounds(10, 73, 70, 35);
		getContentPane().add(nombreProducto);
		
		this.precioIngreso=new JLabel();
		this.precioIngreso.setText("Precio Ingreso");
		this.precioIngreso.setBounds(10, 130, 77, 40);
		getContentPane().add(precioIngreso);
		
		this.cantidadProducto=new JLabel();
		this.cantidadProducto.setText("Cantidad");
		this.cantidadProducto.setBounds(10, 105, 70, 30);
		getContentPane().add(cantidadProducto);
		
		this.precioVenta=new JLabel();
		this.precioVenta.setText("Precio Venta");
		this.precioVenta.setBounds(10, 163, 77, 35);
		getContentPane().add(precioVenta);
		
		this.fechaDeVencimineto=new JLabel();
		this.fechaDeVencimineto.setText("Fecha de Vencimiento");
		this.fechaDeVencimineto.setBounds(10, 195, 120, 30);
		getContentPane().add(fechaDeVencimineto);
		
		this.fechaIngreso=new JLabel();
		this.fechaIngreso.setText("Fecha Ingreso");
		this.fechaIngreso.setBounds(10, 223, 105, 35);
		getContentPane().add(fechaIngreso);
	}
	
	private void crearIngresoDatos() {
		this.txtIdProducto=new JTextField();
		this.txtIdProducto.setEditable(false);
		this.txtIdProducto.setBounds(90, 50, 180, 20);
		getContentPane().add(txtIdProducto);
		
		this.txtNombreProducto=new JTextField();
		this.txtNombreProducto.setEditable(false);
		this.txtNombreProducto.setBounds(90, 80, 180, 20);
		getContentPane().add(txtNombreProducto);
		
		this.txtCantidadProducto=new JTextField();
		this.txtCantidadProducto.setEditable(false);
		this.txtCantidadProducto.setBounds(90, 110, 180, 20);
		getContentPane().add(txtCantidadProducto);
		
		this.txtPrecioIngreso=new JTextField();
		this.txtPrecioIngreso.setEditable(false);
		this.txtPrecioIngreso.setBounds(90, 140, 180, 20);
		getContentPane().add(txtPrecioIngreso);
		
		this.txtFechaIngreso=new JTextField();
		this.txtFechaIngreso.setEditable(false);
		this.txtFechaIngreso.setBounds(121, 230, 180, 20);
		getContentPane().add(txtFechaIngreso);
	}
	private void crearBotones() {
		this.btnVolver=new JButton();
		this.btnVolver.setText("Volver");
		this.btnVolver.setBounds(167, 272, 120, 20);
		btnVolver.addActionListener(this);
		getContentPane().add(btnVolver);
		

		this.listaProductos = new JComboBox();
		this.listaProductos.setBounds(10, 20, 149, 20);
		this.listaProductos.addActionListener(this);
		getContentPane().add(listaProductos);
		this.leerProducto();
		
		txtPrecioVenta = new JTextField();
		txtPrecioVenta.setText((String) null);
		txtPrecioVenta.setEditable(false);
		txtPrecioVenta.setBounds(90, 170, 180, 20);
		getContentPane().add(txtPrecioVenta);
		
		txtFechaVencimiento = new JTextField();
		txtFechaVencimiento.setText((String) null);
		txtFechaVencimiento.setEditable(false);
		txtFechaVencimiento.setBounds(121, 200, 180, 20);
		getContentPane().add(txtFechaVencimiento);
		
		this.llenarProductos();
	}

	public void actionPerformed(ActionEvent e) {	
		if(e.getSource()==btnVolver){
			if (rolid==2){
			/*	VentanaUsuario ventana = new VentanaUsuario(rolid);
				ventana.setVisible(true);*/
			} else if(rolid==3){
				//abreventana emp
			}
			setVisible(false);
		}
		
		if(e.getSource()==listaProductos){
			llenarProductos();
		}

	}
	
	private void leerProducto() {
		DefaultComboBoxModel mlista = new DefaultComboBoxModel();

		for (int i = 0; i < tienda.getLstProductos().size(); i++) {
			mlista.addElement(tienda.getLstProductos().get(i).getId());
		}
		listaProductos.setModel(mlista);
	}

	private void llenarProductos() {
		String id = (String) listaProductos.getSelectedItem();
		producto = tienda.buscarProducto(producto, id);
		txtIdProducto.setText(producto.getId());
		txtNombreProducto.setText(producto.getNombre());
		txtCantidadProducto.setText(producto.getCantidad());
		txtPrecioIngreso.setText(producto.getPrecioIngreso());
		txtPrecioVenta.setText(producto.getPrecioVenta());
		txtFechaIngreso.setText(producto.getFechaIngreso());
		txtFechaVencimiento.setText(producto.getFechaVencimiento());
	
	}
}
