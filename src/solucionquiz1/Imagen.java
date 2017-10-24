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
public class Imagen {
    
    private int[][] imagen = new int[50][50];
    private String nombre;
    private boolean activo;
    
    

            
    public Imagen(String n){
        
        nombre = n;
        
        for (int i = 0; i < imagen.length; i++) {
            
            for (int j = 0; j < imagen.length; j++) {
                
                imagen[i][j] = 0;
            }
        }
        
    }

    public String getNombre() {
        return nombre;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    
    
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
    
    public int[][] getImagen() {
        return imagen;
    }

    public void setImagen(int[][] imagen) {
        this.imagen = imagen;
    }
    
    public void ModificarImg(){
        
        for (int i = 0; i < imagen.length; i++) {
            
            for (int j = 0; j < imagen.length; j++) {
                
                int numeroAleatorio = (int) (Math.random()*2+1);
                
                if(numeroAleatorio == 1){
                    imagen[i][j] = 0;
                }else{
                    imagen[i][j] = 1;
                }
                
            }
        }
        
    }
    
    public void MostrarImagen(){
        
        for (int i = 0; i < imagen.length; i++) {
            
            System.out.println("");
            
            for (int j = 0; j < imagen.length; j++) {
                System.out.print(imagen[i][j]);
            }
        }
    }
    
}
