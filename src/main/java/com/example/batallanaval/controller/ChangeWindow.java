package com.example.batallanaval.controller;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Clase para el cambio de pantallas entre la pantalla de inicio y la del juego (la partida como tal)
 */
public class ChangeWindow {
    private Stage stage;
    private Scene scene;
    private ControllerPlay controllerPlay = new ControllerPlay();

    /**
     * Este metodo realiza el cambio de la pantalla inicial a la pantalla del juego
     */
    public void show() throws FileNotFoundException {
        this.scene = new Scene(controllerPlay.getPane(), 778, 600);
        this.stage.setScene(this.scene);
        this.controllerPlay.setScene(this.scene);
        this.controllerPlay.setStage(this.stage);
        this.controllerPlay.init();
        this.stage.show();
    }

    /**
     * Evento para generar el cambio de la pantalla de inicio a la del juego
     * Se hace el llamado de la funcion show para realizar dicho cambiio
     */
    public void init(ActionEvent e) throws IOException {
        this.stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        show();
    }
}
