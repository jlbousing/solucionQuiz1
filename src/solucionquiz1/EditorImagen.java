/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package solucionquiz1;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Jorge
 */
public class EditorImagen extends Editor{
    
    private ArrayList<Imagen> al;
    private Scanner sc = new Scanner(System.in);
    
    
    
    public EditorImagen(Proceso p, ArrayList<Imagen> i){
        super(p);
        al = i;
    }
    
    public void ejecutar(){
        
        boolean repeat = true;
        
        while(repeat){
            
            System.out.println("Ingrese la opcion deseada ");
            System.out.println("(1) Crear imagen");
            System.out.println("(2) Editar imagen");
            System.out.println("(3) Mostrar imagen");
            System.out.println("(4) Eliminar");
            System.out.println("(5) Salir del editor");
            int rsp = sc.nextInt();
            
            String nombre = "";
            
            switch(rsp){
                case 1:
                    System.out.println("Ingrese el nombre de la imagen");
                    nombre = sc.next();
                    CrearImagen(new Imagen(nombre));
                    break;
                case 2:
                    System.out.println("Ingrese el nombre de la imagen que quiere editar");
                    nombre = sc.next();
                    ModificarImagen(nombre);
                    break;
                case 3:
                    System.out.println("Ingrese el nombre de la imagen que quiere mostrar");
                    nombre = sc.next();
                    MostrarImagen(nombre);
                    break;
                case 4:
                    System.out.println("Ingrese el nombre de la imagen que quiere eliminar");
                    nombre = sc.next();
                    Eliminar(nombre);
                    break;
                case 5:
                    repeat = false; //SE SALE DEL CICLO
                    break;
            }
            
        }
        
    }
    
    public void CrearImagen(Imagen nuevo){
        
        al.add(nuevo);
    }
    
    public Imagen isContaint(String nombre){
        
        for (int i = 0; i < al.size(); i++) {
            
            if(al.get(i).getNombre().equals(nombre)){
                return al.get(i);
            }
        }
        
        return null;
        
    }
    
    public void ModificarImagen(String nombre){
        
       if(isContaint(nombre) != null){
           
           isContaint(nombre).ModificarImg();
       }
       else{
           System.out.println("No existe una imagen con el nombre "+nombre);
       }
        
    }
    
    public void MostrarImagen(String nombre){
        
        if(isContaint(nombre) != null){
            
            isContaint(nombre).MostrarImagen();
        }
        else{
            System.out.println("No existe una imagen con el nombre "+nombre);
        }
    }
    
    public void Eliminar(String nombre){
        
        if(isContaint(nombre) != null){
            al.remove(isContaint(nombre));
        }
        else{
            System.out.println("No existe una imagen con el nombre "+nombre);
        }
    }
    
    public void MostrarLista(){
        for (int i = 0; i < al.size(); i++) {
            System.out.println(al.get(i).getNombre());
        }
    }
   
}
