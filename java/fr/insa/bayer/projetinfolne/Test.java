/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.bayer.projetinfolne;

import java.util.ArrayList;
import matrice.Matrice;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Date;
 
/**
 *
 * @author etien
 */
public class Test {
    public static void main (String[] args){
        
        
               
        ArrayList<Barre>listBarres = new ArrayList<Barre>();
        ArrayList<Noeud>listNoeuds = new ArrayList<Noeud>();
        Treillis treillis = new Treillis(listBarres,listNoeuds);
        
        
       /**
        double cx,cy;
        
        ArrayList<Vecteur2D>tabv ;
        tabv=new ArrayList<Vecteur2D> (10);
        
        ArrayList<NoeudSimple>tabns ;
        tabns=new ArrayList<NoeudSimple> (10);
         
        ArrayList<NoeudAppuiSimple>tabnAs ;
        tabnAs=new ArrayList<NoeudAppuiSimple> (10);
        
        ArrayList<NoeudAppuiDouble>tabnAd ;
        tabnAd=new ArrayList<NoeudAppuiDouble> (10);
        
        int n=3;
        double[] coeffs = new double[n];
        for(int i=0;i<n;i++){                             //[+2,3,4 ]   COEFFS DE VECTEURS
               coeffs[i] = i+2;                           //
        }
        Matrice vect = Matrice.creeVecteur(coeffs);
        System.out.println(vect.toString());
        //[+2,00E+00 ]
        //[+3,00E+00 ]
        //[+4,00E+00 ]
        Matrice m = new Matrice (n,n);
        double k=2;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                m.getCoeffs()[i][j]= k;
                k=k+1;
            }
        }
        System.out.println(m.toString());
        //[+2,00E+00 +3,00E+00 +4,00E+00 ]
        //[+5,00E+00 +6,00E+00 +7,00E+00 ]
        //[+8,00E+00 +9,00E+00 +1,00E+01 ]
        
         m = m.concatCol(vect); //met sous forme de système matriciel
       System.out.println("Systeme a resoudre :");
       System.out.println(m.toString());
       //[+2,00E+00 +3,00E+00 +4,00E+00 +2,00E+00 ]
       //[+5,00E+00 +6,00E+00 +7,00E+00 +3,00E+00 ]
       //[+8,00E+00 +9,00E+00 +1,00E+01 +4,00E+00 ]
       m.descenteGauss();
       //[+8,00E+00 +9,00E+00 +1,00E+01 +4,00E+00 ]
       //[+0,00E+00 +7,50E-01 +1,50E+00 +1,00E+00 ]
       //[+0,00E+00 +0,00E+00 +0,00E+00 +0,00E+00 ]
       // matrice non inversible
       
       
       m = Matrice.matTest2(n);
        m = m.concatCol(vect); //met sous forme de système matriciel
        System.out.println("Systeme a resoudre :");
        System.out.println(m.toString());
        //m.descenteGauss();//PIVOT DE GAUSS FORME ECHELONNEE ; voir feuille tp 13/05/2022
        m.resolution();
        
        
        
       Matrice m2= new Matrice(n,n);
       m2.getCoeffs()[0][0]=3;m2.getCoeffs()[0][1]=4;m2.getCoeffs()[0][2]=-1;m2.getCoeffs()[1][0]=1;m2.getCoeffs()[1][1]=-1;m2.getCoeffs()[1][2]=+2;m2.getCoeffs()[2][0]=2;m2.getCoeffs()[2][1]=3;m2.getCoeffs()[2][2]=-4;
       double []coeffs2 = {23,3,7};
       Matrice vect2 = Matrice.creeVecteur(coeffs2);
       m2 = m2.concatCol(vect2);
       System.out.println("Systeme a resoudre :");
       System.out.println(m2.toString());
       m2.resolution();
       
       treillis.testMatriceTreillis();
       **/
       
       
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
        
        NoeudSimple n0=new NoeudSimple(1,-100,-100);
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
