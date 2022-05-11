/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.bayer.projetinfolne;


import static fr.insa.bayer.projetinfolne.Test.ChoixtypeNoeud;
import java.util.ArrayList;



/**
 *
 * @author etien
 */
public class Treillis {
    private   ArrayList<Barre>listBarres;
    private   ArrayList<Noeud>listNoeuds;
    
    public  void MenuTexte(){
        ArrayList<Barre>listBarres = new ArrayList<Barre>();
        ArrayList<NoeudSimple>tabns ;
        tabns=new ArrayList<NoeudSimple> (10);
         
        ArrayList<NoeudAppuiSimple>tabnAs ;
        tabnAs=new ArrayList<NoeudAppuiSimple> (10);
        
        ArrayList<NoeudAppuiDouble>tabnAd ;
        tabnAd=new ArrayList<NoeudAppuiDouble> (10);
        
        
        System.out.println(" (1) afficher le treillis");
        System.out.println(" (2) creer un nouveau noeud");
        System.out.println(" (3) créer une nouvelle barre entre deux noeuds existants");
        System.out.println(" (4) supprimer une barre");
        System.out.println(" (5) supprimer une noeud");
        System.out.println(" (0) quitter");
    
        int choix = Lire.i();
        while (choix!=0){


        if (choix==1){

            affichTreillis(tabns,tabnAs,tabnAd,listBarres);
            System.out.println("");
        }
        if (choix==2){
        
            int a =ChoixtypeNoeud();
            if (a==1){
                NoeudSimple ns = new NoeudSimple();
              
          
                ns=((NoeudSimple) ENTRENOEUD(tabns, tabnAs, tabnAd, a));  //ici, on converti un objet en noeud Simple pour le mettre dans ns
                tabns.add(ns);  
            }
        
            if (a==2){
                NoeudAppuiSimple nAs;
                nAs=(NoeudAppuiSimple) ENTRENOEUD(tabns, tabnAs, tabnAd, a);
                tabnAs.add(nAs);
            }
            if (a==3){ 
                NoeudAppuiDouble nAd;
                nAd=(NoeudAppuiDouble) ENTRENOEUD(tabns, tabnAs, tabnAd, a);
                tabnAd.add(nAd);      
            }
        }
        if (choix==3){

           Noeud n1=Noeudcherche(tabns, tabnAs, tabnAd);
           Noeud n2= Noeudcherche(tabns, tabnAs, tabnAd); 
           Barre b = new Barre(n1,n2);
           System.out.println("coucou");
           b=b.CreerBarre(n1, n2);
           System.out.println("la barre cree entre 2 noeuds :");
           System.out.println(b.toString());
           listBarres.add(b);
           affichbarre(listBarres);
           System.out.println("");

        }
        if (choix==4){
            SupprBarre(listBarres);
            affichbarre(listBarres);
            System.out.println("");
       }
       if (choix==5){
           Object noeuasuppr;
            noeuasuppr=Noeudcherche(tabns, tabnAs, tabnAd);
           int typeNoeud = nbrInconnues(noeuasuppr);
           
           if (typeNoeud==1){
               NoeudSimple nsasuppr = new NoeudSimple();
               
               nsasuppr=(NoeudSimple)noeuasuppr;
               listBarres.remove(nsasuppr.getbarresArrivee());
               listBarres.remove(nsasuppr.getbarresDepart());
               tabns.remove(nsasuppr);
           }
           if (typeNoeud==2){
               NoeudAppuiSimple nAsasuppr = new NoeudAppuiSimple();
               
               nAsasuppr=(NoeudAppuiSimple)noeuasuppr;
               listBarres.remove(nAsasuppr.getbarresArrivee());
               listBarres.remove(nAsasuppr.getbarresDepart());
               tabnAs.remove(nAsasuppr);
           }
           if (typeNoeud==3){
               NoeudAppuiDouble nAdasuppr = new NoeudAppuiDouble();
               
               nAdasuppr=(NoeudAppuiDouble)noeuasuppr;
               listBarres.remove(nAdasuppr.getbarresArrivee());
               listBarres.remove(nAdasuppr.getbarresDepart());
               tabnAd.remove(nAdasuppr);
           }
           affichnoeud(tabns,tabnAs,tabnAd);
           System.out.println("");
           
           
           
           
        }
        System.out.println(" (1) afficher le treillis");
        System.out.println(" (2) creer un nouveau noeud");
        System.out.println(" (3) créer une nouvelle barre entre deux noeuds existants");
        System.out.println(" (4) supprimer une barre");
        System.out.println(" (5) supprimer une noeud");
        System.out.println(" (0) quitter");
        choix = Lire.i();
        }
    }
     
         
     
      
    
    
     
    
            
            
            
            
            
            
            
            
            
    public void SupprBarre (ArrayList<Barre>listBarres){
        System.out.println("quelle est l'ID de la barre");
        int idcherche=Lire.i();
        this.listBarres=listBarres;
        for(int i=0;i<listBarres.size();i++){
            if (listBarres.get(i).getID()==idcherche){
                listBarres.remove(listBarres.get(i));
            }
        }
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
            
    public Treillis(ArrayList<Barre>listBarres,ArrayList<Noeud>listNoeuds){
        this.listBarres=listBarres;
        this.listNoeuds=listNoeuds;
    } 
    public Treillis(ArrayList<Barre>listBarres){
        this.listBarres=listBarres;
    } 
    public void affichTreillis(ArrayList<NoeudSimple>tabns,ArrayList<NoeudAppuiSimple>tabnAs,ArrayList<NoeudAppuiDouble>tabnAd,ArrayList<Barre>listBarres){
       
       affichbarre(listBarres);
       System.out.println("");
       affichnoeud(tabns,tabnAs,tabnAd);
                
    }
     public  Noeud Noeudcherche(ArrayList<NoeudSimple> tabns,ArrayList<NoeudAppuiSimple> tabnAs,ArrayList<NoeudAppuiDouble> tabnAd){      
       
        System.out.println("quelle sont les coordonnees cx et cy du point recherchees ?");
        double cx,cy;
        
        NoeudSimple n0=new NoeudSimple(-100,-100);
         cx=Lire.d();
         cy=Lire.d();
         for (int i=0;i<tabns.size();i++){
             if ((tabns.get(i).getPx()==cx)&&(tabns.get(i).getPy()==cy)){
                 System.out.println(tabns.get(i).toString()+"son nombre d'inconnues "+nbrInconnues(tabns.get(i))) ;
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
             
    
    
    public void affichbarre (ArrayList<Barre>listBarres){
        
        for(int i=0;i<listBarres.size();i++)
        {
            
            System.out.print("la barre "+listBarres.get(i).getID()+" "+listBarres.get(i).toString()+" ");
            System.out.println("");
        }
         System.out.println();       
        
    }
     public void affichnoeud (ArrayList<NoeudSimple>tabns,ArrayList<NoeudAppuiSimple>tabnAs,ArrayList<NoeudAppuiDouble>tabnAd){
        for(int i=0;i<tabns.size();i++)
        {
            System.out.print(tabns.get(i).toString()+" ");
        }
         System.out.println();
         for(int i=0;i<tabnAs.size();i++)
        {
            System.out.print(tabnAs.get(i).toString()+" ");
        }
         System.out.println();
         for(int i=0;i<tabnAd.size();i++)
        {
            System.out.print(tabnAd.get(i).toString()+" ");
        }
         System.out.println();
         
         
         
        
    }
    
     public int maxIdNoeud (ArrayList<Noeud> listNoeuds){
         this.listNoeuds=listNoeuds;
         int i,max=0;
         
         for (i=0;i<listNoeuds.size();i++){
             if (listNoeuds.get(i).getId()>max){
                 max=listNoeuds.get(i).getId();
             }  
         }
         return (max); 
     }
     public int maxIdBarre (ArrayList<Barre> listBarres){
         this.listBarres=listBarres;
         int i,max=0;
         
         for (i=0;i<listBarres.size();i++){
             if (listBarres.get(i).getID()>max){
                 max=listBarres.get(i).getID();
             }  
         }
         return (max); 
     }
     
     public void ajouteNoeud(Noeud n){
      if (listNoeuds.contains(n)){
          System.out.print("le noeud est déja dans contenu dans le treillis");
      }else{
          n.setId(maxIdNoeud(listNoeuds)+1);
          listNoeuds.add(n);
          
      }   
     }
     public void ajouteBarre(Barre b){
      if (listBarres.contains(b)){     
          System.out.print("le noeud est déja dans contenu dans le treillis");
      }else{
          if(listNoeuds.contains(b.getNd())){
             //on fait rien   
            }else{
              listNoeuds.add(b.getNd());             
          }
          if(listNoeuds.contains(b.getNa())){
             //on fait rien   
            }else{
              listNoeuds.add(b.getNa());             
          }
          
          b.setID(maxIdNoeud(listNoeuds)+1);
          listBarres.add(b);
          
      }   
     }
    
    
    
    public ArrayList<Barre> getlistBarres(){
        return (this.listBarres);
    }
    public ArrayList<Noeud> getlistNoeuds(){
        return (this.listNoeuds);
    }
     public void setlistBarres(ArrayList<Barre> barres) {
        this.listBarres = barres;
    }
    public void setlistNoeuds(ArrayList<Noeud>noeuds) {
        this.listNoeuds = noeuds;
    }
    
}
