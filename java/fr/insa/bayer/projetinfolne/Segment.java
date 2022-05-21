/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.bayer.projetinfolne;
import java.lang.Math.*;
/**
 *
 * @author etien
 */
public class Segment {
    private int id;
    private Point p1;
    private Point p2;
    
    public Segment (Point p1, Point p2){
        this.id = p1.getId()*10+p2.getId();
        this.p1=p1;
        this.p2=p2;            
    }
    public Segment(int id){  //segment fictif (juste pour initialiser)
        this.id = id;
    }

    public int getId() {
        return id;
    }
    public Point getP1() {
        return p1;
    }
    public Point getP2() {
        return p2;
    }
    public void setP1(Point p1) {
        this.p1 = p1;
    }
    public void setP2(Point p2) {
        this.p2 = p2;
    }
    
    @Override
    public String toString(){
        
       return("Points du segment: ( "+this.p1.toString()+";"+this.p2.toString()+")");   
    }
    
    public String toShortString(){
        return("Segment "+id+":"+p1.toShortString()+p2.toShortString());
    }
    
    //méthodes normales 
    
    //calcul le coeff directeur d'un segment
    public double coefDir(){
        double coefDir; 
        double deltaX = this.p2.getAbscisse()-this.p1.getAbscisse();
        double deltaY = this.p2.getOrdonnee()-this.p1.getOrdonnee();

        if(deltaX == 0){
            if(deltaY<0){
                return -10000; //valeur finie pour représenter les vecteurs verticaux (évite erreur valeur infinie)
            }
            else{
                return 10000; //valeur finie pour représenter les vecteurs verticaux (évite erreur valeur infinie)
            }    
        }
        else{
            if(deltaX>0){
                return deltaY/deltaX;//(yb-ya)/(xb-xa)
            }
            else{
                return -deltaY/deltaX;
            }
        }
    }
    
    //colinearite entre le segment reliant p1 à un point donné et le segment donné
    public double angleAvec(Point p){
        Segment s2 = new Segment(this.p1,p); //créé un segment entre le 1er point du segment et le point à comparer
        //calcul du vecteur directeur du segment du triangle Terrain :
        double angle1 = java.lang.Math.atan(this.coefDir());  //angle entre le segment donné et l'axe x
        double angle2 = java.lang.Math.atan(s2.coefDir());  //angle entre le segment s2 et l'axe x
        double angle12 = angle2-angle1;  //angle entre les 2 segments

        return angle12;

    }
    
    
    
}