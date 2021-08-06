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

public class PantallaGrafica extends JFrame implements ActionListener
{   
    private ColeccionProductos col =  new ColeccionProductos();
    public PantallaGrafica()
    {
        col.cargarProductos();
        iniciarComponentes();
    }
    
    public void iniciarComponentes()
    {
        setBounds(200, 100, 600, 480);
        setTitle("Bienvenidos a las interfaces gráficas Java");
        setLayout(null);
        
        JLabel lblTitulo = new JLabel("MENU PRINCIPAL");
        JTabbedPane pestaña=new JTabbedPane();
        JPanel p1=new JPanel();
        lblTitulo.setBounds(50, 50, 200, 30);
        p1.add(lblTitulo);
        JPanel p2=new JPanel();
        pestaña.addTab("Pestaña Uno", p1);
        pestaña.addTab("Pestaña Uno", p2);
        pestaña.setBounds(0, 30, 600, 400);
        add(pestaña);        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e)
    {
        JOptionPane.showMessageDialog(null, "Productos");
    }
}