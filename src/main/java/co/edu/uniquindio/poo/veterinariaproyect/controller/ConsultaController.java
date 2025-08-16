package co.edu.uniquindio.poo.veterinariaproyect.controller;

import co.edu.uniquindio.poo.veterinariaproyect.App;
import co.edu.uniquindio.poo.veterinariaproyect.model.Cita;
import co.edu.uniquindio.poo.veterinariaproyect.model.Consulta;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ConsultaController {

    // Este método debería obtener la lista de consultas desde tu modelo central (App o Clinica)
    public ObservableList<Consulta> obtenerTodasLasConsultas() {
        // Ejemplo: retornar una lista de consultas de la clínica
        return App.clinica1.getListConsultas();
    }

    // Este método debería obtener la lista de citas disponibles desde tu modelo central
    public ObservableList<Cita> obtenerCitasDisponibles() {
        // Ejemplo: retornar una lista de citas
        return App.clinica1.getListCitas();
    }

    public void crearNuevaConsulta(Cita citaBase, String motivo, String tratamiento) {
        // Se crea la consulta usando el constructor
        Consulta nuevaConsulta = new Consulta(
                citaBase.getIDCita(),
                citaBase.getFecha(),
                citaBase.getHora(),
                citaBase.getLugarCita(),
                citaBase.getVeterinario(),
                citaBase.getMascota(),
                citaBase.getPropietario(),
                citaBase.getPersonalApoyo(),
                motivo,
                tratamiento
        );

        // Se añade la consulta a la lista principal en tu modelo
        App.clinica1.getListConsultas().add(nuevaConsulta);
    }

    public void eliminarConsulta(Consulta consulta) {
        App.clinica1.getListConsultas().remove(consulta);
    }

    public void actualizarConsulta(Consulta consultaOriginal, String nuevoMotivo, String nuevoTratamiento) {
        consultaOriginal.setMotivo(nuevoMotivo);
        consultaOriginal.setTratamiento(nuevoTratamiento);
    }
}