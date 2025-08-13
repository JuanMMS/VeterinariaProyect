package co.edu.uniquindio.poo.veterinariaproyect.viewController;

import co.edu.uniquindio.poo.veterinariaproyect.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;



import java.io.IOException;

//ViewController del Inicio
public class InicioViewController {


    @FXML
    public void iniciarMenu() throws IOException {
        App.cambiarEscena("/co/edu/uniquindio/poo/veterinariaproyect/Menu.fxml");
    }


    @FXML
    private void cerrarPrograma() {
        App.cerrarPrograma();
    }

    @FXML
    private void cerrarPrograma(ActionEvent event) {
        App.cerrarPrograma();
    }

}