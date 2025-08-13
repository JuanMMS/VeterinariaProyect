module co.edu.uniquindio.poo.veterinariaproyect {
    requires javafx.controls;
    requires javafx.fxml;


    requires java.desktop;


    requires java.desktop;
    requires transitive javafx.graphics;


    opens co.edu.uniquindio.poo.veterinariaproyect to javafx.fxml;
    exports co.edu.uniquindio.poo.veterinariaproyect;

    // Esta línea es la que soluciona el problema de acceso
    opens co.edu.uniquindio.poo.veterinariaproyect.viewController to javafx.fxml;
    exports co.edu.uniquindio.poo.veterinariaproyect.viewController;
}