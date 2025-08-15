package co.edu.uniquindio.poo.veterinariaproyect.controller;

import co.edu.uniquindio.poo.veterinariaproyect.App;
import co.edu.uniquindio.poo.veterinariaproyect.model.Persona;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;

public class PersonasController {

    public ObservableList<Persona> getListPersonas() {
        return FXCollections.observableArrayList(App.clinica1.getListPersonas());
    }
}
