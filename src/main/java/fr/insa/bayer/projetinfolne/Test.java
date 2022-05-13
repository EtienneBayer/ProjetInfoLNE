/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.bayer.projetinfolne;

import java.util.ArrayList;
import matrice.Matrice;
/**
 *
 * @author etien
 */
public class Test {
    public static void main (String[] args){
        /**
        Vecteur2D v1 =new Vecteur2D(0, 0) ;
        v1=v1.creerVecteur();
        System.out.println(v1.toString());
        NoeudSimple ns = new NoeudSimple();
        ns=ns.creerNoeudSimple();
        System.out.println(ns.toString());
         */      
        ArrayList<Barre>listBarres = new ArrayList<Barre>();
        ArrayList<Noeud>listNoeuds = new ArrayList<Noeud>();
        Treillis treillis = new Treillis(listBarres,listNoeuds);
       
        double cx,cy;
        
        ArrayList<Vecteur2D>tabv ;
        tabv=new ArrayList<Vecteur2D> (10);
        
        ArrayList<NoeudSimple>tabns ;
        tabns=new ArrayList<NoeudSimple> (10);
         
        ArrayList<NoeudAppuiSimple>tabnAs ;
        tabnAs=new ArrayList<NoeudAppuiSimple> (10);
        
        ArrayList<NoeudAppuiDouble>tabnAd ;
        tabnAd=new ArrayList<NoeudAppuiDouble> (10);
        
        Matrice M = new Matrice (3,3);
        M = M.matAleaZeroUnDeux(4, 4, 0);
        System.out.println(M.toString());
       treillis.MenuTexte();
      
        
    }
    
    
     public  Object ENTRENOEUD(ArrayList<NoeudSimple> tabns,ArrayList<NoeudAppuiSimple> tabnAs,ArrayList<NoeudAppuiDouble> tabnAd,int a){
     if (a==1){
          NoeudSimple ns= new NoeudSimple();
          ns=ns.creerNoeudSimple();
          System.out.println("le noeud Simple creer : "+ns.toString());
          
          return(ns); 
        }
        if (a==2){
          NoeudAppuiSimple nAs= new NoeudAppuiSimple();
          nAs=nAs.creerNoeudAppuiSimple();   
          System.out.println("le noeud Appui Simple creer : "+nAs.toString());
          return(nAs);
        }
         NoeudAppuiDouble nAd= new NoeudAppuiDouble();
         nAd=nAd.creerNoeudAppuiDouble(); 
         System.out.println("le noeud  Appui Double creer : "+nAd.toString());    
         return(nAd);
     }
     
    

    /**
     *
     * @param tabns
     * @param tabnAs
     * @param tabnAd
     */
    public  Noeud Noeudcherche(ArrayList<NoeudSimple> tabns,ArrayList<NoeudAppuiSimple> tabnAs,ArrayList<NoeudAppuiDouble> tabnAd){      
       
        System.out.println("quelle sont les coordonnees cx et cy du point recherchees ?");
        double cx,cy;
        
        NoeudSimple n0=new NoeudSimple(-100,-100);
         cx=Lire.d();
         cy=Lire.d();
         for (int i=0;i<tabns.size();i++){
             if ((tabns.get(i).getPx()==cx)&&(tabns.get(i).getPy()==cy)){
                 System.out.println(tabns.get(i).toString()+"son nombre d'inconnues "+nbrInconnues(tabns.get(i)) );
                 return(tabns.get(i));
               
             }  
         }
         for (int i=0;i<tabnAs.size();i++){
             if ((tabnAs.get(i).getPx()==cx)&&(tabnAs.get(i).getPy()==cy)){
                 System.out.println(tabnAs.get(i).toString()+"son nombre d'inconnues "+nbrInconnues(tabnAs.get(i)) );
                 return(tabnAs.get(i));
             }  
         }
         for (int i=0;i<tabnAd.size();i++){
             if ((tabnAd.get(i).getPx()==cx)&&(tabnAd.get(i).getPy()==cy)){
                 System.out.println(tabnAd.get(i).toString()+"son nombre d'inconnues "+nbrInconnues(tabnAd.get(i)) );
                return(tabnAd.get(i));
             }  
         }
         System.out.println("le noeud n'existe pas");
       return(null);
    }
    
     
      public  static int  ChoixtypeNoeud(){
        System.out.println("quelle type de noeud veux tu creer: 1 pour Noeud Simple, 2 Noeud Appui Simple,3 Noeud appui Double");
        int a=Lire.i();
        return(a);
      }
       
       
       public  int  nbrInconnues(Object noeud){
           if (noeud.getClass() == NoeudSimple.class) {
            return(0);
        } else if (noeud.getClass() == NoeudAppuiSimple.class) {
           return(1);
        } 
            return(2);
        //il retourne pour un noeud appuie double
           
       }
       
}
