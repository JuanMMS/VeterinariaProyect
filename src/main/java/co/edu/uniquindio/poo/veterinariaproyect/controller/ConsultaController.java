package co.edu.uniquindio.poo.veterinariaproyect.controller;

import co.edu.uniquindio.poo.veterinariaproyect.App;
import co.edu.uniquindio.poo.veterinariaproyect.model.Cita;
import co.edu.uniquindio.poo.veterinariaproyect.model.Consulta;
import co.edu.uniquindio.poo.veterinariaproyect.model.Tratamiento;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.util.List;

public class ConsultaController {

    public ObservableList<Consulta> obtenerTodasLasConsultas() {
        List<Consulta> consultas = App.clinica1.getListConsultas();
        return FXCollections.observableArrayList(consultas);
    }

    public ObservableList<Cita> obtenerCitasDisponibles() {
        List<Cita> citas = App.clinica1.getListCitas();
        return FXCollections.observableArrayList(citas);
    }

    public void crearNuevaConsulta(String fecha, String hora, String motivo, String idTratamiento, String nombreTratamiento, String duracionTratamiento, String medicamentoTratamiento, Cita citaBase) {
        Tratamiento nuevoTratamiento = new Tratamiento(idTratamiento, nombreTratamiento, duracionTratamiento, medicamentoTratamiento);

        // Aquí se llama al nuevo constructor con los 6 argumentos
        Consulta nuevaConsulta = new Consulta(fecha, citaBase.getIDCita(), hora, motivo, citaBase, nuevoTratamiento);

        App.clinica1.getListConsultas().add(nuevaConsulta);
    }

    public void eliminarConsulta(Consulta consulta) {
        App.clinica1.getListConsultas().remove(consulta);
    }

    public void actualizarConsulta(Consulta consultaOriginal, String nuevoMotivo, String nuevoIDTratamiento, String nuevoNombreTratamiento, String nuevaDuracionTratamiento, String nuevoMedicamentoTratamiento) {
        consultaOriginal.setMotivo(nuevoMotivo);
        // Crea un nuevo Tratamiento record y lo asigna
        consultaOriginal.setTratamiento(new Tratamiento(nuevoIDTratamiento, nuevoNombreTratamiento, nuevaDuracionTratamiento, nuevoMedicamentoTratamiento));
    }
}