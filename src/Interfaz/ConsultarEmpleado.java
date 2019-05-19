package Interfaz;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;

	import javax.swing.DefaultComboBoxModel;
	import javax.swing.JButton;
	import javax.swing.JComboBox;
	import javax.swing.JFrame;
	import javax.swing.JLabel;
	import javax.swing.JTextField;

import Modelo.Empleado;
import Modelo.Fachada;
    import Modelo.Persona;
    import Modelo.Tienda;

	public class ConsultarEmpleado extends JFrame implements ActionListener{
		
		private JButton btnVolver;
		private JLabel idEmpleado;
		private JLabel nombreEmpleado;
		private JLabel telefonoEmpleado;
		private JLabel direccionEmpleado;
		private JLabel correoEmpleado;
		private JLabel usrEmpleado;
		private JLabel clavEmpleado;
		private JLabel salarioEmpleado;
		private JLabel bonificaEmpleado;
		private JLabel activoEmpleado;
		
		
		private JTextField txtIdEmpleado;
		private JTextField txtNombreEmpleado;
		private JTextField txtTelefonoEmpleado;
		private JTextField txtDireccionEmpleado;
		private JTextField txtCorreoEmpleado;
		private JTextField txtusrEmpleado;
		private JTextField txtclaveEmpleado;
		private JTextField txtsalarioEmpleado;
		private JTextField txtbonoEmpleado;
		private JTextField txtactivoEmpleado;
		private Persona persona;
		private JComboBox listaEmpleado;

		private JTextField txtFechaVencimiento;
		private Empleado empleado = new Empleado();

	    private Tienda tienda = Fachada.getTienda();
		
		public ConsultarEmpleado(Persona usuario){
			super();
			persona=usuario;
			this.setTitle("Consultar Empleado");
			this.setSize(460, 420);
			this.setLocationRelativeTo(null);
			this.setResizable(false);
			getContentPane().setLayout(null);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.crearEtiquetas();
			this.crearIngresoDatos();
			this.crearBotones();
		}
		
		private void crearEtiquetas() {
			this.idEmpleado=new JLabel();
			this.idEmpleado.setText("ID");
			this.idEmpleado.setBounds(10, 43, 70, 35);
			getContentPane().add(idEmpleado);
			
			this.nombreEmpleado=new JLabel();
			this.nombreEmpleado.setText("Nombre");
			this.nombreEmpleado.setBounds(10, 73, 70, 35);
			getContentPane().add(nombreEmpleado);

			this.direccionEmpleado=new JLabel();
			this.direccionEmpleado.setText("Direccion");
			this.direccionEmpleado.setBounds(10, 105, 70, 30);
			getContentPane().add(direccionEmpleado);

			this.telefonoEmpleado=new JLabel();
			this.telefonoEmpleado.setText("Telefono");
			this.telefonoEmpleado.setBounds(10, 130, 77, 40);
			getContentPane().add(telefonoEmpleado);

			this.correoEmpleado=new JLabel();
			this.correoEmpleado.setText("correo");
			this.correoEmpleado.setBounds(10, 163, 77, 35);
			getContentPane().add(correoEmpleado);

			this.usrEmpleado=new JLabel();
			this.usrEmpleado.setText("Usuario");
			this.usrEmpleado.setBounds(10, 193, 70, 35);
			getContentPane().add(usrEmpleado);

			this.clavEmpleado=new JLabel();
			this.clavEmpleado.setText("Clave");
			this.clavEmpleado.setBounds(10, 223, 70, 35);
			getContentPane().add(clavEmpleado);

			this.salarioEmpleado=new JLabel();
			this.salarioEmpleado.setText("Salario");
			this.salarioEmpleado.setBounds(10, 253, 77, 40);
			getContentPane().add(salarioEmpleado);

			this.bonificaEmpleado=new JLabel();
			this.bonificaEmpleado.setText("Bonificacion");
			this.bonificaEmpleado.setBounds(10, 283, 70, 30);
			getContentPane().add(bonificaEmpleado);

			this.activoEmpleado=new JLabel();
			this.activoEmpleado.setText("Activo");
			this.activoEmpleado.setBounds(10, 313, 77, 35);
			getContentPane().add(activoEmpleado);


		}
		
		private void crearIngresoDatos() {
			this.txtIdEmpleado=new JTextField();
			this.txtIdEmpleado.setEditable(false);
			this.txtIdEmpleado.setBounds(90, 50, 180, 20);
			getContentPane().add(txtIdEmpleado);
			
			this.txtNombreEmpleado=new JTextField();
			this.txtNombreEmpleado.setEditable(false);
			this.txtNombreEmpleado.setBounds(90, 80, 180, 20);
			getContentPane().add(txtNombreEmpleado);
			
			this.txtTelefonoEmpleado=new JTextField();
			this.txtTelefonoEmpleado.setEditable(false);
			this.txtTelefonoEmpleado.setBounds(90, 140, 180, 20);
			getContentPane().add(txtTelefonoEmpleado);
			
			this.txtDireccionEmpleado=new JTextField();
			this.txtDireccionEmpleado.setEditable(false);
			this.txtDireccionEmpleado.setBounds(90, 110, 180, 20);
			getContentPane().add(txtDireccionEmpleado);
			
			this.txtCorreoEmpleado=new JTextField();
			this.txtCorreoEmpleado.setEditable(false);
			this.txtCorreoEmpleado.setBounds(90, 170, 180, 20);
			getContentPane().add(txtCorreoEmpleado);

			this.txtusrEmpleado=new JTextField();
			this.txtusrEmpleado.setEditable(false);
			this.txtusrEmpleado.setBounds(90, 200, 180, 20);
			getContentPane().add(txtusrEmpleado);

			this.txtclaveEmpleado=new JTextField();
			this.txtclaveEmpleado.setEditable(false);
			this.txtclaveEmpleado.setBounds(90, 230, 180, 20);
			getContentPane().add(txtclaveEmpleado);

			this.txtsalarioEmpleado=new JTextField();
			this.txtsalarioEmpleado.setEditable(false);
			this.txtsalarioEmpleado.setBounds(90, 260, 180, 20);
			getContentPane().add(txtsalarioEmpleado);

			this.txtbonoEmpleado=new JTextField();
			this.txtbonoEmpleado.setEditable(false);
			this.txtbonoEmpleado.setBounds(90, 290, 180, 20);
			getContentPane().add(txtbonoEmpleado);

			this.txtactivoEmpleado=new JTextField();
			this.txtactivoEmpleado.setEditable(false);
			this.txtactivoEmpleado.setBounds(90, 320, 180, 20);
			getContentPane().add(txtactivoEmpleado);
			
	
		}
		private void crearBotones() {
			this.btnVolver=new JButton();
			this.btnVolver.setText("Volver");
			this.btnVolver.setBounds(167, 350, 120, 20);
			btnVolver.addActionListener(this);
			getContentPane().add(btnVolver);
			
			this.listaEmpleado = new JComboBox();
			this.listaEmpleado.setBounds(10, 20, 149, 20);
			listaEmpleado.addActionListener(this);
			getContentPane().add(listaEmpleado);
			this.leerEmpleado();
			this.llenarEmpleado();
		}

		public void actionPerformed(ActionEvent e) {	
			if(e.getSource()==btnVolver){
				VentanaUsuario ventana = new VentanaUsuario(persona);
				ventana.setVisible(true);
				dispose();
			}
			if(e.getSource()==listaEmpleado){
				llenarEmpleado();
			}
		}

		private void leerEmpleado() {
			DefaultComboBoxModel mlista = new DefaultComboBoxModel();
			for (int i = 0; i < tienda.getLstSEmpleados().size(); i++) {
				mlista.addElement(tienda.getLstSEmpleados().get(i).getId());
			}
			listaEmpleado.setModel(mlista);
		}
		private void llenarEmpleado() {
			String id = (String) listaEmpleado.getSelectedItem();
			empleado = tienda.buscarEmpleado(empleado, id);
			txtIdEmpleado.setText(empleado.getId());
			txtNombreEmpleado.setText(empleado.getNombre());
			txtTelefonoEmpleado.setText(empleado.getTelefono());
			txtDireccionEmpleado.setText(empleado.getDireccion());
			txtCorreoEmpleado.setText(empleado.getCorreo());
			txtusrEmpleado.setText(empleado.getUsuario());
			txtclaveEmpleado.setText(empleado.getClave());
			txtsalarioEmpleado.setText(String.valueOf(empleado.getSalario()));
			txtbonoEmpleado.setText(String.valueOf(empleado.getBonificacion()));
			txtactivoEmpleado.setText(String.valueOf(empleado.getActivo()));
		}
	}