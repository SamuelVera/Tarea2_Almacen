package tarea2_samuelvera;

import java.util.Random;

public class NoPerecedero extends Alimento{
    
    Random rand = new Random();
    
    public NoPerecedero(int cantidad, String proveedor) {
        super(cantidad, proveedor);
        setNombre(); //Elección del nombre
    }
    public int getFVence(){
        return 0;
    }
    @Override
    public void setNombre(){ //Nombre y su precio acorde
        this.aux = rand.nextInt(4);
        if(aux == 0){
            this.nombre = "Latas de Atun";
            this.precio = 100;
        }else if(aux == 1){
            this.nombre = "Latas de Maiz";
            this.precio = 50;
        }else if(aux == 2){
            this.nombre = "Salsa de Tomate";
            this.precio = 30;
        }else{
            this.nombre = "Enlatado de Vegetales Genero";
            this.precio = 30;
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
    public int getCantidad() {
        return this.cantidad;
    }
    @Override
    public float getPrecio() {
        return this.precio;
    }
}
