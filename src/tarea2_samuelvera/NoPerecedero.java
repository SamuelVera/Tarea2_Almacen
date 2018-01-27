package tarea2_samuelvera;


public class NoPerecedero extends Alimento{
    
    public NoPerecedero(String nombre) {
        super(nombre);
        setProveedorPrecioCosto();
    }
    @Override
    public void setProveedorPrecioCosto(){ //Nombre y su precio acorde
        if(this.nombre == "Enlatado de carne"){
            this.proveedor = "Kreft";
            this.costo = 8;
            this.precio = 30;
        }else if(this.nombre == "Enlatado de pollo"){
            this.proveedor = "Hainz";
            this.costo = 10;
            this.precio = 40;
        }else if(this.nombre == "Vegetales en lata"){
            this.proveedor = "Abastos Co";
            this.costo = 20;
            this.precio = 60;
        }
    }
    @Override
    public String getNombre() {
        return this.nombre;
    }
    @Override
    public String getProveedor() {
        return this.proveedor;
    }
    @Override
    public double getPrecio() {
        return this.precio;
    }
    @Override
    public double getCosto(){
        return this.costo;
    }
}