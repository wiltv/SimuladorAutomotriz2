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
    
    public void Contator(Cola cola1,Cola cola2,Cola cola3) {
        Cola aux = new Cola();
        for (int i = 0; i < cola1.size; i++) {
            String x = cola1.PrintCola();
            System.out.println(x);
                    
            Vehiculo auxVehiculo = cola1.Desencolar();
            auxVehiculo.setContador(auxVehiculo.getContador() + 1);
            auxVehiculo.setNext(null);
            cola1.Encolar(auxVehiculo);
            String y = cola1.PrintCola();
            System.out.println(y);
            System.out.println("Se aumento " + i + " vez");
        }
        aux.Vacio();
        
        
        
        
        for (int i = 0; i < cola2.size; i++) {
            
            Vehiculo auxVehiculo = cola2.Desencolar();
            auxVehiculo.setContador(auxVehiculo.getContador() + 1);
            auxVehiculo.setNext(null);
            
            
            if (auxVehiculo.getContador() < 8) {
                    cola2.Encolar(auxVehiculo);
                }else{
                    auxVehiculo.setContador(0);
                    cola1.Encolar(auxVehiculo);
                }
            
        }   
        
        
        for (int i = 0; i < cola3.size; i++) {
            
            Vehiculo auxVehiculo = cola3.Desencolar();
            auxVehiculo.setContador(auxVehiculo.getContador() + 1);
            auxVehiculo.setNext(null);
            
            
            if (auxVehiculo.getContador() < 8) {
                    cola3.Encolar(auxVehiculo);
                }else{
                    auxVehiculo.setContador(0);
                    cola2.Encolar(auxVehiculo);
                }
            
        }   
            
        
    }
    
}
