package co.edu.uniquindio.poo.veterinariaproyect.viewController;

import co.edu.uniquindio.poo.veterinariaproyect.App;
import co.edu.uniquindio.poo.veterinariaproyect.controller.PersonasController;
import co.edu.uniquindio.poo.veterinariaproyect.model.Persona;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import java.io.IOException;

public class PersonasViewController {

    @FXML
    private TableView<Persona> tablaPersonas;
    @FXML
    private TableColumn<Persona, String> idColumn;
    @FXML
    private TableColumn<Persona, String> nombreColumn;
    @FXML
    private TableColumn<Persona, String> telefonoColumn;
    @FXML
    private TableColumn<Persona, String> rolColumn;

    private PersonasController personasController;

    @FXML
    public void initialize() {
        personasController = new PersonasController();
        tablaPersonas.setItems(personasController.getListPersonas());

        // Verificación de los bindings
        nombreColumn.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        idColumn.setCellValueFactory(new PropertyValueFactory<>("ID"));
        telefonoColumn.setCellValueFactory(new PropertyValueFactory<>("telefono"));
        rolColumn.setCellValueFactory(new PropertyValueFactory<>("rol"));
    }
    @FXML
    public void agregarPersona() {

    }
    @FXML
    public void eliminarPersona() {
    }
    @FXML
    public void actualizarPersona() {

    }
    @FXML
    public void leerPersona() {

    }
    @FXML
    public void volverAtras() throws IOException {
        App.cambiarEscena("/co/edu/uniquindio/poo/veterinariaproyect/menu.fxml");
    }

}
