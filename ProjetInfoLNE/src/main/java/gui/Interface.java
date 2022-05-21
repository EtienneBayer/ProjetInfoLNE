/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.*;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author Admin
 */
public class Interface extends Application {
    
    @Override
    //Lance l'application
    public void start(Stage primaryStage) {
        
        //Nom à la fenêtre
        primaryStage.setTitle("Treillis");
      
      
        //Créer la barre de menu en "haut"
        MenuBar menuBar = new MenuBar();
        
        //Créer une instance de la classe menu
        Menu fichier = new Menu("Fichier");
        //Ajout de l'instance dans menuBar
        menuBar.getMenus().add(fichier);
        
        //Créer des sous-menu
        MenuItem nouveau = new MenuItem ("Nouveau");
        MenuItem ouvrir = new MenuItem ("Ouvrir");
        MenuItem enregistrer = new MenuItem ("Enregistrer");
      
        //Ajout des sous-menu dans fichier
        fichier.getItems().add(nouveau);
        fichier.getItems().add(ouvrir);
        fichier.getItems().add(enregistrer);
        
        //On créer une Vbox
        VBox vBox = new VBox(menuBar) ;
        
        //Créer une scène qui va contenir Vbox et sa taille et tous les autres objets
        Scene root = new Scene(vBox, 960, 600);
        
        //Ajout de la scène sur notre fenêtre
        primaryStage.setScene(root);
        
        //Affiche la fenêtre
        primaryStage.show();
    
        // MENU FICHIER ________________________________________________________
        
        //action qui se passe lorsqu'on clique sur nouveau
        nouveau.setOnAction(new EventHandler<ActionEvent>(){
            //on redéfinit une méthode déjà existante dans une classe mère
            @Override
            public void handle (ActionEvent event) {
              GridPane gridPane = new GridPane();
            //on demande les coordonnées du terrain pour le placer dans l'espace
                Label x = new Label ("Abscisse : ");
                Label y = new Label ("Ordonnée :");
            //on demande la taille du terrain
                Label hauteur = new Label("Longueur : ");
                Label longueur = new Label("Hauteur : ");
                
                
                TextField textXg = new TextField();
                TextField textYg = new TextField();
                TextField textHaut = new TextField();
                TextField textLong = new TextField();
                
                //permet l'affichage
                gridPane.add(x,0,0);
                gridPane.add(y,0,1);
                gridPane.add(textXg, 1, 0);
                gridPane.add(textYg, 1, 1);
                gridPane.add(hauteur,0,2);
                gridPane.add(longueur,0,3);
                gridPane.add(textHaut, 1, 2);
                gridPane.add(textLong, 1, 3);
                
                
                Button créer = new Button("Créer");
                gridPane.add(créer,4,5);
                
                créer.setOnAction(new EventHandler<ActionEvent>(){
            //on redéfinit une méthode déjà existante dans une classe mère
                @Override
                public void handle (ActionEvent event) {
                    
                    //Récupère les données String et les convertir en numérique.
                    double longueur = Double.parseDouble(textLong.getText());
                    double hauteur = Double.parseDouble(textHaut.getText());
                    double x  = Double.parseDouble(textXg.getText());
                    double y = Double.parseDouble(textYg.getText());
                    
                    //test d'affichage de terrain peu convaincant
                    Rectangle terrrain = new Rectangle();
                    terrrain.setX(x);
                    terrrain.setY(y);
                    terrrain.setWidth(hauteur);
                    terrrain.setHeight(longueur);
                    terrrain.setFill(Color.PURPLE);

                  

                    Group root = new Group();
                    root.getChildren().add(terrrain);
                    //paramètre de la fenêtre
                    Scene scene = new Scene(root, 400, 250, Color.YELLOW);
                    primaryStage.setTitle("JavaFX Rectangle (o7planning.org)");
                    primaryStage.setScene(scene);
                    primaryStage.show();
                    
                }
                
                });
                
                 Scene sceneTerrain = new Scene(gridPane, 330, 200);
                
                //Créer la nouvelle fenêtre
                Stage stageTerrain = new Stage ();
                
                stageTerrain.setTitle("Dimensions");
                
                
                
                
                // On ajoute la scène à la nouvelle fenêtre
                stageTerrain.setScene(sceneTerrain);
                // On affiche la fenêtre
                stageTerrain.show();
                
            }
        });
                
        
        
        
        
        // MENU NOEUD __________________________________________________________
        Menu noeud = new Menu("Noeud");
        menuBar.getMenus().add(noeud);
        
        MenuItem nouveauNoeud = new MenuItem ("Saisir");
        MenuItem supprimerNoeud = new MenuItem ("Supprimer");
        MenuItem supprimerTous = new MenuItem ("Supprimer tous");
      
        noeud.getItems().add(nouveauNoeud);
        noeud.getItems().add(supprimerNoeud);
        noeud.getItems().add(supprimerTous);
        
        // SAISIR
        //Créer une action quand on clique sur le sous-menu "saisir"
        nouveauNoeud.setOnAction(new EventHandler<ActionEvent>(){
            //on redéfinit une méthode déjà existante dans une classe mère
            @Override
            public void handle (ActionEvent event) {
                GridPane gridPane = new GridPane();
                //paramètre du nouveau noeud saisie
                Label x = new Label("Coordonnées x : ");
                Label y = new Label("Coordonnées y : ");
                Label id = new Label ("Identifiant : ");
                Label type = new Label ("Type : ");
                
                TextField textX = new TextField();
                TextField textY = new TextField();
                TextField textId = new TextField();
                RadioButton s = new RadioButton("Noeud Simple");
                RadioButton as = new RadioButton("Noeud appui Simple");
                RadioButton ad = new RadioButton("Noeud appui Double");
                
                
                //permet l'affichage
                gridPane.add(x,0,0);
                gridPane.add(y,0,1);
                gridPane.add(id,0,2);
                gridPane.add(type,0,3);
                gridPane.add(textX, 1, 0);
                gridPane.add(textY, 1, 1);
                gridPane.add(textId, 1, 2);
                gridPane.add(s, 1, 3);
                gridPane.add(as, 1, 4);
                gridPane.add(ad, 1, 5);
                
                Button valider = new Button("Ajouter");
                
                gridPane.add(valider,2,6);
                
                valider.setOnAction(new EventHandler<ActionEvent>(){
            //on redéfinit une méthode déjà existante dans une classe mère
                @Override
                public void handle (ActionEvent event) {
                    
                    //Récupère les données String et les convertir en numérique.
                    double x = Double.parseDouble(textX.getText());
                    double y = Double.parseDouble(textY.getText());
                    double id = Double.parseDouble(textId.getText());
                    
                    //Si le bouton Noeud Simple est cliqué cette action se passe
                    s.setOnAction(new EventHandler<ActionEvent>(){
                    String type;
                    @Override
                    //La variable type prend Noeud Simple
                    public void handle(ActionEvent event) {
                         type = "Noeud Simple";
                        
                         //Sert a vider les cases une fois la barre validée
                    textX.clear();
                    textY.clear();
                    textId.clear();
                    }});
                    
                    //idem pour Appui Simple
                    as.setOnAction(new EventHandler<ActionEvent>(){
                    String type;
                    @Override
                    public void handle(ActionEvent event) {
                         type = "Noeud Appui Simple";
                        
                    //Sert a vider les cases une fois la barre validée
                    textX.clear();
                    textY.clear();
                    textId.clear();
                    }});
                    
                    //idem pour appui double
                    ad.setOnAction(new EventHandler<ActionEvent>(){
                    String type;
                    @Override
                    public void handle(ActionEvent event) {
                         type = "Noeud Appui Double";
                        
                    //Sert a vider les cases une fois la barre validée
                    textX.clear();
                    textY.clear();
                    textId.clear();
                    }});
                    

                    /*Circle circle = new Circle();
                    circle.setCenterx);
                    circle.setCenterY(y);
                    circle.setRadius(10);
                    circle.setStroke(Color.valueOf("#ff00ff"));
                    */
                    
                }
                
                });
                
                //Créer une nouvelle scène qui va contenir tous les visuels et objets (exemple : boutons, menuBar)
                Scene sceneSaisieNoeud = new Scene(gridPane, 330, 200);
                
                //Créer la nouvelle fenêtre
                Stage stageSaisieNoeud = new Stage ();
                
                stageSaisieNoeud.setTitle("Coordonnées");
              
                // On ajoute la scène à la nouvelle fenêtre
                stageSaisieNoeud.setScene(sceneSaisieNoeud);
                // On affiche la fenêtre
                stageSaisieNoeud.show();
                
            
              
            }
        });
        
        supprimerNoeud.setOnAction(new EventHandler<ActionEvent>() {
                    
                @Override
                
                public void handle (ActionEvent event) {
                    
                GridPane gridPane = new GridPane();
                Label idns = new Label("Identifiant du noeud : ");
                TextField textIdns = new TextField();
                
                Button supprimer = new Button("Supprimer");
                
                supprimer.setOnAction(new EventHandler<ActionEvent>(){
            //on redéfinit une méthode déjà existante dans une classe mère
                @Override
                public void handle (ActionEvent event) {
                    
                    //Récupère les données String et les convertir en numérique.
                    double idns = Double.parseDouble(textIdns.getText());
                
                    textIdns.clear();
                }
                });
                
                gridPane.add(idns,0,0);
                gridPane.add(textIdns, 1, 0);
                gridPane.add(supprimer,2,4);
                

                Scene sceneSupprimerNoeud = new Scene (gridPane, 430, 250);
                
                //Créer la nouvelle fenêtre supprimer
                Stage stageSupprimerNoeud = new Stage ();
                
                stageSupprimerNoeud.setTitle("Identifiant");
                
                stageSupprimerNoeud.setScene(sceneSupprimerNoeud);
                stageSupprimerNoeud.show();
                
                
                
            }
            });
        
        supprimerTous.setOnAction(new EventHandler<ActionEvent>(){
            //on redéfinit une méthode déjà existante dans une classe mère
            @Override
            public void handle (ActionEvent event) {
                GridPane gridPane = new GridPane();
                Label sur = new Label("Etes-vous certain(e)? ");
                RadioButton oui = new RadioButton("Oui");
                RadioButton non = new RadioButton("Non");
              
                Button valider = new Button("Valider");
                
                
                gridPane.add(sur,0,0);
                gridPane.add(oui,0,1);
                gridPane.add(non,0,2);
                gridPane.add(valider,3,3);
                
                
                
            
              
                //Créer une nouvelle scène qui va contenir tous les visuels et objets (exemple : boutons, menuBar)
                Scene sceneSaisieTous = new Scene(gridPane, 330, 200);
                
                //Créer la nouvelle fenêtre nouvelle
                Stage stageSaisieTous = new Stage ();
                
                stageSaisieTous.setTitle("Suppression");
                
                stageSaisieTous.setScene(sceneSaisieTous);
                stageSaisieTous.show();
            }

              });
            
        
        // MENU BARRE __________________________________________________________
        Menu barre = new Menu("Barre");
        menuBar.getMenus().add(barre);
        
        MenuItem nouvelleBarre = new MenuItem ("Saisir");
        MenuItem supprimerBarre = new MenuItem ("Supprimer");
        MenuItem supprimerToutes = new MenuItem ("Supprimer toutes");
      
        barre.getItems().add(nouvelleBarre);
        barre.getItems().add(supprimerBarre);
        barre.getItems().add(supprimerToutes);
        
        
        nouvelleBarre.setOnAction(new EventHandler<ActionEvent>(){
            //on redéfinit une méthode déjà existante dans une classe mère
            @Override
            public void handle (ActionEvent event) {
                GridPane gridPane = new GridPane();
                Label nd = new Label("Noeud de départ : ");
                Label na = new Label("Noeud d'arrivé : ");
                Label idb = new Label ("Identifiant : ");
                TextField textNd = new TextField();
                TextField textNa = new TextField();
                TextField textIdb = new TextField();
              
            
                
                Button valider = new Button("Ajouter");
                  
                
                valider.setOnAction(new EventHandler<ActionEvent>(){
            //on redéfinit une méthode déjà existante dans une classe mère
                @Override
                public void handle (ActionEvent event) {
                    
                    //Récupère les données String et les convertir en numérique.
                    double Na1 = Double.parseDouble(textNa.getText());
                    double Nd1 = Double.parseDouble(textNd.getText());
                    double idb1 = Double.parseDouble(textIdb.getText());
                    
                    
                    
                    
                    //Sert a vider les cases une fois la barre validée
                    textNa.clear();
                    textNd.clear();
                    textIdb.clear();
                    
                    
                    
                    //Afficher sur la zone constructuble qui sera dans la fenêtre principal
                    //Stocker les données dans l'arraylist.
                  
                }
                
                });
            //Les variables sont ajouté à la liste des noeuds
                gridPane.add(nd,0,0);
                gridPane.add(na,0,1);
                gridPane.add(idb,0,2);
                gridPane.add(textNd, 1, 0);
                gridPane.add(textNa, 1, 1);
                gridPane.add(textIdb, 1, 2);
                gridPane.add(valider,4,5);
                // Recupérer les données ecrit avec les getText / double
              
                //Créer une nouvelle scène qui va contenir tous les visuels et objets (exemple : boutons, menuBar)
                Scene sceneSaisieBarre = new Scene(gridPane, 330, 200);
                
                //Créer la nouvelle fenêtre nouvelle
                Stage stageSaisieBarre = new Stage ();
                
                stageSaisieBarre.setTitle("Coordonnées");
                
                stageSaisieBarre.setScene(sceneSaisieBarre);
                stageSaisieBarre.show();

              
            }
            
        });
        
                supprimerBarre.setOnAction(new EventHandler<ActionEvent>() {
                    
                @Override
                
                public void handle (ActionEvent event) {
                    
                GridPane gridPane = new GridPane();
                Label ids = new Label("Identifiant de la barre : ");
                TextField textIds = new TextField();
                
                Button supprimer = new Button("Supprimer");
                
                supprimer.setOnAction(new EventHandler<ActionEvent>(){
            //on redéfinit une méthode déjà existante dans une classe mère
                @Override
                public void handle (ActionEvent event) {
                    
                    //Récupère les données String et les convertir en numérique.
                    double ids = Double.parseDouble(textIds.getText());
                
                    textIds.clear();
                }
                });
                
                gridPane.add(ids,0,0);
                gridPane.add(textIds, 1, 0);
                gridPane.add(supprimer,2,4);
                

                Scene sceneSupprimerBarre = new Scene (gridPane, 400, 220);
                
                //Créer la nouvelle fenêtre supprimer
                Stage stageSupprimerBarre = new Stage ();
                
                stageSupprimerBarre.setTitle("Identifiant");
                
                stageSupprimerBarre.setScene(sceneSupprimerBarre);
                stageSupprimerBarre.show();
                
                
                
            }
            });
            
        supprimerToutes.setOnAction(new EventHandler<ActionEvent>(){
            //on redéfinit une méthode déjà existante dans une classe mère
            @Override
            public void handle (ActionEvent event) {
                GridPane gridPane = new GridPane();
                Label certain = new Label("Etes-vous certain(e)? ");
                RadioButton oui = new RadioButton("Oui");
                RadioButton non = new RadioButton("Non");
              
                Button valider = new Button("Valider");
                
                
                gridPane.add(certain,0,0);
                gridPane.add(oui,0,1);
                gridPane.add(non,0,2);
                gridPane.add(valider,3,3);
                
                
                
            
              
                //Créer une nouvelle scène qui va contenir tous les visuels et objets (exemple : boutons, menuBar)
                Scene sceneSaisieToutes = new Scene(gridPane, 330, 200);
                
                //Créer la nouvelle fenêtre nouvelle
                Stage stageSaisieToutes = new Stage ();
                
                stageSaisieToutes.setTitle("Suppression");
                
                stageSaisieToutes.setScene(sceneSaisieToutes);
                stageSaisieToutes.show();
            }

              });
            
        
        
        // MENU FORCE __________________________________________________________
        
        Menu force = new Menu("Force");
        menuBar.getMenus().add(force);
        
        MenuItem nouvelleForce = new MenuItem ("Saisir");
        MenuItem supprimerForce = new MenuItem ("Supprimer");
        MenuItem supprimerToutesLesForces = new MenuItem ("Supprimer toutes");
      
        force.getItems().add(nouvelleForce);
        force.getItems().add(supprimerForce);
        force.getItems().add(supprimerToutesLesForces);
        
        
        nouvelleForce.setOnAction(new EventHandler<ActionEvent>(){
            //on redéfinit une méthode déjà existante dans une classe mère
            @Override
            public void handle (ActionEvent event) {
                GridPane gridPane = new GridPane();
                Label napp = new Label("Noeud d'application : ");
                Label vx = new Label("Composante sur x : ");
                Label vy = new Label ("Compposante sur y : ");
                TextField textNapp = new TextField();
                TextField textVx = new TextField();
                TextField textVy = new TextField();
              
            
                
                Button valider = new Button("Ajouter");
                  
                
                valider.setOnAction(new EventHandler<ActionEvent>(){
            //on redéfinit une méthode déjà existante dans une classe mère
                @Override
                public void handle (ActionEvent event) {
                    
                    //Récupère les données String et les convertir en numérique.
                    double Napp = Double.parseDouble(textNapp.getText());
                    double Vx = Double.parseDouble(textVx.getText());
                    double Vy = Double.parseDouble(textVy.getText());
                    
                    
                    
                    
                    //Sert a vider les cases une fois la barre validée
                    textNapp.clear();
                    textVx.clear();
                    textVy.clear();
        
                }
                
                });
            //Les variables sont ajouté à la liste des noeuds
                gridPane.add(napp,0,0);
                gridPane.add(vx,0,1);
                gridPane.add(vy,0,2);
                gridPane.add(textNapp, 1, 0);
                gridPane.add(textVx, 1, 1);
                gridPane.add(textVy, 1, 2);
                gridPane.add(valider,4,5);
                // Recupérer les données ecrit avec les getText / double
              
                //Créer une nouvelle scène qui va contenir tous les visuels et objets (exemple : boutons, menuBar)
                Scene sceneSaisieForce = new Scene(gridPane, 330, 200);
                
                //Créer la nouvelle fenêtre nouvelle
                Stage stageSaisieForce = new Stage ();
                
                stageSaisieForce.setTitle("Composantes");
                
                stageSaisieForce.setScene(sceneSaisieForce);
                stageSaisieForce.show();

              
            }
            
        });
        
                supprimerForce.setOnAction(new EventHandler<ActionEvent>() {
                    
                @Override
                
                public void handle (ActionEvent event) {
                    
                GridPane gridPane = new GridPane();
                Label idns = new Label("Force du noeud : ");
                TextField textIdns = new TextField();
                
                Button supprimer = new Button("Supprimer");
                
                supprimer.setOnAction(new EventHandler<ActionEvent>(){
            //on redéfinit une méthode déjà existante dans une classe mère
                @Override
                public void handle (ActionEvent event) {
                    
                    //Récupère les données String et les convertir en numérique.
                    double idns = Double.parseDouble(textIdns.getText());
                
                    textIdns.clear();
                }
                });
                
                gridPane.add(idns,0,0);
                gridPane.add(textIdns, 1, 0);
                gridPane.add(supprimer,2,4);
                

                Scene sceneSupprimerForce = new Scene (gridPane, 400, 220);
                
                //Créer la nouvelle fenêtre supprimer
                Stage stageSupprimerForce = new Stage ();
                
                stageSupprimerForce.setTitle("Identifiant");
                
                stageSupprimerForce.setScene(sceneSupprimerForce);
                stageSupprimerForce.show();
                
                
                
            }
            });
            
           supprimerToutesLesForces.setOnAction(new EventHandler<ActionEvent>(){
            //on redéfinit une méthode déjà existante dans une classe mère
            @Override
            public void handle (ActionEvent event) {
                GridPane gridPane = new GridPane();
                Label sur = new Label("Etes-vous certain(e)? ");
                RadioButton oui = new RadioButton("Oui");
                RadioButton non = new RadioButton("Non");
              
                Button valider = new Button("Valider");
                
                
                gridPane.add(sur,0,0);
                gridPane.add(oui,0,1);
                gridPane.add(non,0,2);
                gridPane.add(valider,3,3);
                
                
                
            
              
                //Créer une nouvelle scène qui va contenir tous les visuels et objets (exemple : boutons, menuBar)
                Scene sceneSaisieToutesLesForces = new Scene(gridPane, 330, 200);
                
                //Créer la nouvelle fenêtre nouvelle
                Stage stageSaisieToutesLesForces = new Stage ();
                
                stageSaisieToutesLesForces.setTitle("Suppression");
                
                stageSaisieToutesLesForces.setScene(sceneSaisieToutesLesForces);
                stageSaisieToutesLesForces.show();
            }

              });
            
        
        // MENU SIMULATION _____________________________________________________
        
       Menu simulation = new Menu("Simulation");
        menuBar.getMenus().add(simulation);
        
        
        
            }
    
        /*Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });
        
        StackPane root = new StackPane();
        root.getChildren().add(btn);
        
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
        */
        
          
        
    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        launch(args);
    }
    
    
 
                }