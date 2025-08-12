package co.edu.uniquindio.poo.veterinariaproyect.controller;
import co.edu.uniquindio.poo.veterinariaproyect.App;
import javafx.fxml.FXML;
import javafx.stage.Stage;
import java.io.IOException;


//Controller del Inicio

public class InicioController {

    private Stage inicioStage;

    public void setInicioStage(Stage primaryStage) {
        this.inicioStage = primaryStage;
    }

    @FXML
    private void iniciarMenu() {
        try {
            App.cambiarEscena("menu.fxml");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}