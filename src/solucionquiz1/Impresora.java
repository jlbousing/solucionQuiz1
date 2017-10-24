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
public class Impresora implements Dispositivo {
    
    private String nombre;
    private Proceso p;
    private ArrayList<Texto> arregloD;
    private ArrayList<Imagen> arregloI;
    private Scanner sc = new Scanner(System.in);

    public Impresora( Proceso p, ArrayList<Texto> d, ArrayList<Imagen> i) {
        
        this.p = p;
        this.arregloD = d;
        this.arregloI = i;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Proceso getP() {
        return p;
    }

    public void setP(Proceso p) {
        this.p = p;
    }
    
    public void comunicar(){
     
        System.out.println("Ingrese que opcion desea hacer");
        System.out.println("(1) Imprimir documento");
        System.out.println("(2) Imprimir imagen");
        int rsp = sc.nextInt();
        String nombre = "";
        
        if(rsp == 1){
            
            mostrarListaDocumento();
            System.out.println("");
            System.out.println("Ingrese el nombre del documento que desea imprimir");
            nombre = sc.next();
            ImprimirDocumento(nombre);
        }else{
            
            mostrarListaImagen();
            System.out.println("Ingrese el nombre de la imagen que desea imprimir");
            System.out.println("");
            nombre = sc.next();
            ImprimirImagen(nombre);
        }
    }
    
    public Texto isContaint(String nombre){
        
        for (int i = 0; i < this.arregloD.size(); i++) {
            
            if(arregloD.get(i).getNombre() == nombre){
                return arregloD.get(i);
            }
        }
        
        return null;
    }
    
    public Imagen isContaintImagen(String nombre){
        
        for (int i = 0; i < arregloI.size(); i++) {
            
            if(arregloI.get(i).getNombre() == nombre){
                return arregloI.get(i);
            }
            
        }
        
        return null;
    }
    
    public void ImprimirDocumento(String nombre){
        
        if(isContaint(nombre) != null){
            System.out.println("Se esta imprimiento "+nombre);
            isContaint(nombre).toString();
        }
        else{
            System.out.println("No existe el documento de nombre "+nombre);
        }
    }
    
    public void ImprimirImagen(String nombre){
        
        if(isContaintImagen(nombre) != null){
            System.out.println("Se esta imprimiento "+nombre);
            isContaintImagen(nombre).MostrarImagen();
        }
        else{
            System.out.println("No existe la imagen de nombre "+nombre);
        }
    }
    
    public void mostrarListaDocumento(){
        for (int i = 0; i < arregloD.size(); i++) {
            System.out.println(arregloD.get(i).getNombre());
        }
    }
    
    public void mostrarListaImagen(){
        for (int i = 0; i < arregloI.size(); i++) {
            System.out.println(arregloI.get(i).getNombre());
        }
    }
    
    
    
}
