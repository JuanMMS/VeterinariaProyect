module co.edu.uniquindio.poo.veterinariaproyect {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens co.edu.uniquindio.poo.veterinariaproyect to javafx.fxml;
    exports co.edu.uniquindio.poo.veterinariaproyect;
}