package co.edu.uniquindio.poo.veterinariaproyect.controller;


import co.edu.uniquindio.poo.veterinariaproyect.App;

import javafx.fxml.FXML;
import javafx.stage.Stage;
import java.io.IOException;




//Controller del Inicio

public class InicioController {


import co.edu.uniquindio.poo.veterinariaproyect.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import java.io.IOException;

// Controller para la escena de Inicio (login)

public class InicioController {

    @FXML
    private void iniciarMenu(ActionEvent event) {
        try {
            // Llama a tu método centralizado para cambiar la escena a la del menú principal
            App.cambiarEscena("menu.fxml");
        } catch (IOException e) {
            e.printStackTrace();
            // Aquí puedes manejar el error, por ejemplo, mostrando una alerta
        }
    }

    @FXML

    private void iniciarMenu() {
        try {
            App.cambiarEscena("menu.fxml");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
=======
    private void cerrarPrograma(ActionEvent event) {
        // Cierra la aplicación de forma segura
        App.cerrarPrograma();

    }
}