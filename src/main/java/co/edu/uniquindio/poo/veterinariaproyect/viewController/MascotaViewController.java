package co.edu.uniquindio.poo.veterinariaproyect.viewController;

import co.edu.uniquindio.poo.veterinariaproyect.App;
import co.edu.uniquindio.poo.veterinariaproyect.controller.MascotaController;
import co.edu.uniquindio.poo.veterinariaproyect.model.Mascota;
import co.edu.uniquindio.poo.veterinariaproyect.model.Propietario;
import co.edu.uniquindio.poo.veterinariaproyect.model.TipoEspecie;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.StringConverter;
import java.io.IOException;

public class MascotaViewController {

    @FXML private TableView<Mascota> tablaMascotas;
    @FXML private TableColumn<Mascota, String> colNombre;
    @FXML private TableColumn<Mascota, Integer> colEdad;
    @FXML private TableColumn<Mascota, String> colIdVeterinario;
    @FXML private TableColumn<Mascota, TipoEspecie> colEspecie;
    @FXML private TableColumn<Mascota, String> colPropietario;

    @FXML private TextField nombreField;
    @FXML private Spinner<Integer> edadSpinner;
    @FXML private TextField idVeterinarioField;
    @FXML private ComboBox<TipoEspecie> especieCombo;
    @FXML private ComboBox<Propietario> propietarioCombo;

    private MascotaController mascotaController;

    @FXML
    public void initialize() {
        mascotaController = new MascotaController();

        SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 30, 1);
        edadSpinner.setValueFactory(valueFactory);

        especieCombo.setItems(mascotaController.obtenerEspecies());
        propietarioCombo.setItems(mascotaController.obtenerPropietarios());

        // Configurar el StringConverter para el ComboBox
        propietarioCombo.setConverter(new StringConverter<>() {
            @Override
            public String toString(Propietario propietario) {
                return propietario != null ? propietario.getNombre() : "";
            }
            @Override
            public Propietario fromString(String string) {
                return null;
            }
        });

        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colEdad.setCellValueFactory(new PropertyValueFactory<>("edad"));
        colIdVeterinario.setCellValueFactory(new PropertyValueFactory<>("IDVeterinario"));
        colEspecie.setCellValueFactory(new PropertyValueFactory<>("tipoEspecie"));
        colPropietario.setCellValueFactory(new PropertyValueFactory<>("nombrePropietario"));

        tablaMascotas.setItems(mascotaController.obtenerMascotas());

        tablaMascotas.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                nombreField.setText(newSelection.getNombre());
                edadSpinner.getValueFactory().setValue(newSelection.getEdad());
                idVeterinarioField.setText(newSelection.getIDVeterinario());
                especieCombo.setValue(newSelection.getTipoEspecie());
                propietarioCombo.setValue(newSelection.getPropietario());
            } else {
                limpiarCampos();
            }
        });
    }

    @FXML
    private void agregarMascota() {
        String nombre = nombreField.getText();
        String idVeterinario = idVeterinarioField.getText();
        TipoEspecie tipoEspecie = especieCombo.getValue();
        Propietario propietario = propietarioCombo.getValue();
        int edad = edadSpinner.getValue();

        if (nombre.isEmpty() || idVeterinario.isEmpty() || tipoEspecie == null || propietario == null) {
            mostrarAlerta(Alert.AlertType.ERROR, "Campos Incompletos", "Por favor, complete todos los campos.");
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
            mostrarAlerta(Alert.AlertType.WARNING, "No hay selección", "Seleccione una mascota de la tabla para eliminar.");
        }
    }

    @FXML
    private void actualizarMascota() {
        Mascota mascotaSeleccionada = tablaMascotas.getSelectionModel().getSelectedItem();
        if (mascotaSeleccionada != null) {
            String nombre = nombreField.getText();
            String idVeterinario = idVeterinarioField.getText();
            TipoEspecie tipoEspecie = especieCombo.getValue();
            Propietario propietario = propietarioCombo.getValue();
            Integer edad = edadSpinner.getValue();

            if (nombre.isEmpty() || idVeterinario.isEmpty() || tipoEspecie == null || propietario == null) {
                mostrarAlerta(Alert.AlertType.ERROR, "Campos Incompletos", "Por favor, complete todos los campos para actualizar.");
                return;
            }

            mascotaController.actualizarMascota(mascotaSeleccionada,
                    new Mascota(nombre, edad, idVeterinario, tipoEspecie, propietario));

            tablaMascotas.refresh();
            limpiarCampos();
        } else {
            mostrarAlerta(Alert.AlertType.WARNING, "No hay selección", "Seleccione una mascota de la tabla para actualizar.");
        }
    }
    @FXML
    public void volverMenu() throws IOException {
        App.cambiarEscena("/co/edu/uniquindio/poo/veterinariaproyect/menu.fxml");
    }

    private void limpiarCampos() {
        nombreField.clear();
        idVeterinarioField.clear();
        edadSpinner.getValueFactory().setValue(1);
        especieCombo.getSelectionModel().clearSelection();
        propietarioCombo.getSelectionModel().clearSelection();
        tablaMascotas.getSelectionModel().clearSelection();
    }

    private void mostrarAlerta(Alert.AlertType tipo, String titulo, String mensaje) {
        Alert alert = new Alert(tipo);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}