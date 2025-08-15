package co.edu.uniquindio.poo.veterinariaproyect.viewController;

import co.edu.uniquindio.poo.veterinariaproyect.App;
import co.edu.uniquindio.poo.veterinariaproyect.controller.PersonasController;
import co.edu.uniquindio.poo.veterinariaproyect.model.*;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import java.io.IOException;

import java.awt.*;

public class TratamientoController {
    @FXML private Button BotonAceptar;
    @FXML private TextField IntroducirID;
    @FXML private TextField IntroducirNombre;
    @FXML private TextField IntroducirDuracion;
    @FXML private TextField IntroducirMedicamento;

    private TratamientoController tratamientoController;

    @FXML
    public void initialize() {
        tratamientoController = new TratamientoController();
        habilitarCampos(false);
        BotonAceptar.setDisable(True);

    }
    private void habilitarCampos(boolean estado) {
        IntroducirID.setDisable(!estado);
        IntroducirNombre.setDisable(!estado);
        IntroducirDuracion.setDisable(!estado);
        IntroducirMedicamento.setDisable(!estado);

    }

    public void crearTratamiento(){
        String ID = IntroducirID.getText();
        String Nombre = IntroducirNombre.getText();
        String Duracion = IntroducirDuracion.getText();
        String Medicamento = IntroducirMedicamento.getText();

        // Validación 1: Campos vacíos
        if (ID.isEmpty() || Nombre.isEmpty() || Duracion.isEmpty() || Medicamento.isEmpty()) {
            System.out.println("Error: Todos los campos son obligatorios.");
            // Aquí puedes mostrar un cuadro de diálogo al usuario
            return;
        }

        // Validación 2: Formato del ID
        int id;
        try {
            id = Integer.parseInt(ID);
        } catch (NumberFormatException e) {
            System.out.println("Error: El ID debe ser un número entero.");
            return;
        }

        // Validación 3: Formato y valor de la Duración
        int duracion;
        try {
            duracion = Integer.parseInt(Duracion);
            if (duracion <= 0) {
                System.out.println("Error: La duración debe ser un número positivo.");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("Error: La duración debe ser un número entero.");
            return;
        }

        // Si todas las validaciones pasan, se puede proceder a crear el objeto Tratamiento
        // Tratamiento nuevoTratamiento = new Tratamiento(id, Nombre, duracion, Medicamento);
        System.out.println("Tratamiento creado exitosamente.");
    }
    }


}
