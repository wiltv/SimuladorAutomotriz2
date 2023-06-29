/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package simuladorautomotriz;
import java.util.Random;
/**
 *
 * @author wiltsson
 */
public class Vehiculo {
    private Vehiculo next;
    private int ID;
    private int prioridad;
    private int contador;
    
    
    public int Prioridad() {
        int prioridad = 0;
        Random random = new Random(); 
        int carroceria = random.nextInt(100); 
        if (carroceria>=40){ //Carroceria
            prioridad++;
        }
        int chasis = random.nextInt(100); 
        if (chasis>=30){ //Chasis
            prioridad++;
        }
        int motor = random.nextInt(100); 
        if (motor>=50){ //Motor
            prioridad++;
        }
        int rueda = random.nextInt(100); 
        if (rueda>=60){ //Rueda
            prioridad++;
        }
        
        if(prioridad<2){
            prioridad = 3;
        }else if(prioridad==2){
            prioridad = 2;
        }else{
            prioridad = 1;
        }
        return prioridad;
    }
    
    
    public Vehiculo(int ID) {
        this.ID = ID;
        this.prioridad = this.Prioridad();
        this.contador = 0;
    }
    
    public Vehiculo getNext() {
        return next;
    }

    public void setNext(Vehiculo next) {
        this.next = next;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }
    
    
}
