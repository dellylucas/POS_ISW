package Interfaz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import ConexionBD.Dao_Proveedor;
import Modelo.Fachada;
import Modelo.Factura;
import Modelo.Persona;
import Modelo.Producto;
import Modelo.Proveedor;
import Modelo.Tienda;


public class GenerarPago extends JFrame implements ActionListener{
	private JButton btnVolver;
	private JButton btnModificarProveedor;
    private JLabel idProveedor;
	private JLabel nombreProveedor;
	private JTextField txtNombreProveedor;
	private Persona persona;
	private Dao_Proveedor daoProveedor;
	private Proveedor proveedor = new Proveedor();
	private Factura fac;

	private Tienda tienda = Fachada.getTienda();
	private JLabel Vueltas;
	private JLabel valorVueltas;
	
	public GenerarPago(Persona usuario, Factura factura){
		super();
		fac=factura;
		persona = usuario;
		daoProveedor=new Dao_Proveedor();
		this.setTitle("Modificar Proveedor");
		this.setSize(352, 259);
		this.setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.crearEtiquetas();
		this.crearIngresoDatos();
		this.crearBotones();
	}
	private void crearEtiquetas() {
		this.idProveedor=new JLabel();
		this.idProveedor.setText("Valor Compra");
		this.idProveedor.setBounds(30, 13, 86, 37);
		getContentPane().add(idProveedor);
		
		this.nombreProveedor=new JLabel();
		this.nombreProveedor.setText("Recibido");
		this.nombreProveedor.setBounds(30, 57, 56, 18);
		getContentPane().add(nombreProveedor);
		

		

	}
	
	private void crearIngresoDatos() {
		
		this.txtNombreProveedor=new JTextField();
		this.txtNombreProveedor.setBounds(111, 56, 104, 20);
		getContentPane().add(txtNombreProveedor);
		txtNombreProveedor.addKeyListener(new KeyAdapter() {
        	@Override
        	public void keyPressed(KeyEvent arg0) {
        		if(!txtNombreProveedor.getText().equals("")) {
        			int total=	fac.getTotalCompra()- Integer.parseInt(txtNombreProveedor.getText());
            		if(total >=0) {
            			valorVueltas.setText("0");
            			
            		}	else {
            			valorVueltas.setText("$ "+String.valueOf(total*(-1)));
            			
            		}
        			
        		}
        		
        		
        	}
        	@Override
        	public void keyReleased(KeyEvent e) {
        		if(!txtNombreProveedor.getText().equals("")) {
        			int total=	fac.getTotalCompra()- Integer.parseInt(txtNombreProveedor.getText());
            		if(total >=0) {
            			valorVueltas.setText("0");
            			
            		}	else {
            			valorVueltas.setText("$ "+String.valueOf(total*(-1)));
            			
            		}
        			
        		}
        	}
        });

		

	}
	private void crearBotones() {
		this.btnVolver=new JButton();
		this.btnVolver.setText("Volver");
		this.btnVolver.setBounds(191, 143, 120, 20);
		btnVolver.addActionListener(this);
		getContentPane().add(btnVolver);

		this.btnModificarProveedor=new JButton();
		this.btnModificarProveedor.setText("Pagar");
		this.btnModificarProveedor.setBounds(53, 143, 86, 20);
		btnModificarProveedor.setEnabled(false);
		btnModificarProveedor.addActionListener(this);

		getContentPane().add(btnModificarProveedor);
		
		JLabel label = new JLabel(String.valueOf(fac.getTotalCompra()));
		label.setBounds(135, 23, 104, 16);
		getContentPane().add(label);
		
		Vueltas = new JLabel("Vueltas");
		Vueltas.setBounds(55, 97, 56, 16);
		getContentPane().add(Vueltas);
		
		valorVueltas = new JLabel("0");
		valorVueltas.setBounds(147, 97, 56, 16);
		getContentPane().add(valorVueltas);
	}
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==btnVolver){
			VentanaCompras ventana = new VentanaCompras(persona);
        	ventana.setVisible(true);
            dispose();
		}

		if(e.getSource()==btnModificarProveedor){
			
		}
	}



}