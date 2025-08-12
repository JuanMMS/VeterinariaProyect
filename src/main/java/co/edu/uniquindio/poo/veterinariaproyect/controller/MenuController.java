package co.edu.uniquindio.poo.veterinariaproyect.controller;

import co.edu.uniquindio.poo.veterinariaproyect.App;
import co.edu.uniquindio.poo.veterinariaproyect.model.Cita;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


import java.io.IOException;

public class MenuController {

    public ObservableList<Cita> getListaCitas() {
        return FXCollections.observableArrayList(App.clinica1.getListCitas());
    }

    public void abrirVistaMascotas() {
        try {
            App.cambiarEscena("mascota.fxml");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void abrirVistaCitas() {
        try {
            App.cambiarEscena("agenda.fxml");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void abrirVistaPersonal() {
        try {
            App.cambiarEscena("personas.fxml");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }



}