/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.bayer.projetinfolne;

import java.util.ArrayList;
/**
 *
 * @author etien
 */
public class NoeudSimple extends Noeud {
   
    public NoeudSimple(int ID, double PX, double PY, Vecteur2D V,ArrayList<Barre> barreArrivee,ArrayList<Barre> barreDepart){
        super(ID,PX,PY,V,barreArrivee,barreDepart);   
        
    }
    public NoeudSimple(int ID,double PX, double PY, Vecteur2D V){
       super(ID,PX,PY,V); 
       
    }
    public NoeudSimple(int ID,double PX, double PY){
      super(ID,PX,PY);      
      
    }
    public NoeudSimple(){
        super();
    }
    

   
   
    
    
    @Override
    public String toString(){
        return("Le Point : [id : "+getId() +" px:"+getPx()+" py:"+getPy()+" force:"+getV().toString());
    }

   
    @Override
    public  ArrayList<Barre> barreIncidentes (Noeud noeud){
    {
         ArrayList<Barre> barreInci;
         ArrayList<Barre> barreArrivee=noeud.getbarresArrivee();
         ArrayList<Barre> barreDepart=noeud.getbarresDepart();
         (barreInci=new ArrayList<Barre>(barreArrivee)).addAll(barreDepart);
         
         return(barreInci);
     }
    }
     public  NoeudSimple creerNoeudSimple(){
         Vecteur2D v1=new Vecteur2D(0,0);
          v1= v1.creerVecteur();
          
            
            NoeudSimple ns = new NoeudSimple(1,0,0,v1);
            ns.demandePx();
            ns.demandePy();
            System.out.println("quelle est l'ID du noeud");
            int id = Lire.i();
            
            ns.setId(id);
            System.out.println("quelle est l'angle OX et noeud-terrain (pi/2 = 1.570796327, pi/3 = 1.047197, pi/4=0.7853981, 3pi/4=2.35619449)");
            ns.setAngle_ns(Lire.d());
            
            
            return(ns);
         
     }

    /**
     * @return the Angle_ns
     */
   
    
    
}
