package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public abstract class ControllerParent implements Initializable {
    protected MyDataBase MyDb;

    @FXML
    protected TextField firstName;

    @FXML
    protected TextField secondName;

    @FXML
    protected TextField thirdName;

    @FXML
    protected TextField phoneNumber;

    @FXML
    protected TextField snils;

    @FXML
    protected TextField inn;

    @FXML
    protected TextField passport;

    @FXML
    protected TextField position;

    @FXML
    protected Button acceptButton;
    @FXML
    protected Label ModeLabel;

    protected Controller controller;
    public ControllerParent(Controller controller){
        this.controller = controller;
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }


    public abstract void ClickAccept(ActionEvent actionEvent);
}
