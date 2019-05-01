
	package Interfaz;

	import java.awt.Toolkit;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;

	import javax.swing.JButton;
	import javax.swing.JFrame;
	import javax.swing.JLabel;
	import javax.swing.JOptionPane;
	import javax.swing.JTextField;

	import ConexionBD.DAO_Crear;
import Modelo.Empleado;
import Modelo.Fachada;
	import Modelo.Persona;
	import Modelo.Tienda;
	public class CrearEmpleado extends JFrame implements ActionListener{
		private JLabel idEmpleado;
		private JLabel nombreEmpleado;
		private JLabel telefonoEmpleado;
		private JLabel direccionEmpleado;
		private JLabel correoEmpleado;
		private JLabel usuarioEmpleado;
		private JLabel claveEmpleado;

		private JTextField txtIdEmpleado;
		private JTextField txtNombreEmpleado;
		private JTextField txtTelefonoEmpleado;
		private JTextField txtDireccionEmpleado;
		private JTextField txtCorreoEmpleado;
		private JTextField txtusuarioEmpleado;
		private JTextField txtclaveEmpleado;


		private JButton btnCrearEmpleado;
		private JButton btnVolver;
		private Empleado empleado;

		private DAO_Crear dao;
		private Tienda a = Fachada.getTienda();

		
		public CrearEmpleado(){
			super();
			this.setTitle("Crear Empleado");
			this.setSize(400, 350);
			this.setLocationRelativeTo(null);
			getContentPane().setLayout(null);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.crearEtiquetas();
			this.crearIngreseDatos();
			this.crearBotones();
		}
		private void crearEtiquetas() {
			this.idEmpleado=new JLabel();
			this.idEmpleado.setText("ID");
			this.idEmpleado.setBounds(10, 31, 79, 29);
			getContentPane().add(idEmpleado);
			
			this.nombreEmpleado=new JLabel();
			this.nombreEmpleado.setText("Nombre");
			this.nombreEmpleado.setBounds(10, 61, 79, 29);
			getContentPane().add(nombreEmpleado);
			
			this.telefonoEmpleado=new JLabel();
			this.telefonoEmpleado.setText("Telefono");
			this.telefonoEmpleado.setBounds(10, 91, 79, 29);
			getContentPane().add(telefonoEmpleado);
			
			this.direccionEmpleado=new JLabel();
			this.direccionEmpleado.setText("Direccion");
			this.direccionEmpleado.setBounds(10, 121, 79, 29);
			getContentPane().add(direccionEmpleado);
			
			this.correoEmpleado=new JLabel();
			this.correoEmpleado.setText("Correo");
			this.correoEmpleado.setBounds(10, 154, 79, 29);
			getContentPane().add(correoEmpleado);

			this.usuarioEmpleado=new JLabel();
			this.usuarioEmpleado.setText("Usuario");
			this.usuarioEmpleado.setBounds(10, 154+(154-121), 79, 29);
			getContentPane().add(usuarioEmpleado);

			this.claveEmpleado=new JLabel();
			this.claveEmpleado.setText("clave");
			this.claveEmpleado.setBounds(10, 154+(2*(154-121)), 79, 29);
			getContentPane().add(claveEmpleado);

				}
		
		private void crearIngreseDatos() {
			this.txtIdEmpleado=new JTextField();
			this.txtIdEmpleado.setBounds(90, 35, 180, 20);
			getContentPane().add(txtIdEmpleado);
			
			this.txtNombreEmpleado=new JTextField();
			this.txtNombreEmpleado.setBounds(90, 65, 180, 20);
			getContentPane().add(txtNombreEmpleado);
			
			this.txtTelefonoEmpleado=new JTextField();
			this.txtTelefonoEmpleado.setBounds(90, 95, 180, 20);
			getContentPane().add(txtTelefonoEmpleado);
			
			this.txtDireccionEmpleado=new JTextField();
			this.txtDireccionEmpleado.setBounds(90, 125, 180, 20);
			getContentPane().add(txtDireccionEmpleado);
			
			this.txtCorreoEmpleado=new JTextField();
			this.txtCorreoEmpleado.setBounds(90, 161, 180, 20);
			getContentPane().add(txtCorreoEmpleado);

			this.txtusuarioEmpleado=new JTextField();
			this.txtusuarioEmpleado.setBounds(90, 161+(161-125), 180, 20);
			getContentPane().add(txtusuarioEmpleado);

			this.txtclaveEmpleado=new JTextField();
			this.txtclaveEmpleado.setBounds(90, 161+(2*(161-125)), 180, 20);
			getContentPane().add(txtclaveEmpleado);

		}
		
		private void crearBotones() {
			this.btnCrearEmpleado=new JButton();
			this.btnCrearEmpleado.setText("Crear");
			this.btnCrearEmpleado.setBounds(35, 255, 120, 20);
			btnCrearEmpleado.addActionListener(this);
			getContentPane().add(btnCrearEmpleado);
			
			this.btnVolver=new JButton();
			this.btnVolver.setText("Volver");
			this.btnVolver.setBounds(220, 255, 120, 20);
			btnVolver.addActionListener(this);
			getContentPane().add(btnVolver);
			
		;
			

		}
		
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == btnCrearEmpleado) {
				if (txtIdEmpleado.getText().equals("") || txtNombreEmpleado.getText().equals("")
						|| txtTelefonoEmpleado.getText().equals("") || txtDireccionEmpleado.getText().equals("")
						|| txtCorreoEmpleado.getText().equals("")|| txtclaveEmpleado.getText().equals("")
						|| txtusuarioEmpleado.getText().equals("")){
					JOptionPane.showMessageDialog(null, "Completa el formulario");
				} else {
					empleado = new Empleado(
							null,null,null,null,null,null,null
					);

					dao = new DAO_Crear();
					empleado.setId(txtIdEmpleado.getText());
					empleado.setNombre(txtNombreEmpleado.getText());
					empleado.setTelefono(txtTelefonoEmpleado.getText());
					empleado.setDireccion(txtDireccionEmpleado.getText());
					empleado.setCorreo(txtCorreoEmpleado.getText());
					empleado.setUsuario(txtusuarioEmpleado.getText());
					empleado.setClave(txtclaveEmpleado.getText());
					dao.Empleado(empleado);

					JOptionPane.showMessageDialog(null, "Empleado Creado Exitosamente");
					limpiarFormulario();
				}
			}
			
			if(e.getSource()==btnVolver){
				VentanaAdministrador ventana = new VentanaAdministrador();
				ventana.setVisible(true);
				setVisible(false);
			}
		}
		
		private void limpiarFormulario() {
			txtIdEmpleado.setText("");
			txtNombreEmpleado.setText("");
			txtTelefonoEmpleado.setText("");
			txtDireccionEmpleado.setText("");
			txtCorreoEmpleado.setText("");
			txtusuarioEmpleado.setText("");
			txtclaveEmpleado.setText("");
		}
	}

