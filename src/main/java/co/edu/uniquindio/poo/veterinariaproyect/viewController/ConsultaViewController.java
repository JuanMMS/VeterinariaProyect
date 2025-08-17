package co.edu.uniquindio.poo.veterinariaproyect.viewController;

import co.edu.uniquindio.poo.veterinariaproyect.App;
import co.edu.uniquindio.poo.veterinariaproyect.controller.ConsultaController;
import co.edu.uniquindio.poo.veterinariaproyect.model.Consulta;
import co.edu.uniquindio.poo.veterinariaproyect.model.Cita;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ListCell;
import javafx.util.Callback;

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


    @FXML private ListView<Cita> listCitasDisponibles;
    @FXML private ListView<Consulta> ListConsultasRealizadas;



    @FXML private TextField IntroducirFecha;
    @FXML private TextField IntroducirHora;
    @FXML private TextArea IntroducirMotivo;


    @FXML private TextField IntroducirIDTratamiento;
    @FXML private TextField IntroducirNombreTratamiento;
    @FXML private TextField IntroducirDuracion;
    @FXML private TextField IntroducirMedicamento;

    // Asumiendo que estos campos existen en tu FXML de consulta
    @FXML private TextField IntroducirIDTratamiento;
    @FXML private TextField IntroducirNombreTratamiento;
    @FXML private TextField IntroducirDuracion;
    @FXML private TextArea IntroducirMedicamento;


    private ConsultaController consultaController;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.consultaController = new ConsultaController();

        this.listaConsultasObservable = consultaController.getListaConsultas();

        // Configuración de CellFactory para Citas Disponibles
        listCitasDisponibles.setCellFactory(new Callback<ListView<Cita>, ListCell<Cita>>() {
            @Override
            public ListCell<Cita> call(ListView<Cita> param) {
                return new ListCell<Cita>() {
                    @Override
                    protected void updateItem(Cita cita, boolean empty) {
                        super.updateItem(cita, empty);
                        if (empty || cita == null) {
                            setText(null);
                        } else {
                            setText("Cita con " + cita.getMascota().getNombre() + " (" + cita.getFecha() + ")");
                        }
                    }
                };
            }
        });
        listCitasDisponibles.setItems(consultaController.obtenerCitasDisponibles());

        // Configuración de CellFactory para Consultas Realizadas
        ListConsultasRealizadas.setCellFactory(new Callback<ListView<Consulta>, ListCell<Consulta>>() {
            @Override
            public ListCell<Consulta> call(ListView<Consulta> param) {
                return new ListCell<Consulta>() {
                    @Override
                    protected void updateItem(Consulta consulta, boolean empty) {
                        super.updateItem(consulta, empty);
                        if (empty || consulta == null) {
                            setText(null);
                        } else {
                            setText("Consulta ID: " + consulta.getCita().getIDCita() + " (" + consulta.getFecha() + ")");
                        }
                    }
                };
            }
        });
        ListConsultasRealizadas.setItems(listaConsultasObservable);

        // Listener para la ListView de Citas
        listCitasDisponibles.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newCita) -> {


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


        // Listener para la ListView de Consultas
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

        Cita citaSeleccionada = listCitasDisponibles.getSelectionModel().getSelectedItem();

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


    @FXML
    public void volverAtras() throws IOException {
        App.cambiarEscena("/co/edu/uniquindio/poo/veterinariaproyect/citas.fxml");
    }

}