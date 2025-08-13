package co.edu.uniquindio.poo.veterinariaproyect.viewController;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
<<<<<<< Updated upstream
import javafx.fxml.FXMLLoader;

import javafx.scene.Parent;


=======
>>>>>>> Stashed changes
import java.io.IOException;

public class InicioViewController {

    @FXML
    public void iniciarMenu() throws IOException {
        App.cambiarEscena("/co/edu/uniquindio/poo/veterinariaproyect/Menu.fxml");
    }
<<<<<<< Updated upstream
=======
    @FXML
    private void cerrarPrograma() {
        App.cerrarPrograma();
    }
>>>>>>> Stashed changes
}