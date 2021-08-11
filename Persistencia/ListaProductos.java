package Persistencia;
import java.util.ArrayList;
import Logica.Producto;
import java.text.DecimalFormat;

public class ListaProductos
{
    private ArrayList<Producto> lista = new ArrayList<Producto>();
    
    public ArrayList<Producto> getLista()
    {
        return lista;
    }
    
    private void setLista(ArrayList<Producto> lista)
    {
        this.lista = lista;
    }
    
    
    public Producto getProductolista(int index)
    {
        return lista.get(index);
    }
    
    public Object[] getProductoArray(int index)
    {
        DecimalFormat formateador = new DecimalFormat("$ #,###.##");
        Producto t = lista.get(index);
        
        Object[] terrenoArray = {t.getId(),t.getNombre(),t.getCantidad(),t.getCategoria() ,formateador.format(t.getPrecio())};
        return terrenoArray;
    }
    
    private void setTerreno(int index, Producto producto)
    {
        this.lista.set(index, producto);
    }
    
    private void addProducto(Producto producto)
    {
        this.lista.add(producto);
    }
    
    public void cargarProductosDeBD()
    {
        DAOTProductos dao = new DAOTProductos();
        if (dao.obtenerProductos2()) 
        {
            setLista(dao.getListaConsultada());    
        }
    }
    
    
    
    
    
    
    
}

