package com.example.batallanaval.controller;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ChangeWindow {
    private Stage stage;
    private Scene scene;
    private ControllerPlay controllerPlay = new ControllerPlay();

    public void show(){
        this.scene = new Scene(controllerPlay.getPane(), 778, 600);
        this.stage.setScene(this.scene);
        this.controllerPlay.setScene(this.scene);
        this.controllerPlay.setStage(this.stage);
        this.controllerPlay.init();
        this.stage.show();
    }

    public void init(ActionEvent e) throws IOException {
        this.stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        show();
    }
}
