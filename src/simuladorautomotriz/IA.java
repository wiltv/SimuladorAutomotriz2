/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package simuladorautomotriz;
import java.awt.Color;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
/**
 *
 * @author wiltsson, Valeria
 */
public class IA {
    
    public static volatile int[] ganadores = new int[100];
    
    
    public int resultado(Cola colaB, Cola colaL, Cola refuerzoB, Cola refuerzoL,int ganador,Cola cola1B,Cola cola1L){
           Vehiculo vehiculoB = colaB.Desencolar();
           simulador.ai1.setText(String.valueOf(vehiculoB.getID()));
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
                   simulador.ai1.setBackground(Color.green);
                   simulador.ai2.setBackground(Color.red);
                   
               }else{
                   ganadores[ganador] = vehiculoL.getID();
                    simulador.ai2.setText(String.valueOf(vehiculoB.getID()));
                    SimuladorAutomotriz.ganL = SimuladorAutomotriz.ganL +1;
                    simulador.ganadasLambo1.setText(String.valueOf(SimuladorAutomotriz.ganL));
                    simulador.ai2.setBackground(Color.green);
                   simulador.ai1.setBackground(Color.red);
               }
               
               
               System.out.println("Gano");
               simulador.accion.setText(String.valueOf("Gano"));
               System.out.println(Arrays.toString(ganadores));
               
               // Obtenemos el contenido actual del TextArea
               String contenidoActual = simulador.listaGanadores.getText();

               // Creamos una variable para concatenar los elementos
               String elementos = "";
               // Recorremos el arreglo con un ciclo for
               for (int i = 0; i < ganadores.length; i++) {
                   // Verificamos si el elemento es diferente de cero
                   if (ganadores[i] != 0) {
                       // Concatenamos el elemento a la cadena
                       if (elementos.isEmpty()) {
                           elementos += ganadores[i];
                       } else {
                           elementos += " --> " + ganadores[i];
                       }
                   }
               }

               // Verificamos si el TextArea está vacío
               if (contenidoActual.isEmpty()) {
                   // Si está vacío, establecemos el contenido con la cadena de elementos
                   simulador.listaGanadores.setText(elementos);
               } else {
                   // Si no está vacío, concatenamos los nuevos elementos al contenido actual
                   String nuevoContenido = contenidoActual + elementos;
                   simulador.listaGanadores.setText(nuevoContenido);
               }
               
               ganador++;
               
           }else if(valor >=40 && valor<67){
               cola1B.Encolar(vehiculoB);
               cola1L.Encolar(vehiculoL);
               System.out.println("Empato");
               simulador.accion.setText(String.valueOf("Empato"));
               simulador.ai2.setBackground(Color.white);
               simulador.ai1.setBackground(Color.white);
           }else{
               System.out.println("Pospuesto");
               refuerzoB.Encolar(vehiculoB);
               refuerzoL.Encolar(vehiculoL);
               simulador.accion.setText(String.valueOf("Pospuesto"));
               simulador.ai2.setBackground(Color.yellow);
               simulador.ai1.setBackground(Color.yellow);
               
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
