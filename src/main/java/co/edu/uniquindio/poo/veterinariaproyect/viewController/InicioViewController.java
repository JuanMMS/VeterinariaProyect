package co.edu.uniquindio.poo.veterinariaproyect.viewController;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import javafx.scene.Parent;


import java.io.IOException;

public class InicioViewController {

    @FXML
    public void iniciarMenu(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/poo/veterinariaproyect/fxml/menu.fxml"));
        Parent root = loader.load();
    }
}