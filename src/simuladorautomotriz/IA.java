/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package simuladorautomotriz;
import java.util.Arrays;
import java.util.Random;
/**
 *
 * @author wiltsson
 */
public class IA {
    
    public static volatile int[] ganadores = new int[100];
    
    
    public int resultado(Cola colaB, Cola colaL, Cola refuerzoB, Cola refuerzoL,int ganador,Cola cola1B,Cola cola1L){
           Vehiculo vehiculoB = colaB.Desencolar();
           simulador.ai3.setText(String.valueOf(vehiculoB.getID()));
           Vehiculo vehiculoL = colaL.Desencolar();
           simulador.ai2.setText(String.valueOf(vehiculoL.getID()));
           
           Random random = new Random(); 
           int valor = random.nextInt(100);
           
           if (valor<40){
               //Agarrar id
               
               
               Random randomG = new Random(); 
               int valorG = randomG.nextInt(100);
               
               if (valorG<50){ //BONO SE PODRIA MEJORAR
                   ganadores[ganador] = vehiculoB.getID();
                   simulador.ganador.setText(String.valueOf(vehiculoB.getID()));
                   SimuladorAutomotriz.ganB = SimuladorAutomotriz.ganB +1;
                   simulador.ganadasBugatti.setText(String.valueOf(SimuladorAutomotriz.ganB));
                   
               }else{
                   ganadores[ganador] = vehiculoL.getID();
                    simulador.ai2.setText(String.valueOf(vehiculoB.getID()));
                    SimuladorAutomotriz.ganL = SimuladorAutomotriz.ganL +1;
                    simulador.ganadasLambo1.setText(String.valueOf(SimuladorAutomotriz.ganL));
               }
               
               
               System.out.println("Gano");
               simulador.accion.setText(String.valueOf("Gano"));
               System.out.println(Arrays.toString(ganadores));
               
               ganador++;
               
               
           }else if(valor >=40 && valor<67){
               cola1B.Encolar(vehiculoB);
               cola1L.Encolar(vehiculoL);
               System.out.println("Empato");
               simulador.accion.setText(String.valueOf("Empato"));
           }else{
               System.out.println("Pospuesto");
               refuerzoB.Encolar(vehiculoB);
               refuerzoL.Encolar(vehiculoL);
               simulador.accion.setText(String.valueOf("Pospuesto"));
               
           }
           
           
           
           if (refuerzoB.esVacia()== false){
                Random randomB = new Random(); 
                int valorB = randomB.nextInt(100);

                if (valorB>60){
                    Vehiculo vB = refuerzoB.Desencolar();
                    cola1B.Encolar(vB);

                } else{
                    System.out.println("B no se encolo");
                }
           }else{
               System.out.println("Vacia");
           }
           
           if (refuerzoL.esVacia()== false){
                Random randomL = new Random(); 
                int valorL = randomL.nextInt(100);


                if (valorL>60){
                    Vehiculo vL = refuerzoL.Desencolar();
                    cola1L.Encolar(vL);

                } else{
                    System.out.println("L no se encolo");
                }

                
           }
           
           
           
           return ganador;
    }

    
}
