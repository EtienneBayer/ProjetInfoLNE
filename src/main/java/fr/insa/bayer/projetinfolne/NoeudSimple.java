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
    public NoeudSimple(double PX, double PY, Vecteur2D V){
       super(PX,PY,V);      
    }
    public NoeudSimple(double PX, double PY){
      super(PX,PY);      
    }
    public NoeudSimple(){
        super();
    }
    
    @Override
    public String toString(){
        return("TON POINT NARVALO : [id : "+getId() +" px:"+getPx()+" py:"+getPy()+" force:"+getV().toString() );
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
          
            
            NoeudSimple ns = new NoeudSimple(0,0,v1);
            ns.demandePx();
            ns.demandePy();
            System.out.println("quelle est l'ID du noeud");
            int id = Lire.i();
            ns.setId(id);
            
            return(ns);
         
     }
    
    
    
}
