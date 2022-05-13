/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.bayer.projetinfolne;

/**
 *
 * @author etien
 */
public class Point {
    
    private double abscisse;
    private double ordonnee;
    private int id;
    
     //constructeurs
    
     public Point (int id, double abscisse, double ordonnee){
    this.abscisse=abscisse;
    this.ordonnee=ordonnee;
    this.id = id;
    }
    public Point (int id){
        this.id=id;
    }
     @Override
    public String toString(){
        
        return("Coordonées du point"+this.id+": ( "+this.abscisse+";"+this.ordonnee+")");   
    }
    public String toShortString(){
        return ("("+this.abscisse+","+this.ordonnee+")");
    }
    
    //get - set
    
    public double getAbscisse() {
        return this.abscisse;
    }
    public double getOrdonnee() {
        return this.ordonnee;
    }
    public int getId() {
        return this.id;
    }
    public void setAbscisse(double abscisse) {
        this.abscisse = abscisse;
    }
    public void setOrdonnee(double ordonnee) {
        this.ordonnee = ordonnee;
    }
    /**
    
    //méthodes normales 
    
    //renvoie si un point est dans/en dehors d'un triangle terrain
    public boolean dansTriangle(TriangleTerrain triangle){
        int i;
        double[] angles = new double[3]; //tableau de 3 cases
        angles[0] = triangle.getS1().angleAvec(this);
        angles[1] = triangle.getS2().angleAvec(this);
        angles[2] = triangle.getS3().angleAvec(this);
        boolean[] signeAngles = new boolean[3];
        for(i=0; i<3;i++){
            signeAngles[i] = signeAngle(angles[i]);
            //System.out.println("signe angle "+i+" : "+signeAngles[i]);
        }
        if(signeAngles[0]==signeAngles[1]&&signeAngles[1]==signeAngles[2]){  //les 3 angles du même signe
            return true;  //le point est dans le triangle
        }
        else{  // les 3 angles pas tous du même signe
            return false;  //le point est en dehors du triangle
        }
    }
     public boolean VerificationDansTerrain(Terrain terrain){
        if(this.abscisse<terrain.getxMin()||this.abscisse>terrain.getxMax()||this.ordonnee<terrain.getyMin()||this.ordonnee>terrain.getyMax()){
            System.out.println("erreur : point en dehors du terrain (reessayez)");
            return false; //Le Point n'est pas dans le terrain défini
        }
        else{
            return true;
        }
    }
    
    //assure que l'utilisateur créé un point qui soit dans le terrain
    public void SaisieControlee(Terrain terrain){
        boolean dansTerrain = false;
        double x,y;
        System.out.println("coordonnees point:");
        while(dansTerrain!=true){ 
            x = Lire.d();
            y = Lire.d();
            this.setAbscisse(x);
            this.setOrdonnee(y);
            dansTerrain = this.VerificationDansTerrain(terrain);
        }
    }
    **/
    //méthodes statiques
    
    public static Point saisiePoint(){
        System.out.println("Entrez identifiant du point (entier)");
        int id=Lire.i();
        System.out.println("coordonnee x :");
        double x = Lire.d();
        System.out.println("coordonnee y :");
        double y = Lire.d();
        Point p = new Point(id,x,y); //crée le point demandé
        return p;
    }
    /**
    //ou ranger cette méthode ?
    public static boolean signeAngle(double angleEnRadians){
        if(angleEnRadians>0 && angleEnRadians<Math.PI){  //angle entre 0 (exclu) et pi rad (exclu)
            return true; //angle positif
        }
        else{   //angle entre 0 et - pi rad
            return false;  //angle négatif
        }
    }
    
}
*/
}

