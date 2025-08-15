package co.edu.uniquindio.poo.veterinariaproyect.viewController;

import co.edu.uniquindio.poo.veterinariaproyect.App;
import co.edu.uniquindio.poo.veterinariaproyect.controller.PersonasController;
import co.edu.uniquindio.poo.veterinariaproyect.model.*;
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
        BotonModificar.setDisable(true);
    }

    private void habilitarCampos(boolean estado) {
        EspacioNombre.setDisable(!estado);
        EspacioID.setDisable(!estado);
        EspacioTelefono.setDisable(!estado);
        BotonAgregar.setDisable(!estado);
        BotonEliminar.setDisable(!estado);
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
        String nombre = EspacioNombre.getText();
        String id = EspacioID.getText();
        String tipoSeleccionado = SelectorTipoPersona.getValue();

        // 1. Validar los campos comunes
        if (nombre.isEmpty() || id.isEmpty() || EspacioTelefono.getText().isEmpty() || tipoSeleccionado == null) {
            mostrarAlerta(Alert.AlertType.ERROR, "Campos Incompletos", "Por favor, complete todos los campos obligatorios.");
            return;
        }

        int telefono;
        try {
            telefono = Integer.parseInt(EspacioTelefono.getText());
        } catch (NumberFormatException e) {
            mostrarAlerta(Alert.AlertType.ERROR, "Dato Incorrecto", "El campo Teléfono debe ser un número válido.");
            return;
        }

        // Creacion persona y validacion para saber que tipo de obejto es
        Persona nuevaPersona = null;
        if ("Veterinario".equals(tipoSeleccionado)) {
            String licencia = campoLicencia.getText();
            EspecialidadVeterinario especialidad = campoEspecialidad.getValue();

            if (licencia.isEmpty() || especialidad == null) {
                mostrarAlerta(Alert.AlertType.ERROR, "Campos Incompletos", "Complete los campos de Licencia y Especialidad.");
                return;
            }

            // Constructor veterinario
            nuevaPersona = new Veterinario(nombre, id, telefono, especialidad, licencia, true);

        } else if ("Propietario".equals(tipoSeleccionado)) {
            String direccion = campoDireccion.getText();

            if (direccion.isEmpty()) {
                mostrarAlerta(Alert.AlertType.ERROR, "Campos Incompletos", "Complete el campo de Dirección.");
                return;
            }
            // Constructor propietario
            nuevaPersona = new Propietario(nombre, id, telefono, direccion);

        } else if ("Personal Apoyo".equals(tipoSeleccionado)) {

            // Constructor personal apoyo
            nuevaPersona = new PersonalApoyo(nombre, id, telefono);
        }

        // 3. Agregar la persona si se creó exitosamente
        if (nuevaPersona != null) {
            personasController.agregarPersona(nuevaPersona);
            actualizarTabla(tipoSeleccionado);
            limpiarCampos();
            mostrarAlerta(Alert.AlertType.INFORMATION, "Éxito", "Persona agregada correctamente.");
        } else {
            mostrarAlerta(Alert.AlertType.ERROR, "Error", "No se pudo crear la persona.");
        }
    }

    private void mostrarAlerta(Alert.AlertType tipo, String titulo, String mensaje) {
        Alert alert = new Alert(tipo);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    @FXML
    public void eliminarPersona() {
        Persona persona = TablaPersonas.getSelectionModel().getSelectedItem();
        if (persona != null) {
            personasController.eliminarPersona(persona);
            TablaPersonas  .setItems(personasController.obtenerPersonas());
        } else {
            mostrarAlerta(Alert.AlertType.WARNING, "No hay selección", "Seleccione una mascota de la tabla para eliminar.");
        }
    }

    @FXML
    private void actualizarPersona() {
        Persona personaSeleccionada = TablaPersonas.getSelectionModel().getSelectedItem();
        if (personaSeleccionada == null) {
            mostrarAlerta(Alert.AlertType.WARNING, "No hay selección", "Seleccione una persona de la tabla para actualizar.");
            return;
        }

        String nombre = EspacioNombre.getText();
        String id = EspacioID.getText();
        String tipoSeleccionado = SelectorTipoPersona.getValue();

        // 1. Validar campos comunes
        if (nombre.isEmpty() || id.isEmpty() || EspacioTelefono.getText().isEmpty() || tipoSeleccionado == null) {
            mostrarAlerta(Alert.AlertType.ERROR, "Campos Incompletos", "Por favor, complete todos los campos para actualizar.");
            return;
        }

        int telefono;
        try {
            telefono = Integer.parseInt(EspacioTelefono.getText());
        } catch (NumberFormatException e) {
            mostrarAlerta(Alert.AlertType.ERROR, "Dato Incorrecto", "El campo Teléfono debe ser un número válido.");
            return;
        }

        // 2. Lógica para crear un nuevo objeto actualizado según el tipo
        Persona personaActualizada = null;
        if ("Veterinario".equals(tipoSeleccionado)) {
            String licencia = campoLicencia.getText();
            EspecialidadVeterinario especialidad = campoEspecialidad.getValue();
            boolean disponibilidad = ((Veterinario) personaSeleccionada).isDisponibilidad(); // Se mantiene el valor de disponibilidad

            if (licencia.isEmpty() || especialidad == null) {
                mostrarAlerta(Alert.AlertType.ERROR, "Campos Incompletos", "Complete los campos de Licencia y Especialidad.");
                return;
            }

            personaActualizada = new Veterinario(nombre, id, telefono, especialidad, licencia, disponibilidad);

        } else if ("Propietario".equals(tipoSeleccionado)) {
            String direccion = campoDireccion.getText();

            if (direccion.isEmpty()) {
                mostrarAlerta(Alert.AlertType.ERROR, "Campos Incompletos", "Complete el campo de Dirección.");
                return;
            }

            personaActualizada = new Propietario(nombre, id, telefono, direccion);

        } else if ("Personal Apoyo".equals(tipoSeleccionado)) {
            personaActualizada = new PersonalApoyo(nombre, id, telefono);
        }

        // 3. Actualizar la persona si se creó exitosamente
        if (personaActualizada != null) {
            personasController.actualizarPersona(personaSeleccionada, personaActualizada);
            actualizarTabla(tipoSeleccionado);
            limpiarCampos();
            mostrarAlerta(Alert.AlertType.INFORMATION, "Éxito", "Persona actualizada correctamente.");
        } else {
            mostrarAlerta(Alert.AlertType.ERROR, "Error", "No se pudo actualizar la persona.");
        }
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