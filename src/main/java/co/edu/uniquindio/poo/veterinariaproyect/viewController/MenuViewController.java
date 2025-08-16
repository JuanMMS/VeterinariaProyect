package co.edu.uniquindio.poo.veterinariaproyect.viewController;

import co.edu.uniquindio.poo.veterinariaproyect.App;
import co.edu.uniquindio.poo.veterinariaproyect.controller.MenuController;
import co.edu.uniquindio.poo.veterinariaproyect.model.Cita;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import java.io.IOException;

public class MenuViewController {

    @FXML
    private TableView<Cita> tablaCitas;
    @FXML
    private TableColumn<Cita, String> columnaFecha;
    @FXML
    private TableColumn<Cita, String> columnaHora;
    @FXML
    private TableColumn<Cita, String> columnaMascota;
    @FXML
    private TableColumn<Cita, String> columnaDuenio;
    @FXML
    private TableColumn<Cita, String> columnaTelefono;
    @FXML
    private TableColumn<Cita, String> columnaVeterinario;

    private MenuController menuController;

    @FXML
    public void initialize() {
        menuController = new MenuController();
        tablaCitas.setItems(menuController.getListCitas());

        // Verificación de los bindings
        columnaFecha.setCellValueFactory(new PropertyValueFactory<>("fecha"));
        columnaHora.setCellValueFactory(new PropertyValueFactory<>("hora"));
        columnaMascota.setCellValueFactory(new PropertyValueFactory<>("nombreMascota"));
        columnaDuenio.setCellValueFactory(new PropertyValueFactory<>("nombrePropietario"));
        columnaTelefono.setCellValueFactory(new PropertyValueFactory<>("telefonoPropietario"));
        columnaVeterinario.setCellValueFactory(new PropertyValueFactory<>("nombreVeterinario"));
    }

    @FXML
    private void cerrarPrograma() {
        App.cerrarPrograma();
    }
    @FXML
    public void volverAtras() throws IOException {
        App.cambiarEscena("/co/edu/uniquindio/poo/veterinariaproyect/inicio.fxml");
    }
    @FXML
    private void onMascotasClick() throws IOException {
        App.cambiarEscena("/co/edu/uniquindio/poo/veterinariaproyect/mascota.fxml");
    }
    @FXML
    private void onCitasClick() throws IOException {
        App.cambiarEscena("/co/edu/uniquindio/poo/veterinariaproyect/citas.fxml");
    }
    @FXML
    private void onPersonalClick() throws IOException {
        App.cambiarEscena("/co/edu/uniquindio/poo/veterinariaproyect/personas.fxml");
    }
}
