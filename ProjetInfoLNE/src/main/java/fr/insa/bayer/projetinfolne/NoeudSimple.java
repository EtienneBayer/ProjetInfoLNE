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
   private Vecteur2D v;
    public NoeudSimple(int ID, double PX, double PY, Vecteur2D V,ArrayList<Barre> barreArrivee,ArrayList<Barre> barreDepart){
        super(ID,PX,PY,barreArrivee,barreDepart);   
        this.v=V;
    }
    public NoeudSimple(int ID,double PX, double PY, Vecteur2D V){
       super(ID,PX,PY); 
       this.v=V;
    }
    public NoeudSimple(int ID,double PX, double PY){
      super(ID,PX,PY);      
      
    }
    public NoeudSimple(){
        super();
    }
    

   
   
    
    
    @Override
    public String toString(){
        return("Le NoeudSimple : [id : "+getId() +" px:"+getPx()+" py:"+getPy()+" force:"+getV().toString())+"]";
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
                    
            return(ns);
         
     }

    /**
     * @return the v
     */
    public Vecteur2D getV() {
        return v;
    }

    /**
     * @param v the v to set
     */
    public void setV(Vecteur2D v) {
        this.v = v;
    }

    /**
     * @return the Angle_ns
     */
   
    
    
}
