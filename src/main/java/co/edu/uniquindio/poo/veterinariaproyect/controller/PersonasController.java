package co.edu.uniquindio.poo.veterinariaproyect.controller;

import co.edu.uniquindio.poo.veterinariaproyect.App;
import co.edu.uniquindio.poo.veterinariaproyect.model.Persona;
import co.edu.uniquindio.poo.veterinariaproyect.model.EspecialidadVeterinario;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class PersonasController {

    public ObservableList<Persona> obtenerPersonasPorTipo(String tipo) {
        ObservableList<Persona> personasFiltradas = FXCollections.observableArrayList();
        if (App.clinica1 != null && App.clinica1.getListPersonas() != null) {
            for (Persona p : App.clinica1.getListPersonas()) {
                if (tipo != null && tipo.equalsIgnoreCase(p.getRol())) {
                    personasFiltradas.add(p);
                }
            }
        }
        return personasFiltradas;
    }

    public ObservableList<EspecialidadVeterinario> obtenerEspecialidades() {
        return FXCollections.observableArrayList(EspecialidadVeterinario.values());
    }

    // Aquí puedes implementar los métodos para agregar, eliminar y actualizar
}