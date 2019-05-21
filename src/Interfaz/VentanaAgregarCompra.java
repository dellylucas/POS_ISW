package Interfaz;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
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
import javax.swing.JInternalFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.Font;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import net.miginfocom.swing.MigLayout;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JDesktopPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Insets;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class VentanaAgregarCompra extends JFrame implements ActionListener {
    private JMenuBar menu;
    private JMenu salir;
    private JMenuItem salirInt;

    private Dao_Producto daoProduct;
    private Dao_Empleado daoEmpleado;
    private Dao_Proveedor daoProveedor;

    private JMenuItem cerrarSesion;
    private Persona usuario;
    private Tienda tienda;
  
    private VentanaCompras ventanaAnt;
    private JPanel panel;
    private JTextField textField;
    private JLabel lblNewLabel;
    private JButton btnNewButton;
    private JLabel lblNewLabel_1;
    private JLabel lblNewLabel_2;
    private JTable table;
    private JLabel lblNewLabel_3;
    private JTextField textField_1;
    private Dao_Producto daoProducto;
    private DefaultTableModel modelo;
    private ArrayList<Producto> lista;
    private ArrayList<Proveedor> listaProvee;
    
    public VentanaAgregarCompra(VentanaCompras ventanaCompra) {
        super();
        ventanaAnt = ventanaCompra;
        daoProducto = new Dao_Producto();
        usuario = ventanaCompra.getPerona();
        tienda = Fachada.getInstance(usuario);
        
        tienda.setLstProductos(daoProducto.ConsultaTodos(tienda.getId()));
        lista = tienda.getLstProductos();
        listaProvee = tienda.getLstProveedor();
        
        this.setTitle(usuario.getNombre() + "(" + usuario.toString() + ") - Agrear Producto " );
        this.setSize(750, 400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.crearMenu();
        
 
                             
                                    
                                          // Initializing the JTable 
                                          /*
                                          j.setBounds(30, 40, 200, 300); 
                                          
                                                // adding it to JScrollPane 
                                                JScrollPane sp = new JScrollPane(j); 
                                                GridBagConstraints gbc_sp = new GridBagConstraints();
                                                gbc_sp.fill = GridBagConstraints.BOTH;
                                                gbc_sp.gridx = 0;
                                                gbc_sp.gridy = 0;
                                                getContentPane().add(sp, gbc_sp);*/
            
 
        
    
    }

    private void crearMenu() {
             
            // Column Names 
            String[] columnNames = { "Id", "Nombre", "U/Disponibles", "Precio" , "proveedor"}; 
        menu = new JMenuBar();
        setJMenuBar(menu);

        salir = new JMenu("Opciones");
        salir.addActionListener(this);
        menu.add(salir);
        
        salirInt = new JMenuItem("Atras");
        salirInt.addActionListener(this);
        salir.add(salirInt);
        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 1.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
        gridBagLayout.rowWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        getContentPane().setLayout(gridBagLayout);
        
        lblNewLabel_3 = new JLabel("New label");
        GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
        gbc_lblNewLabel_3.gridwidth = 3;
        gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_3.gridx = 2;
        gbc_lblNewLabel_3.gridy = 0;
        getContentPane().add(lblNewLabel_3, gbc_lblNewLabel_3);
        
        textField_1 = new JTextField();
        GridBagConstraints gbc_textField_1 = new GridBagConstraints();
        gbc_textField_1.gridwidth = 11;
        gbc_textField_1.insets = new Insets(0, 0, 5, 5);
        gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField_1.gridx = 6;
        gbc_textField_1.gridy = 0;
        getContentPane().add(textField_1, gbc_textField_1);
        textField_1.setColumns(10);
        
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
			
			JTable source = (JTable)e.getSource();
		            int row = source.rowAtPoint(e.getPoint() );
		            String s=source.getModel().getValueAt(row, 0)+"";

		            JOptionPane.showMessageDialog(null, s);
			}

	
        });
        getContentPane().add(sp);
        
        
        getContentPane().add(sp, gbc_table);
        

        
        lblNewLabel = new JLabel("New label");
        GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
        gbc_lblNewLabel.anchor = GridBagConstraints.SOUTH;
        gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
        gbc_lblNewLabel.gridx = 22;
        gbc_lblNewLabel.gridy = 1;
        getContentPane().add(lblNewLabel, gbc_lblNewLabel);
        
        textField = new JTextField();
        GridBagConstraints gbc_textField = new GridBagConstraints();
        gbc_textField.insets = new Insets(0, 0, 5, 0);
        gbc_textField.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField.gridx = 22;
        gbc_textField.gridy = 2;
        getContentPane().add(textField, gbc_textField);
        textField.setColumns(10);
        
        lblNewLabel_1 = new JLabel("New label");
        GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
        gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 0);
        gbc_lblNewLabel_1.gridx = 22;
        gbc_lblNewLabel_1.gridy = 4;
        getContentPane().add(lblNewLabel_1, gbc_lblNewLabel_1);
        
        lblNewLabel_2 = new JLabel("New label");
        GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
        gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 0);
        gbc_lblNewLabel_2.gridx = 22;
        gbc_lblNewLabel_2.gridy = 5;
        getContentPane().add(lblNewLabel_2, gbc_lblNewLabel_2);
        
        btnNewButton = new JButton("New button");
        GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
        gbc_btnNewButton.gridx = 22;
        gbc_btnNewButton.gridy = 9;
        getContentPane().add(btnNewButton, gbc_btnNewButton);

    }
	public void obtenerProductos() {
		Object O[]=null;
		for (int i = 0; i < lista.size(); i++) {

			 Producto getP = (Producto) lista.get(i);
			O=new Object[] {getP.getId(),
					getP.getNombre(),
					getP.getCantidad(),
					getP.getPrecioVenta(),
					"ads"
					};
			 modelo.addRow (O);
			 }
		
	}
	public void jTable1MouseClicked(java.awt.event.MouseEvent evt) {                                     
	     /*JTable source = (JTable)evt.getSource();
	            int row = source.rowAtPoint( evt.getPoint() );
	            int column = source.columnAtPoint( evt.getPoint() );
	            String s=source.getModel().getValueAt(row, column)+"";*/

	            JOptionPane.showMessageDialog(null, "rhdrbdfb");


	} 
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() ==  salirInt) {
        	ventanaAnt.setVisible(true);
            dispose();
        }
        
    }
}