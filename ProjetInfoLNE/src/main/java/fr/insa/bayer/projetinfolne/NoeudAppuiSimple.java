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
     private double Angle_nAs;
    public NoeudAppuiSimple(int ID, double PX, double PY, Vecteur2D V,ArrayList<Barre> barreArrivee,ArrayList<Barre> barreDepart){
        super(ID,PX,PY,V,barreArrivee,barreDepart);
        this.Angle_nAs=-1.570796327;
    }
    public NoeudAppuiSimple(int ID,double PX, double PY, Vecteur2D V){
       super(ID,PX,PY,V);      
       this.Angle_nAs=-1.570796327;
    }
    public NoeudAppuiSimple(int ID,double PX, double PY){
      super(ID,PX,PY);      
      this.Angle_nAs=-1.570796327;
    }
    public NoeudAppuiSimple(){
        super();
        this.Angle_nAs=-1.570796327;
    }
    
    @Override
    public String toString(){
        return("Le Point : [id : "+getId() +" px:"+getPx()+" py:"+getPy()+" force:"+getV().toString()+"angle "+getAngle_nAs() );
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
            
            NoeudAppuiSimple nAs = new NoeudAppuiSimple(1,0,0,v2);
            nAs.demandePx();
            nAs.demandePy();
            System.out.println("quelle est l'ID du noeud");
            int id = Lire.i();
            nAs.setId(id);
            System.out.println("quelle est l'Angle du noeud OX, terrain fictif");
            
            return(nAs);
         
     }

    /**
     * @return the Angle_ns
     */
    public double getAngle_nAs() {
        return Angle_nAs;
    }

    /**
     * @param Angle_ns the Angle_ns to set
     */
    public void setAngle_nAs(double Angle_nAs) {
        this.Angle_nAs = Angle_nAs;
    }
    
}
