package co.edu.uniquindio.poo.veterinariaproyect.controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class InicioController {

    public void mostrarVentanaMenu(Stage stageActual) {
        try {
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("/co/edu/uniquindio/poo/veterinariaproyect/view/Menu.fxml")
            );
            Parent root = loader.load();

            stageActual.setScene(new Scene(root));
            stageActual.setTitle("Menú Principal");
            stageActual.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
