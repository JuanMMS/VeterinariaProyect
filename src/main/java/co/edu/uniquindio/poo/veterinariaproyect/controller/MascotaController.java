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

public class MascotaController {

    private ClinicaVeterinaria clinica;

    public MascotaController(ClinicaVeterinaria clinica) {
        this.clinica = clinica;
    }

    public ObservableList<Mascota> obtenerMascotas() {
        return FXCollections.observableArrayList(clinica.getListMascotas());
    }

    public void agregarMascota(Mascota mascota) {
        clinica.agregarMascota(mascota);
    }

    public void eliminarMascota(Mascota mascota) {
        clinica.eliminarMascota(mascota);
    }

    //public void actualizarMascota(Mascota mascota) {
        //clinica.actualizarMascota(mascota);
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
