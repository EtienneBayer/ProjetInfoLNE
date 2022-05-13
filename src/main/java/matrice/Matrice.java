/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package matrice;
import fr.insa.bayer.projetinfolne.*;

/**
 *
 * @author etien
 */
public class Matrice {
    //définition des attributs
    private int nbrLig;
    private int nbrCol;
    double[][] coeffs; 
    
    public Matrice(int nl, int nc){  //constructeur 
        this.nbrLig = nl;
        this.nbrCol = nc;
        this.coeffs = new double[nl][nc];
    }
    
    public int getNbrLig (){
        return this.nbrLig;
    }
    public int getNbrCol (){
        return this.nbrCol;
    }
    public void setNbrLig(int nbrLig){
        this.nbrLig = nbrLig;
    }
    public void setNbrCol(int nbrCol){
        this.nbrCol = nbrCol;
    }
    
    public double get(int i, int j){
        return this.coeffs[i][j];
    }
    public void set(int i, int j, double x){
        if(0<=i && i<this.nbrLig && 0<=j && j<this.nbrCol){
            this.coeffs[i][j] = x;
        }
    }
    
    @Override
    public String toString(){
        String res = ""; //chaine retournée par la méthode 
        for (int i=0;i<this.nbrLig;i++){
           res = res + "[";
           for(int j=0;j<this.nbrCol;j++){
              res = res + String.format("%+4.2E",this.coeffs[i][j]) + " ";
            }
           res = res + "]\n";
        }
       return res;
    }
    
    public static Matrice identite(int n){  
        Matrice id = new Matrice(n,n);
        for(int i=0;i<n;i++){
            id.coeffs[i][i]=1;
        }
        return id;
    }
    
    public static Matrice matTest1(int n){
        Matrice mat = new Matrice(n,n);
        double k=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                mat.coeffs[i][j] = k;
                k++;
            }
        }
        return mat;
    }
    
    public static Matrice matTest2(int n){  
        Matrice mat = matTest1(n);
        for(int i=0;i<n;i++){
            mat.coeffs[i][i] = -mat.coeffs[i][i];
        }
        return mat;
    }
    
    public static int aleaUnOuDeux (){
        return((int)Math.round(Math.random()+1));  //renvoie un nombre aléatoire entre 1 et 2 arrondi à l'unité (1 ou 2)
    }
    
    public static Matrice matAleaZeroUnDeux(int nl, int nc, double pz){  //crée matrice de taille nl*nc (pz : proba que coeff = 0)
        Matrice m = new Matrice(nl,nc);
        for(int i=0;i<nl;i++){
            for(int j=0;j<nc;j++){
                if(Math.random()<=pz){  //pour tout nombre aléa entre 0 et pz
                    m.coeffs[i][j] = 0;  //affecte 0 au coeff
                }
                else{
                    m.coeffs[i][j] = aleaUnOuDeux();  //affecte aléatoirement 1 ou 2 avec même proba
                }
            }
        }
        return m;
    }
    
    public static Matrice creeVecteur (double[] coeffs){
        Matrice mat = new Matrice(coeffs.length,1);
        for(int i=0;i<coeffs.length;i++){
            mat.coeffs[i][0] = coeffs[i];
        }
        return mat;
    }
    
    public static Matrice test1(double pz) {
        Matrice m;
        m = matAleaZeroUnDeux(4,6,pz);  //construit une matrice avec P(0) = pz et P(1)=P(2)
        return m;
    }
    
    //c'est mieux de faire des méthodes statiques pour les concaténations
    public Matrice concatLig (Matrice mat2){
        int nl1 = this.nbrLig;
        int nc1 = this.nbrCol;
        int nl2 = mat2.getNbrLig();
        int nc2 = mat2.getNbrCol();
        Matrice R = new Matrice(nl1+nl2,nc1) ;  //nouvelle matrice de taille (nl1+nl2)*nc
        if(nc1 == nc2){  //vérifie que le nombre de colonnes des 2 matrices est égal
           int i,j;
           for(i=0;i<nl1;i++){
               for(j=0;j<nc1;j++){
                   R.coeffs[i][j] = this.coeffs[i][j];
                }
            }
           for(i=nl2;i<nl1+nl2;i++){
               for(j=0;j<nc1;j++){
                   R.coeffs[i][j] = mat2.coeffs[i-nl1][j];
               }
           } 
        }
        else {
            throw new Error ("pas le meme nombre de colonnes");
        }
        return R;
    }
    
    
    public Matrice concatCol (Matrice mat2){
        int nl1 = this.nbrLig;
        int nc1 = this.nbrCol;
        int nl2 = mat2.getNbrLig();
        int nc2 = mat2.getNbrCol();
        Matrice R = new Matrice(nl1,nc1+nc2) ;  //nouvelle matrice de taille nl*(nc1+nc2)
        if(nl1 == nl2){  //vérifie que le nombre de lignes des 2 matrices est égal
           int i,j;
           for(i=0;i<nl1;i++){
               for(j=0;j<nc1;j++){
                   R.coeffs[i][j] = this.coeffs[i][j];
                }
            }
           for(i=0;i<nl1;i++){
               for(j=nc1;j<nc1+nc2;j++){
                   R.coeffs[i][j] = mat2.coeffs[i][j-nc1];
               }
           } 
        }
        else {
            throw new Error ("pas le meme nombre de lignes");
        }
        return R;
    }
    
    public Matrice subLignes(int nMin, int nMax){
        Matrice mat = new Matrice(nMax-nMin+1,this.nbrCol);
        for(int i=0;i<mat.nbrLig;i++){
            for(int j=0;j<mat.nbrCol;j++){
                mat.coeffs[i][j] = this.coeffs[nMin+i][j];
            }
        }
        return mat;
    }
    
    public Matrice subCols(int nMin, int nMax){
        Matrice mat = new Matrice(this.nbrLig,nMax-nMin+1);
        for(int i=0;i<mat.nbrLig;i++){
            for(int j=0;j<mat.nbrCol;j++){
                mat.coeffs[i][j] = this.coeffs[i][nMin+j];
            }
        }
        return mat;
    }
    
    public Matrice transposee (){
        Matrice mt = new Matrice(this.nbrCol,this.nbrLig);  //cree la matrice transposée
        for(int i=0;i<this.nbrLig;i++){  //remplit la matrice transposée
            for(int j=0;j<this.nbrCol;j++){
                mt.coeffs[i][j] = this.coeffs[j][i];
            }
        }
        return mt;
    }
    
    public static Matrice metAuCarre (Matrice m){
        int n = m.nbrLig;
        int c = m.nbrCol;
        Matrice mt, idn, idc;
        mt = m.transposee();
        idn = identite(n);
        idc = identite(c);
        
        return m.concatCol(idn).concatLig(idc.concatCol(mt)) ;  //renvoie la concaténation de M/Idn/Idc/Mt
    }

    public static int intAlea (int bMin, int bMax){
        return (int) ( (Math.random()*(bMax-bMin))+ bMin );
    }
    
    public static void test2(){
        int nl = intAlea(2,4);
        int nc = intAlea(2,4);
        Matrice M = matAleaZeroUnDeux(nl,nc,0.33);
        System.out.println("matrice de base :");
        System.out.println(M.toString());
        Matrice MC = metAuCarre(M);
        System.out.println("matrice au carre :");
        System.out.println(MC.toString());
        System.out.println("matrice m bis");
        Matrice Mbis = MC;
        Mbis = Mbis.subLignes(0,nl-1);
        Mbis = Mbis.subCols(0, nc-1);
        System.out.println(Mbis.toString());
    }
    
    public Matrice add(Matrice m2) {
        if (this.getNbrLig() != m2.getNbrLig() || this.getNbrCol() != m2.getNbrCol()) {
            throw new Error("tailles incompatibles pour add");
        }
        Matrice res = new Matrice(this.getNbrLig(), this.getNbrCol());
        for (int i = 0; i < res.getNbrLig(); i++) {
            for (int j = 0; j < res.getNbrCol(); j++) {
                res.set(i, j, this.get(i, j) + m2.get(i, j));
            }
        }
        return res;
    }
    
    public Matrice opp() {
        Matrice res = new Matrice(this.getNbrLig(), this.getNbrCol());
        for (int i = 0; i < res.getNbrLig(); i++) {
            for (int j = 0; j < res.getNbrCol(); j++) {
                res.set(i, j, -this.get(i, j));
            }
        }
        return res;
    }
    
    public Matrice moins(Matrice m2) {
        return this.add(m2.opp());
    }
    
    public Matrice mult(Matrice m2) {
        if (this.getNbrCol() != m2.getNbrLig()) {
            throw new Error("tailles incompatibles pour mult");
        }
        Matrice res = new Matrice(this.getNbrLig(), m2.getNbrCol());
        for (int i = 0; i < res.getNbrLig(); i++) {
            for (int j = 0; j < res.getNbrCol(); j++) {
                double cur = 0;
                for (int k = 0; k < this.getNbrCol(); k++) {
                    cur = cur + this.get(i, k) * m2.get(k, j);
                }
                res.set(i, j, cur);
            }
        }
        return res;
    }
    
    public static void test3(){
        Matrice m = Matrice.matTest1(3);
        System.out.println("m*m^2 :");
        System.out.println(m.add(m.mult(m)).toString());
    }
    
    public int permuteLigne(int l1, int l2){
        int egal=0;  //compte le nb de coeffs égaux entre les deux lignes
        double temp;
        for(int c=0;c<this.nbrCol;c++){
            if(this.coeffs[l1][c] == this.coeffs[l2][c]){
                egal++;
            }
            else {  //permutation des coeffs
                temp = this.coeffs[l1][c];
                this.coeffs[l1][c] = this.coeffs[l2][c];
                this.coeffs[l2][c] = temp;
            }
        }
        if(egal == this.nbrCol){  //les 2 lignes sont identiques
            return 1;  //signature permutation
        }
        else{
            return -1; //signature permutation
        }
    }
    
    public void transvection(int l1, int l2){  
        if(this.coeffs[l1][l1] != 0){ 
            double p = this.coeffs[l2][l1]/this.coeffs[l1][l1]; 
            for(int i=0;i<this.nbrCol;i++){
                if(i==l1){
                    this.coeffs[l2][i] = 0;
                }
                else{
                    this.coeffs[l2][i] = this.coeffs[l2][i] - p*(this.coeffs[l1][i]);
                }
            }
            if(p != 0){
                System.out.println("transvection : "+"L"+l2+" recoit "+"L"+l2+"- "+p+" x "+"L"+l1);
            }
            else{
                System.out.println("transvection : "+"L"+l2+" ne change pas");
            }
        }
        else{
            throw new Error ("pivot nul");
        }  
    }
    
    public int lignePlusGrandPivot(int e){  
        double EPSILON_PIVOT = Math.pow(10,-8);
        int iMax=-1;
        double max = 0;
        for(int i=e+1;i<this.nbrLig;i++){
            if(Math.abs(this.coeffs[i][e])>max) {  //si valeur absolue de l'élément > max
                max = this.coeffs[i][e];
                iMax = i;
            }
        }
        if(Math.abs(max)<EPSILON_PIVOT){
           iMax=-1; 
        }
        return iMax;
    }
   
    public ResGauss descenteGauss (){ 
        int col; //compteur de étapes = nombre de colonnes de la matrice à inverser
        ResGauss resultat = new ResGauss();
        int sigPermut = 1;  //signature des permutations
        
        for(col=0;col<this.nbrCol-2;col++){  //ne traite ni la dernière colonne (coeffs) ni l'avant dernière (élément diagonal)
            System.out.println("etape "+col+" :");
            //if(this.coeffs[col][col]==0){  //si pivot nul
                int iMax = this.lignePlusGrandPivot(col);
                if(iMax==-1){
                    System.out.println("pas de pivot trouve");
                    System.out.println("matrice non inversible");  
                }
                else{
                    sigPermut = sigPermut * this.permuteLigne(col,iMax); //inverse avec la ligne du + grand pivot 
                    System.out.println("permutation lignes "+col+" et "+iMax);
                }
           // }
            for(int i=col+1;i<this.nbrLig;i++){  //pour toutes les lignes sous le pivot
                this.transvection(col, i);  //supprime le coef sur la ligne actuelle à l'aide du pivot (ligne e)
            }
            System.out.println(this.toString());
        }
        
        boolean inversible =true;
        for(col=0;col<this.nbrCol-1;col++){  //vérifie que les coeffs diagonaux sont non nuls
            if(this.coeffs[col][col]==0.0){
                inversible=false;
            }
        }
        if(inversible==true){
            System.out.println("matrice inversible");
        }
        else{
           System.out.println("matrice non inversible"); 
        }
        resultat.rang = col;
        resultat.signature = sigPermut;
        return resultat;
    }
    
    //test du pivot de Gauss sur les matrices MatTest1 et MatTest2 :
    public static void test4 (int n){  
        //création des coeffs d'un vecteur ;
        double[] coeffs = new double[n];
        for(int i=0;i<n;i++){
            coeffs[i] = i+1;
        }
        Matrice vect = Matrice.creeVecteur(coeffs);
        //résolution de matTest1 concaténée au vecteur (1,2,...n)
        Matrice m = Matrice.matTest1(n);
        m = m.concatCol(vect); //met sous forme de système matriciel
        System.out.println("Systeme a resoudre :");
        System.out.println(m.toString());
        m.descenteGauss();
        
        System.out.println();
        
        //résolution de matTest2 concaténée au vecteur (1,2,...n)
        m = Matrice.matTest2(n);
        m = m.concatCol(vect); //met sous forme de système matriciel
        System.out.println("Systeme a resoudre :");
        System.out.println(m.toString());
        m.descenteGauss();
    }
    
     public ResGauss remonteeGauss(){  //similaire à descente Gauss
        int col; //compteur de étapes = nombre de colonnes de la matrice à inverser
        ResGauss resultat = new ResGauss();
        //pas besoin de permutation car éléments diagonaux sont tous égal à 1
        for(col=this.nbrCol-2;col>0;col=col-1){  //ne traite ni la dernière colonne (coeffs) ni la première (élément diagonal)
            System.out.println("etape "+(this.nbrCol-2-col)+" :");
            for(int i=col-1;i>=0;i=i-1){  //pour toutes les lignes au-dessus du pivot
                this.transvection(col, i);  //supprime le coef sur la ligne actuelle à l'aide du pivot (ligne e)
            }
            System.out.println(this.toString());
        }
        
        boolean inversible =true;
        for(col=0;col<this.nbrCol-1;col++){  //vérifie que les coeffs diagonaux sont non nuls
            if(this.coeffs[col][col]==0.0){
                inversible=false;
            }
        }
        if(inversible==true){
            System.out.println("matrice inversible");
        }
        else{
           System.out.println("matrice non inversible"); 
        }
        resultat.rang = col;
        resultat.signature = 1;
        return resultat;
    }
    
     
    //méthode faisant toutes les étapes du pivot de gauss et renvoyant la matrice résultat
    public Matrice resolution(){
        this.descenteGauss();
        for(int i=0; i<this.nbrLig; i++){
            for(int j=this.nbrCol-1; j>=0;j--){
                this.coeffs[i][j]=this.coeffs[i][j]/this.coeffs[i][i]; //rend éléments diagonaux unitaires
            }
        }
        this.remonteeGauss();
        return this.subCols(this.nbrCol-1,this.nbrCol-1);
    } //donne matrice solution, maintenant il faut identifier inconnues
    
 
    public Matrice supprimeCol(int c){
        if(c==0){
            return this.subCols(1, this.nbrCol-1);
        }
        else{
            if(c==this.nbrCol-1){
                return this.subCols(0, this.nbrCol-2);
            }
            else{
                Matrice M1 = this.subCols(0, c-1);
                Matrice M2=this.subCols(c+1, this.nbrCol-1);
                return M1.concatCol(M2);
            }
        }

    }
    
     //méthode qui construit matrices associées au treilli
    public static Matrice systeme(Treillis treillis){
        Matrice coeffs=new Matrice(2*treillis.getListNoeuds().size(),2*treillis.getListNoeuds().size()); //nb lignes=nb colonnes=2*nb noeuds nb colonnes
        Matrice cst=new Matrice(2*treillis.getListNoeuds().size(), 1);  //partie droite de l'égalité matricielle (vecteur colonne)

       int l=0; //ligne
      //première boucle for: traction
        for (int n=0; n<treillis.getListNoeuds().size();n++){  //pour chaque noeud
            for (int b=0; b<treillis.getListBarres().size();b++){ //pour chaque barre et chaque colonne

                projectionTraction(coeffs, b, l, treillis, n, b);
            }
            projectionForce(cst, treillis, n, l);
            l=l+2;
        }
        //deuxième boucle for: reaction
        l=2*treillis.getListNoeudsSimple().size();
        int colonneR=treillis.getListBarres().size(); // variable indiquant colonne de la reaction
        for (int n=0; n<treillis.getListNoeudsAppui().size();n++){  //parcours liste noeuds appuis  
            projectionReaction(coeffs, colonneR, l, treillis, n);
            colonneR++;
            if(treillis.getListNoeudsAppui().get(n).getClass().getSimpleName().equals("AppuiDouble")){
                colonneR++; //laisse colonne pour réaction à 2 inconnues
            }
            l=l+2;
        }
    return coeffs.concatCol(cst);
    }
    
    public static Matrice projectionTraction(Matrice coeffs, int c, int l, Treillis treillis, int n, int b){
        if (treillis.getListNoeuds().get(n)==treillis.getListBarres().get(b).getNd()||treillis.getListNoeuds().get(n)==treillis.getListBarres().get(b).getNa()){ // Si noeud est le noeud de début ou fin de la barre 
            double angle_b = Math.atan(treillis.getListBarres().get(b).coefDir()); // angle entre barre et horizontale
            if (treillis.getListNoeuds().get(n).getPx()<treillis.getListBarres().get(b).getNd().getPx()||treillis.getListNoeuds().get(n).getPx()<treillis.getListBarres().get(b).getNd().getPx()){ //si noeud est à l'extrémité gauche
                System.out.println("coef dir barre"+treillis.getListBarres().get(b).getID()+" :"+treillis.getListBarres().get(b).coefDir());
                System.out.println("angle barre"+treillis.getListBarres().get(b).getID()+":"+angle_b);
                coeffs.set(l,c,arrondi(Math.cos(angle_b))); //remplie matrice coeffs avec projection traction sur axe x
                coeffs.set(l+1,c,arrondi(Math.sin(angle_b)));//remplie matrice coeffs avec projection traction sur axe y
                // a est bien en radian car atan retourne un angle en radians
            }
            else{
                if(treillis.getListBarres().get(b).coefDir()==10000){ // si barre verticale
                    if(treillis.getListNoeuds().get(n).getPy()<treillis.getListBarres().get(b).getNd().getPy()||treillis.getListNoeuds().get(n).getPy()<treillis.getListBarres().get(b).getNa().getPy()){ //si noeud est en bas
                        coeffs.set(l+1,c,arrondi(Math.sin(angle_b)));//remplie matrice coeffs avec projection traction sur axe y
                    }
                    if(treillis.getListNoeuds().get(n).getPy()>treillis.getListBarres().get(b).getNd().getPy()||treillis.getListNoeuds().get(n).getPy()>treillis.getListBarres().get(b).getNa().getPy()){ //si noeud est en bas
                        coeffs.set(l+1,c,arrondi(-Math.sin(angle_b)));//remplie matrice coeffs avec projection traction sur axe y
                    }
                }
                else{ //noeuds est à l'extrémité droite
                    coeffs.set(l,c,arrondi(-Math.cos(angle_b))); //remplie matrice coeffs avec projection traction sur axe x
                    coeffs.set(l+1,c,arrondi(-Math.sin(angle_b)));//remplie matrice coeffs avec projection traction sur axe y
                }// a est bien en radian car atan retourne un angle en radians
            }
        }
        return coeffs;  //renvoi du tableau inutile car déjà modifié
    }
    
    public static Matrice projectionReaction(Matrice coeffs, int c, int l, Treillis treillis, int n){
        double angle_t= Math.atan(treillis.getListNoeudsAppui().get(n).getSegment().coefDir()); //angle terrain
            if(treillis.getListNoeudsAppui().get(n).getClass().getSimpleName().equals("AppuiDouble")){ //Si noeud est un appui double, Rx et Ry inconnues
                coeffs.set(l,c,1); //Rx
                coeffs.set(l+1,c+1,1);//Ry
            }
            else{ //Si noeud est un appui simple, réaction est perpendiculaire au terrain
                if (treillis.getListNoeudsAppui().get(n).getSegment().coefDir()<0 ||treillis.getListNoeudsAppui().get(n).getSegment().coefDir()==10000){
                    coeffs.set(l,c,arrondi(Math.cos(angle_t+Math.PI/2)));
                    coeffs.set(l+1,c,arrondi(Math.sin(angle_t+Math.PI/2)));
                }
                else{
                    coeffs.set(l,c,arrondi(Math.cos(angle_t-Math.PI/2)));
                    coeffs.set(l+1,c,arrondi(Math.sin(angle_t-Math.PI/2)));
                }
            }
        return coeffs;
    }
    
    
    public static Matrice projectionForce(Matrice cst,Treillis treillis, int n, int l){
            for(int f=0; f<treillis.getListVecteur2D().size(); f++){ // pour chaque force associée au treillis
                if (treillis.getListVecteur2D().get(f).getNoeud()==treillis.getListNoeuds().get(n)){ // si force est appliquée à ce noeud
                    double angle_f=Math.atan(treillis.getListVecteur2D().get(f).getCoefDir()); //angle force
                    cst.set(l, 0, arrondi(treillis.getListVecteur2D().get(f).getValeur()*Math.cos(angle_f)));  // remplie matrice constante
                    cst.set(l+1, 0, arrondi(treillis.getListVecteur2D().get(f).getValeur()*Math.sin(angle_f)));
                    break; // 1 seule force par noeud
                }
            }
        return cst;
    }
    
    
    public static double arrondi(double d){
        if(d>0 && d<Math.pow(10,-2)|| d<0 && d>-Math.pow(10,-2)){
            return 0;
        }
        else{
            return d;
        }
    }
}
