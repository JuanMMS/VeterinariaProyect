package co.edu.uniquindio.poo.veterinariaproyect.viewController;

import co.edu.uniquindio.poo.veterinariaproyect.controller.MenuController;
import co.edu.uniquindio.poo.veterinariaproyect.model.Cita;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

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
    private void onMascotasClick() {
    }
    @FXML
    private void onCitasClick() {
    }
    @FXML
    private void onPersonalClick() {
    }
}
