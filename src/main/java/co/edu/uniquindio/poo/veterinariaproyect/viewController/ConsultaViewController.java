package co.edu.uniquindio.poo.veterinariaproyect.viewController;

import co.edu.uniquindio.poo.veterinariaproyect.controller.ConsultaController;
import co.edu.uniquindio.poo.veterinariaproyect.model.Consulta;
import co.edu.uniquindio.poo.veterinariaproyect.model.Cita;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

public class ConsultaViewController implements Initializable {

    @FXML private ListView<Cita> ListCitasDisponibles;
    @FXML private ListView<Consulta> ListConsultasRealizadas;
    @FXML private TextField IntroducirFecha;
    @FXML private TextField IntroducirHora;
    @FXML private TextArea IntroducirMotivo;
    @FXML private TextArea IntroducirTratamiento;

    private ConsultaController consultaController;
    private ObservableList<Consulta> listaConsultasObservable;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.consultaController = new ConsultaController();
        this.listaConsultasObservable = consultaController.obtenerTodasLasConsultas();

        // Asumiendo que tu CitaController carga las citas disponibles
        ListCitasDisponibles.setItems(consultaController.obtenerCitasDisponibles());

        ListConsultasRealizadas.setItems(listaConsultasObservable);

        // Listener para poblar los campos al seleccionar una consulta
        ListConsultasRealizadas.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newConsulta) -> {
            if (newConsulta != null) {
                IntroducirFecha.setText(newConsulta.getFecha());
                IntroducirHora.setText(newConsulta.getHora());
                IntroducirMotivo.setText(newConsulta.getMotivo());
                IntroducirTratamiento.setText(newConsulta.getTratamiento());
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
        String tratamiento = IntroducirTratamiento.getText();
        if (motivo.isEmpty() || tratamiento.isEmpty()) {
            mostrarAlerta(Alert.AlertType.ERROR, "Error", "Todos los campos de la consulta son obligatorios.");
            return;
        }

        consultaController.crearNuevaConsulta(citaSeleccionada, motivo, tratamiento);
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
            IntroducirTratamiento.setText(selectedItem.getTratamiento());
        } else {
            mostrarAlerta(Alert.AlertType.ERROR, "Error", "Por favor, seleccione una consulta para leer.");
        }
    }

    @FXML
    public void BotonModificar() {
        Consulta selectedItem = ListConsultasRealizadas.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            String nuevoMotivo = IntroducirMotivo.getText();
            String nuevoTratamiento = IntroducirTratamiento.getText();
            consultaController.actualizarConsulta(selectedItem, nuevoMotivo, nuevoTratamiento);
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
        IntroducirTratamiento.clear();
    }

    private void mostrarAlerta(Alert.AlertType tipo, String titulo, String mensaje) {
        Alert alert = new Alert(tipo);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}