/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui;



import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Label;



public class Main extends Application {
   @Override
   public void start(Stage stage)  {
        Scene sc = new Scene (new MainPane(),800,600);
        stage.setScene(sc);
        stage.show();
    }
public static void main(String[] args) {
    launch(args);
}
}
    
 

