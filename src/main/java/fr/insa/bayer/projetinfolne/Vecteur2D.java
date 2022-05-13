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
    private Noeud noeud;
    private double coefDir;
    private double valeur;
    
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
    
    
      //méthodes normales
    public double projX(){
        if(this.coefDir>9999){  //évite erreurs avec vecteurs vetticaux
            return 0;
        }
        else{
            return this.valeur*java.lang.Math.cos(java.lang.Math.atan(this.coefDir)); //norme*cos(angle avec l'horizontale)
        }
    }
    public double projY(){
        if(this.coefDir>9999){ 
            return this.valeur;
        }
        else{
           return this.valeur*java.lang.Math.sin(java.lang.Math.atan(this.coefDir));  //norme*sin(angle avec l'horizontale)     
        }
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

    /**
     * @return the noeud
     */
    public Noeud getNoeud() {
        return noeud;
    }

    /**
     * @return the coefDir
     */
    public double getCoefDir() {
        return coefDir;
    }

    /**
     * @param coefDir the coefDir to set
     */
    public void setCoefDir(double coefDir) {
        this.coefDir = coefDir;
    }

    /**
     * @return the valeur
     */
    public double getValeur() {
        return valeur;
    }

    /**
     * @param valeur the valeur to set
     */
    public void setValeur(double valeur) {
        this.valeur = valeur;
    }
    
    
    
}

