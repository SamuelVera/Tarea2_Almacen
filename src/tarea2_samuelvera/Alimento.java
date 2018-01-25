package tarea2_samuelvera;

public abstract class Alimento {
    protected String nombre, proveedor;
    protected int cantidad, aux, FVence;
    protected float precio;
    
        //Constructor
    Alimento(int cantidad, String proveedor){
        this.cantidad = cantidad;
        this.proveedor = proveedor;
    }
    
    public abstract String getNombre();
    public abstract String getProveedor();
    public abstract int getCantidad();
    public abstract float getPrecio();
    public abstract void setNombre();
    public abstract int getFVence();
}
