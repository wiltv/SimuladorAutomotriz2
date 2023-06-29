/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package simuladorautomotriz;
import java.util.Arrays;
import java.util.Random;
import SimuladorAutomotriz.*;
/**
 *
 * @author wiltsson
 */
public class IA {
    
    public static volatile int[] ganadores = new int[30];
    
    
    public int resultado(Cola cola, Cola refuerzo,int ganador){
           Vehiculo vehiculo = cola.Desencolar();
           
           Random random = new Random(); 
           int valor = random.nextInt(100);
           
           if (valor<40){
               //Agarrar id
               ganadores[ganador] = vehiculo.getID();
               System.out.println("Gano");
               System.out.println(Arrays.toString(ganadores));
               ganador++;
               
               
           }else if(valor >=40 && valor<67){
               cola.Encolar(vehiculo);
               System.out.println("Empato");
           }else{
               System.out.println("Pospuesto");
               refuerzo.Encolar(vehiculo);
               String r = refuerzo.PrintCola();
               
           }
           return ganador;
           
           
    }
    
    
}
