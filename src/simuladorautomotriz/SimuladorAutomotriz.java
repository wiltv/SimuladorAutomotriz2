/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package simuladorautomotriz;

import java.io.File;
import java.util.concurrent.TimeUnit;
import java.util.Random;
//import javafx.scene.media.Media;
//import javafx.scene.media.MediaPlayer;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
/**
 *
 * @author wiltsson
 */
public class SimuladorAutomotriz {
    
    public static volatile Integer victorias = 0;
    public static volatile Integer velocidad = 5000;
    public static volatile Integer ganB = 0;
    public static volatile Integer ganL = 0;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        
        simulador interfaz = new simulador();
        interfaz.setLocationRelativeTo(null);
        interfaz.setVisible(true);
        
        try {
            File file = new File("src/Mario.wav");
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(file);
            Clip clip = AudioSystem.getClip();
            clip.open(audioIn);
            clip.start();
          } catch (Exception e) {
            e.printStackTrace();
          }
       
        
        Cola colaNv1B = new Cola();
        Cola colaNv2B = new Cola();
        Cola colaNv3B = new Cola();
        Cola refuerzoB = new Cola();
        int revisionB = 1;
        
        int ganador = 0;
        int idsB = 11;
        int countB = 0;
        
        Cola colaNv1L = new Cola();
        Cola colaNv2L = new Cola();
        Cola colaNv3L = new Cola();
        Cola refuerzoL = new Cola();
        int revisionL = 1;
        
        int idsL = 1011;
        int countL = 1000;
        
        simulador.ganadasBugatti.setText(String.valueOf(SimuladorAutomotriz.ganB));
        simulador.ganadasLambo1.setText(String.valueOf(SimuladorAutomotriz.ganL));
        simulador.accion.setText(String.valueOf(velocidad));
        
        while(countB<10){
            Vehiculo vehiculo = new Vehiculo(countB+1);
            if (vehiculo.getPrioridad()==1){
                colaNv1B.Encolar(vehiculo);
            }else if(vehiculo.getPrioridad()==2){
                colaNv2B.Encolar(vehiculo);
            }else{
                colaNv3B.Encolar(vehiculo);
            }
            countB++;
        }
        while(countL<1010){
            Vehiculo vehiculo = new Vehiculo(countL+1);
            if (vehiculo.getPrioridad()==1){
                colaNv1L.Encolar(vehiculo);
            }else if(vehiculo.getPrioridad()==2){
                colaNv2L.Encolar(vehiculo);
            }else{
                colaNv3L.Encolar(vehiculo);
            }
            countL++;
        }
        
        
       
        Boolean terminar = false;
        
        while (terminar ==false){
            
            
            
            
            
            IA ia = new IA();
            Administrador administrador = new Administrador();
            
            if (colaNv1B.esVacia() == false){
                if (colaNv1L.esVacia() == false){
                    ganador = ia.resultado(colaNv1B,colaNv1L,refuerzoB,refuerzoL,ganador,colaNv1B,colaNv1L);

                }else{
                    if (colaNv2L.esVacia() == false){
                        ganador = ia.resultado(colaNv1B,colaNv2L,refuerzoB,refuerzoL,ganador,colaNv1B,colaNv1L);

                    }else{
                        if(colaNv3L.esVacia() == false){
                            ganador = ia.resultado(colaNv1B,colaNv3L,refuerzoB,refuerzoL,ganador,colaNv1B,colaNv1L);

                        }else{
                            System.out.println("Se acabo");
                            terminar = true;
                        }
                    }
                }
                
                
                
                
                
                
               
                
                
            }else{
                if (colaNv2B.esVacia() == false){
                    if (colaNv1L.esVacia() == false){
                        ganador = ia.resultado(colaNv2B,colaNv1L,refuerzoB,refuerzoL,ganador,colaNv1B,colaNv1L);

                    }else{
                        if (colaNv2L.esVacia() == false){
                            ganador = ia.resultado(colaNv2B,colaNv2L,refuerzoB,refuerzoL,ganador,colaNv1B,colaNv1L);

                        }else{
                            if(colaNv3L.esVacia() == false){
                                ganador = ia.resultado(colaNv2B,colaNv3L,refuerzoB,refuerzoL,ganador,colaNv1B,colaNv1L);

                            }else{
                                System.out.println("Se acabo");
                                terminar = true;
                            }
                        }
                    }
                    
                    
                    
                    
                    
                    
                    
                }else{
                    if(colaNv3B.esVacia() == false){
                        if (colaNv1L.esVacia() == false){
                            ganador = ia.resultado(colaNv3B,colaNv1L,refuerzoB,refuerzoL,ganador,colaNv1B,colaNv1L);

                        }else{
                            if (colaNv2L.esVacia() == false){
                                ganador = ia.resultado(colaNv3B,colaNv2L,refuerzoB,refuerzoL,ganador,colaNv1B,colaNv1L);

                            }else{
                                if(colaNv3L.esVacia() == false){
                                    ganador = ia.resultado(colaNv3B,colaNv3L,refuerzoB,refuerzoL,ganador,colaNv1B,colaNv1L);

                                }else{
                                    System.out.println("Se acabo");
                                    terminar = true;
                                }
                            }
                        }
                        
                        
                        
                        
                    }else{
                        System.out.println("Se acabo");
                        terminar = true;
                    }
                }
            }
            
            
            
            Administrador administrador2 = new Administrador();
       
            
            
            
            if (revisionB%2 == 0){
                Random random = new Random(); 
                int nuevo = random.nextInt(100);
                if(nuevo>20){
                    Vehiculo vehiculo = administrador.crearVehiculo(idsB);
                    idsB++;
                    if (vehiculo.getPrioridad()==1){
                        colaNv1B.Encolar(vehiculo);
                    }else if(vehiculo.getPrioridad()==2){
                        colaNv2B.Encolar(vehiculo);
                    }else{
                        colaNv3B.Encolar(vehiculo);
                    }
                }else{
                    System.out.println("No se creo");
                }
            }else{
                System.out.println("Admin atento");
            }
            
            revisionB++;
            
            if (revisionL%2 == 0){
                Random random = new Random(); 
                int nuevo = random.nextInt(100);
                if(nuevo>20){
                    Vehiculo vehiculo = administrador2.crearVehiculo(idsL);
                    idsL++;
                    if (vehiculo.getPrioridad()==1){
                        colaNv1L.Encolar(vehiculo);
                    }else if(vehiculo.getPrioridad()==2){
                        colaNv2L.Encolar(vehiculo);
                    }else{
                        colaNv3L.Encolar(vehiculo);
                    }
                }else{
                    System.out.println("No se creo");
                }
            }else{
                System.out.println("Admin atento");
            }
            
            revisionL++;
            
            String Nv1 = colaNv1B.PrintCola();
            simulador.colaBugatti1.setText(String.valueOf(Nv1));
            String Nv2 = colaNv2B.PrintCola();
            simulador.colaBugatti2.setText(Nv2);
            String Nv3 = colaNv3B.PrintCola();
            simulador.colaBugatti3.setText(Nv3);
            String R = refuerzoB.PrintCola();
            
            simulador.colaBugattiRef.setText(R);
            
            String Nv1L  = colaNv1L.PrintCola();
            simulador.colaLambo1.setText(String.valueOf(Nv1L));
            String Nv2L = colaNv2L.PrintCola();
            simulador.colaLambo2.setText(Nv2L);
            String Nv3L = colaNv3L.PrintCola();
            simulador.colaLambo3.setText(Nv3L);
            String L = refuerzoL.PrintCola();
            simulador.colaLamboRef.setText(L);
            
            Cola cola = new Cola();
            cola.Contator(colaNv1B,colaNv2B,colaNv3B);
            cola.Contator(colaNv1L,colaNv2L,colaNv3L);
            
            TimeUnit.MILLISECONDS.sleep(velocidad);
            
        }
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    }
    
}
