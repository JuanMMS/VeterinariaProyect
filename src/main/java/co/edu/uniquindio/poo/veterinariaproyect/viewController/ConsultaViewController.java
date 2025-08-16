package co.edu.uniquindio.poo.veterinariaproyect.viewController;

import co.edu.uniquindio.poo.veterinariaproyect.App;
import co.edu.uniquindio.poo.veterinariaproyect.controller.ConsultaController;
import co.edu.uniquindio.poo.veterinariaproyect.model.Consulta;
import co.edu.uniquindio.poo.veterinariaproyect.model.Cita;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.stage.Stage;

public class ConsultaViewController implements Initializable {

    @FXML private ListView<Cita> ListCitasDisponibles;
    @FXML private TextField IntroducirFecha;
    @FXML private TextField IntroducirHora;
    @FXML private TextArea IntroducirMotivo;

    // Asumiendo que estos campos existen en tu FXML de consulta
    @FXML private TextField IntroducirIDTratamiento;
    @FXML private TextField IntroducirNombreTratamiento;
    @FXML private TextField IntroducirDuracion;
    @FXML private TextArea IntroducirMedicamento;

    private ConsultaController consultaController;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.consultaController = new ConsultaController();

        ListCitasDisponibles.setCellFactory(lv -> new ListCell<Cita>() {
            @Override
            protected void updateItem(Cita cita, boolean empty) {
                super.updateItem(cita, empty);
                if (empty || cita == null) {
                    setText(null);
                } else {
                    setText("ID: " + cita.getIDCita() + " - Fecha: " + cita.getFecha() + " - Hora: " + cita.getHora());
                }
            }
        });

        ListCitasDisponibles.setItems(consultaController.obtenerCitasDisponibles());

        ListCitasDisponibles.getSelectionModel().selectedItemProperty().addListener((obs, oldCita, newCita) -> {
            if (newCita != null) {
                IntroducirFecha.setText(newCita.getFecha());
                IntroducirHora.setText(newCita.getHora());
            } else {
                IntroducirFecha.clear();
                IntroducirHora.clear();
            }
        });
    }

    @FXML
    public void BotonAceptar() {
        // Validaciones previas
        Cita citaSeleccionada = ListCitasDisponibles.getSelectionModel().getSelectedItem();
        if (citaSeleccionada == null) {
            mostrarAlerta(Alert.AlertType.ERROR, "Error de selección", "Por favor, seleccione una cita de la lista.");
            return;
        }

        // Obtener los datos de la interfaz de usuario
        String motivo = IntroducirMotivo.getText();
        String idTratamiento = IntroducirIDTratamiento.getText();
        String nombreTratamiento = IntroducirNombreTratamiento.getText();
        String duracionTratamiento = IntroducirDuracion.getText();
        String medicamentoTratamiento = IntroducirMedicamento.getText();

        // Validar que los campos de la consulta no estén vacíos
        if (motivo.isEmpty()) {
            mostrarAlerta(Alert.AlertType.ERROR, "Error de datos", "El motivo de la consulta es obligatorio.");
            return;
        }

        // Validar que todos los campos del tratamiento no estén vacíos
        if (idTratamiento.isEmpty() || nombreTratamiento.isEmpty() || duracionTratamiento.isEmpty() || medicamentoTratamiento.isEmpty()) {
            mostrarAlerta(Alert.AlertType.ERROR, "Error de datos", "Todos los campos del tratamiento son obligatorios.");
            return;
        }

        // Llamar al controlador para crear la consulta
        consultaController.crearNuevaConsulta(citaSeleccionada.getFecha(), citaSeleccionada.getIDCita(), citaSeleccionada.getHora(), motivo, idTratamiento, nombreTratamiento, duracionTratamiento, citaSeleccionada);

        // Limpiar campos y mostrar mensaje de éxito
        limpiarCampos();
        mostrarAlerta(Alert.AlertType.INFORMATION, "Éxito", "Consulta creada exitosamente.");
    }

    // ... (resto de los métodos como BotonEliminar, BotonLeer, etc.)

    @FXML
    public void volverAtras() throws IOException {
        App.cambiarEscena("citas.fxml");
    }

    private void limpiarCampos() {
        // ... (lógica para limpiar todos los campos)
    }

    private void mostrarAlerta(Alert.AlertType tipo, String titulo, String mensaje) {
        Alert alert = new Alert(tipo);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}