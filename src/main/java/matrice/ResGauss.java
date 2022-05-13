/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package matrice;
import matrice.Matrice;
/**
 classe permettant de retourner un resultat du pivot de Gauss
 * @author etien
 */
public class ResGauss {
    public int rang;
    public int signature;
    
    public ResGauss(){
        rang = 0;
        signature = 1;
    }
    
    public void to_String(){
        System.out.println("rang :"+this.rang);
        System.out.println("signature :"+this.signature);
    }
}