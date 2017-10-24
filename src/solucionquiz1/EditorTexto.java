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
public class EditorTexto extends Editor{
    
    private Scanner sc = new Scanner(System.in);
    
    private ArrayList<Texto> la; //UN ARREGLO DINÁMICO DE DOCUMENTOS
    
    public EditorTexto(Proceso p, ArrayList<Texto> d){
        super(p);
        this.la = d;
    }
    
    
    public void ejecutar(){
        
        boolean repeat = true;
        
        while(repeat){
            
            System.out.println("Ingrese la opcion que desea");
        System.out.println("(1) Crear Documento");
        System.out.println("(2) Modificar Documento");
        System.out.println("(3) Agregar texto en un documento");
        System.out.println("(4) Eliminar texto");
        System.out.println("(5) Mostrar texto");
        System.out.println("(6) Salir del editor de texto");
        
        int rsp = sc.nextInt();
        String nombre = "";
        
        switch(rsp){
            case 1:
                System.out.println("Ingrese el nombre del documento");
                nombre = sc.next();
                crearDocumento(new Texto(nombre)); //SE CREA UN DOCUMENTO EN LA LISTA DE DOCUMENTOS
                this.MostrarLista();
                break;
            case 2:
                System.out.println("Ingrese el nombre del documento que va a modificar");
                nombre = sc.next();
                modificarDocumento(nombre);
                break;
            case 3:
                System.out.println("Ingrese el nombre del documento");
                nombre = sc.next();
                agregarTexto(nombre);
                break;
            case 4:
                System.out.println("Ingrese el nombre del documento que va a eliminar");
                nombre = sc.next();
                EliminarTexto(nombre);
                break;
            case 5:
                System.out.println("Ingrese el nombre del documento que quiere mostrar");
                nombre = sc.next();
                MostrarTexto(nombre);
                break;
            case 6:
                repeat = false; //SE SALE DEL CICLO
                break;
                
         }
            
        }
        
    }
    
    public void crearDocumento(Texto nuevo){
        la.add(nuevo); //SE CREA UN NUEVO TEXTO
    }
    
    public Texto isContaint (String nombre){
        
        for (int i = 0; i < la.size(); i++) {
            
            if(la.get(i).getNombre().equals(nombre)){
                return la.get(i);
            }
            
        }
        return null;
    }
    
    public void modificarDocumento(String nombre){
        
        if(isContaint(nombre) != null){
            
            System.out.println("Ingrese el texto ");
            String nuevoTexto = sc.next();
            isContaint(nombre).setTexto(nuevoTexto); //SE MODIFICA EL TEXTO  
        }
        else {
            System.out.println("No existe un documento con el nombre "+nombre);
        }
        
    }
    
    public void agregarTexto(String nombre){
        
        if(isContaint(nombre) != null){
            
            System.out.println("Ingrese el texto que va a agregar");
            String nuevoTexto = sc.next();
            isContaint(nombre).setTexto(isContaint(nombre).getTexto()+" "+nuevoTexto); //SE AÑADE EL TEXTO NUEVO
        }
        else{
            System.out.println("No existe un documento con el nombre "+nombre);
        }
        
    }
    
    public void EliminarTexto(String nombre){
        
        if(isContaint(nombre) != null){
            
           la.remove(isContaint(nombre)); //SE ELIMINA EL DOCUMENTO
        }
        else{
            System.out.println("No existe un documento con el nombre "+nombre);
        }
    }
    
    public void MostrarTexto(String nombre){
        
        if(isContaint(nombre) != null){
            
            System.out.println(isContaint(nombre).getTexto());
            
        }
        else{
            System.out.println("No existe un documento con el nombre "+nombre);
        }
    }
    
    public void MostrarLista(){
        
        for (int i = 0; i < la.size(); i++) {
            
            System.out.println(la.get(i).getNombre());
            
        }
    }
    
}
