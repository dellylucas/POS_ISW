package Interfaz;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

import ConexionBD.Dao_Empleado;
import ConexionBD.Dao_Producto;
import ConexionBD.Dao_Proveedor;
import Modelo.*;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JInternalFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.Font;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import net.miginfocom.swing.MigLayout;


public class VentanaCompras extends JFrame implements ActionListener {
    private JMenuBar menu;
    private JMenu caja;
    private JMenu salir;
    private JMenu menProductos;
    private JMenuItem salirInt;
    private JMenuItem Compras;

    private Dao_Producto daoProduct;
    private Dao_Empleado daoEmpleado;
    private Dao_Proveedor daoProveedor;

    private JMenuItem cerrarSesion;
    private JLabel label;
    private Persona usuario;
    private Tienda tienda;
    private DefaultTableModel modelo;
    private  JLabel lblMostraTotal;
    private JTable table;
    private JMenuItem mntmQuitar;
    private  ArrayList<Compra> lista;
    private Factura factura;
    private  Compra getP; 

    public VentanaCompras(Persona persona) {
        super();
        switch (persona.getRol()) {
        case 2:
            usuario = new Administrador(persona);
            break;
        case 3:
            usuario = new Empleado(persona);
            break;
    }
        //Singleton Una tienda
        factura = new Factura();
        tienda = Fachada.getInstance(usuario);
        lista = new ArrayList<Compra>();
       lista = tienda.getLstCompra();
      
       
        this.setTitle(usuario.getNombre() + "(" + usuario.toString() + ") - SuperMercado " + tienda.getNombre());
        this.setSize(750, 400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.crearMenu();
     
      
    }

    private void crearMenu() {
        
        // Column Names 
        String[] columnNames = { "Id", "Nombre", "U/Disponibles", "Precio" , "proveedor"}; 
    menu = new JMenuBar();
    setJMenuBar(menu);

    menProductos = new JMenu("Productos");
    menProductos.addActionListener(this);
    menu.add(menProductos);
    
    salir = new JMenu("Opciones");
    salir.addActionListener(this);
    menu.add(salir);
    
    
    Compras = new JMenuItem("Agregar");
    Compras.addActionListener(this);
    menProductos.add(Compras);
    
    salirInt = new JMenuItem("Atras");
    salirInt.addActionListener(this);
    salir.add(salirInt);
    
    GridBagLayout gridBagLayout = new GridBagLayout();
    gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 1.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
    gridBagLayout.rowWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
    getContentPane().setLayout(gridBagLayout);
    
    JLabel lblNewLabel_3 = new JLabel("Busqueda");
    GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
    gbc_lblNewLabel_3.gridwidth = 3;
    gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
    gbc_lblNewLabel_3.gridx = 2;
    gbc_lblNewLabel_3.gridy = 0;
    getContentPane().add(lblNewLabel_3, gbc_lblNewLabel_3);
    
    JTextField txtBusqueda = new JTextField();
   
    JLabel lblNewLabel_1 = new JLabel("Total");
    lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
    GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
    gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 0);
    gbc_lblNewLabel_1.gridx = 22;
    gbc_lblNewLabel_1.gridy = 4;
    getContentPane().add(lblNewLabel_1, gbc_lblNewLabel_1);
    
     lblMostraTotal = new JLabel("0");
     lblMostraTotal.setFont(new Font("Tahoma", Font.BOLD, 16));
    GridBagConstraints gbc_lblMostraTotal = new GridBagConstraints();
    gbc_lblMostraTotal.insets = new Insets(0, 0, 5, 0);
    gbc_lblMostraTotal.gridx = 22;
    gbc_lblMostraTotal.gridy = 5;
    getContentPane().add(lblMostraTotal, gbc_lblMostraTotal);
    
    JButton btnAgrega = new JButton("Facturar");
    GridBagConstraints gbc_btnAgrega = new GridBagConstraints();
    gbc_btnAgrega.insets = new Insets(0, 0, 5, 0);
    gbc_btnAgrega.gridx = 22;
    gbc_btnAgrega.gridy = 7;
    btnAgrega.addActionListener(this);
    getContentPane().add(btnAgrega, gbc_btnAgrega);
    
    GridBagConstraints gbc_txtBusqueda = new GridBagConstraints();
    gbc_txtBusqueda.gridwidth = 12;
    gbc_txtBusqueda.insets = new Insets(0, 0, 5, 5);
    gbc_txtBusqueda.fill = GridBagConstraints.HORIZONTAL;
    gbc_txtBusqueda.gridx = 5;
    gbc_txtBusqueda.gridy = 0;
    getContentPane().add(txtBusqueda, gbc_txtBusqueda);
    txtBusqueda.setColumns(10);
    
    modelo = new DefaultTableModel(0, columnNames.length) ;
    modelo.setColumnIdentifiers(columnNames);
    obtenerProductos();
    table = new JTable (modelo);
    table.setBorder(new LineBorder(Color.gray));
    table.setBounds(30, 40, 200, 300); 
    GridBagConstraints gbc_table = new GridBagConstraints();
    gbc_table.gridwidth = 20;
    gbc_table.gridheight = 9;
    gbc_table.insets = new Insets(0, 0, 0, 5);
    gbc_table.fill = GridBagConstraints.BOTH;
    gbc_table.gridx = 1;
    gbc_table.gridy = 1;
    
    JScrollPane sp = new JScrollPane(table); 
    table.addMouseListener(new MouseAdapter() {
    	


		@Override
		public void mousePressed(MouseEvent e) {
		
		
		}
    });
    getContentPane().add(sp);        
    getContentPane().add(sp, gbc_table);
    
   

}

    public void obtenerProductos() {
		Object O[]=null;
		factura.setTotalCompra(0);
		for (int i = 0; i < lista.size(); i++) {

			Compra getP = (Compra) lista.get(i);
			O=new Object[] {getP.getProducto().getId(),
					getP.getProducto().getNombre(),
					getP.getCantidad(),
					getP.getProducto().getPrecioVenta(),
					getP.getValorTotal()
					};
			int tes = factura.getTotalCompra()+ getP.getValorTotal();
			factura.setTotalCompra(tes);
			 modelo.addRow (O);
			
			 }
		  lblMostraTotal.setText(String.valueOf(factura.getTotalCompra() ));
	}
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == salir || e.getSource() ==  salirInt) {
            VentanaUsuario ventana = new VentanaUsuario(usuario);
            ventana.setVisible(true);
            dispose();
        }
        //agregar compra
        if (e.getSource() == Compras ) {
        	VentanaAgregarCompra agregar = new VentanaAgregarCompra(usuario);
        	agregar.setVisible(true);
        	dispose();
        }
        
    }



    public Persona getPerona() {
    	return this.usuario;
    	
    }
}