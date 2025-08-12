package co.edu.uniquindio.poo.veterinariaproyect.viewController;

import co.edu.uniquindio.poo.veterinariaproyect.controller.MascotaController;
import co.edu.uniquindio.poo.veterinariaproyect.model.Mascota;
import co.edu.uniquindio.poo.veterinariaproyect.App;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;

public class MascotaViewController {

    @FXML private TableView<Mascota> tableMascotas;
    @FXML private TableColumn<Mascota, String> colNombre;
    @FXML private TableColumn<Mascota, String> colEspecie;
    @FXML private TableColumn<Mascota, String> colRaza;

    @FXML private TextField txtNombre;
    @FXML private TextField txtEspecie;
    @FXML private TextField txtRaza;

    @FXML private Button btnAgregar;
    @FXML private Button btnEliminar;
    @FXML private Button btnActualizar;

    private MascotaController mascotaController;

    @FXML
    public void initialize() {
        mascotaController = new MascotaController(App.getInstance());

        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colEspecie.setCellValueFactory(new PropertyValueFactory<>("especie"));
        colRaza.setCellValueFactory(new PropertyValueFactory<>("raza"));

        tableMascotas.setItems(mascotaController.obtenerMascotas());
    }

    @FXML
    private void agregarMascota() {
        Mascota mascota = new Mascota(txtNombre.getText(), txtEspecie.getText(), txtRaza.getText());
        mascotaController.agregarMascota(mascota);
        tableMascotas.setItems(mascotaController.obtenerMascotas());
    }

    @FXML
    private void eliminarMascota() {
        Mascota mascota = tableMascotas.getSelectionModel().getSelectedItem();
        if (mascota != null) {
            mascotaController.eliminarMascota(mascota);
            tableMascotas.setItems(mascotaController.obtenerMascotas());
        }
    }

    @FXML
    private void actualizarMascota() {
        Mascota mascota = tableMascotas.getSelectionModel().getSelectedItem();
        if (mascota != null) {
            mascota.setNombre(txtNombre.getText());
            //mascota.setEspecie(txtEspecie.getText());
            //mascota.setRaza(txtRaza.getText());
            //mascotaController.actualizarMascota(mascota);
            tableMascotas.setItems(mascotaController.obtenerMascotas());
        }
    }
    public void volverMenu(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/poo/veterinariaproyect/fxml/menu.fxml"));
        Parent root = loader.load();
    }
}
