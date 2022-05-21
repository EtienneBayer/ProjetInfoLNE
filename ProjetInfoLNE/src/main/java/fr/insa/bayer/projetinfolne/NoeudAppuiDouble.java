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
    public NoeudAppuiDouble(int ID, double PX, double PY,ArrayList<Barre> barreArrivee,ArrayList<Barre> barreDepart){
        super(ID,PX,PY,barreArrivee,barreDepart);   
    }
    public NoeudAppuiDouble(int ID,double PX, double PY){
       super(ID,PX,PY);      
    }
    public NoeudAppuiDouble(){
      super();      
    }
    @Override
    public String toString(){
        return("Le NoeudAppuiDouble : [id : "+getId() +" px:"+getPx()+" py:"+getPy()+"]");
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
          
            NoeudAppuiDouble nAd = new NoeudAppuiDouble(1,0,0);
            nAd.demandePx();
            nAd.demandePy();
            System.out.println("quelle est l'ID du noeud");
            int id = Lire.i();
            nAd.setId(id);
            
            return(nAd);
         
     }
    
    
}
