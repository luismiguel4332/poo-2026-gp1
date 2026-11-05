package pe.edu.upeu.proyect_final_gp1.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import pe.edu.upeu.proyect_final_gp1.HelloApplication;
import pe.edu.upeu.proyect_final_gp1.implementacion.HabitacionDaoImpl;
import pe.edu.upeu.proyect_final_gp1.interfaces.IHabitacionDao;
import pe.edu.upeu.proyect_final_gp1.modelo.Habitacion;
import pe.edu.upeu.proyect_final_gp1.utils.UtilAlerts;


public class HabitacionController {
    private static UtilAlerts utilAlert = new UtilAlerts();

    //definimos la tabla
    @FXML
    private TableView<Habitacion> tableHabitacion;
    //variable correlativa
    @FXML
    private TableColumn<Habitacion,Number> ColNum;
    @FXML
    private TableColumn<Habitacion,Integer> ColId;
    @FXML
    private TableColumn<Habitacion,String> ColNumero;
    @FXML
    private TableColumn<Habitacion,String> ColNumeroPiso;
    @FXML
    private TableColumn<Habitacion,String> ColNumeroHab;
    @FXML
    private TableColumn<Habitacion,String> ColTipo;

    @FXML
    private TableColumn<Habitacion,Double> Colprecio;
    @FXML
    private TableColumn<Habitacion,String> ColEstado;


    private final IHabitacionDao habitacionDao = new HabitacionDaoImpl();
    private ObservableList<Habitacion> listaHabitacions;


    @FXML
    public void initialize(){
        ColNum.setCellFactory(colum -> new TableCell<>(){
            @Override
            protected void updateItem(Number item, boolean empty){
                super.updateItem(item,empty);
                if (empty){
                    setText(null);
                }else{
                    setText(String.valueOf(getIndex() +1));
                }
            }
        });

        ColId.setCellValueFactory(
                cellData -> cellData.getValue().idhabitacionProperty().asObject());
        ColNumero.setCellValueFactory(
                cellData -> cellData.getValue().numeroProperty());
        ColNumeroPiso.setCellValueFactory(
                cellData -> cellData.getValue().numeroPisoProperty());
        ColNumeroHab.setCellValueFactory(
                cellData -> cellData.getValue().numeroHabitacionProperty());
        ColTipo.setCellValueFactory(
                cellData -> cellData.getValue().tipoProperty());

        Colprecio.setCellValueFactory(
                cellData -> cellData.getValue().precioProperty().asObject());
        ColEstado.setCellValueFactory(
                cellData -> cellData.getValue().estadoProperty());
        //llamar al metodo
        cargarDatos();
    }
    private void cargarDatos(){
        listaHabitacions = FXCollections.observableArrayList(habitacionDao.listAll());
        tableHabitacion.setItems(listaHabitacions);
    }


    @FXML
    private void handleNew(){
         System.out.println("abriendo el formulario");
        showForm(null);

    }

    private void showForm(Habitacion c){
        try{
            FXMLLoader loader = new FXMLLoader(HelloApplication.class
                    .getResource("/pe/edu/upeu/project_final/views/habitacion-form.fxml"));
            Parent root = loader.load();
            HabitacionFormController controller = loader.getController();
            controller.setHabitacion(c); //pasamos el cliente null si es nuevo
            Stage stage = new Stage();
            stage.setTitle(c==null ? "Nuevo Habitacion": "Editar Habitacion");
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene( new Scene(root));
            stage.showAndWait();
            if (controller.isSaved()){
                Habitacion hProcesado = controller.getHabitacion();
                if (c == null){
                    boolean result =  habitacionDao.insert(hProcesado);
                    if (result){
                        Alert alert = utilAlert.mostrarAlerts("Success","Registro satisfactorio!!!","CONFIRMATION");
                        alert.show();
                    }else{
                        Alert alert = utilAlert.mostrarAlerts("Error","Error al insertar!!!","ERROR");
                        alert.show();
                    }
                }else{
                    boolean result =  habitacionDao.update(hProcesado);
                    if (result){
                        Alert alert = utilAlert.mostrarAlerts("Update",
                                "Registro actualizado!!!","WARNING");
                        alert.showAndWait();
                    }else{
                        Alert alert = utilAlert.mostrarAlerts("Error",
                                "Error al actualizar!!!","ERROR");
                        alert.show();
                    }
                }
                cargarDatos();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
