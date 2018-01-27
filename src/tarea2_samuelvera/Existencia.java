package tarea2_samuelvera;

public class Existencia{
    private String producto, proveedor;
    private int existencias;
    private double precioUnidad;
    
    Existencia(String producto, int existencias, double precioUnidad, String proveedor){
        this.producto = producto;
        this.existencias = existencias;
        this.precioUnidad = precioUnidad;
        this.proveedor = proveedor;   
    }
    public String getProducto() {
        return producto;
    }
    public int getExistencias() {
        return existencias;
    }
    public double getPrecioUnidad() {
        return precioUnidad;
    }
    public String getProveedor() {
        return proveedor;
    }
    
}
