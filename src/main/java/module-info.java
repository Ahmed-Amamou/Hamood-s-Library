module com.example.bibliotheque_project {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires java.sql;
    requires mysql.connector.j;
    opens com.example.bibliotheque_project to javafx.fxml;
    exports com.example.bibliotheque_project;
    exports com.example.bibliotheque_project.Models;
    opens com.example.bibliotheque_project.Models to javafx.fxml;
}