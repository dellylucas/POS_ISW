package Interfaz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import ConexionBD.Dao_Proveedor;
import Modelo.Fachada;
import Modelo.Persona;
import Modelo.Proveedor;
import Modelo.Tienda;


public class ConsultarProveedor extends JFrame implements ActionListener{
	
	private JButton btnVolver;
	private JLabel idProveedor;
	private JLabel nombreProveedor;
	private JLabel telefonoProveedor;
	private JLabel direccionProveedor;
	private JLabel ciudadProveedor;
	private JLabel tipoDeProveedor;
	
	private JTextField txtIdProveedor;
	private JTextField txtNombreProveedor;
	private JTextField txtTelefonoProveedor;
	private JTextField txtDireccionProveedor;
	private JTextField txtCiudadProveedor;
	private JTextField txtTipoDeProveedor;
	private JComboBox listaProveedor;
	private Persona persona;
	private Dao_Proveedor daoProveedor;
	private JTextField txtFechaVencimiento;
	private Proveedor proveedor = new Proveedor();

    private Tienda tienda = Fachada.getTienda();
	
	public ConsultarProveedor(Persona usuario){
		super();
		persona = usuario;
		daoProveedor = new Dao_Proveedor();
		this.setTitle("Consultar Proveedor");
		this.setSize(460, 350);
		this.setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.crearEtiquetas();
		this.crearIngresoDatos();
		this.crearBotones();
	}
	
	private void crearEtiquetas() {
		this.idProveedor=new JLabel();
		this.idProveedor.setText("ID");
		this.idProveedor.setBounds(10, 43, 70, 35);
		getContentPane().add(idProveedor);
		
		this.nombreProveedor=new JLabel();
		this.nombreProveedor.setText("Nombre");
		this.nombreProveedor.setBounds(10, 73, 70, 35);
		getContentPane().add(nombreProveedor);
		
		this.telefonoProveedor=new JLabel();
		this.telefonoProveedor.setText("Telefono");
		this.telefonoProveedor.setBounds(10, 130, 77, 40);
		getContentPane().add(telefonoProveedor);
		
		this.direccionProveedor=new JLabel();
		this.direccionProveedor.setText("Direccion");
		this.direccionProveedor.setBounds(10, 105, 70, 30);
		getContentPane().add(direccionProveedor);
		
		this.ciudadProveedor=new JLabel();
		this.ciudadProveedor.setText("Ciudad");
		this.ciudadProveedor.setBounds(10, 163, 77, 35);
		getContentPane().add(ciudadProveedor);
		
		this.tipoDeProveedor=new JLabel();
		this.tipoDeProveedor.setText("Tipo De Proveedor");
		this.tipoDeProveedor.setBounds(10, 195, 120, 30);
		getContentPane().add(tipoDeProveedor);

	}
	
	private void crearIngresoDatos() {
		this.txtIdProveedor=new JTextField();
		this.txtIdProveedor.setEditable(false);
		this.txtIdProveedor.setBounds(90, 50, 180, 20);
		getContentPane().add(txtIdProveedor);
		
		this.txtNombreProveedor=new JTextField();
		this.txtNombreProveedor.setEditable(false);
		this.txtNombreProveedor.setBounds(90, 80, 180, 20);
		getContentPane().add(txtNombreProveedor);
		
		this.txtTelefonoProveedor=new JTextField();
		this.txtTelefonoProveedor.setEditable(false);
		this.txtTelefonoProveedor.setBounds(90, 140, 180, 20);
		getContentPane().add(txtTelefonoProveedor);
		
		this.txtDireccionProveedor=new JTextField();
		this.txtDireccionProveedor.setEditable(false);
		this.txtDireccionProveedor.setBounds(90, 110, 180, 20);
		getContentPane().add(txtDireccionProveedor);
		
		this.txtCiudadProveedor=new JTextField();
		this.txtCiudadProveedor.setEditable(false);
		this.txtCiudadProveedor.setBounds(90, 170, 180, 20);
		getContentPane().add(txtCiudadProveedor);
		
		this.txtTipoDeProveedor=new JTextField();
		this.txtTipoDeProveedor.setEditable(false);
		this.txtTipoDeProveedor.setBounds(111, 200, 180, 20);
		getContentPane().add(txtTipoDeProveedor);
	}
	private void crearBotones() {
		this.btnVolver=new JButton();
		this.btnVolver.setText("Volver");
		this.btnVolver.setBounds(167, 272, 120, 20);
		btnVolver.addActionListener(this);
		getContentPane().add(btnVolver);
		
		this.listaProveedor = new JComboBox();
		this.listaProveedor.setBounds(10, 20, 149, 20);
		getContentPane().add(listaProveedor);
		listaProveedor.addActionListener(this);
		this.leerProveedor();
		this.llenarProveedor();
	}

	public void actionPerformed(ActionEvent e) {	
		if(e.getSource()==btnVolver){
			VentanaUsuario ventana = new VentanaUsuario(persona);
			ventana.setVisible(true);
			dispose();
		}
		
		if(e.getSource()==listaProveedor){
			llenarProveedor();
		}
	}
	
	private void leerProveedor() {
		DefaultComboBoxModel mlista = new DefaultComboBoxModel();
		for (int i = 0; i < tienda.getLstProveedor().size(); i++) {
			mlista.addElement(tienda.getLstProveedor().get(i).getId());
		}
		listaProveedor.setModel(mlista);
	}
	private void llenarProveedor() {
		String id = (String) listaProveedor.getSelectedItem();
		proveedor = tienda.buscarProveedor(proveedor, id);
		txtIdProveedor.setText(proveedor.getId());
		txtNombreProveedor.setText(proveedor.getNombre());
		txtTelefonoProveedor.setText(proveedor.getTelefono());
		txtDireccionProveedor.setText(proveedor.getDireccion());
		txtCiudadProveedor.setText(proveedor.getCiudad());
		txtTipoDeProveedor.setText(proveedor.getTipoDeProducto());
	}
}