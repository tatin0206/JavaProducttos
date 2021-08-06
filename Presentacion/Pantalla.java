package Presentacion;
import javax.swing.JOptionPane;
import Logica.ColeccionProductos;
import Logica.Producto;

public class Pantalla
{
    private ColeccionProductos col = new ColeccionProductos();
    
    public void presentarMenu()
    {
        col.cargarProductos();
        String [] opciones = {"Listar productos",
                            "Ingresar nuevo producto",
                            "Modificar datos del producto",
                            "Borrar producto",
                            "Salir" };
        
        do
        {
            String opcion = (String)JOptionPane.showInputDialog(null,
                                                                "Seleccione una opción",
                                                                "MENU PRINCIPAL",
                                                                JOptionPane.DEFAULT_OPTION, 
                                                                null,
                                                                opciones, 
                                                                opciones[0]);
            if (opcion.equals(opciones[0]))
            {
                if(col.getSize() == 0)
                {
                    JOptionPane.showMessageDialog(null, "No hay productos registrados");
                }
                
                else
                {
                    String mensaje = "";
                    for (int i = 0; i < col.getSize(); i++)
                    {
                        Producto p = col.getProducto(i);
                        mensaje = mensaje + i + ") " + p.toString() + "\n";
                    }
                    JOptionPane.showMessageDialog(null, mensaje);
                }
            }
            
            else if (opcion.equals(opciones[1]))
            {
                String nombre = JOptionPane.showInputDialog(null, "Ingrese nombre del producto");
                int cantidad = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese cantidad del producto"));
                String categoria = JOptionPane.showInputDialog(null, "Ingrese la categoria del producto");
                double precio = Double.parseDouble(JOptionPane.showInputDialog(null, "Ingrese precio del producto"));
                Producto p = new Producto(nombre, cantidad, categoria, precio);
                boolean guardado = col.guardarProducto(p);
                if (guardado == true)
                {
                    JOptionPane.showMessageDialog(null, "Producto agregado");
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Producto no guardado");
                }
            }
            
            else if (opcion.equals(opciones[2]))
            {
                int index = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese posición del producto"));
                if (index <0 || index > col.getSize() - 1)
                {
                    JOptionPane.showMessageDialog(null, "No se puede modificar");
                }
                else 
                {
                    Producto p = col.getProducto(index);
                    String nombre = JOptionPane.showInputDialog(null, "Ingrese nombre del producto para modificar",p.getNombre());
                    int cantidad = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese cantidar del producto para modificar",p.getCantidad()));
                    String categoria = JOptionPane.showInputDialog(null, "Ingrese categoria del producto para modificar",p.getCategoria());
                    double precio = Double.parseDouble(JOptionPane.showInputDialog(null, "Ingrese precio del producto a modificar", p.getPrecio()));
                    p.setNombre(nombre);
                    p.setCantidad(cantidad);
                    p.setCategoria(categoria);
                    col.actualizarProducto(index, p);
                    JOptionPane.showMessageDialog(null, "Producto actualizado");
                }                
            }
            else if (opcion.equals(opciones[3]))
            {
                int index = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese posición del producto a borrar"));
                if (index <0 || index > col.getSize() - 1)
                {
                    JOptionPane.showMessageDialog(null, "No se puede borrar");
                }
                else
                {
                    col.borrarProducto(index);
                    JOptionPane.showMessageDialog(null, "Vehiculo borrado");
                }
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Programa terminado");
                break;
            }
        }
        while (true);
    }
    
}