module co.edu.uniquindio.poo.veterinariaproyect {
    requires javafx.controls;
    requires javafx.fxml;
<<<<<<< Updated upstream

=======
    requires java.desktop;
    requires transitive javafx.graphics;
>>>>>>> Stashed changes

    opens co.edu.uniquindio.poo.veterinariaproyect to javafx.fxml;
    exports co.edu.uniquindio.poo.veterinariaproyect;

    // Esta línea es la que soluciona el problema de acceso
    opens co.edu.uniquindio.poo.veterinariaproyect.viewController to javafx.fxml;
    exports co.edu.uniquindio.poo.veterinariaproyect.viewController;
}