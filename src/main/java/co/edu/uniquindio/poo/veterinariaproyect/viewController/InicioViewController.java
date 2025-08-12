package co.edu.uniquindio.poo.veterinariaproyect.viewController;

import co.edu.uniquindio.poo.veterinariaproyect.controller.InicioController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.Stage;

public class InicioViewController {

    private InicioController inicioController;

    public InicioViewController() {
        this.inicioController = new InicioController();
    }

    @FXML
    public void abrirMenu(ActionEvent event) {
        inicioController.mostrarVentanaMenu((Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow());
    }
}

