package co.edu.uniquindio.poo.veterinariaproyect;
import co.edu.uniquindio.poo.veterinariaproyect.model.Consulta;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

    public class ConsultaViewController implements Initializable {

        // Se enlaza el ListView a un tipo de objeto Consulta
        @FXML
        private ListView<Cita> ListCitas;

        @FXML
        private TextField IntroducirFecha;

        @FXML
        private TextField IntroducirHora;

        @FXML
        private TextArea IntroducirMotivo;

        // ObservableList para almacenar las consultas y actualizar automáticamente la vista
        private ObservableList<Consulta> listaDeConsultas = FXCollections.observableArrayList();

        @Override
        public void initialize(URL url, ResourceBundle rb) {
            // Vincula la ObservableList al ListView
            ListCitas.setItems(listaDeConsultas);
        }

        @FXML
        public void BotonAceptar() {
            String fecha = IntroducirFecha.getText();
            String hora = IntroducirHora.getText();
            String motivo = IntroducirMotivo.getText();

            // Validaciones básicas
            if (fecha.isEmpty() || hora.isEmpty() || motivo.isEmpty()) {
                mostrarAlerta("Error", "Todos los campos son obligatorios.");
                return;
            }

            // Se crea un nuevo objeto Consulta con los datos de los campos de texto
            // Aquí necesitas un ID y un objeto Cita, los cuales no están en tu FXML,
            // así que se usan valores de ejemplo.
            String nuevoID = "C-" + (listaDeConsultas.size() + 1);
            Consulta nuevaConsulta = new Consulta(fecha, nuevoID, hora, motivo, new Cita());

            // Se añade la nueva consulta a la lista
            listaDeConsultas.add(nuevaConsulta);

            // Limpiar los campos después de crear la consulta
            limpiarCampos();
            mostrarAlerta("Éxito", "Consulta creada exitosamente.");
        }

        @FXML
        public void BotonEliminar() {
            Consulta selectedItem = ListCitas.getSelectionModel().getSelectedItem();
            if (selectedItem != null) {
                listaDeConsultas.remove(selectedItem);
                limpiarCampos();
                mostrarAlerta("Éxito", "Consulta eliminada.");
            } else {
                mostrarAlerta("Error", "Por favor, seleccione una consulta para eliminar.");
            }
        }

        @FXML
        public void BotonLeer() {
            Consulta selectedItem = ListCitas.getSelectionModel().getSelectedItem();
            if (selectedItem != null) {
                // Cargar los datos de la consulta seleccionada en los campos de texto
                IntroducirFecha.setText(selectedItem.getFecha());
                IntroducirHora.setText(selectedItem.getHora());
                IntroducirMotivo.setText(selectedItem.getMotivo());
            } else {
                mostrarAlerta("Error", "Por favor, seleccione una consulta para leer.");
            }
        }

        @FXML
        public void BotonModificar() {
            Consulta selectedItem = ListCitas.getSelectionModel().getSelectedItem();
            if (selectedItem != null) {
                // Actualizar el objeto seleccionado con los nuevos datos de los campos
                selectedItem.setFecha(IntroducirFecha.getText());
                selectedItem.setHora(IntroducirHora.getText());
                selectedItem.setMotivo(IntroducirMotivo.getText());

                // La vista se actualiza automáticamente gracias a la ObservableList
                ListCitas.refresh(); // Se usa refresh para asegurar la actualización visual del toString()
                mostrarAlerta("Éxito", "Consulta modificada.");
            } else {
                mostrarAlerta("Error", "Por favor, seleccione una consulta para modificar.");
            }
        }

        // Métodos auxiliares
        private void limpiarCampos() {
            IntroducirFecha.clear();
            IntroducirHora.clear();
            IntroducirMotivo.clear();
        }

        private void mostrarAlerta(String titulo, String mensaje) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle(titulo);
            alert.setHeaderText(null);
            alert.setContentText(mensaje);
            alert.showAndWait();
        }
    }
}
