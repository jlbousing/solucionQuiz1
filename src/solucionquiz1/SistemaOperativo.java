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
public class SistemaOperativo {
    
    private ArrayList<Texto> d = new ArrayList<Texto>();
    private ArrayList<Imagen> i = new ArrayList<Imagen>();
    private Scanner sc = new Scanner(System.in);
    private Dispositivo[] arrayDispositivo = new Dispositivo[3];
    private Proceso[] mp = new Proceso[10];
    private Usuario user;
    private Editor[] arrayEditor = new Editor[3];
    
    public SistemaOperativo(){
        
        Run();
    }
    
    public void Run(){
        
        System.out.println("Escriba su nombre usuario ");
        String nombre = sc.next();
        System.out.println("");
        
        this.user = new Usuario(nombre);
        
        while(true){
            
            System.out.println("Escriba la opcion deseada");
            System.out.println("(1) Crear Proceso");
            System.out.println("(2) EliminarProceso");
            System.out.println("(3) Agregar dispositivo");
            System.out.println("(4) Eliminar dispositivo");
            System.out.println("(5) Usar editor de texto");
            System.out.println("(6) Usar editor de imagen");
            System.out.println("(7) Salir");
            int rsp = sc.nextInt();
            
            
            switch(rsp){
                
                case 1:
                    crearProceso();
                    break;
                case 2:
                                        
                    System.out.println("Ingrese el nombre del proceso que desea eliminar");
                    nombre = sc.next();
                    
                    for (int j = 0; j < mp.length; j++) {
                        
                        if(mp[j] != null && mp[j].getNombre() == nombre){
                            mp[j] = null; //SE ELIMINA EL PROCESO DE LA MEMORIA PRINCIPAL
                        }
                        
                    }
                    
                    break;
                case 3:
                    agregarDispositivo();
                    break;
                case 4:
                    
                    System.out.println("Ingrese el nombre del proceso del dispositivo que quiere eliminar");
                    nombre = sc.next();
                    
                    for (int j = 0; j < arrayDispositivo.length; j++) {
                         if(arrayDispositivo[j] != null && arrayDispositivo[j] instanceof Impresora){
                             //SE APLICA UN CASTEO PARA LLAMAR A FUNCIONES PROPIAS DE IMPRESORAS
                             Impresora impresora = (Impresora) arrayDispositivo[j];
                             if(impresora.getP().getNombre() == nombre){
                                 arrayDispositivo[j] = null; //SE ELIMINA EL DISPOSITIVO
                                 
                                 for (int k = 0; k < mp.length; k++) {
                                     if(mp[k].getNombre() == nombre){
                                         mp[k] = null; //SE ELIMINA EL PROCESO
                                     }
                                 }
                             }
                         }    
                    }
                    break;
                case 5:
                    for (int j = 0; j < arrayEditor.length; j++) {
                        if(arrayEditor[j] instanceof EditorTexto){
                            arrayEditor[j].ejecutar();
                            break; //SE MATA EL CICLO
                        }
                    }
                    break;
                case 6:
                    for (int j = 0; j < arrayEditor.length; j++) {
                        if(arrayEditor[j] instanceof EditorImagen){
                            arrayEditor[j].ejecutar();
                            break; //SE MATA EL CICLO
                        }
                    }
                    break;
                case 7:
                    System.exit(0); //SE SALE DEL PROGRAMA
                    
            }
            
            
            
        }
        
    }
    
    public void crearProceso(){
        
        
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("(1) Crear Editor de Texto");
        System.out.println("(2) Crear Editor de imagen");
        int rsp = sc.nextInt();
        
        if(rsp == 1){
            
            for (int j = 0; j < mp.length; j++) {
                
                if(mp[j] == null){
                    System.out.println("Ingrese el nombre del proceso");
                    String nombre = sc.next();
                    mp[j] = new Proceso(nombre,user);
                    
                    for (int k = 0; k < arrayEditor.length; k++) {
                        if(arrayEditor[k] == null){
                            arrayEditor[k] = new EditorTexto(mp[j],this.d);
                            break;
                        }
                    }
                    break;
                }
            }
        }
        else{
            for (int j = 0; j < mp.length; j++) {
                
                if(mp[j] == null){
                    System.out.println("Ingrese el nombre del proceso");
                    String nombre = sc.next();
                    mp[j] = new Proceso(nombre,user);
                    
                    for (int k = 0; k < arrayEditor.length; k++) {
                        
                        if(arrayEditor[k] == null){
                            arrayEditor[k] = new EditorImagen(mp[j],this.i);
                            break;
                        }
                    }
                    break;
                }
            }
    
        }
    }
    
    public void agregarDispositivo(){
        
        System.out.println("Ingrese el nombre del proceso que controla al dispositivo");
        String nombre = sc.next();
        for (int j = 0; j < mp.length; j++) {
            if(mp[j] == null){
                mp[j] = new Proceso(nombre,user);
                
                for (int k = 0; k < this.arrayDispositivo.length; k++) {
                    
                    if(arrayDispositivo[k] == null){
                        arrayDispositivo[k] = new Impresora(mp[j],d,i);
                    }
                }
            }
        }
    }
    
}
