package Interfaz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import ConexionBD.Dao_Proveedor;
import Modelo.Fachada;
import Modelo.Persona;
import Modelo.Proveedor;
import Modelo.Tienda;


public class ModificarProveedor extends JFrame implements ActionListener{
	private JButton btnVolver;
	private JButton btnModificarProveedor;
    private JLabel idProveedor;
	private JLabel nombreProveedor;
	private JLabel telefonoProveedor;
	private JLabel direccionProveedor;
	private JLabel ciudadProveedor;
	private JLabel tipoDeProducto;
	private JTextField txtIdProveedor;
	private JTextField txtNombreProveedor;
	private JTextField txtTelefonoProveedoro;
	private JTextField txtDireccionProveedor;
	private JTextField txtCiudadProveedor;
	private JTextField txtTipoDeProducto;
	private Persona persona;
	private JComboBox listaProveedor;
	private Dao_Proveedor daoProveedor;
	private Proveedor proveedor = new Proveedor();

	private Tienda tienda = Fachada.getTienda();
	
	public ModificarProveedor(Persona usuario){
		super();
		persona = usuario;
		daoProveedor=new Dao_Proveedor();
		this.setTitle("Modificar Proveedor");
		this.setSize(500, 400);
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
		this.idProveedor.setBounds(10, 39, 75, 42);
		getContentPane().add(idProveedor);
		
		this.nombreProveedor=new JLabel();
		this.nombreProveedor.setText("Nombre");
		this.nombreProveedor.setBounds(10, 50, 200, 80);
		getContentPane().add(nombreProveedor);
		
		this.telefonoProveedor=new JLabel();
		this.telefonoProveedor.setText("Telefono");
		this.telefonoProveedor.setBounds(10, 80, 200, 80);
		getContentPane().add(telefonoProveedor);
		
		this.direccionProveedor=new JLabel();
		this.direccionProveedor.setText("Direccion");
		this.direccionProveedor.setBounds(10, 110, 200, 80);
		getContentPane().add(direccionProveedor);
		
		this.ciudadProveedor=new JLabel();
		this.ciudadProveedor.setText("Ciudad");
		this.ciudadProveedor.setBounds(10, 140, 200, 80);
		getContentPane().add(ciudadProveedor);
		
		this.tipoDeProducto=new JLabel();
		this.tipoDeProducto.setText("Tipo De Producto");
		this.tipoDeProducto.setBounds(10, 170, 200, 80);
		getContentPane().add(tipoDeProducto);
		

		

	}
	
	private void crearIngresoDatos() {
		this.txtIdProveedor=new JTextField();
		this.txtIdProveedor.setBounds(90, 50, 180, 20);
		txtIdProveedor.setEditable(false);
		getContentPane().add(txtIdProveedor);
		
		this.txtNombreProveedor=new JTextField();
		this.txtNombreProveedor.setBounds(90, 80, 180, 20);
		getContentPane().add(txtNombreProveedor);
		
		this.txtTelefonoProveedoro=new JTextField();
		this.txtTelefonoProveedoro.setBounds(90, 110, 180, 20);
		getContentPane().add(txtTelefonoProveedoro);
		
		this.txtDireccionProveedor=new JTextField();
		this.txtDireccionProveedor.setBounds(90, 140, 180, 20);
		getContentPane().add(txtDireccionProveedor);
		
		this.txtCiudadProveedor=new JTextField();
		this.txtCiudadProveedor.setBounds(90, 171, 180, 20);
		getContentPane().add(txtCiudadProveedor);
		
		this.txtTipoDeProducto=new JTextField();
		this.txtTipoDeProducto.setBounds(126, 201, 180, 20);
		getContentPane().add(txtTipoDeProducto);

		

	}
	private void crearBotones() {
		this.btnVolver=new JButton();
		this.btnVolver.setText("Volver");
		this.btnVolver.setBounds(300, 290, 120, 20);
		btnVolver.addActionListener(this);
		getContentPane().add(btnVolver);

		this.btnModificarProveedor=new JButton();
		this.btnModificarProveedor.setText("Modificar Proveedor");
		this.btnModificarProveedor.setBounds(20, 290, 150, 20);
		btnModificarProveedor.setEnabled(false);
		btnModificarProveedor.addActionListener(this);

		getContentPane().add(btnModificarProveedor);

		this.listaProveedor = new JComboBox();
		this.listaProveedor.setBounds(10, 20, 149, 20);
		listaProveedor.addActionListener(this);
		getContentPane().add(listaProveedor);
		this.leerProveedor();
	}
	public void actionPerformed(ActionEvent e) {
		String nombreProveedor = (String) listaProveedor.getSelectedItem();
		proveedor = tienda.buscarProveedor(proveedor, nombreProveedor);
		if(e.getSource()==btnVolver){
			VentanaUsuario ventana = new VentanaUsuario(persona);
			ventana.setVisible(true);
			dispose();
		}
		if(e.getSource()==listaProveedor){
			llenarProducto();
		}

		if(e.getSource()==btnModificarProveedor){
			proveedor.setNombre(txtNombreProveedor.getText());
			proveedor.setTelefono(txtTelefonoProveedoro.getText());
			proveedor.setDireccion(txtDireccionProveedor.getText());
			proveedor.setCiudad(txtCiudadProveedor.getText());
			proveedor.setTipoDeProducto(txtTipoDeProducto.getText());
			daoProveedor.Modificar(proveedor, tienda.getId());
			leerProveedor();
			btnModificarProveedor.setEnabled(false);
			limpiarFormulario();
			JOptionPane.showMessageDialog(null, "Proveedor  Modificado");
		}
	}
	private void leerProveedor() {
		DefaultComboBoxModel mlista = new DefaultComboBoxModel();
		tienda.setLstProveedor(daoProveedor.ConsultaTodos(tienda.getId()));
		for (int i = 0; i < tienda.getLstProveedor().size(); i++) {
			mlista.addElement(tienda.getLstProveedor().get(i).getId());
		}
		listaProveedor.setModel(mlista);
		getContentPane().add(listaProveedor);
	}
	
	private void llenarProducto() {
		String id = (String) listaProveedor.getSelectedItem();
		proveedor = tienda.buscarProveedor(proveedor, id);
		txtIdProveedor.setText(proveedor.getId());
		txtNombreProveedor.setText(proveedor.getNombre());
		txtTelefonoProveedoro.setText(proveedor.getTelefono());
		txtDireccionProveedor.setText(proveedor.getDireccion());
		txtCiudadProveedor.setText(proveedor.getCiudad());
		txtTipoDeProducto.setText(proveedor.getTipoDeProducto());
		btnModificarProveedor.setEnabled(true);
	}

	private void limpiarFormulario() {
		txtIdProveedor.setText("");
		txtNombreProveedor.setText("");
		txtTelefonoProveedoro.setText("");
		txtDireccionProveedor.setText("");
		txtCiudadProveedor.setText("");
		txtTipoDeProducto.setText("");

	}
}