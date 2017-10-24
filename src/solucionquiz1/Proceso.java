/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package solucionquiz1;

/**
 *
 * @author Jorge
 */
public class Proceso {
 
    private String nombre;
    private boolean active;
    private Usuario user;
    
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Proceso(String nombre, Usuario u) {
        this.nombre = nombre;
        this.active = false; //POR DEFECTO LOS PROCESOS NO ESTAN ACTIVOS
        user = u;
    }
    
    public void ejecutarProceso(){
        this.active = true;
    }
    
    public void desactivarProceso(){
        this.active = false;
    }
    
    public String  matarProceso(){
        return this.nombre; //RETORNA EL NOMBRE DEL PROCESO PARA LUEGO BUSCARLO EN MEMORIA Y ELIMINARLO
    }

    @Override
    public String toString() {
        return "Proceso{" + "nombre=" + nombre + '}';
    }
    
    
   
    
    
}
