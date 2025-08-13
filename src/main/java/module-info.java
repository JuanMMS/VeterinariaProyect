module co.edu.uniquindio.poo.veterinariaproyect {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires transitive javafx.graphics;


    opens co.edu.uniquindio.poo.veterinariaproyect to javafx.fxml;
    exports co.edu.uniquindio.poo.veterinariaproyect;
    opens co.edu.uniquindio.poo.veterinariaproyect.model to javafx.base;
    opens co.edu.uniquindio.poo.veterinariaproyect.viewController to javafx.fxml;
    exports co.edu.uniquindio.poo.veterinariaproyect.viewController;
}