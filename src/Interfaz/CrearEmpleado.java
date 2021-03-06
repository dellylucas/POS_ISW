
package Interfaz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import ConexionBD.Dao_Empleado;
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
		private JLabel salarioEmpleado;
		private JLabel bonificacionEmpleado;

		private JTextField txtIdEmpleado;
		private JTextField txtNombreEmpleado;
		private JTextField txtTelefonoEmpleado;
		private JTextField txtDireccionEmpleado;
		private JTextField txtCorreoEmpleado;
		private JTextField txtusuarioEmpleado;
		private JTextField txtclaveEmpleado;
		private JTextField txtsalarioEmpleado;
		private JTextField txtbonificacionEmpleado;

		private JButton btnCrearEmpleado;
		private JButton btnVolver;
		private Empleado empleado;
		private Dao_Empleado daoEmpleado;
		private Persona persona;
		private Tienda tienda = Fachada.getTienda();

		public CrearEmpleado(Persona usuario){
			super();
			persona=usuario;
			this.setTitle("Crear Empleado");
			this.setSize(400, 450);
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

			this.salarioEmpleado=new JLabel();
			this.salarioEmpleado.setText("Salario");
			this.salarioEmpleado.setBounds(10, 165+(3*(154-121)), 79, 29);
			getContentPane().add(salarioEmpleado);

			this.bonificacionEmpleado=new JLabel();
			this.bonificacionEmpleado.setText("bonificacion");
			this.bonificacionEmpleado.setBounds(10, 165+(4*(154-121)), 79, 29);
			getContentPane().add(bonificacionEmpleado);


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

			this.txtsalarioEmpleado=new JTextField();
			this.txtsalarioEmpleado.setBounds(90, 161+(3*(161-125)), 180, 20);
			getContentPane().add(txtsalarioEmpleado);

			this.txtbonificacionEmpleado=new JTextField();
			this.txtbonificacionEmpleado.setBounds(90, 161+(4*(161-125)), 180, 20);
			getContentPane().add(txtbonificacionEmpleado);
		}
		
		private void crearBotones() {
			this.btnCrearEmpleado=new JButton();
			this.btnCrearEmpleado.setText("Crear");
			this.btnCrearEmpleado.setBounds(35, 350, 120, 20);
			btnCrearEmpleado.addActionListener(this);
			getContentPane().add(btnCrearEmpleado);
			
			this.btnVolver=new JButton();
			this.btnVolver.setText("Volver");
			this.btnVolver.setBounds(220, 350, 120, 20);
			btnVolver.addActionListener(this);
			getContentPane().add(btnVolver);

		}
		
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == btnCrearEmpleado) {
				if (txtIdEmpleado.getText().equals("") || txtNombreEmpleado.getText().equals("")
						|| txtTelefonoEmpleado.getText().equals("") || txtDireccionEmpleado.getText().equals("")
						|| txtCorreoEmpleado.getText().equals("")|| txtclaveEmpleado.getText().equals("")
						|| txtusuarioEmpleado.getText().equals("")|| txtsalarioEmpleado
						.getText().equals("")){
					JOptionPane.showMessageDialog(null, "Completa el formulario");
				} else {
					empleado = new Empleado();

					daoEmpleado = new Dao_Empleado();
					empleado.setId(txtIdEmpleado.getText());
					empleado.setNombre(txtNombreEmpleado.getText());
					empleado.setTelefono(txtTelefonoEmpleado.getText());
					empleado.setDireccion(txtDireccionEmpleado.getText());
					empleado.setCorreo(txtCorreoEmpleado.getText());
					empleado.setUsuario(txtusuarioEmpleado.getText());
					empleado.setClave(txtclaveEmpleado.getText());

					empleado.setSalario(Integer.parseInt(txtsalarioEmpleado.getText()));
					if (txtbonificacionEmpleado.getText().isEmpty()) {
						empleado.setBonificacion(0);
					}else {
						empleado.setBonificacion(Integer.parseInt(txtbonificacionEmpleado.getText()));
					}
					daoEmpleado.Crear(empleado,tienda.getId());

					JOptionPane.showMessageDialog(null, "Empleado Creado Exitosamente");
					limpiarFormulario();
				}
			}
			
			if(e.getSource()==btnVolver){
				VentanaUsuario ventana = new VentanaUsuario(persona);
				ventana.setVisible(true);
				dispose();
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
			txtsalarioEmpleado.setText("");
			txtbonificacionEmpleado.setText("");
		}
	}

