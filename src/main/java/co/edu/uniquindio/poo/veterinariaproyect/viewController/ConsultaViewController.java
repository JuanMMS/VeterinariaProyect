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

    // Asumiendo que estos campos existen en un FXML más completo o que se añadirán
    @FXML private TextField IntroducirIDTratamiento;
    @FXML private TextField IntroducirNombreTratamiento;
    @FXML private TextField IntroducirDuracion;
    @FXML private TextArea IntroducirMedicamento;

    private ConsultaController consultaController;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.consultaController = new ConsultaController();

        // Configura cómo se renderizan los objetos Cita en el ListView
        ListCitasDisponibles.setCellFactory(lv -> new ListCell<Cita>() {
            @Override
            protected void updateItem(Cita cita, boolean empty) {
                super.updateItem(cita, empty);
                if (empty || cita == null) {
                    setText(null);
                } else {
                    // Formatea la cadena para mostrar los datos de la cita
                    setText("ID: " + cita.getIDCita() + " - Fecha: " + cita.getFecha() + " - Hora: " + cita.getHora());
                }
            }
        });

        // Carga la lista de citas disponibles en el ListView
        ListCitasDisponibles.setItems(consultaController.obtenerCitasDisponibles());

        // Listener para rellenar campos al seleccionar una cita
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
    public void BotonAceptar(ActionEvent event) {
        try {
            // Carga el archivo FXML para la nueva ventana.
            // La ruta es relativa a la clase 'App'.
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("tratamiento.fxml"));
            Parent root = fxmlLoader.load();

            // Crea un nuevo Stage (ventana emergente)
            Stage stage = new Stage();
            stage.setTitle("Gestión de Tratamiento");
            stage.setScene(new Scene(root));
            stage.show();

        } catch (IOException e) {
            // Maneja el error si el archivo FXML no se encuentra o no se puede cargar
            e.printStackTrace();
            mostrarAlerta(Alert.AlertType.ERROR, "Error de carga", "No se pudo cargar la ventana de tratamiento.");
        }
    }

    @FXML
    public void BotonEliminar() {
        // Lógica de eliminación
    }

    @FXML
    public void BotonLeer() {
        // Lógica de lectura
    }

    @FXML
    public void BotonModificar() {
        // Lógica de modificación
    }

    @FXML
    public void volverAtras() throws IOException {
        App.cambiarEscena("citas.fxml");
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
}