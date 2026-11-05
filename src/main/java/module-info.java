module pe.edu.upeu.proyect_final_gp1 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.bootstrapfx.core;
    requires java.sql;

    opens pe.edu.upeu.proyect_final_gp1 to javafx.fxml;
    opens pe.edu.upeu.proyect_final_gp1.model to javafx.base, javafx.fxml;
    opens pe.edu.upeu.proyect_final_gp1.controller to javafx.fxml;
    opens pe.edu.upeu.proyect_final_gp1.views to javafx.fxml;



    exports pe.edu.upeu.proyect_final_gp1;
    //añadimos paquete del proyecto
    exports pe.edu.upeu.proyect_final_gp1.utils;
    exports pe.edu.upeu.proyect_final_gp1.model;
    exports pe.edu.upeu.proyect_final_gp1.interfaces;
    exports pe.edu.upeu.proyect_final_gp1.implementacion;
    exports pe.edu.upeu.proyect_final_gp1.controller;


}