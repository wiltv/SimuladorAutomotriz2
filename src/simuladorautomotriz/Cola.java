/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package simuladorautomotriz;

/**
 *
 * @author wiltsson
 */
public class Cola {
    private Vehiculo head;
    private Vehiculo tail;
    private int size;
    
    public Cola() {
        this.head = this.tail = null;
        this.size = 0;
    }
    
    public void Vacio() {
        this.head = this.tail = null;
        this.size = 0;
    }
    
    public boolean esVacia() {
        if (head == null){
            return true;
        }else{
            return false;
        }
    }
    
    
    public void Encolar(Vehiculo vehiculo) {
        if (this.esVacia()) {
            this.head = this.tail = vehiculo;
        } else {
            this.tail.setNext(vehiculo);
            this.tail = vehiculo;
        }
        size++;
    }
    
    public Vehiculo Desencolar() {
        Vehiculo newVehiculo = null;
        switch (this.size) {
            case 0:
                break;
            case 1:
                newVehiculo = this.head;
                this.Vacio();
                break;
            default:
                newVehiculo = this.head;
                head = head.getNext();
                size--;
                break;
        }
        return newVehiculo;
    }
    
    public void EncolarVehiculo(Vehiculo vehiculo) {
        if (this.esVacia()) {
            this.head = this.tail = vehiculo;
        } else {
            this.tail.setNext(vehiculo);
            this.tail = vehiculo;
        }
        size++;
    }
    
    public String PrintCola(){
        String string = "";
        for (int i = 0; i < size; i++) {
            Vehiculo vehiculo = this.Desencolar();
            vehiculo.setNext(null);
            if (i == 0) {
                string = Integer.toString(vehiculo.getID());
            }else{
                string += "->" + Integer.toString(vehiculo.getID());
            }
            this.EncolarVehiculo(vehiculo);
        }
        return string;
    }
}
