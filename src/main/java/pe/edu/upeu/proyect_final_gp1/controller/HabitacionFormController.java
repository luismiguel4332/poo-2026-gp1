package pe.edu.upeu.proyect_final_gp1.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import pe.edu.upeu.proyect_final_gp1.modelo.Habitacion;
import pe.edu.upeu.proyect_final_gp1.utils.UtilAlerts;


public class HabitacionFormController {
    public static UtilAlerts utilAlerts = new UtilAlerts();
    @FXML
    private Label lblTitulo;
    @FXML
    private TextField txtNumero, txtNumeroPiso, txtNumeroHabitacion, txtTipo, txtPrecio;
    @FXML
    private ComboBox<String> cbEstado;
    private Habitacion habitacion;
    private boolean saved = false;

    @FXML
    public void initialize(){
        cbEstado.getItems().addAll("Disponible", "Ocupado", "Mantenimiento");
    }

    public boolean isSaved(){
        return saved;
    }

    public Habitacion getHabitacion(){
        return habitacion;
    }

    private boolean validate(){
        if (txtNumero.getText().isEmpty() && txtPrecio.getText().isEmpty()){
            Alert alert = utilAlerts.mostrarAlerts("",
                    "Número y Precio son obligatorios","ERROR");
            alert.show();
            return false;
        }
        return true;
    }

    private void cerrar(){
        Stage stage = (Stage) txtNumero.getScene().getWindow();
        stage.close();
    }

    // Acciones de las vistas
    @FXML
    private void handleCancel(){
        cerrar();
    }

    @FXML
    private void handleSave(){
        if (validate()){
            if (habitacion == null)
                habitacion = new Habitacion();
            habitacion.setNumero(txtNumero.getText());
            habitacion.setNumeroPiso(txtNumeroPiso.getText());
            habitacion.setNumeroHabitacion(txtNumeroHabitacion.getText());
            habitacion.setTipo(txtTipo.getText());
            habitacion.setPrecio(Double.parseDouble(txtPrecio.getText().trim().replace(',','.')));
            habitacion.setEstado(cbEstado.getValue());
            saved = true;
            cerrar();
        }
    }

    //

    public void setHabitacion(Habitacion h){
        this.habitacion = h;
        if (h != null){
            lblTitulo.setText("Editar Habitación");
            txtNumero.setText(h.getNumero());
            txtNumeroPiso.setText(h.getNumeroPiso());
            txtNumeroHabitacion.setText(h.getNumeroHabitacion());
            txtTipo.setText(h.getTipo());
            txtPrecio.setText(String.valueOf(h.getPrecio()));
            cbEstado.setValue(h.getEstado());
        }
    }
}
