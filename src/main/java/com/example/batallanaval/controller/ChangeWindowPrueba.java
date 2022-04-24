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
    private ControllerPlay controllerPlay = new ControllerPlay();

    public void show(){
        this.scene = new Scene(controllerPlay.getPane(), 700, 600);
        this.stage.setScene(this.scene);
        this.controllerPlay.setScene(this.scene);
        this.controllerPlay.setStage(this.stage);
        this.controllerPlay.init();
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
