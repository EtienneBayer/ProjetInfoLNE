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
public class NoeudAppuiSimple extends NoeudAppui {
    public NoeudAppuiSimple(int ID, double PX, double PY, Vecteur2D V,ArrayList<Barre> barreArrivee,ArrayList<Barre> barreDepart){
        super(ID,PX,PY,V,barreArrivee,barreDepart);   
    }
    public NoeudAppuiSimple(double PX, double PY, Vecteur2D V){
       super(PX,PY,V);      
    }
    public NoeudAppuiSimple(double PX, double PY){
      super(PX,PY);      
    }
    public NoeudAppuiSimple(){
        super();
    }
    
    @Override
    public String toString(){
        return("TON POINT NARVALO : [id : "+getId() +" px:"+getPx()+" py:"+getPy()+" force:"+getV().toString() );
    }
     public  ArrayList<Barre> barreIncidentes (Noeud noeud){
    {
         ArrayList<Barre> barreInci;
         ArrayList<Barre> barreArrivee=noeud.getbarresArrivee();
         ArrayList<Barre> barreDepart=noeud.getbarresDepart();
         (barreInci=new ArrayList<Barre>(barreArrivee)).addAll(barreDepart);
         
         return(barreInci);
     }
    }
     public  NoeudAppuiSimple creerNoeudAppuiSimple(){
          Vecteur2D v2=new Vecteur2D(0,0);
            v2=v2.creerVecteur();
            
            NoeudAppuiSimple nAs = new NoeudAppuiSimple(0,0,v2);
            nAs.demandePx();
            nAs.demandePy();
            System.out.println("quelle est l'ID du noeud");
            int id = Lire.i();
            nAs.setId(id);
            
            return(nAs);
         
     }
    
}
