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
public class Terrain {
    private double xMin;
    private double xMax;
    private double yMin;
    private double yMax;
    private ArrayList<TriangleTerrain> triangles;
    
    //constructeur 
    public Terrain (double xMin,double xMax,double yMin,double yMax){
        this.xMin = xMin;
        this.xMax = xMax;
        this.yMin = yMin;
        this.yMax = yMax;
        this.triangles = new ArrayList<TriangleTerrain>();
    }
    
    // get - set
    public double getxMin(){    
        return xMin;
    }
    public double getxMax() {
        return xMax;
    }
    public double getyMin() {
        return yMin;
    }
    public double getyMax() {    
        return yMax;
    }
    public ArrayList<TriangleTerrain> getTriangles(){
        return this.triangles;
    }
    public void setxMin(double xMin) {
        this.xMin = xMin;
    }
    public void setxMax(double xMax) {
        this.xMax = xMax;
    }
    public void setyMax(double yMax) {
        this.yMax = yMax;
    }
    
    //add
    public void addTriangle(TriangleTerrain triangle){
        this.triangles.add(triangle);
    }
    

    //méthodes normales
    @Override
    public String toString() {
        String res = "Terrain : xMin: "+this.xMin+" xMax: "+this.xMax+" yMin: "+this.yMin+" yMax: "+this.yMax+"\n"; 
        for(int i=0;i<this.triangles.size();i++){
            res = res + this.triangles.get(i).toString();
        }
        return res;
    }
   
    
    //méthodes statiques 
    public static Terrain saisieTerrain(){
        System.out.println("creation d'un nouveau terrain :");
        System.out.println("xMin :");
        double xMin = Lire.d();
        System.out.println("xMax :");
        double xMax = Lire.d();  
        System.out.println("yMin :");
        double yMin = Lire.d();
        System.out.println("yMax :");
        double yMax = Lire.d();
        Terrain terrain = new Terrain(xMin,xMax,yMin,yMax);
        return terrain;
    }
    /**
    public void saisieTrianglesTerrain(){
        int i=0;
        boolean stop = false;
        while(stop!=true){
            i++;
            TriangleTerrain t = TriangleTerrain.creationTriangle(100*i,this);  //créé un triangle terrain
            this.addTriangle(t);  //ajoute le triangle à la liste des triangles terrain du terrain
            stop = saisieTerminee("terrain");
        }
    }
    **/
    
    public static boolean verificationSaisieTerrain(Terrain terrain){
        if(terrain.getxMin()<terrain.getxMax() && terrain.getyMin()<terrain.getyMax()){
            System.out.println("Saisie du terrain conforme");
            return true;
        }
        else{
            System.out.println("Saisie du terrain non conforme");
            return false;
        }
    }
}
