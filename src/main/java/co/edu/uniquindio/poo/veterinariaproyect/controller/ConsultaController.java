package co.edu.uniquindio.poo.veterinariaproyect.controller;

import co.edu.uniquindio.poo.veterinariaproyect.App;
import co.edu.uniquindio.poo.veterinariaproyect.model.Cita;
import co.edu.uniquindio.poo.veterinariaproyect.model.Consulta;
import co.edu.uniquindio.poo.veterinariaproyect.model.Tratamiento;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.util.List;

public class ConsultaController {

    private ObservableList<Consulta> listaConsultas;

    public ConsultaController() {
        this.listaConsultas = FXCollections.observableArrayList(App.clinica1.getListConsultas());
    }

    public ObservableList<Consulta> getListaConsultas() {
        return listaConsultas;
    }

    public ObservableList<Cita> obtenerCitasDisponibles() {
        List<Cita> citas = App.clinica1.getListCitas();
        return FXCollections.observableArrayList(citas);
    }

    public void crearNuevaConsulta(String fecha, String hora, String motivo, String idTratamiento, String nombreTratamiento, String duracionTratamiento, String medicamentoTratamiento, Cita citaBase) {
        Tratamiento nuevoTratamiento = new Tratamiento(idTratamiento, nombreTratamiento, duracionTratamiento, medicamentoTratamiento);

        Consulta nuevaConsulta = new Consulta(fecha, citaBase.getIDCita(), hora, motivo, citaBase, nuevoTratamiento);

        // Agrega a la ObservableList para que la UI se actualice automáticamente
        this.listaConsultas.add(nuevaConsulta);

        // También agrega al modelo de datos persistente (en este caso, App.clinica1)
        App.clinica1.getListConsultas().add(nuevaConsulta);
    }

    public void eliminarConsulta(Consulta consulta) {
        // Elimina de la ObservableList para actualizar la UI
        this.listaConsultas.remove(consulta);

        // También elimina del modelo de datos
        App.clinica1.getListConsultas().remove(consulta);
    }

    public void actualizarConsulta(Consulta consultaOriginal, String nuevoMotivo, String nuevoIDTratamiento, String nuevoNombreTratamiento, String nuevaDuracionTratamiento, String nuevoMedicamentoTratamiento) {
        consultaOriginal.setMotivo(nuevoMotivo);
        consultaOriginal.setTratamiento(new Tratamiento(nuevoIDTratamiento, nuevoNombreTratamiento, nuevaDuracionTratamiento, nuevoMedicamentoTratamiento));
        // La vista se actualizará porque se está modificando un objeto dentro de la ObservableList
    }
}