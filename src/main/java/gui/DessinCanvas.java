/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui;

import javafx.scene.canvas.Canvas;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.canvas.GraphicsContext;
































public class DessinCanvas extends Pane{
private Canvas realCanvas;   

public DessinCanvas(){
    this.realCanvas=new Canvas(this.getWidth(),this.getHeight());
    this.getChildren().add(this.realCanvas);
    System.out.println("w = "+this.getWidth()+"; h = "+this.getHeight());
    this.realCanvas.heightProperty().bind(this.heightProperty());
    this.realCanvas.heightProperty().addListener((o) -> {
          System.out.println("w = "+this.realCanvas.getWidth()+"; h = "+this.realCanvas.getHeight());
        this.redrawAll();
    });
    this.realCanvas.widthProperty().bind(this.widthProperty());
    this.realCanvas.widthProperty().addListener((o) -> {
    this.redrawAll();
    });
    this.redrawAll();
}
public void redrawAll(){
    GraphicsContext context = this.realCanvas.getGraphicsContext2D();
        context.setFill(Color.AZURE);
        context.fillRect(0, 0, this.getWidth(), this.getHeight());
}

    
}
