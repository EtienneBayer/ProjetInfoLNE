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
public abstract class Noeud {
    private int  id=-1;
    protected double px;
    protected double py;
    
    private   ArrayList<Barre>BarreDepart =new ArrayList<Barre>() ;
    private   ArrayList<Barre>BarreArrivee =new ArrayList<Barre>() ;
    
    public Noeud(int ID, double PX, double PY, ArrayList<Barre> barreArrivee,ArrayList<Barre> barreDepart){
        this.id=ID;
        this.px=PX;
        this.py=PY;
        
        this.BarreArrivee=barreArrivee;
        this.BarreDepart=barreDepart;
    }
    public Noeud(int ID,double PX, double PY){
        this.id=ID;
        this.px=PX;
        this.py=PY;
       
        this.BarreArrivee=new ArrayList<Barre>();
        this.BarreDepart=new ArrayList<Barre>();
    }
    
    public Noeud(){
        Vecteur2D V=new Vecteur2D(0.0,0.0);
        this.id=-1;
        this.px=-1000;
        this.py=-1000;
        
        this.BarreArrivee=new ArrayList<Barre>();
        this.BarreDepart=new ArrayList<Barre>();
    }
    public Noeud(int id){
        this.id=id;
    }
       
    //public Noeud trouvetonnoeud (double PX, double PY){
      //  for (int i=0; i<10;i++){
        //    if ((n(i).getPx()==PX)&&(n(i).getPy()==PX))
        //}
        
    //}
     
   
    
     public String toString(){
       return "Le Point : [id : "+this.id +" px:"+this.px+" py:"+this.py ;
    
    } 
   
     public abstract ArrayList<Barre> barreIncidentes (Noeud noeud);
    
    
    
    public ArrayList<Barre> getbarresDepart(){
        return (this.BarreDepart);
    }
    public ArrayList<Barre> getbarresArrivee(){
        return (this.BarreArrivee);
    }
    
    
    public double getPx(){
        return (this.px);
    }
    public double getPy(){
        return (this.py);
    }
    
    public int getId(){
        return (this.id);
    }
    
    public void setPx(double px) {
        this.px = px;
    }
    public void setPy(double py) {
        this.py = py;
    }
    public void setbarresDepart(ArrayList<Barre> barresDepart) {
        this.BarreDepart = barresDepart;
    }
    public void setbarresArrivee(ArrayList<Barre> barresArrivee) {
        this.BarreArrivee = barresArrivee;
    }
    public void setId(int id) {
        this.id = id;
    }
    
    
    public void demandePx(){
        System.out.println(" quelle est la coordonnee px");
       double pX=Lire.d();  
        this.px=pX  ;
    }
    public void demandePy(){
        System.out.println(" quelle est la coordonnee py");
        double pY=Lire.d();
        this.py=pY;
    }
    public int  ChoixtypeNoeud(){
        System.out.println("quelle type de noeud veux tu creer: 1 pour Noeud Simple, 2 Noeud Appui Simple,3 Noeud appui Double");
        int a=Lire.i();
        return(a);
    }
    
    
   
   
    
    
   
}


