/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.bayer.projetinfolne;

/**
 *
 * @author etien
 */
public class Vecteur2D {
    private double vx;
    private double vy;
    
    
    public Vecteur2D(double cx,double cy ){
        this.vx=cx;
        this.vy=cy;
    }
    @Override
    public String toString(){
       return "[vx:"+this.vx+" "+"vy:"+this.vy+"]";
    
    }
    public  Vecteur2D creerVecteur(){
         Vecteur2D v1=new Vecteur2D(0,0);
            v1.demandeVx();
            v1.demandeVy();
            return(v1);
     }
 
    public double getVx(){
        return (this.vx);
    }
    public double getVy(){
        return (this.vy);
    }
    
    public void demandeVx(){
        System.out.println(" quelle est la composante vx");
       double cx=Lire.d();  
        this.vx=cx  ;
    }
    public void demandeVy(){
        System.out.println(" quelle est la composante vy");
        double cy=Lire.d();
        this.vy=cy;
    }
     public void setVx(double cx){
        this.vx=cx  ;
    }
     public void setVy(double cy){
        this.vy=cy;
    }

}

