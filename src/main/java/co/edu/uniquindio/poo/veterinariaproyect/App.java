package co.edu.uniquindio.poo.veterinariaproyect;

import co.edu.uniquindio.poo.veterinariaproyect.model.*;
import co.edu.uniquindio.poo.veterinariaproyect.model.ClinicaVeterinaria;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class App extends Application {



    @Override
    public void start(Stage stage) throws IOException {
        // Inicializamos datos
        initData();
        App.clinica1 = new ClinicaVeterinaria("Clínica San Albero", "1234");
        // Cargar el menú principal
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("menu.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Clínica Veterinaria");
        stage.setScene(scene);
        stage.show();
    }

    private void initData() {
        //Crear clínica
        ClinicaVeterinaria clinica1 = new ClinicaVeterinaria("Clínica San Albero", "1234");

        //Crear Listas globales

        List<Mascota> mascotas = new ArrayList<>();
        List<Persona> personas = new ArrayList<>();
        List<PersonalApoyo> personalApoyo = new ArrayList<>();
        List<Propietario> propietarios = new ArrayList<>();
        List<Veterinario> veterinarios = new ArrayList<>();
        List<Consulta> consultas = new ArrayList<>();
        List<Cita> citas = new ArrayList<>();
        List<Tratamiento> tratamientos = new ArrayList<>();

        //Definir personas base
        Propietario prop1 = new Propietario("Juan Pérez", "12345678", 317561655, "Cll 35 - 10");
        Propietario prop2 = new Propietario("Ana Gómez", "87654321", 315561655, "Cll 12 - 10");
        propietarios.add(prop1);
        propietarios.add(prop2);

        Veterinario vet1 = new Veterinario("Carlos Ruiz", "11223344", 31575, "EspecialidadVeterinario.CARDIOLOGIA", "21515151", true);
        Veterinario vet2 = new Veterinario("María Torres", "99887766", 31878, "EspecialidadVeterinario.GENERAL","51552111", false);
        veterinarios.add(vet1);
        veterinarios.add(vet2);

        PersonalApoyo personal1 = new PersonalApoyo("Pedro López", "AB123", 315154);
        PersonalApoyo personal2 = new PersonalApoyo("Carlos Estrada", "AB122", 315154);
        personalApoyo.add(personal1);
        personalApoyo.add(personal2);

        personas.addAll(propietarios);
        personas.addAll(veterinarios);
        personas.addAll(personalApoyo);

        //Crear mascotas
        Mascota mascota1 = new Mascota("Firulais", 8, "F2018", TipoEspecie.PERRO, prop1);
        Mascota mascota2 = new Mascota("Misu", 10, "M2013", TipoEspecie.GATO, prop2);
        mascotas.add(mascota1);
        mascotas.add(mascota2);

        //Crear tratamientos
        Tratamiento trat1 = new Tratamiento("Vacunación", "Vacuna antirrábica", "10-08-2025");
        Tratamiento trat2 = new Tratamiento("Desparasitación", "Desparasitación interna", "05-08-2025");
        tratamientos.add(trat1);
        tratamientos.add(trat2);



        //Definir citas
        Cita cita1 = new Cita("54DF4", "10-05-2025", "15:00", LugarCita.SEDECENTRO, vet1, mascota1, prop1, personal1);
        Cita cita2 = new Cita("55DF4", "05-05-2025", "12:00", LugarCita.SEDENORTE, vet2, mascota2, prop1, personal2);
        citas.add(cita1);
        citas.add(cita2);

        //Definir consultas consultas
        Consulta consulta1 = new Consulta("10-08-2025", "545FDF5","15:05", "Chequeo general", cita1);
        Consulta consulta2 = new Consulta("05-08-2025", "1FD5F15", "12:05", "Control de salud", cita2);
        consultas.add(consulta1);
        consultas.add(consulta2);

        // 7. Relacionar objetos con la clínica
        clinica1.getListPersonas().addAll(personas);
        clinica1.getListMascotas().addAll(mascotas);
        clinica1.getListConsultas().addAll(consultas);
        clinica1.getListCitas().addAll(citas);
    }

    public static void main(String[] args) {
        launch();
    }
}