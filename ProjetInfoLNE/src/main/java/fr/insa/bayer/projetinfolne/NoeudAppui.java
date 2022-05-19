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
    protected Segment segment;
    protected double position;
    public NoeudAppui(int id,Segment segment, double position){
       super(id);
       this.segment=segment;
       this.position=position;
       this.px=(1-position)*segment.getP1().getAbscisse()+position*segment.getP2().getAbscisse();
       this.py=(1-position)*segment.getP1().getOrdonnee()+position*segment.getP2().getOrdonnee();
    }
    
   public NoeudAppui(int ID, double PX, double PY, Vecteur2D V,ArrayList<Barre> barreArrivee,ArrayList<Barre> barreDepart){
        super(ID,PX,PY,V,barreArrivee,barreDepart);   
    }
    public NoeudAppui(int ID,double PX, double PY, Vecteur2D V){
       super(ID,PX,PY,V);      
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
        return("Le Point: [id : "+getId() +" px:"+getPx()+" py:"+getPy()+" force:"+getV().toString() );
    }
    
    public Segment getSegment(){
        return this.segment;
    }
    public double getPosition(){
        return this.position;
    }
    public void setSegment(Segment segment){
        this.segment=segment;
    }
    public void setPosition (double position){
        this.position=position;
    }
    
    
    public static boolean verifieSegmentNoeudAppui(NoeudAppui n, Terrain terrain){
        int i=0; //compte nb de triangles terrain sur lequel est le noeud appui
        for(int tt=0; tt<terrain.getTriangles().size(); tt++){ //pour chaque triangle terrain constituant le terrain
            if(n.getSegment()==terrain.getTriangles()n.get(tt).getS1() || n.getSegment()==terrain.getTriangles().get(tt).getS2() || n.getSegment()==terrain.getTriangles().get(tt).getS3()){
                //Si noeud est sur un segment du triangle
                i++;
            }
        }
        if(i>1){
            System.out.println("Noeud appui est entre deux triangles terrains");
            return false;
        }
        else{
            return true;
        }
    }
    
}
