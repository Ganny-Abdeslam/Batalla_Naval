package com.example.batallanaval.controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ControllerPlay {

    private Stage stage;
    private Scene scene;
    private Parent root;

    public void show(){
        this.scene = new Scene(this.root);
        this.stage.setScene(this.scene);
        this.stage.show();
    }

    public void prueba(ActionEvent e) throws IOException{

        this.root = FXMLLoader.load(getClass().getResource("ForgetPassword.fxml"));
        this.stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        show();
    }
}
