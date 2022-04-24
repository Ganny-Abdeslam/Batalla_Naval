package com.example.batallanaval.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class ChangeWindowPrueba {
    private Stage stage;
    private Scene scene;
    private Parent root;
    final private Pane pane;

    public ChangeWindowPrueba() {

        this.pane = new Pane();
        //this.pane.setStyle("-fx-background-color:#0F92DF");

        //this.scene = new Scene(this.pane, 700, 600);
    }

    public void show(){
        this.scene = new Scene(this.pane, 700, 600);
        scene.getStylesheets().add(getClass().getResource("/com/example/batallanaval/interfaceCSS.css").toExternalForm());
        this.stage.setScene(this.scene);
        this.stage.show();
    }

    public void prueba(ActionEvent e) throws IOException {
        this.stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        show();
    }

    public void cerrar(ActionEvent e) throws  IOException{
        System.exit(0);
    }
}
