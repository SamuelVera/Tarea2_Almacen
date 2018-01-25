/**
 * Universidad Metropolitana
 * Departamento de Sistemas
 * Estructuras de Datos
 * Preparaduría
 * Tarea 2
 */
package tarea2_samuelvera;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * Samuel Vera
 * CI: 26475783
 * Carnet: 20171110080
 * 
 */
public class Almacen {
    static Alimento alimentos[] = new Alimento[20];
    static int capacidad;
    static int dia; //1 = lunes, 2 = martes, 3 = miércoles, 4 = jueves, 5 = viernes
    static Random rand = new Random();
    static Scanner in = new Scanner(System.in);
        //Reporte de entradas del dia
    private static void entradas(){
        int aux, cantidad; 
        String prov1 = "Kroft.SA", prov2 = "Hanz.CA", prov3 = "Food.CA"; //Proveedores
        capacidad = 1000;
        System.out.println("INGRESOS DEL DIA "+dia);
        if(dia == 1 || dia == 2 || dia == 4){ //Ingreso de alimentos
            for(int i=0;i<alimentos.length;i++){
                aux = rand.nextInt(4); //Random auxiliar
                cantidad = rand.nextInt(100)+1; //Cantidad ingresada
                if(cantidad < capacidad && alimentos[i] == null){
                    aux = rand.nextInt(3);
                    if(dia == 2 || dia == 4){   //Dias que pueden ingresar los no perecederos
                        if(aux==1) alimentos[i] = new NoPerecedero(cantidad, prov1);
                        else alimentos[i] = new NoPerecedero(cantidad,prov2);
                        capacidad = capacidad - cantidad;
                    }else if(dia == 1 && aux < 2){ //Día lunes de ingreso de perecederos
                        alimentos[i] = new Perecedero(cantidad, prov3);
                        capacidad = capacidad - cantidad;
                    }
                }
                if(alimentos[i] != null){   //Impresión de los ingresos del día
                    System.out.println(alimentos[i].getCantidad()+" Cajas de "+alimentos[i].getNombre());
                    System.out.println("Proveedor: "+alimentos[i].getProveedor());
                    if(alimentos[i].getFVence() != 0){
                        System.out.println("Fecha de vencimiento:"+alimentos[i].getFVence());
                    }
                    System.out.println();
                }
                System.out.println("Capacidad restante del dia:"+capacidad);
                System.out.println();
            }
        }
    }
        //Reporte de salidas del día
    private static void salidas(){
        int aux;
        System.out.println("VENTAS DEL DIA "+dia);
        for(int i=0;i<alimentos.length;i++){ //Ventas del día
            if(alimentos[i] != null){
                if(alimentos[i].getFVence() == dia){ //Ventas antes del vencimiento
                    System.out.println(alimentos[i].getCantidad()+" Cajas de "+alimentos[i].getNombre());
                    System.out.println("Vendido: "+(alimentos[i].getCantidad()*alimentos[i].getPrecio()));
                    capacidad = capacidad + alimentos[i].getCantidad();
                    alimentos[i] = null;
                    System.out.println();
                }else if(dia == 5 && alimentos[i].getFVence()!=0){ //Venta de Perecedero el viernes
                    System.out.println(alimentos[i].getCantidad()+" Cajas de "+alimentos[i].getNombre());
                    System.out.println("Vendido: "+(alimentos[i].getCantidad()*alimentos[i].getPrecio()));
                    capacidad = capacidad + alimentos[i].getCantidad();
                    alimentos[i] = null;
                    System.out.println();
                }else{ //Caso Perecedero Normal y No Perecedero
                    aux = rand.nextInt(4);
                    if(aux == 2){
                        System.out.println(alimentos[i].getCantidad()+" Cajas de "+alimentos[i].getNombre());
                        System.out.println("Vendido: "+(alimentos[i].getCantidad()*alimentos[i].getPrecio()));
                        System.out.println();
                        capacidad = capacidad + alimentos[i].getCantidad();
                        alimentos[i] = null;
                    }
                }
                System.out.println(capacidad);
                System.out.println();
            }
        }
    }
        //Reporte del final de la semana
    private static void finalSemana(){
        System.out.println("Al finalizar la semana quedaron");
        for(int i=0;i<alimentos.length;i++){
            if(alimentos[i] != null){
                System.out.println(alimentos[i].getCantidad()+" Cajas de "+alimentos[i].getNombre());
                System.out.println();
            }
        }
    }
    private static void inicial(){
        for(int i=0;i<alimentos.length;i++){
            alimentos[i] = null;
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int confirma = 2;
        dia = 1;
        inicial();
        do{
            while(dia<=5){
                System.out.println("SIMULACION DEL DIA "+dia);
                entradas();
                if(dia>1) {
                    salidas();
                }
                dia++;
            }
            dia = 1;
            finalSemana();
            System.out.println("¿Comenzar simulación de la próxima semana?");
            while(confirma!=0 && confirma!=1){
                System.out.println("Si(1)/No(0)");
                confirma = in.nextInt();
                if(dia!=0 && dia!=1){
                    System.out.println("ERROR!!! Introduce una entrada válida");
                }
            }
        }while(confirma == 0);
    }
}
