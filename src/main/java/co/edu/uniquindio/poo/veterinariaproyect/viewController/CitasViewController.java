package co.edu.uniquindio.poo.veterinariaproyect.viewController;

import co.edu.uniquindio.poo.veterinariaproyect.App;
import co.edu.uniquindio.poo.veterinariaproyect.controller.CitasController;
import co.edu.uniquindio.poo.veterinariaproyect.model.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.util.StringConverter;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import java.util.List;

public class CitasViewController implements Initializable {

    // TableView y sus columnas para mostrar los datos de la cita
    @FXML private TableView<Cita> tablaCitas;
    @FXML private TableColumn<Cita, String> columnaID;
    @FXML private TableColumn<Cita, String> columnaFecha;
    @FXML private TableColumn<Cita, String> columnaHora;
    @FXML private TableColumn<Cita, LugarCita> columnaLugar;
    @FXML private TableColumn<Cita, String> columnaVeterinario;
    @FXML private TableColumn<Cita, String> columnaMascota;
    @FXML private TableColumn<Cita, String> columnaPropietario;
    @FXML private TableColumn<Cita, String> columnaPersonalApoyo;

    // Campos de entrada de datos para el CRUD
    @FXML private TextField introducirFecha;
    @FXML private TextField introducirHora;
    @FXML private ComboBox<LugarCita> seleccionarLugar;
    @FXML private TextField introducirID;

    // ComboBoxes para seleccionar personas y mascotas
    @FXML private ComboBox<Veterinario> seleccionarVeterinario;
    @FXML private ComboBox<Mascota> seleccionarMascota;
    @FXML private ComboBox<Propietario> seleccionarPropietario;
    @FXML private ComboBox<PersonalApoyo> seleccionarPersonalApoyo;

    private CitasController citasController;
    private ObservableList<Cita> listCitasObservable;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.citasController = new CitasController();
        this.listCitasObservable = citasController.obtenerTodasLasCitas();

        // Configurar las columnas de la tabla para que muestren los datos
        columnaID.setCellValueFactory(new PropertyValueFactory<>("IDCita"));
        columnaFecha.setCellValueFactory(new PropertyValueFactory<>("fecha"));
        columnaHora.setCellValueFactory(new PropertyValueFactory<>("hora"));
        columnaLugar.setCellValueFactory(new PropertyValueFactory<>("lugarCita"));

        // Uso de PropertyValueFactory con los métodos getNombre... de la clase Cita
        columnaVeterinario.setCellValueFactory(new PropertyValueFactory<>("nombreVeterinario"));
        columnaMascota.setCellValueFactory(new PropertyValueFactory<>("nombreMascota"));
        columnaPropietario.setCellValueFactory(new PropertyValueFactory<>("nombrePropietario"));
        columnaPersonalApoyo.setCellValueFactory(new PropertyValueFactory<>("nombrePersonalApoyo"));

        tablaCitas.setItems(listCitasObservable);

        // Llenar los ComboBox con los valores del enum y las listas filtradas
        seleccionarLugar.setItems(FXCollections.observableArrayList(LugarCita.values()));

        List<Persona> allPersonasList = App.clinica1.getListPersonas();
        ObservableList<Persona> allPersonasObservable = FXCollections.observableArrayList(allPersonasList);

        // Filtrar personas usando el método getRol()
        ObservableList<Veterinario> veterinarios = allPersonasObservable.stream()
                .filter(p -> "Veterinario".equals(p.getRol()))
                .map(p -> (Veterinario) p)
                .collect(Collectors.toCollection(FXCollections::observableArrayList));

        ObservableList<Propietario> propietarios = allPersonasObservable.stream()
                .filter(p -> "Propietario".equals(p.getRol()))
                .map(p -> (Propietario) p)
                .collect(Collectors.toCollection(FXCollections::observableArrayList));

        ObservableList<PersonalApoyo> personalApoyo = allPersonasObservable.stream()
                .filter(p -> "Personal Apoyo".equals(p.getRol()))
                .map(p -> (PersonalApoyo) p)
                .collect(Collectors.toCollection(FXCollections::observableArrayList));

        seleccionarVeterinario.setItems(veterinarios);
        seleccionarPropietario.setItems(propietarios);
        seleccionarPersonalApoyo.setItems(personalApoyo);

        seleccionarMascota.setItems(FXCollections.observableArrayList(App.clinica1.getListMascotas()));

        // Configurar los StringConverter para los ComboBoxes
        seleccionarVeterinario.setConverter(new StringConverter<>() {
            @Override
            public String toString(Veterinario vet) {
                return vet != null ? vet.getNombre() : "";
            }
            @Override
            public Veterinario fromString(String string) {
                return null;
            }
        });

        seleccionarMascota.setConverter(new StringConverter<>() {
            @Override
            public String toString(Mascota mascota) {
                return mascota != null ? mascota.getNombre() : "";
            }
            @Override
            public Mascota fromString(String string) {
                return null;
            }
        });

        seleccionarPropietario.setConverter(new StringConverter<>() {
            @Override
            public String toString(Propietario prop) {
                return prop != null ? prop.getNombre() : "";
            }
            @Override
            public Propietario fromString(String string) {
                return null;
            }
        });

        seleccionarPersonalApoyo.setConverter(new StringConverter<>() {
            @Override
            public String toString(PersonalApoyo pa) {
                return pa != null ? pa.getNombre() : "";
            }
            @Override
            public PersonalApoyo fromString(String string) {
                return null;
            }
        });

        // Listener para cargar datos de la cita seleccionada en la tabla
        tablaCitas.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newCita) -> {
            if (newCita != null) {
                introducirFecha.setText(newCita.getFecha());
                introducirHora.setText(newCita.getHora());
                introducirID.setText(newCita.getIDCita());
                seleccionarLugar.getSelectionModel().select(newCita.getLugarCita());
                seleccionarVeterinario.getSelectionModel().select(newCita.getVeterinario());
                seleccionarMascota.getSelectionModel().select(newCita.getMascota());
                seleccionarPropietario.getSelectionModel().select(newCita.getPropietario());
                seleccionarPersonalApoyo.getSelectionModel().select(newCita.getPersonalApoyo());
            } else {
                limpiarCampos();
            }
        });
    }

    @FXML
    public void onAgregarClick(ActionEvent event) {
        String fecha = introducirFecha.getText();
        String hora = introducirHora.getText();
        LugarCita lugarCita = seleccionarLugar.getValue();
        Veterinario veterinario = seleccionarVeterinario.getValue();
        Mascota mascota = seleccionarMascota.getValue();
        Propietario propietario = seleccionarPropietario.getValue();
        PersonalApoyo personalApoyo = seleccionarPersonalApoyo.getValue();

        if (fecha.isEmpty() || hora.isEmpty() || lugarCita == null || veterinario == null || mascota == null || propietario == null || personalApoyo == null) {
            mostrarAlerta(Alert.AlertType.ERROR, "Error", "Todos los campos son obligatorios.");
            return;
        }

        citasController.crearNuevaCita(fecha, hora, lugarCita, veterinario, mascota, propietario, personalApoyo);
        limpiarCampos();
        tablaCitas.refresh(); // Refrescar la tabla
        mostrarAlerta(Alert.AlertType.INFORMATION, "Éxito", "Cita agregada exitosamente.");
    }

    @FXML
    public void onEliminarClick(ActionEvent event) {
        Cita selectedItem = tablaCitas.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            citasController.eliminarCita(selectedItem);
            limpiarCampos();
            tablaCitas.refresh(); // Refrescar la tabla
            mostrarAlerta(Alert.AlertType.INFORMATION, "Éxito", "Cita eliminada.");
        } else {
            mostrarAlerta(Alert.AlertType.ERROR, "Error", "Por favor, seleccione una cita para eliminar.");
        }
    }

    @FXML
    public void onLeerClick(ActionEvent event) {
        Cita selectedItem = tablaCitas.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            introducirFecha.setText(selectedItem.getFecha());
            introducirHora.setText(selectedItem.getHora());
            introducirID.setText(selectedItem.getIDCita());
            seleccionarLugar.getSelectionModel().select(selectedItem.getLugarCita());
            seleccionarVeterinario.getSelectionModel().select(selectedItem.getVeterinario());
            seleccionarMascota.getSelectionModel().select(selectedItem.getMascota());
            seleccionarPropietario.getSelectionModel().select(selectedItem.getPropietario());
            seleccionarPersonalApoyo.getSelectionModel().select(selectedItem.getPersonalApoyo());
        } else {
            mostrarAlerta(Alert.AlertType.ERROR, "Error", "Por favor, seleccione una cita para leer.");
        }
    }

    @FXML
    public void onModificarClick(ActionEvent event) {
        Cita selectedItem = tablaCitas.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            String nuevaFecha = introducirFecha.getText();
            String nuevaHora = introducirHora.getText();
            String nuevoID = introducirID.getText();
            LugarCita nuevoLugar = seleccionarLugar.getValue();
            Veterinario nuevoVeterinario = seleccionarVeterinario.getValue();
            Mascota nuevaMascota = seleccionarMascota.getValue();
            Propietario nuevoPropietario = seleccionarPropietario.getValue();
            PersonalApoyo nuevoPersonalApoyo = seleccionarPersonalApoyo.getValue();

            citasController.actualizarCita(selectedItem, nuevaFecha, nuevaHora, nuevoLugar, nuevoVeterinario, nuevaMascota, nuevoPropietario, nuevoPersonalApoyo, nuevoID);
            tablaCitas.refresh();
            mostrarAlerta(Alert.AlertType.INFORMATION, "Éxito", "Cita modificada.");
        } else {
            mostrarAlerta(Alert.AlertType.ERROR, "Error", "Por favor, seleccione una cita para modificar.");
        }
    }

    @FXML
    public void onConsultasClick(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("consulta.fxml"));
            Parent root = fxmlLoader.load();
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void limpiarCampos() {
        introducirFecha.clear();
        introducirHora.clear();
        seleccionarLugar.getSelectionModel().clearSelection();
        seleccionarVeterinario.getSelectionModel().clearSelection();
        seleccionarMascota.getSelectionModel().clearSelection();
        seleccionarPropietario.getSelectionModel().clearSelection();
        seleccionarPersonalApoyo.getSelectionModel().clearSelection();
        introducirID.clear();
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
        App.cambiarEscena("/co/edu/uniquindio/poo/veterinariaproyect/menu.fxml");
    }
}