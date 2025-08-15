package co.edu.uniquindio.poo.veterinariaproyect.controller;


import co.edu.uniquindio.poo.veterinariaproyect.App;
import javafx.fxml.FXML;
import java.awt.event.ActionEvent;
import java.io.IOException;







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
}