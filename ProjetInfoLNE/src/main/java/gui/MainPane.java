/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui;



import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


public class MainPane extends BorderPane {
    
    
    
    
    private RadioButton rbSelect;
    
    private Button bTreillis;
    private Button bBarre;
    private Button bVecteur2D; 
    private Button bNoeud;
    private Button bGrouper;
    private Button bCouleur;
    private Button bCalculer;
    private Button bModifier;
    private Button bAide;
    
    private DessinCanvas cDessin;
    
    public MainPane() {
        this.rbSelect = new RadioButton("Select");
        this.bTreillis=new Button("new Treillis");
        this.bBarre=new Button("new Barre");
        this.bNoeud=new Button("new Noeud");
        this.bVecteur2D=new Button("new Vecteur2D");
        this.bCalculer=new Button("Calculer");        
        this.bModifier=new Button("Modifier");
        this.bAide=new Button("Aide");
        
        
        
        VBox vbGauche = new VBox(this.rbSelect, this.bTreillis,this.bBarre,this.bNoeud,this.bVecteur2D);
        this.setLeft(vbGauche);
        
        HBox hbhaut = new HBox(this.bCalculer,this.bModifier,this.bAide);
        this.setTop(hbhaut);
        
        this.bGrouper=new Button("Grouper");
        this.bGrouper.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
         System.out.println("bouton Grouper cliqué");
            }
        });
        
        
        this.bCouleur= new Button("Couleur");
       this.bCouleur.setOnAction((t) -> {
         System.out.println("bouton couelur cliqué");
       });
       this.bCouleur.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent t) {
    System.out.println("entered couleur en :"+t.getX()+" , "+t.getY()); 
            }
       });
       
       
        VBox vbDroit = new VBox(this.bCouleur,this.bGrouper);
        this.setRight(vbDroit);
       
        this.cDessin=new DessinCanvas();
        this.setCenter(this.cDessin);

    }
    
    
}
