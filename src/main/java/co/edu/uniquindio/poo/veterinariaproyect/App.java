package co.edu.uniquindio.poo.veterinariaproyect;

import co.edu.uniquindio.poo.veterinariaproyect.model.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase principal de la aplicación.
 * <p>
 * Se encarga de inicializar la interfaz gráfica, cargar los datos iniciales
 * de la clínica y gestionar el cambio de escenas.
 * </p>
 */
public class App extends Application {

    private static Stage primaryStage;
    public static ClinicaVeterinaria clinica1;

    /**
     * Inicia la aplicación y configura la ventana principal.
     * <p>
     * Este método carga los datos iniciales de la clínica, crea la escena
     * inicial y la muestra en la ventana principal (stage).
     * </p>
     *
     * @param stage La ventana principal (stage) de la aplicación.
     * @throws IOException Si ocurre un error al cargar el archivo FXML.
     */
    @Override
    public void start(Stage stage) throws IOException {
        primaryStage = stage;
        initData();

        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("inicio.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Clínica Veterinaria");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Cambia la escena actual de la aplicación por una nueva escena cargada desde un archivo FXML.
     *
     * @param fxml El nombre del archivo FXML (por ejemplo, "menu.fxml").
     * @throws IOException Si ocurre un error al cargar el archivo FXML.
     */
    public static void cambiarEscena(String fxml) throws IOException {
        FXMLLoader loader = new FXMLLoader(App.class.getResource(fxml));
        Scene scene = new Scene(loader.load());
        primaryStage.setScene(scene);
        primaryStage.centerOnScreen();
    }

    /**
     * Cierra la aplicación.
     */
    public static void cerrarPrograma() {
        System.exit(0);
    }
    /**
     * Inicializa y carga los datos de prueba en la clínica.
     * <p>
     * Este método crea instancias de `ClinicaVeterinaria`, `Propietario`, `Mascota`, `Cita`,
     * `Consulta`, etc., y las añade a las listas correspondientes de la clínica.
     * </p>
     */
    private void initData() {
        // Inicializa el objeto estático de la clínica
        clinica1 = new ClinicaVeterinaria("Clínica San Albero", "1234");

        // Crea y popula las listas de datos
        List<Mascota> mascotas = new ArrayList<>();
        List<Persona> personas = new ArrayList<>();
        List<PersonalApoyo> personalApoyo = new ArrayList<>();
        List<Propietario> propietarios = new ArrayList<>();
        List<Veterinario> veterinarios = new ArrayList<>();
        List<ConsultaViewController> consultas = new ArrayList<>();
        List<Cita> citas = new ArrayList<>();
        List<Tratamiento> tratamientos = new ArrayList<>();

        // Define personas base
        Propietario prop1 = new Propietario("Juan Pérez", "12345678", 317561655, "Cll 35 - 10");
        Propietario prop2 = new Propietario("Ana Gómez", "87654321", 315561655, "Cll 12 - 10");
        propietarios.add(prop1);
        propietarios.add(prop2);

        Veterinario vet1 = new Veterinario("Carlos Ruiz", "11223344", 31575, EspecialidadVeterinario.CARDIOLOGIA, "21515151", true);
        Veterinario vet2 = new Veterinario("María Torres", "99887766", 31878, EspecialidadVeterinario.GENERAL,"51552111", false);
        veterinarios.add(vet1);
        veterinarios.add(vet2);

        PersonalApoyo personal1 = new PersonalApoyo("Pedro López", "AB123", 315154);
        PersonalApoyo personal2 = new PersonalApoyo("Carlos Estrada", "AB122", 315154);
        personalApoyo.add(personal1);
        personalApoyo.add(personal2);

        personas.addAll(propietarios);
        personas.addAll(veterinarios);
        personas.addAll(personalApoyo);

        // Crea mascotas
        Mascota mascota1 = new Mascota("Firulais", 8, "F2018", TipoEspecie.PERRO, prop1);
        Mascota mascota2 = new Mascota("Misu", 10, "M2013", TipoEspecie.GATO, prop2);
        mascotas.add(mascota1);
        mascotas.add(mascota2);

        // Crea tratamientos
        Tratamiento trat1 = new Tratamiento("Vacunación", "Vacuna antirrábica", "350", "DIS");
        Tratamiento trat2 = new Tratamiento("Desparasitación", "Desparasitación interna","180", "DSA");
        tratamientos.add(trat1);
        tratamientos.add(trat2);

        // Define citas
        Cita cita1 = new Cita("54DF4", "10-05-2025", "15:00", LugarCita.SEDECENTRO, vet1, mascota1, prop1, personal1);
        Cita cita2 = new Cita("55DF4", "05-05-2025", "12:00", LugarCita.SEDENORTE, vet2, mascota2, prop2, personal2);
        citas.add(cita1);
        citas.add(cita2);

        // Define consultas
        ConsultaViewController consulta1 = new ConsultaViewController("10-08-2025", "545FDF5","15:05", "Chequeo general", cita1);
        ConsultaViewController consulta2 = new ConsultaViewController("05-08-2025", "1FD5F15", "12:05", "Control de salud", cita2);
        consultas.add(consulta1);
        consultas.add(consulta2);

        // Relaciona objetos con la clínica
        clinica1.getListPersonas().addAll(personas);
        clinica1.getListMascotas().addAll(mascotas);
        clinica1.getListConsultas().addAll(consultas);
        clinica1.getListCitas().addAll(citas);
    }

    /**
     * Método principal para lanzar la aplicación.
     *
     * @param args Argumentos de la línea de comandos.
     */
    public static void main(String[] args) {
        launch();
    }
}