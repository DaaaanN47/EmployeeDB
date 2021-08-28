package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    private Button button;

    @FXML
    private Text TextBox;


    @FXML
    private TextArea Password;

    @FXML
    private Button registrationButton;

    @FXML
    private ListView<Employee> userList;

    public Employee First;
    public Employee Second;
    public Employee Third;
    MyDataBase myDataBase;


    public Controller(){

        myDataBase = new MyDataBase();
    }
    private ObservableList<String> items = FXCollections.observableArrayList();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        UbdateList();





    }
    public void UbdateList(){
        userList.getItems().clear();
        var Employees = myDataBase.GetAll();
        for (Employee employee:Employees) {
            userList.getItems().add(employee);
        }
    }

    public void DeleteEmployee(ActionEvent actionEvent) {
        myDataBase.Delete(ClickGetSelectedEmployee());
        System.out.println(ClickGetSelectedEmployee().toString());
        userList.getItems().remove(userList.getSelectionModel().getSelectedItem());
//


    }
    public Employee ClickGetSelectedEmployee(){
        Employee employee = (Employee)this.userList.getSelectionModel().getSelectedItem();
        return employee;
    }



    public void OpenRegistWindow(ActionEvent actionEvent) throws IOException {

        Stage stage =new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("/RegistrAndEdit.fxml"));
        fxmlLoader.setControllerFactory(c->new RegistrationController(this));
        Scene scene = new Scene(fxmlLoader.load(), 630, 400);
        stage.setTitle("New Window");
        stage.setScene(scene);
        stage.show();
    }

    public void AddElementToList(Employee employee){
        userList.getItems().add(employee);
    }

    public void UpdateData(ActionEvent actionEvent) throws IOException {
        Stage stage =new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("/RegistrAndEdit.fxml"));
        fxmlLoader.setControllerFactory(c->new EmployeeEditor(
                (Employee)this.userList.getSelectionModel().getSelectedItem(),this));
        Scene scene = new Scene(fxmlLoader.load(), 630, 400);
        stage.setTitle("New Window");
        stage.setScene(scene);
        stage.show();
    }
}

