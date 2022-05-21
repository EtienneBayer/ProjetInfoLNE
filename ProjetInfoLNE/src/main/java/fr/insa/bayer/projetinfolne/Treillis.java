/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.bayer.projetinfolne;


import static fr.insa.bayer.projetinfolne.Test.ChoixtypeNoeud;
import java.util.ArrayList;
import matrice.Matrice;



/**
 *
 * @author etien
 */
public class Treillis {
    private   ArrayList<Barre>listBarres = new ArrayList<Barre>();
    private   ArrayList<Noeud>listNoeuds = new ArrayList<Noeud>();
    private   ArrayList<NoeudAppui>listNoeudsAppui = new ArrayList<NoeudAppui>() ;
    private   ArrayList<NoeudSimple>listNoeudsSimple=new ArrayList<NoeudSimple>();
    private   ArrayList<NoeudAppuiSimple>listNoeudsAppuiSimple=new ArrayList<NoeudAppuiSimple>();
    private   ArrayList<NoeudAppuiDouble>listNoeudsAppuiDouble=new ArrayList<NoeudAppuiDouble>();
    private   ArrayList<Vecteur2D>listVecteur2D= new ArrayList<Vecteur2D>();
    
    public Treillis(ArrayList<Barre>listBarres,ArrayList<Noeud>listNoeuds){
        this.listBarres=listBarres;
        this.listNoeuds=listNoeuds;
    }  
    public Treillis(){
        ArrayList<Barre>listBarres = new ArrayList<Barre>();
        ArrayList<Noeud>listNoeuds = new ArrayList<Noeud>(); 
        ArrayList<NoeudAppui>listNoeudsAppui = new ArrayList<NoeudAppui>() ;
        ArrayList<NoeudSimple>listNoeudsSimple=new ArrayList<NoeudSimple>();
        ArrayList<NoeudAppuiSimple>listNoeudsAppuiSimple=new ArrayList<NoeudAppuiSimple>();
        ArrayList<NoeudAppuiDouble>listNoeudsAppuiDouble=new ArrayList<NoeudAppuiDouble>();
        ArrayList<Vecteur2D>listVecteur2D= new ArrayList<Vecteur2D>();
        this.listBarres=listBarres;
        this.listNoeuds = listNoeuds;
        this.listNoeudsAppui=listNoeudsAppui;
        this.listNoeudsSimple=listNoeudsSimple;
        this.listNoeudsAppuiSimple=listNoeudsAppuiSimple;
        this.listNoeudsAppuiDouble=listNoeudsAppuiDouble;
        this.listVecteur2D=listVecteur2D;
    } 
    
     public  void MenuTexte(){
         /**
        ArrayList<Barre>listBarres = new ArrayList<Barre>();
        ArrayList<NoeudSimple>tabns ;
        tabns=new ArrayList<NoeudSimple> (10);
         
        ArrayList<NoeudAppuiSimple>tabnAs ;
        tabnAs=new ArrayList<NoeudAppuiSimple> (10);
        
        ArrayList<NoeudAppuiDouble>tabnAd ;
        tabnAd=new ArrayList<NoeudAppuiDouble> (10);
        **/
        Treillis treillis = new Treillis();
                    
        
        
        System.out.println(" (1) afficher le treillis");
        System.out.println(" (2) creer un nouveau noeud");
        System.out.println(" (3) créer une nouvelle barre entre deux noeuds existants");
        System.out.println(" (4) supprimer une barre");
        System.out.println(" (5) supprimer une noeud");
        System.out.println(" (6) Afficher la matrice résolution du treillis ");
        System.out.println(" (0) quitter");
    
        int choix = Lire.i();
        while (choix!=0){


        if (choix==1){

            affichTreillis(treillis.getListNoeudsSimple(),treillis.getListNoeudsAppuiSimple(),treillis.getListNoeudsAppuiDouble(),treillis.getListBarres());
            System.out.println("");
        }
        if (choix==2){
        
            int a =ChoixtypeNoeud();
            if (a==1){
                NoeudSimple ns = new NoeudSimple();
              
          
                ns=((NoeudSimple) ENTRENOEUD(treillis.getListNoeudsSimple(),treillis.getListNoeudsAppuiSimple(),treillis.getListNoeudsAppuiDouble(), a));  //ici, on converti un objet en noeud Simple pour le mettre dans ns
                treillis.listNoeudsSimple.add(ns);  
                treillis.listNoeuds.add(ns);
            }
        
            if (a==2){
                NoeudAppuiSimple nAs;
                nAs=(NoeudAppuiSimple) ENTRENOEUD(treillis.getListNoeudsSimple(), treillis.getListNoeudsAppuiSimple(), treillis.getListNoeudsAppuiDouble(), a);
                treillis.listNoeudsAppuiSimple.add(nAs);
                treillis.listNoeuds.add(nAs);
            }
            if (a==3){ 
                NoeudAppuiDouble nAd;
                nAd=(NoeudAppuiDouble) ENTRENOEUD(treillis.getListNoeudsSimple(), treillis.getListNoeudsAppuiSimple(), treillis.getListNoeudsAppuiDouble(), a);
                treillis.listNoeudsAppuiDouble.add(nAd);
                treillis.listNoeuds.add(nAd);
            }
        }
        if (choix==3){

           Noeud n1=Noeudcherche(treillis.getListNoeudsSimple(),treillis.getListNoeudsAppuiSimple(),treillis.getListNoeudsAppuiDouble());
           Noeud n2=Noeudcherche(treillis.getListNoeudsSimple(),treillis.getListNoeudsAppuiSimple(),treillis.getListNoeudsAppuiDouble());
           Barre b = new Barre(1,n1,n2);
           System.out.println("coucou");
           b=b.CreerBarre(n1, n2);
           System.out.println("la barre cree entre 2 noeuds :");
           System.out.println(b.toString());
           treillis.listBarres.add(b);
           System.out.println("");
           affichbarre(treillis.listBarres);
           System.out.println("");

        }
        if (choix==4){
            SupprBarre(treillis.listBarres);
            affichbarre(treillis.listBarres);
            System.out.println("");
       }
       if (choix==5){
           Object noeuasuppr;
            noeuasuppr=Noeudcherche(treillis.getListNoeudsSimple(),treillis.getListNoeudsAppuiSimple(),treillis.getListNoeudsAppuiDouble());
           int typeNoeud = nbrInconnues(noeuasuppr);
           System.out.println("le type de noeud "+typeNoeud);
           if (typeNoeud==0){
               NoeudSimple nsasuppr = new NoeudSimple();
               
               nsasuppr=(NoeudSimple)noeuasuppr;
               treillis.listBarres.remove(nsasuppr.getbarresArrivee());
               treillis.listBarres.remove(nsasuppr.getbarresDepart());
               treillis.listNoeudsSimple.remove(nsasuppr);
               treillis.listNoeuds.remove(nsasuppr);
               
           }
           if (typeNoeud==1){
               NoeudAppuiSimple nAsasuppr = new NoeudAppuiSimple();
               
               nAsasuppr=(NoeudAppuiSimple)noeuasuppr;
               treillis.listBarres.remove(nAsasuppr.getbarresArrivee());
               treillis.listBarres.remove(nAsasuppr.getbarresDepart());
               treillis.listNoeudsAppuiSimple.remove(nAsasuppr);
               treillis.listNoeuds.remove(nAsasuppr);
           }
           if (typeNoeud==2){
               NoeudAppuiDouble nAdasuppr = new NoeudAppuiDouble();
               
               nAdasuppr=(NoeudAppuiDouble)noeuasuppr;
               treillis.listBarres.remove(nAdasuppr.getbarresArrivee());
               treillis.listBarres.remove(nAdasuppr.getbarresDepart());
               treillis.listNoeudsAppuiDouble.remove(nAdasuppr);
               treillis.listNoeuds.remove(nAdasuppr);
           }
           affichnoeud(treillis.getListNoeudsSimple(),treillis.getListNoeudsAppuiSimple(),treillis.getListNoeudsAppuiDouble());
           System.out.println("");
           
           
           
           
        }
       if (choix==6){
            Terrain terrain = new Terrain(-50, 50, -50, 50);
            int TailleMatrice = treillis.getListBarres().size()+treillis.getListNoeudsSimple().size()+2*treillis.getListNoeudsAppuiDouble().size();  //la taille de la matrice est nb+nAs+2*nAd
            System.out.println("TailleMatrice "+TailleMatrice);
            
            
            
            Matrice matrice = new Matrice(TailleMatrice,TailleMatrice+1);
            
                
                    matrice=matrice.systeme3(treillis);
                    System.out.println(matrice.toString());
                    matrice.resolution();
                   for(int i=0;i<treillis.getListNoeuds().size();i++){
                        System.out.print("T"+(i+1)+"    ");
                    }
                    for(int i=0;i<treillis.getListNoeudsAppuiDouble().size();i++){
                        System.out.print("R"+treillis.getListNoeudsAppuiDouble().get(i).getId()+"x"+"    ");
                        System.out.print("R"+treillis.getListNoeudsAppuiDouble().get(i).getId()+"y"+"    ");
                    }
                    for(int i=0;i<treillis.getListNoeudsAppuiDouble().size();i++){
                        System.out.print("R"+treillis.getListNoeudsAppuiSimple().get(i).getId()+"    ");
                        
                    }
                    System.out.println(" ");
                    for(int i=0;i<2*treillis.getListNoeuds().size();i++){
                        System.out.print(matrice.Grosarrondi(matrice.get(i, 2*treillis.getListNoeuds().size())) +" " );
                    }
                    System.out.println("");
                    
                    
                   
            }   
       
        System.out.println(" (1) afficher le treillis");
        System.out.println(" (2) creer un nouveau noeud");
        System.out.println(" (3) créer une nouvelle barre entre deux noeuds existants");
        System.out.println(" (4) supprimer une barre");
        System.out.println(" (5) supprimer une noeud");
        System.out.println(" (6) Afficher la matrice résolution du treillis ");
        System.out.println(" (0) quitter");
        choix = Lire.i();
        
    }
     }
    
    public void testMatriceTreillis (){
        Terrain terrain = new Terrain(-50, 50, -50, 50);            //creation terrain
       
        
        NoeudAppuiDouble S1 = new NoeudAppuiDouble(1,0, 0);          //creation des noeuds
        NoeudAppuiSimple S2 = new NoeudAppuiSimple(2,0, 2);
        Vecteur2D v = new Vecteur2D(0, -1000);
        NoeudSimple S3 = new NoeudSimple(3,1, 1, v);
        
     
        Treillis treillis = new Treillis();   //creation du treillis
        
        treillis.listNoeuds.add(S1); treillis.listNoeuds.add(S2) ; treillis.listNoeuds.add(S3); //ajoute les noeuds aux listes des noeuds du treillis
        treillis.listNoeudsAppuiDouble.add(S1);treillis.listNoeudsAppuiSimple.add(S2);treillis.listNoeudsSimple.add(S3);
        
        treillis.listBarres.add(new Barre(1,S1, S3));treillis.listBarres.add(new Barre(2,S2, S3));treillis.listBarres.add(new Barre(3,S1, S2)); //ajoute les noeuds aux listes des noeuds du treillis
        treillis.listVecteur2D.add(v); //ajoute la force à liste des forces
        System.out.println(S1.toString());
        System.out.println(S2.toString());
        System.out.println(S3.toString());
        
        
       
        
        //NoeudSimple n2 = new NoeudSimple(4,0, 0, v);
        //NoeudSimple n3 = new NoeudSimple(5,0, -2, v);
        //Barre barreangle = new Barre(4, n2, n3);
        //System.out.println("angle barre test "+barreangle.Angle2(n2,n3)); 
        //System.out.println("angle barre test2 "+barreangle.coefDir());
    
        Matrice m = new Matrice(2*treillis.getListNoeuds().size(), 2*treillis.getListNoeuds().size()+1);
        m=m.systeme3(treillis);
        System.out.println(m.toString());
        m.resolution();
                    for(int i=0;i<treillis.getListNoeuds().size();i++){
                        System.out.print("T"+(i+1)+"    ");
                    }
                    for(int i=0;i<treillis.getListNoeudsAppuiDouble().size();i++){
                        System.out.print("R"+treillis.getListNoeudsAppuiDouble().get(i).getId()+"x"+"    ");
                        System.out.print("R"+treillis.getListNoeudsAppuiDouble().get(i).getId()+"y"+"    ");
                    }
                    for(int i=0;i<treillis.getListNoeudsAppuiDouble().size();i++){
                        System.out.print("R"+treillis.getListNoeudsAppuiSimple().get(i).getId()+"    ");
                        
                    }
                    System.out.println(" ");
                    for(int i=0;i<2*treillis.getListNoeuds().size();i++){
                        System.out.print(m.Grosarrondi(m.get(i, 2*treillis.getListNoeuds().size())) +" " );
                    }
                    System.out.println("");
                    
        
    
        NoeudAppuiDouble S4 = new NoeudAppuiDouble(4,0, 0);
        NoeudAppuiDouble S5 = new NoeudAppuiDouble(5,1, 1);
        NoeudAppuiDouble S6 = new NoeudAppuiDouble(6,0, 0);
        NoeudAppuiDouble S7 = new NoeudAppuiDouble(7,0, 0);
        NoeudAppuiDouble S8 = new NoeudAppuiDouble(8,0, 0);
        NoeudAppuiDouble S9 = new NoeudAppuiDouble(9,0, 0);
        
        //Barre b45 = new Barre(4,S5,S4);
        //System.out.println("angle barre"+b45.Angle3(b45));
    
    }
            
    public void SupprBarre (ArrayList<Barre>listBarres){
        System.out.println("quelle est l'ID de la barre");
        int idcherche=Lire.i();
        this.setListBarres(listBarres);
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
            
    
   
     public  Noeud Noeudcherche(ArrayList<NoeudSimple> tabns,ArrayList<NoeudAppuiSimple> tabnAs,ArrayList<NoeudAppuiDouble> tabnAd){      
       System.out.println("quelle est l'id du noeud cherche ?");
      int IDn1 = Lire.i();
      
      
       for (int i=0;i<tabns.size();i++){
             if ((tabns.get(i).getId()==IDn1)){
                 System.out.println(tabns.get(i).toString()+"son nombre d'inconnues "+nbrInconnues(tabns.get(i))) ;
                 return(tabns.get(i));
               
             }  
         }
         for (int i=0;i<tabnAs.size();i++){
             if ((tabnAs.get(i).getId()==IDn1)){
                 System.out.println(tabnAs.get(i).toString()+"son nombre d'inconnues "+nbrInconnues(tabnAs.get(i)) );
                 return(tabnAs.get(i));
             }  
         }
         for (int i=0;i<tabnAd.size();i++){
             if ((tabnAd.get(i).getId()==IDn1)){
                 System.out.println(tabnAd.get(i).toString()+"son nombre d'inconnues "+nbrInconnues(tabnAd.get(i)) );
                return(tabnAd.get(i));
             }  
         }
         System.out.println("le noeud n'existe pas");
       return(null);
    }
       
       
       
       /**
        System.out.println("quelle sont les coordonnees cx et cy du point recherchees ?");
        double cx,cy;
        
        NoeudSimple n0=new NoeudSimple(1,-100,-100);
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
    * */
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
         public void affichTreillis(ArrayList<NoeudSimple>tabns,ArrayList<NoeudAppuiSimple>tabnAs,ArrayList<NoeudAppuiDouble>tabnAd,ArrayList<Barre>listBarres){
       
       affichbarre(listBarres);
       System.out.println("");
       affichnoeud(tabns,tabnAs,tabnAd);
                
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
            System.out.println("");
        }
         System.out.println("");
         for(int i=0;i<tabnAs.size();i++)
        {
            System.out.print(tabnAs.get(i).toString()+" ");
            System.out.println("");
        }
         System.out.println("");
         for(int i=0;i<tabnAd.size();i++)
        {
            System.out.print(tabnAd.get(i).toString()+" ");
            System.out.println("");
        }
         System.out.println("");
         
         
         
        
    }
    
     public int maxIdNoeud (ArrayList<Noeud> listNoeuds){
         this.setListNoeuds(listNoeuds);
         int i,max=0;
         
         for (i=0;i<listNoeuds.size();i++){
             if (listNoeuds.get(i).getId()>max){
                 max=listNoeuds.get(i).getId();
             }  
         }
         return (max); 
     }
     public int maxIdBarre (ArrayList<Barre> listBarres){
         this.setListBarres(listBarres);
         int i,max=0;
         
         for (i=0;i<listBarres.size();i++){
             if (listBarres.get(i).getID()>max){
                 max=listBarres.get(i).getID();
             }  
         }
         return (max); 
     }
     
     public void ajouteNoeud(Noeud n){
      if (getListNoeuds().contains(n)){
          System.out.print("le noeud est déja dans contenu dans le treillis");
      }else{
          n.setId(maxIdNoeud(getListNoeuds())+1);
            getListNoeuds().add(n);
          
      }   
     }
     public void ajouteBarre(Barre b){
      if (getListBarres().contains(b)){     
          System.out.print("le noeud est déja dans contenu dans le treillis");
      }else{
          if(getListNoeuds().contains(b.getNd())){
             //on fait rien   
            }else{
                getListNoeuds().add(b.getNd());             
          }
          if(getListNoeuds().contains(b.getNa())){
             //on fait rien   
            }else{
                getListNoeuds().add(b.getNa());             
          }
          
          b.setID(maxIdNoeud(getListNoeuds())+1);
            getListBarres().add(b);
          
      }   
     }
    

    /**
     * @return the listBarres
     */
    public ArrayList<Barre> getListBarres() {
        return listBarres;
    }

    /**
     * @param listBarres the listBarres to set
     */
    public void setListBarres(ArrayList<Barre> listBarres) {
        this.listBarres = listBarres;
    }

    /**
     * @return the listNoeuds
     */
    public ArrayList<Noeud> getListNoeuds() {
        return listNoeuds;
    }

    /**
     * @param listNoeuds the listNoeuds to set
     */
    public void setListNoeuds(ArrayList<Noeud> listNoeuds) {
        this.listNoeuds = listNoeuds;
    }

    /**
     * @return the listNoeudsAppui
     */
    public ArrayList<NoeudAppui> getListNoeudsAppui() {
        return listNoeudsAppui;
    }

    /**
     * @return the listNoeudsAppuiSimple
     */
    public ArrayList<NoeudAppuiSimple> getListNoeudsAppuiSimple() {
        return listNoeudsAppuiSimple;
    }

    /**
     * @return the listNoeudsAppuiDouble
     */
    public ArrayList<NoeudAppuiDouble> getListNoeudsAppuiDouble() {
        return listNoeudsAppuiDouble;
    }

    /**
     * @return the listNoeudsSimple
     */
    public ArrayList<NoeudSimple> getListNoeudsSimple() {
        return listNoeudsSimple;
    }

    /**
     * @return the listVecteur2D
     */
    public ArrayList<Vecteur2D> getListVecteur2D() {
        return listVecteur2D;
    }

    /**
     * @param listVecteur2D the listVecteur2D to set
     */
    public void setListVecteur2D(ArrayList<Vecteur2D> listVecteur2D) {
        this.listVecteur2D = listVecteur2D;
    }
    
    
    
   

    

  

    
}
