package co.edu.uniquindio.poo.veterinariaproyect.controller;

import co.edu.uniquindio.poo.veterinariaproyect.App;
import co.edu.uniquindio.poo.veterinariaproyect.model.Cita;
import co.edu.uniquindio.poo.veterinariaproyect.model.Consulta;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


import java.io.IOException;

public class MenuController {

    public ObservableList<Cita> getListCitas() {
        return FXCollections.observableArrayList(App.clinica1.getListCitas());
    }
    public ObservableList<Consulta> getListConsultas() {
        return FXCollections.observableArrayList(App.clinica1.getListConsultas());
    }
}