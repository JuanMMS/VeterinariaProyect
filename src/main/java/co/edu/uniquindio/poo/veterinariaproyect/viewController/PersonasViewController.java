package co.edu.uniquindio.poo.veterinariaproyect.viewController;

import co.edu.uniquindio.poo.veterinariaproyect.App;
import co.edu.uniquindio.poo.veterinariaproyect.controller.PersonasController;
import co.edu.uniquindio.poo.veterinariaproyect.model.Persona;
import co.edu.uniquindio.poo.veterinariaproyect.model.Propietario;
import co.edu.uniquindio.poo.veterinariaproyect.model.EspecialidadVeterinario;
import co.edu.uniquindio.poo.veterinariaproyect.model.Veterinario;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import java.io.IOException;

public class PersonasViewController {

    @FXML private TableView<Persona> TablaPersonas;
    @FXML private TableColumn<Persona, String> idColumn;
    @FXML private TableColumn<Persona, String> nombreColumn;
    @FXML private TableColumn<Persona, String> rolColumn;

    @FXML private ChoiceBox<String> SelectorTipoPersona;

    @FXML private TextField EspacioNombre;
    @FXML private TextField EspacioID;
    @FXML private TextField EspacioTelefono;

    @FXML private VBox camposPropietario;
    @FXML private TextField campoDireccion;

    @FXML private VBox camposVeterinario;
    @FXML private TextField campoLicencia;
    @FXML private ComboBox<EspecialidadVeterinario> campoEspecialidad;
    @FXML private Label labelDisponibilidad;

    @FXML private Button BotonAgregar;
    @FXML private Button BotonEliminar;
    @FXML private Button BotonLeer;
    @FXML private Button BotonModificar;

    private PersonasController personasController;

    @FXML
    public void initialize() {
        personasController = new PersonasController();

        nombreColumn.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        idColumn.setCellValueFactory(new PropertyValueFactory<>("ID"));
        rolColumn.setCellValueFactory(new PropertyValueFactory<>("rol"));

        SelectorTipoPersona.getItems().addAll("Veterinario", "Propietario", "Personal Apoyo");
        SelectorTipoPersona.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
            if (newVal != null) {
                habilitarCampos(true);
                mostrarCamposDinamicos(newVal);
                actualizarTabla(newVal);
                limpiarCampos();
            } else {
                habilitarCampos(false);
                mostrarCamposDinamicos(null);
                TablaPersonas.getItems().clear();
                limpiarCampos();
            }
        });

        TablaPersonas.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                EspacioNombre.setText(newSelection.getNombre());
                EspacioID.setText(newSelection.getID());
                EspacioTelefono.setText(String.valueOf(newSelection.getTelefono()));

                String tipo = newSelection.getRol();
                mostrarCamposDinamicos(tipo);
                SelectorTipoPersona.setValue(tipo);

                if ("Propietario".equals(tipo)) {
                    Propietario propietario = (Propietario) newSelection;
                    campoDireccion.setText(propietario.getDireccion());
                } else if ("Veterinario".equals(tipo)) {
                    Veterinario veterinario = (Veterinario) newSelection;
                    campoLicencia.setText(veterinario.getLicencia());
                    campoEspecialidad.setValue(veterinario.getEspecialidad());
                    labelDisponibilidad.setText(veterinario.isDisponibilidad() ? "Disponible" : "No Disponible");
                }
            } else {
                limpiarCampos();
            }
        });

        habilitarCampos(false);
        BotonAgregar.setDisable(true);
        BotonEliminar.setDisable(true);
        BotonLeer.setDisable(true);
        BotonModificar.setDisable(true);
    }

    private void habilitarCampos(boolean estado) {
        EspacioNombre.setDisable(!estado);
        EspacioID.setDisable(!estado);
        EspacioTelefono.setDisable(!estado);
        BotonAgregar.setDisable(!estado);
        BotonEliminar.setDisable(!estado);
        BotonLeer.setDisable(!estado);
        BotonModificar.setDisable(!estado);
    }

    private void mostrarCamposDinamicos(String tipo) {
        camposPropietario.setVisible(false);
        camposVeterinario.setVisible(false);

        if ("Propietario".equals(tipo)) {
            camposPropietario.setVisible(true);
        } else if ("Veterinario".equals(tipo)) {
            camposVeterinario.setVisible(true);
            campoEspecialidad.setItems(personasController.obtenerEspecialidades());
        }
    }

    private void actualizarTabla(String tipo) {
        TablaPersonas.setItems(personasController.obtenerPersonasPorTipo(tipo));
    }

    @FXML
    public void agregarPersona() {
        // Implementar lógica para agregar
    }

    @FXML
    public void eliminarPersona() {
        // Implementar lógica para eliminar
    }

    @FXML
    public void leerPersona() {
        // Implementar lógica para leer
    }

    @FXML
    public void actualizarPersona() {
        // Implementar lógica para actualizar
    }

    private void limpiarCampos() {
        EspacioNombre.clear();
        EspacioID.clear();
        EspacioTelefono.clear();
        campoDireccion.clear();
        campoLicencia.clear();
        campoEspecialidad.getSelectionModel().clearSelection();
        labelDisponibilidad.setText("");
    }

    @FXML
    public void volverAtras() throws IOException {
        App.cambiarEscena("/co/edu/uniquindio/poo/veterinariaproyect/menu.fxml");
    }
}