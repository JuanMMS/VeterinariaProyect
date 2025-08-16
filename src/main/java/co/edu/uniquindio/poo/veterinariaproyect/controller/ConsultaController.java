package co.edu.uniquindio.poo.veterinariaproyect.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

public class ConsultaController implements Initializable {

    @FXML
    private ListView<String> ListCitas;

    @FXML
    private TextField IntroducirFecha;

    @FXML
    private TextField IntroducirHora;

    @FXML
    private TextArea IntroducirMotivo;

    @FXML
    private Button BotonAceptar;

    @FXML
    private Button BotonEliminar;

    @FXML
    private Button BotonLeer;

    @FXML
    private Button BotonModificar;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Inicialización del controlador.
        // Aquí se pueden cargar datos en la ListView o realizar otras configuraciones iniciales.
    }

    @FXML
    public void BotonAceptar() {
        System.out.println("Boton Aceptar presionado.");
        // Lógica para guardar una nueva consulta
        String fecha = IntroducirFecha.getText();
        String hora = IntroducirHora.getText();
        String motivo = IntroducirMotivo.getText();

        // Ejemplo de validación básica
        if (!fecha.isEmpty() && !hora.isEmpty() && !motivo.isEmpty()) {
            System.out.println("Consulta creada - Fecha: " + fecha + ", Hora: " + hora + ", Motivo: " + motivo);
            // Aquí iría la lógica para guardar la consulta en una base de datos o lista.
        } else {
            System.out.println("Por favor, complete todos los campos.");
        }
    }

    @FXML
    public void BotonEliminar() {
        System.out.println("Boton Eliminar presionado.");
        // Lógica para eliminar la consulta seleccionada de la lista
        String selectedItem = ListCitas.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            ListCitas.getItems().remove(selectedItem);
            System.out.println("Consulta eliminada: " + selectedItem);
        } else {
            System.out.println("Seleccione una consulta para eliminar.");
        }
    }

    @FXML
    public void BotonLeer() {
        System.out.println("Boton Leer presionado.");
        // Lógica para leer la consulta seleccionada y cargar los datos en los campos de texto
        String selectedItem = ListCitas.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            // Suponiendo que la información está en un formato específico dentro del ListView.
            // Para un caso real, se cargaría la información desde el objeto correspondiente.
            // Ejemplo:
            // IntroducirFecha.setText(consulta.getFecha());
            // IntroducirHora.setText(consulta.getHora());
            // IntroducirMotivo.setText(consulta.getMotivo());
            System.out.println("Cargando datos de la consulta: " + selectedItem);
        } else {
            System.out.println("Seleccione una consulta para leer.");
        }
    }

    @FXML
    public void BotonModificar() {
        System.out.println("Boton Modificar presionado.");
        // Lógica para modificar la consulta seleccionada
        String selectedItem = ListCitas.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            System.out.println("Modificando consulta: " + selectedItem);
            // Aquí iría la lógica para actualizar la consulta con los nuevos datos de los campos de texto.
        } else {
            System.out.println("Seleccione una consulta para modificar.");
        }
    }
}
