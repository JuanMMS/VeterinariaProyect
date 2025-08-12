package co.edu.uniquindio.poo.veterinariaproyect.controller;

import co.edu.uniquindio.poo.veterinariaproyect.model.ClinicaVeterinaria;
import co.edu.uniquindio.poo.veterinariaproyect.model.Mascota;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import static co.edu.uniquindio.poo.veterinariaproyect.App.clinica1;

public class MascotaController {


    public MascotaController() {
    }

    public ObservableList<Mascota> obtenerMascotas() {
        return FXCollections.observableArrayList(clinica1.getListMascotas());
    }

    public void agregarMascota(Mascota mascota) {
        clinica1.agregarMascota(mascota);
    }

    public void eliminarMascota(Mascota mascota) {
        clinica1.eliminarMascota(mascota);
    }

    //public void actualizarMascota(Mascota mascota) {
        //clinica1.actualizarMascota(mascota);
    //}
    private void volverMenu() {
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
    }
}
