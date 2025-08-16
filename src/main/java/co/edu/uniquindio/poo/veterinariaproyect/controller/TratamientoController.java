package co.edu.uniquindio.poo.veterinariaproyect.controller;

import co.edu.uniquindio.poo.veterinariaproyect.App;
import co.edu.uniquindio.poo.veterinariaproyect.controller.PersonasController;
import co.edu.uniquindio.poo.veterinariaproyect.model.*;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import java.io.IOException;

import java.awt.*;
import java.util.Optional;

public class TratamientoController {

    /**
     * Creates a new Treatment instance and saves it to the main application model.
     * This method validates if a treatment with the same ID already exists before creating.
     * @param id The ID of the treatment.
     * @param nombre The name of the treatment.
     * @param duracion The duration of the treatment.
     * @param medicamento The medication prescribed.
     * @return The created Treatment object if successful, or null if a treatment with the same ID already exists.
     */
    public Tratamiento crearTratamiento(String id, String nombre, String duracion, String medicamento) {
        // Search for an existing treatment with the same ID.
        Optional<Tratamiento> tratamientoExistente = App.clinica1.getListTratamientos().stream()
                .filter(t -> t.ID().equals(id))
                .findFirst();

        // If a treatment with this ID already exists, return null to indicate failure.
        if (tratamientoExistente.isPresent()) {
            return null;
        }

        // Create a new Treatment object.
        Tratamiento nuevoTratamiento = new Tratamiento(id, nombre, duracion, medicamento);

        // Add the new treatment to the list in the main application model (Clinica).
        App.clinica1.getListTratamientos().add(nuevoTratamiento);

        // Return the newly created object.
        return nuevoTratamiento;
    }
}