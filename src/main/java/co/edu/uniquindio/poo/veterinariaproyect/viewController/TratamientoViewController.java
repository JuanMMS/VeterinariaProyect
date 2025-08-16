package co.edu.uniquindio.poo.veterinariaproyect.viewController;

import co.edu.uniquindio.poo.veterinariaproyect.controller.TratamientoController;
import co.edu.uniquindio.poo.veterinariaproyect.model.Tratamiento;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class TratamientoViewController implements Initializable {

    @FXML private Button BotonAceptar;
    @FXML private TextField IntroducirID;
    @FXML private TextField IntroducirNombre;
    @FXML private TextField IntroducirDuracion;
    @FXML private TextArea IntroducirMedicamento;

    private TratamientoController tratamientoController;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.tratamientoController = new TratamientoController();
    }

    @FXML
    private void handleBotonAceptar() {
        // 1. Obtener los datos de la interfaz de usuario
        String id = IntroducirID.getText();
        String nombre = IntroducirNombre.getText();
        String duracion = IntroducirDuracion.getText();
        String medicamento = IntroducirMedicamento.getText();

        // 2. Validar que los campos no estén vacíos
        if (id.isEmpty() || nombre.isEmpty() || duracion.isEmpty() || medicamento.isEmpty()) {
            mostrarAlerta(Alert.AlertType.ERROR, "Error", "Todos los campos son obligatorios.");
            return; // Detiene la ejecución si hay campos vacíos
        }

        // 3. Llamar al controlador de lógica para crear el tratamiento
        Tratamiento nuevoTratamiento = tratamientoController.crearTratamiento(id, nombre, duracion, medicamento);

        if (nuevoTratamiento != null) {
            mostrarAlerta(Alert.AlertType.INFORMATION, "Éxito", "Tratamiento creado y guardado exitosamente.");

            // Opcional: Cerrar la ventana después de guardar
            Stage stage = (Stage) BotonAceptar.getScene().getWindow();
            stage.close();

        } else {
            mostrarAlerta(Alert.AlertType.ERROR, "Error", "Ya existe un tratamiento con ese ID. Por favor, ingrese uno diferente.");
        }
    }

    /**
     * Muestra una alerta con un tipo, título y mensaje específicos.
     * @param tipo Tipo de la alerta (ERROR, INFORMATION, etc.).
     * @param titulo Título de la ventana de la alerta.
     * @param mensaje Mensaje a mostrar en el cuerpo de la alerta.
     */
    private void mostrarAlerta(Alert.AlertType tipo, String titulo, String mensaje) {
        Alert alert = new Alert(tipo);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}