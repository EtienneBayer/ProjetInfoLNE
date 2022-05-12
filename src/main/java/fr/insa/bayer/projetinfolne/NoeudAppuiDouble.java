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
public class NoeudAppuiDouble extends NoeudAppui {
    public NoeudAppuiDouble(int ID, double PX, double PY, Vecteur2D V,ArrayList<Barre> barreArrivee,ArrayList<Barre> barreDepart){
        super(ID,PX,PY,V,barreArrivee,barreDepart);   
    }
    public NoeudAppuiDouble(double PX, double PY, Vecteur2D V){
       super(PX,PY,V);      
    }
    public NoeudAppuiDouble(double PX, double PY){
      super(PX,PY);      
    }
    public NoeudAppuiDouble(){
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
      public  NoeudAppuiDouble creerNoeudAppuiDouble(){
          Vecteur2D v3=new Vecteur2D(0,0);
           v3=v3.creerVecteur();
            
            NoeudAppuiDouble nAd = new NoeudAppuiDouble(0,0,v3);
            nAd.demandePx();
            nAd.demandePy();
            System.out.println("quelle est l'ID du noeud");
            int id = Lire.i();
            nAd.setId(id);
            
            return(nAd);
         
     }
    
    
}
