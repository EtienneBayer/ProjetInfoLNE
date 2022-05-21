/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.bayer.projetinfolne;

/**
 *
 * @author etien
 */
import java.util.ArrayList;

/**
 *
 * @author etien
 */


public class Barre {
    private int ID;
    private Noeud nd;
    private Noeud na;
    private double tracmax;
    private double compressmax;
    private double cout;
            
    public Barre(int id,Noeud nd,Noeud na,double tracmax, double compressmax,double cout){
        this.ID=id;
        this.nd=nd;
        this.na=na;
        this.tracmax=tracmax;
        this.compressmax=compressmax;
        this.cout=cout;
    }
    public Barre(int id,Noeud nd,Noeud na){
        this.ID=id;
        this.nd=nd;
        this.na=na;
        this.tracmax=-1000;
        this.compressmax=-1000;
        this.cout=-1000;
    }
   
    
    public  Barre CreerBarre(Noeud n1,Noeud n2){
        System.out.println("shiiiiiiiiii");
        
        Barre b =new Barre(-1,n1,n2,0,0,0);
        System.out.println("quelle est est son ID");
        b.ID=Lire.i();
        System.out.println("quelle est est sa traction max");
        b.tracmax=Lire.i();
        System.out.println("quelle est est sa compression max");
        b.compressmax=Lire.i();
        System.out.println("quelle est est son cout");
        b.cout=Lire.i();
        
        return b;
    }
     //calcul le coeff directeur de la barre
    public double coefDir(){
        double coefDir; 
        //traitement de la barre (entre 2 noeuds) en tant que segment (entre 2 points) :
        Point p1 = new Point(99,this.nd.getPx(),this.nd.getPy());
        Point p2 = new Point(99,this.na.getPx(),this.na.getPy());
        Segment s = new Segment(p1,p2);
        
        double deltaX = s.getP2().getAbscisse()-s.getP1().getAbscisse();
        double deltaY = s.getP2().getOrdonnee()-s.getP1().getOrdonnee();
        if(deltaX == 0){
           // if(deltaY<0){
               // return -10000; //valeur finie pour représenter les vecteurs verticaux (évite erreur valeur infinie)
            //}
            //else{
                return 10000; //valeur finie pour représenter les vecteurs verticaux (évite erreur valeur infinie)
           // }    
        }
        else{
            /*
            if(deltaX>0){
                System.out.println("delta X:"+deltaX);
                System.out.println("delta y:"+deltaY);
                return deltaY/deltaX;//(yb-ya)/(xb-xa)
            }
            else{
                System.out.println("delta X:"+deltaX);
                System.out.println("delta y:"+deltaY);
                return -deltaY/deltaX;
            }
            */
            return deltaY/deltaX;
        }
    }
    
    public Barre ChoisiBarre(ArrayList<Barre>listBarres){
        System.out.println("quelle est l'ID de la barre");
        int idcherche=Lire.i();
        for(int i=0;i<listBarres.size();i++){
            if (listBarres.get(i).getID()==idcherche){
                return(listBarres.get(i));
            }
        }
        return(null);
        
    }
    

    
    
    public Noeud NoeudOppose (Noeud nrepere, Barre b){
        if (nrepere==b.nd){
            return(this.na);
        }
         //IF (nrepere==b.na)
            return(this.nd);
        
    }
    
    public Double Angle3(Barre barre){
        double deltaX = barre.getNa().getPx()-barre.getNd().getPx();
       double deltaY =barre.getNa().getPy()-barre.getNd().getPy();
          if(deltaX == 0){
            
                return 1.570796327; //valeur finie de pi/2
            }    
        
        double quotient = deltaY/deltaX;
        System.out.println();
        return Math.atan(quotient);
    }
    
    public Double Angle (double pxd,double pyd,double pxa,double pya){
        return(Math.atan(pya-pyd)/(pxa-pxd));
    }
    public Double Angle2 (Noeud Nd, Noeud Na){
       double deltaX = Na.getPx()-Nd.getPx();
       double deltaY =Na.getPy()-Nd.getPy();
        if(deltaX == 0){
            
                return 1.570796327; //valeur finie de pi/2
            }    
        
        double quotient = deltaY/deltaX;
        System.out.println();
        return Math.atan(quotient);
    }
    
    
    public int getID(){
        return (this.ID);
    }
    public Noeud getNd(){
        return (this.nd);
    }
    public Noeud getNa(){
        return (this.na);
    }
    public double getTracmax(){
        return (this.tracmax);
    }
    public double getCompressmax(){
        return (this.compressmax);
    }
    public double getCout(){
        return (this.cout);
    }
    
    
    public void setID(int ID) {
        this.ID = ID;
    }
    public void setNd(Noeud nd,Barre barreaoud) {
        
        barreaoud.nd = nd;
    }
    public void setNa(Noeud na,Barre barreaoud) {
        barreaoud.na = na;
    }
    public void setTracmax(double tracmax) {
        this.tracmax = tracmax;
    }
    public void setCompressmax(double compressmax) {
        this.compressmax = compressmax;
    }
    public void setCout(double cout) {
        this.cout = cout;
    }
    @Override
    public String toString(){
        return("LA BARRE: [id : "+getID()+" son noeud de depart "+getNd()+" son noeud d'arrivee "+getNa()+" sa traction max "+getTracmax()+" sa compression max :"+getCompressmax()+" et son cout "+getCout()+"]");
    } 
    
    
}
