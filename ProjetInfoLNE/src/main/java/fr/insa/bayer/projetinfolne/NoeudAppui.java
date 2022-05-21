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
public abstract class NoeudAppui extends Noeud {
         
   public NoeudAppui(int ID, double PX, double PY,ArrayList<Barre> barreArrivee,ArrayList<Barre> barreDepart){
        super(ID,PX,PY,barreArrivee,barreDepart);   
    }
    public NoeudAppui(int ID,double PX, double PY){
       super(ID,PX,PY);      
    }
    
    public NoeudAppui(){
        super();
    }
    public abstract ArrayList<Barre> barreIncidentes (Noeud noeud);
      
   @Override
    public String toString(){
        return("Le Point: [id : "+getId() +" px:"+getPx()+" py:"+getPy());
    }
    


}
