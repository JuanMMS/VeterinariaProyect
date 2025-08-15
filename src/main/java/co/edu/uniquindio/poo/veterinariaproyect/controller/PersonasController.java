package co.edu.uniquindio.poo.veterinariaproyect.controller;

import co.edu.uniquindio.poo.veterinariaproyect.App;
import co.edu.uniquindio.poo.veterinariaproyect.model.Persona;
import co.edu.uniquindio.poo.veterinariaproyect.model.EspecialidadVeterinario;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;

import static co.edu.uniquindio.poo.veterinariaproyect.App.clinica1;

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
    public ObservableList<Persona> obtenerPersonas() {
        if (clinica1 != null && clinica1.getListPersonas() != null) {
            return FXCollections.observableArrayList(clinica1.getListPersonas());
        }
        return FXCollections.observableArrayList();
    }
    public void agregarPersona(Persona persona) {
        if (clinica1 != null) {
            clinica1.agregarPersona(persona);
        }
    }

    public void eliminarPersona(Persona persona) {
        if (clinica1 != null) {
            clinica1.eliminarPersona(persona);
        }
    }

    public void actualizarPersona(Persona personaOriginal, Persona personaActualizada) {
        if (clinica1 != null && clinica1.getListPersonas() != null) {
            List<Persona> listPersonas = clinica1.getListPersonas();
            int index = listPersonas.indexOf(personaOriginal);
            if (index != -1) {
                listPersonas.set(index, personaActualizada);
            }
        }
    }

    public ObservableList<EspecialidadVeterinario> obtenerEspecialidades() {
        return FXCollections.observableArrayList(EspecialidadVeterinario.values());
    }

    // Aquí puedes implementar los métodos para agregar, eliminar y actualizar
}