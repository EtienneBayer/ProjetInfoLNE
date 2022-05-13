/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.bayer.projetinfolne;

/**
 *
 * @author etien
 */
public class TriangleTerrain {
    //attributs
    private int id;
    private Point p1;
    private Point p2;
    private Point p3;
    private Segment s1;
    private Segment s2;
    private Segment s3;
    
    //constructeurs
    public TriangleTerrain(int id,Point p1,Point p2,Point p3){
        this.id = id;
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3; 
        this.s1 = new Segment(p1,p2);
        this.s2 = new Segment(p2,p3);
        this.s3 = new Segment(p3,p1);
    }
 
    public TriangleTerrain(int id){
        this.id = id;
    }
    
    //get - set 
    public int getId() {
        return id;
    }
    public Point getP1() {
        return p1;
    }
    public Point getP2() {
        return p2;
    }
    public Point getP3() {
        return p3;
    }
    public Segment getS1() {
        return s1;
    }
    public Segment getS2() {
        return s2;
    }
    public Segment getS3() {
        return s3;
    }
    
      
    //méthodes normales
    @Override
    public String toString(){
        return ("Triangle Terrain "+this.id+" : \n p1: "+this.p1.toString()+"\n p2: "+this.p2.toString()+"\n p3: "+this.p3.toString()+"\n");
    }
    
    //méthodes statiques
    public static TriangleTerrain creationTriangle(int id,Terrain terrain){
        System.out.println("Creation d'un triangle terrain \n");
        Point p1 = new Point(id*100+1);
        p1.SaisieControlee(terrain);  //controle que le point 1 est bien dans le terrain
        Point p2 = new Point(id*100+2);
        p2.SaisieControlee(terrain);
        Point p3 = new Point(id*100+3);
        p3.SaisieControlee(terrain);
        TriangleTerrain triangle = new TriangleTerrain(id,p1,p2,p3);
        return triangle;
    }
    
    //tests
    //méthode qui génère un triangle terrain basique 
    public static TriangleTerrain test1 (){
        Point p1 = new Point(1,0,0);
        Point p2 = new Point(2,0,1);
        Point p3 = new Point(3,1,0);
        int id = 123;
        TriangleTerrain triangle = new TriangleTerrain(id,p1,p2,p3);
        return triangle;
    }

}