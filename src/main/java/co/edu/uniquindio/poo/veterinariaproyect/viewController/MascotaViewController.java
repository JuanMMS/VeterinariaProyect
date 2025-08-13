package co.edu.uniquindio.poo.veterinariaproyect.viewController;

import co.edu.uniquindio.poo.veterinariaproyect.controller.MascotaController;
import co.edu.uniquindio.poo.veterinariaproyect.model.Mascota;
import co.edu.uniquindio.poo.veterinariaproyect.model.Propietario;
import co.edu.uniquindio.poo.veterinariaproyect.model.TipoEspecie;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import java.io.IOException;

public class MascotaViewController {

    @FXML private TableView<Mascota> tablaMascotas;
    @FXML private TableColumn<Mascota, String> colNombre;
    @FXML private TableColumn<Mascota, Integer> colEdad;
    @FXML private TableColumn<Mascota, String> colIdVeterinario;
    @FXML private TableColumn<Mascota, TipoEspecie> colEspecie;
    @FXML private TableColumn<Mascota, Propietario> colPropietario;

    @FXML private TextField nombreField;
    @FXML private Spinner<Integer> edadSpinner;
    @FXML private TextField idVeterinarioField;
    @FXML private ComboBox<TipoEspecie> especieCombo;
    @FXML private ComboBox<Propietario> propietarioCombo;

    private MascotaController mascotaController;

    @FXML
    public void initialize() {
        mascotaController = new MascotaController();

        // Configurar el Spinner de edad
        SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 30, 1);
        edadSpinner.setValueFactory(valueFactory);

        // Llenar los ComboBox con datos
        especieCombo.setItems(mascotaController.obtenerEspecies());
        propietarioCombo.setItems(mascotaController.obtenerPropietarios());

        // Configurar las columnas de la tabla
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colEdad.setCellValueFactory(new PropertyValueFactory<>("edad"));
        colIdVeterinario.setCellValueFactory(new PropertyValueFactory<>("IDVeterinario"));
        colEspecie.setCellValueFactory(new PropertyValueFactory<>("tipoEspecie"));
        colPropietario.setCellValueFactory(new PropertyValueFactory<>("propietario"));

        tablaMascotas.setItems(mascotaController.obtenerMascotas());
    }

    @FXML
    private void agregarMascota() {
        String nombre = nombreField.getText();
        String idVeterinario = idVeterinarioField.getText();
        TipoEspecie tipoEspecie = especieCombo.getValue();
        Propietario propietario = propietarioCombo.getValue();
        int edad = edadSpinner.getValue();

        if (nombre.isEmpty() || idVeterinario.isEmpty() || tipoEspecie == null || propietario == null) {
            mostrarAlerta("Campos Incompletos", "Por favor, complete todos los campos.");
            return;
        }

        Mascota mascota = new Mascota(nombre, edad, idVeterinario, tipoEspecie, propietario);
        mascotaController.agregarMascota(mascota);
        tablaMascotas.setItems(mascotaController.obtenerMascotas());
        limpiarCampos();
    }

    @FXML
    private void eliminarMascota() {
        Mascota mascota = tablaMascotas.getSelectionModel().getSelectedItem();
        if (mascota != null) {
            mascotaController.eliminarMascota(mascota);
            tablaMascotas.setItems(mascotaController.obtenerMascotas());
        } else {
            mostrarAlerta("No hay selección", "Seleccione una mascota de la tabla para eliminar.");
        }
    }

    @FXML
    private void actualizarMascota() {
        Mascota mascota = tablaMascotas.getSelectionModel().getSelectedItem();
        if (mascota != null) {
            String nombre = nombreField.getText();
            String idVeterinario = idVeterinarioField.getText();
            TipoEspecie tipoEspecie = especieCombo.getValue();
            Propietario propietario = propietarioCombo.getValue();
            int edad = edadSpinner.getValue();

            if (nombre.isEmpty() || idVeterinario.isEmpty() || tipoEspecie == null || propietario == null) {
                mostrarAlerta("Campos Incompletos", "Por favor, complete todos los campos para actualizar.");
                return;
            }

            mascota.setNombre(nombre);
            mascota.setEdad(edad);
            mascota.setIDVeterinario(idVeterinario);
            mascota.setTipoEspecie(tipoEspecie);
            mascota.setPropietario(propietario);
            // Si tienes un método de actualizar en el controlador, llámalo aquí.
            // mascotaController.actualizarMascota(mascota);
            tablaMascotas.refresh(); // Refresca la tabla para ver los cambios
            limpiarCampos();
        } else {
            mostrarAlerta("No hay selección", "Seleccione una mascota de la tabla para actualizar.");
        }
    }

    @FXML
    public void volverMenu(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/poo/veterinariaproyect/fxml/menu.fxml"));
        Parent root = loader.load();
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.setTitle("Menú Principal");
        stage.show();
    }

    private void limpiarCampos() {
        nombreField.clear();
        idVeterinarioField.clear();
        edadSpinner.getValueFactory().setValue(1);
        especieCombo.getSelectionModel().clearSelection();
        propietarioCombo.getSelectionModel().clearSelection();
    }

    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}