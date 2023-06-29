/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package simuladorautomotriz;

import java.util.concurrent.TimeUnit;
import java.util.Random;
/**
 *
 * @author wiltsson
 */
public class SimuladorAutomotriz {
    
    public static volatile Integer victorias = 0;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        
       
        
        Cola colaNv1 = new Cola();
        Cola colaNv2 = new Cola();
        Cola colaNv3 = new Cola();
        Cola refuerzo = new Cola();
        int revision = 1;
        
        int ganador = 0;
        int ids = 11;
        int count = 0;
        
        while(count<10){
            Vehiculo vehiculo = new Vehiculo(count+1);
            if (vehiculo.getPrioridad()==1){
                colaNv1.Encolar(vehiculo);
            }else if(vehiculo.getPrioridad()==2){
                colaNv2.Encolar(vehiculo);
            }else{
                colaNv3.Encolar(vehiculo);
            }
            count++;
        }
        
        
       
        Boolean terminar = false;
        
        while (terminar ==false){
            
            
            
            
            String Nv11 = colaNv1.PrintCola();
            System.out.println(Nv11);
            IA ia = new IA();
            Administrador administrador = new Administrador();
            
            if (colaNv1.esVacia() == false){
                ganador = ia.resultado(colaNv1,refuerzo,ganador);
            }else{
                if (colaNv2.esVacia() == false){
                    ganador = ia.resultado(colaNv2,refuerzo,ganador);
                }else{
                    if(colaNv3.esVacia() == false){
                        ganador = ia.resultado(colaNv3,refuerzo,ganador);
                    }else{
                        System.out.println("Se acabo");
                        terminar = true;
                    }
                }
            }
            
            
            
            
            
            if (revision%2 == 0){
                Random random = new Random(); 
                int nuevo = random.nextInt(100);
                if(nuevo>20){
                    Vehiculo vehiculo = administrador.crearVehiculo(ids);
                    ids++;
                    if (vehiculo.getPrioridad()==1){
                        colaNv1.Encolar(vehiculo);
                    }else if(vehiculo.getPrioridad()==2){
                        colaNv2.Encolar(vehiculo);
                    }else{
                        colaNv3.Encolar(vehiculo);
                    }
                }else{
                    System.out.println("No se creo");
                }
            }else{
                System.out.println("Admin atento");
            }
            
            revision++;
            
            String Nv1 = colaNv1.PrintCola();
            System.out.println(Nv1);
            String Nv2 = colaNv2.PrintCola();
            System.out.println(Nv2);
            String Nv3 = colaNv3.PrintCola();
            System.out.println(Nv3);
            String R = refuerzo.PrintCola();
            System.out.println(R);
            System.out.println("  ");
            
            TimeUnit.MILLISECONDS.sleep(1000);
            
        }
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    }
    
}
