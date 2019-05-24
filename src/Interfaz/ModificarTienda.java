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

import ConexionBD.Dao_Producto;
import ConexionBD.Dao_Tienda;
import Modelo.Fachada;
import Modelo.Persona;
import Modelo.Producto;
import Modelo.Tienda;

public class ModificarTienda extends JFrame implements ActionListener{
	private JButton btnVolver;
	private JButton btnModificarTienda;
    private JLabel idTienda;
	private JLabel nombreTienda;
	private JLabel telefonoTienda;
	private JLabel direccionTienda;
	private JLabel ciudadTienda;

	private JTextField txtIdTienda;
	private JTextField txtNombretienda;
	private JTextField txtTelefonotienda;
	private JTextField txtDirecciontienda;
	private JTextField txtCiudadtienda;

	private JComboBox listatienda;
	private Dao_Tienda daoTienda;
	private Producto producto = new Producto();
	private Tienda tienda = Fachada.getTienda();
	private Persona persona;
	
	public ModificarTienda(Persona usuario){
		super();
		persona=usuario;
		daoTienda = new Dao_Tienda();
		this.setTitle("Modificar Tienda");
		this.setSize(500, 400);
		this.setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.crearEtiquetas();
		this.crearIngresoDatos();
		this.crearBotones();
	}
	private void crearEtiquetas() {
		this.idTienda=new JLabel();
		this.idTienda.setText("ID");
		this.idTienda.setBounds(10, 39, 75, 42);
		getContentPane().add(idTienda);
		
		this.nombreTienda=new JLabel();
		this.nombreTienda.setText("Nombre");
		this.nombreTienda.setBounds(10, 50, 200, 80);
		getContentPane().add(nombreTienda);
		
		this.telefonoTienda=new JLabel();
		this.telefonoTienda.setText("Telefono");
		this.telefonoTienda.setBounds(10, 80, 200, 80);
		getContentPane().add(telefonoTienda);
		
		this.direccionTienda=new JLabel();
		this.direccionTienda.setText("Precio Ingreso");
		this.direccionTienda.setBounds(10, 110, 200, 80);
		getContentPane().add(direccionTienda);
		
		this.ciudadTienda=new JLabel();
		this.ciudadTienda.setText("Precio Venta");
		this.ciudadTienda.setBounds(10, 140, 200, 80);
		getContentPane().add(ciudadTienda);
		

	}
	
	private void crearIngresoDatos() {
		this.txtIdTienda=new JTextField();
		this.txtIdTienda.setEditable(false);
		this.txtIdTienda.setBounds(90, 50, 180, 20);
		getContentPane().add(txtIdTienda);
		
		this.txtNombretienda=new JTextField();
		this.txtNombretienda.setBounds(90, 80, 180, 20);
		getContentPane().add(txtNombretienda);
		
		this.txtTelefonotienda=new JTextField();
		this.txtTelefonotienda.setBounds(90, 110, 180, 20);
		getContentPane().add(txtTelefonotienda);
		
		this.txtDirecciontienda=new JTextField();
		this.txtDirecciontienda.setBounds(90, 140, 180, 20);
		getContentPane().add(txtDirecciontienda);
		
		this.txtCiudadtienda=new JTextField();
		this.txtCiudadtienda.setBounds(90, 171, 180, 20);
		getContentPane().add(txtCiudadtienda);
		
;
	}
	private void crearBotones() {
		this.btnVolver=new JButton();
		this.btnVolver.setText("Volver");
		this.btnVolver.setBounds(300, 290, 120, 20);
		btnVolver.addActionListener(this);
		getContentPane().add(btnVolver);

		this.btnModificarTienda=new JButton();
		this.btnModificarTienda.setText("Modificar Producto");
		this.btnModificarTienda.setBounds(20, 290, 150, 20);
     	btnModificarTienda.setEnabled(false);
		btnModificarTienda.addActionListener(this);
		getContentPane().add(btnModificarTienda);

		this.listatienda = new JComboBox();
		this.listatienda.setBounds(10, 20, 149, 20);
		this.listatienda.addActionListener(this);
		getContentPane().add(listatienda);
		this.leerTienda();

	}
	public void actionPerformed(ActionEvent e) {
		Integer nombreTienda = (Integer) listatienda.getSelectedItem();
		tienda = tienda.buscarTienda(tienda, nombreTienda);
		if(e.getSource()==btnVolver){
			VentanaUsuario ventana = new VentanaUsuario(persona);
			ventana.setVisible(true);
			dispose();
		}

		if(e.getSource()==listatienda){
			llenarTienda();
			btnModificarTienda.setEnabled(true);
		}
		if(e.getSource()==btnModificarTienda){
			tienda.setNombre(txtNombretienda.getText());
			tienda.setTelefono(txtTelefonotienda.getText());
			tienda.setDireccion(txtDirecciontienda.getText());
			tienda.setCiudad(txtCiudadtienda.getText());
	
			daoTienda.Modificar(tienda,tienda.getId());
			leerTienda();
			limpiarFormulario();
			btnModificarTienda.setEnabled(false);
			JOptionPane.showMessageDialog(null, "Producto Modificado");
		}
		
	}
	private void leerTienda() {
		DefaultComboBoxModel mlista = new DefaultComboBoxModel();
	//	tienda.setLstTienda(daoTienda.ConsultaTodos(tienda.getId()));
		for (int i = 0; i < tienda.getLstProductos().size(); i++) {
			mlista.addElement(tienda.getLstProductos().get(i).getId());
		}
		listatienda.setModel(mlista);
	getContentPane().add(listatienda);
	}
	
	private void llenarTienda() {
		Integer id = (Integer) listatienda.getSelectedItem();
		tienda = tienda.buscarTienda(tienda, id);
		txtIdTienda.setText(String.valueOf(tienda.getId()));
		txtNombretienda.setText(tienda.getNombre());
		txtTelefonotienda.setText(tienda.getTelefono());
		txtDirecciontienda.setText(tienda.getCiudad());
		txtCiudadtienda.setText(tienda.getDireccion());

		
	}

	private void limpiarFormulario() {
		txtIdTienda.setText("");
		txtNombretienda.setText("");
		txtTelefonotienda.setText("");
		txtDirecciontienda.setText("");
		txtCiudadtienda.setText("");


	}
}
