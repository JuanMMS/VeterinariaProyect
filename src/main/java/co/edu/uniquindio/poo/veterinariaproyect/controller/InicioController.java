package co.edu.uniquindio.poo.veterinariaproyect.controller;
<<<<<<< Updated upstream
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

=======

import co.edu.uniquindio.poo.veterinariaproyect.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import java.io.IOException;

// Controller para la escena de Inicio (login)
>>>>>>> Stashed changes
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
<<<<<<< Updated upstream
    private void iniciarMenu() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/poo/veterinariaproyect/fxml/menu.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Iniciar Sesión");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
=======
    private void cerrarPrograma(ActionEvent event) {
        // Cierra la aplicación de forma segura
        App.cerrarPrograma();
>>>>>>> Stashed changes
    }
}