package Presentacion;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import Logica.ColeccionProductos;
import Logica.Producto;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.GridLayout;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.Dimension;
import javax.swing.table.DefaultTableModel;
import java.awt.FlowLayout;

public class PantallaGrafica extends JFrame implements ActionListener
{   
    JLabel lblnombre,lblcantidad,lblprecio, lblid ;
    JButton btneliminar,btnguardar;
    JTextField txtnombre,txtcantidad,txtprecio, txtid;
    String[] optionsToChoose = {"Aseo","Viveres"};
    
    
    
    private ColeccionProductos col =  new ColeccionProductos();
    public PantallaGrafica()
    {
        col.cargarProductos();
        iniciarComponentes();
    }
    
    public void iniciarComponentes()
    {
        setBounds(200, 100, 600, 900);
        setTitle("Bienvenidos a las interfaces gráficas Java");
        
        //recuadro para vidsualizar las pestañas
        JTabbedPane pestaña=new JTabbedPane();
        pestaña.setBounds(0, 0, 400, 300);  
        
        //<----pestaña 1 ---->
        
        //pestaña1
        JPanel p1=new JPanel();
        p1.setLayout(null);
        pestaña.addTab("Registrar", p1);
        
        //nombre
        lblnombre = new JLabel("nombre");
        txtnombre = new JTextField();
        lblnombre.setBounds(50, 50, 200, 30);
        txtnombre.setBounds(120, 50, 150, 20);
        p1.add(lblnombre);
        p1.add(txtnombre);
        
        //cantidad
        lblcantidad = new JLabel("cantidad");
        txtcantidad = new JTextField();
        lblcantidad.setBounds(50, 90, 200, 30);
        txtcantidad.setBounds(120, 90, 250, 21);
        p1.add(lblcantidad);
        p1.add(txtcantidad);
        
        //precio
        lblprecio = new JLabel("precio");
        txtprecio = new JTextField();
        lblprecio.setBounds(50, 130, 200, 30);
        txtprecio.setBounds(120, 130, 250, 21);
        p1.add(lblprecio);
        p1.add(txtprecio);
        
        //categoria
        JComboBox<String> jComboBox = new JComboBox<>(optionsToChoose);
        jComboBox.setBounds(50, 170, 140, 20);
        p1.add(jComboBox);
        
        //boton guardar
        btnguardar = new JButton("Guardar");
        btnguardar.setBounds(50,210,95,20);
        p1.add(btnguardar);
        
        //<----pestaña 2 ---->
        
        //pestaña2
        JPanel p2=new JPanel();        
        pestaña.addTab("Consultar", p2);
        p2.setBounds(0, 10, 150, 100);
        //p2.setLayout(null);
        //campo para la tabla
        p2.setLayout(new GridLayout(1, 0));
        
        //traer los campos para la tabla
        String [] columnas = col.armarColumnas();
        Object [][] datos = col.armarMatrizVehiculos();
        DefaultTableModel dtm = new DefaultTableModel(datos, columnas);
        
        //creacion de la tabla en pestaña2
        JTable tabla = new JTable(dtm);
        tabla.setPreferredScrollableViewportSize(new Dimension(600, 100));
        JScrollPane scroll = new JScrollPane(tabla);
        p2.add(scroll);
        
        
        //label y texbox de id
        JPanel p3=new JPanel();   
        p3.setBounds(0, 300, 200, 800);
        lblid = new JLabel("Id");
        txtid = new JTextField(5);
        lblid.setBounds(50, 50, 50, 30);
        txtid.setBounds(50, 75, 150, 20);
        lblid = new JLabel("Id");
        txtid = new JTextField(5);
        
        add(p3);
        p3.add(lblid);
        p3.add(txtid);
        
        add(pestaña);
        setLayout(null);  
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e)
    {
        JOptionPane.showMessageDialog(null, "Productos");
    }
}