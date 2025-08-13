package co.edu.uniquindio.poo.veterinariaproyect.viewController;

<<<<<<< Updated upstream
public class MenuViewController {
=======
import co.edu.uniquindio.poo.veterinariaproyect.App;
import co.edu.uniquindio.poo.veterinariaproyect.controller.MenuController;
import co.edu.uniquindio.poo.veterinariaproyect.model.Cita;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
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
    private TableColumn<Cita, String> columnaDescripcion;

    private MenuController menuController;

    @FXML
    public void initialize() {
        menuController = new MenuController();

        columnaFecha.setCellValueFactory(new PropertyValueFactory<>("fecha"));
        columnaHora.setCellValueFactory(new PropertyValueFactory<>("hora"));
        columnaDescripcion.setCellValueFactory(new PropertyValueFactory<>("descripcion"));

        tablaCitas.setItems(menuController.getListaCitas());
    }
    @FXML
    private void cerrarPrograma() {
        App.cerrarPrograma();
    }
    @FXML
    public void volverAtras() throws IOException {
        App.cambiarEscena("/co/edu/uniquindio/poo/veterinariaproyect/Inicio.fxml");
    }
    @FXML
    private void onMascotasClick() throws IOException {
        App.cambiarEscena("/co/edu/uniquindio/poo/veterinariaproyect/mascota.fxml");
    }
    @FXML
    private void onCitasClick() throws IOException {
        App.cambiarEscena("/co/edu/uniquindio/poo/veterinariaproyect/agenda.fxml");
    }
    @FXML
    private void onPersonalClick() throws IOException {
        App.cambiarEscena("/co/edu/uniquindio/poo/veterinariaproyect/personas.fxml");
    }
>>>>>>> Stashed changes
}
