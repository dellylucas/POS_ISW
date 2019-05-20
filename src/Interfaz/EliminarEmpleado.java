
	package Interfaz;

	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
	import java.sql.SQLException;

	import javax.swing.DefaultComboBoxModel;
	import javax.swing.JButton;
	import javax.swing.JComboBox;
	import javax.swing.JFrame;
	import javax.swing.JLabel;
	import javax.swing.JOptionPane;
	import javax.swing.JTextField;

	import ConexionBD.Dao_Empleado;
	import Modelo.Empleado;
import Modelo.Fachada;

    import Modelo.Persona;
    import Modelo.Tienda;

	public class EliminarEmpleado extends JFrame implements ActionListener{
		private JButton btnVolver;
		private JButton btnEliminarEmpleado;
		private JLabel idEmpleado;
		private JLabel nombreEmpleado;
		private JLabel telefonoEmpleado;
		private JLabel direccionEmpleado;
		private JLabel correoEmpleado;
		
		private JTextField txtId;
		private JTextField txtNombreEmpleado;
		private JTextField txtTelefonoEmpleado;
		private JTextField txtDireccionEmpleado;
		private JTextField txtCorreoEmpleado;
		private Persona persona;
		private Dao_Empleado daoEmpleado;
		private JComboBox listaEmpleado;
		private Empleado empleado = new Empleado();
		private Tienda tienda = Fachada.getTienda();

		
		public EliminarEmpleado(Persona usuario){
			super();
			persona = usuario;
			daoEmpleado = new Dao_Empleado();
			this.setTitle("Eliminar Proveedor");
			this.setSize(370, 300);
			this.setLocationRelativeTo(null);
			getContentPane().setLayout(null);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.crearEtiquetas();
			this.crearIngresoDatos();
			this.crearBotones();
		}
		
		private void crearEtiquetas() {
			this.idEmpleado=new JLabel();
			this.idEmpleado.setText("Identificacion");
			this.idEmpleado.setBounds(10, 37, 200, 32);
			getContentPane().add(idEmpleado);
			
			this.nombreEmpleado=new JLabel();
			this.nombreEmpleado.setText("Nombre");
			this.nombreEmpleado.setBounds(10, 61, 91, 32);
			getContentPane().add(nombreEmpleado);
			
			this.telefonoEmpleado=new JLabel();
			this.telefonoEmpleado.setText("Telefono");
			this.telefonoEmpleado.setBounds(10, 91, 86, 32);
			getContentPane().add(telefonoEmpleado);
			
			this.direccionEmpleado=new JLabel();
			this.direccionEmpleado.setText("Direccion");
			this.direccionEmpleado.setBounds(10, 124, 75, 26);
			getContentPane().add(direccionEmpleado);
			
			this.correoEmpleado=new JLabel();
			this.correoEmpleado.setText("Ciudad");
			this.correoEmpleado.setBounds(10, 152, 75, 32);
			getContentPane().add(correoEmpleado);
		}
		
		private void crearIngresoDatos() {
			this.txtId=new JTextField();
			this.txtId.setEditable(false);
			this.txtId.setBounds(95, 43, 180, 20);
			getContentPane().add(txtId);
			
			this.txtNombreEmpleado=new JTextField();
			this.txtNombreEmpleado.setEditable(false);
			this.txtNombreEmpleado.setBounds(95, 67, 180, 20);
			getContentPane().add(txtNombreEmpleado);
			
			this.txtTelefonoEmpleado=new JTextField();
			this.txtTelefonoEmpleado.setEditable(false);
			this.txtTelefonoEmpleado.setBounds(95, 97, 180, 20);
			getContentPane().add(txtTelefonoEmpleado);
			
			this.txtDireccionEmpleado=new JTextField();
			this.txtDireccionEmpleado.setEditable(false);
			this.txtDireccionEmpleado.setBounds(95, 127, 180, 20);
			getContentPane().add(txtDireccionEmpleado);
			
			this.txtCorreoEmpleado=new JTextField();
			this.txtCorreoEmpleado.setEditable(false);
			this.txtCorreoEmpleado.setBounds(95, 158, 180, 20);
			getContentPane().add(txtCorreoEmpleado);

		}
		private void crearBotones() {
			this.btnVolver=new JButton();
			this.btnVolver.setText("Volver");
			this.btnVolver.setBounds(206, 204, 120, 20);
			btnVolver.addActionListener(this);
			getContentPane().add(btnVolver);
			
			
			this.btnEliminarEmpleado=new JButton();
			this.btnEliminarEmpleado.setText("Eliminar Proveedor");
			this.btnEliminarEmpleado.setBounds(50, 204, 130, 20);
			btnEliminarEmpleado.addActionListener(this);
			btnEliminarEmpleado.setEnabled(false);
			getContentPane().add(btnEliminarEmpleado);
			
			this.listaEmpleado = new JComboBox();
			this.listaEmpleado.setBounds(10, 11, 149, 20);
			listaEmpleado.addActionListener(this);
			getContentPane().add(listaEmpleado);
			

			this.leerEmpleado();
		}
		public void actionPerformed(ActionEvent e) {	
			
			String id = (String) listaEmpleado.getSelectedItem();
			
			if(e.getSource()==btnVolver){
				VentanaUsuario ventana = new VentanaUsuario(persona);
				ventana.setVisible(true);
				dispose();
			}
			
			if(e.getSource()==btnEliminarEmpleado){

					daoEmpleado.Eliminar(id);
					 leerEmpleado();
					 limpiarFormulario();
					btnEliminarEmpleado.setEnabled(false);
				JOptionPane.showMessageDialog(null, "Empleado Eliminado");
			}
			
			if(e.getSource()==listaEmpleado){
				llenarEmpleado();
			}
		}
		
		private void leerEmpleado() {
			DefaultComboBoxModel mlista = new DefaultComboBoxModel();
			 tienda.setLstSEmpleados(daoEmpleado.ConsultarTodos(tienda.getId()));
			for (int i = 0; i < tienda.getLstSEmpleados().size(); i++) {
				mlista.addElement(tienda.getLstSEmpleados().get(i).getId());
			}
			listaEmpleado.setModel(mlista);
		}
		
		
		private void llenarEmpleado() {
			String id = (String) listaEmpleado.getSelectedItem();
			empleado = tienda.buscarEmpleado(empleado, id);
			txtId.setText(empleado.getId());
			txtNombreEmpleado.setText(empleado.getNombre());
			txtTelefonoEmpleado.setText(empleado.getTelefono());
			txtDireccionEmpleado.setText(empleado.getDireccion());
			txtCorreoEmpleado.setText(empleado.getCorreo());
			btnEliminarEmpleado.setEnabled(true);
		}
	    private void limpiarFormulario() {
	    	txtId.setText("");
	    	txtNombreEmpleado.setText("");
	        txtTelefonoEmpleado.setText("");
	        txtDireccionEmpleado.setText("");
	        txtCorreoEmpleado.setText("");
	    }
	}


