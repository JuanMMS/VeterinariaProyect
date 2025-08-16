package co.edu.uniquindio.poo.veterinariaproyect.viewController;

import co.edu.uniquindio.poo.veterinariaproyect.App;
import co.edu.uniquindio.poo.veterinariaproyect.controller.ConsultaController;
import co.edu.uniquindio.poo.veterinariaproyect.model.Consulta;
import co.edu.uniquindio.poo.veterinariaproyect.model.Cita;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

public class ConsultaViewController implements Initializable {

    @FXML private ListView<Cita> ListCitasDisponibles;
    @FXML private ListView<Consulta> ListConsultasRealizadas;
    @FXML private TextField IntroducirFecha;
    @FXML private TextField IntroducirHora;
    @FXML private TextArea IntroducirMotivo;

    @FXML private TextField IntroducirIDTratamiento; // Nuevo campo para el ID del tratamiento
    @FXML private TextField IntroducirNombreTratamiento; // Nuevo campo para el nombre
    @FXML private TextField IntroducirDuracion; // Nuevo campo para la duración
    @FXML private TextField IntroducirMedicamento; // Nuevo campo para el medicamento

    private ConsultaController consultaController;
    private ObservableList<Consulta> listaConsultasObservable;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.consultaController = new ConsultaController();
        this.listaConsultasObservable = consultaController.obtenerTodasLasConsultas();

        ListCitasDisponibles.setItems(consultaController.obtenerCitasDisponibles());
        ListConsultasRealizadas.setItems(listaConsultasObservable);

        ListCitasDisponibles.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newCita) -> {
            if (newCita != null) {
                IntroducirFecha.setText(newCita.getFecha());
                IntroducirHora.setText(newCita.getHora());
            } else {
                IntroducirFecha.clear();
                IntroducirHora.clear();
            }
        });

        ListConsultasRealizadas.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newConsulta) -> {
            if (newConsulta != null) {
                IntroducirFecha.setText(newConsulta.getFecha());
                IntroducirHora.setText(newConsulta.getHora());
                IntroducirMotivo.setText(newConsulta.getMotivo());
                IntroducirIDTratamiento.setText(newConsulta.getTratamiento().ID());
                IntroducirNombreTratamiento.setText(newConsulta.getTratamiento().nombre());
                IntroducirDuracion.setText(newConsulta.getTratamiento().duracion());
                IntroducirMedicamento.setText(newConsulta.getTratamiento().medicamento());
            } else {
                limpiarCampos();
            }
        });
    }

    @FXML
    public void BotonAceptar() {
        Cita citaSeleccionada = ListCitasDisponibles.getSelectionModel().getSelectedItem();
        if (citaSeleccionada == null) {
            mostrarAlerta(Alert.AlertType.ERROR, "Error", "Por favor, seleccione una cita para crear una consulta.");
            return;
        }

        String motivo = IntroducirMotivo.getText();
        String idTratamiento = IntroducirIDTratamiento.getText();
        String nombreTratamiento = IntroducirNombreTratamiento.getText();
        String duracionTratamiento = IntroducirDuracion.getText();
        String medicamentoTratamiento = IntroducirMedicamento.getText();

        if (motivo.isEmpty() || idTratamiento.isEmpty() || nombreTratamiento.isEmpty() || duracionTratamiento.isEmpty() || medicamentoTratamiento.isEmpty()) {
            mostrarAlerta(Alert.AlertType.ERROR, "Error", "Todos los campos de la consulta son obligatorios.");
            return;
        }

        consultaController.crearNuevaConsulta(citaSeleccionada.getFecha(), citaSeleccionada.getIDCita(), citaSeleccionada.getHora(), motivo, idTratamiento, nombreTratamiento, duracionTratamiento, citaSeleccionada);
        limpiarCampos();
        mostrarAlerta(Alert.AlertType.INFORMATION, "Éxito", "Consulta creada exitosamente.");
    }

    @FXML
    public void BotonEliminar() {
        Consulta selectedItem = ListConsultasRealizadas.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            consultaController.eliminarConsulta(selectedItem);
            limpiarCampos();
            mostrarAlerta(Alert.AlertType.INFORMATION, "Éxito", "Consulta eliminada.");
        } else {
            mostrarAlerta(Alert.AlertType.ERROR, "Error", "Por favor, seleccione una consulta para eliminar.");
        }
    }

    @FXML
    public void BotonLeer() {
        Consulta selectedItem = ListConsultasRealizadas.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            IntroducirFecha.setText(selectedItem.getFecha());
            IntroducirHora.setText(selectedItem.getHora());
            IntroducirMotivo.setText(selectedItem.getMotivo());
            IntroducirIDTratamiento.setText(selectedItem.getTratamiento().ID());
            IntroducirNombreTratamiento.setText(selectedItem.getTratamiento().nombre());
            IntroducirDuracion.setText(selectedItem.getTratamiento().duracion());
            IntroducirMedicamento.setText(selectedItem.getTratamiento().medicamento());
        } else {
            mostrarAlerta(Alert.AlertType.ERROR, "Error", "Por favor, seleccione una consulta para leer.");
        }
    }

    @FXML
    public void BotonModificar() {
        Consulta selectedItem = ListConsultasRealizadas.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            String nuevoMotivo = IntroducirMotivo.getText();
            String nuevoIDTratamiento = IntroducirIDTratamiento.getText();
            String nuevoNombreTratamiento = IntroducirNombreTratamiento.getText();
            String nuevaDuracionTratamiento = IntroducirDuracion.getText();
            String nuevoMedicamentoTratamiento = IntroducirMedicamento.getText();

            consultaController.actualizarConsulta(selectedItem, nuevoMotivo, nuevoIDTratamiento, nuevoNombreTratamiento, nuevaDuracionTratamiento, nuevoMedicamentoTratamiento);
            ListConsultasRealizadas.refresh();
            mostrarAlerta(Alert.AlertType.INFORMATION, "Éxito", "Consulta modificada.");
        } else {
            mostrarAlerta(Alert.AlertType.ERROR, "Error", "Por favor, seleccione una consulta para modificar.");
        }
    }

    private void limpiarCampos() {
        IntroducirFecha.clear();
        IntroducirHora.clear();
        IntroducirMotivo.clear();
        IntroducirIDTratamiento.clear();
        IntroducirNombreTratamiento.clear();
        IntroducirDuracion.clear();
        IntroducirMedicamento.clear();
    }

    private void mostrarAlerta(Alert.AlertType tipo, String titulo, String mensaje) {
        Alert alert = new Alert(tipo);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
    @FXML
    public void volverAtras() throws IOException {
        App.cambiarEscena("/co/edu/uniquindio/poo/veterinariaproyect/citas.fxml");
    }
}