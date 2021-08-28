package sample;

import javafx.event.ActionEvent;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class EmployeeEditor extends ControllerParent  {

    Employee employee;

    public EmployeeEditor(Employee employee, Controller controller){
        super(controller);
        this.employee = employee;
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        MyDb = new MyDataBase();
        acceptButton.setText("Сохранить");
        ModeLabel.setText("Редактирование");
        firstName.setText(employee.firstName);
        secondName.setText(employee.secondName);
        thirdName.setText(employee.thirdName);
        snils.setText(employee.SNILS);
        inn.setText(employee.INN);
        passport.setText(employee.passport);
        phoneNumber.setText(employee.phoneNumber);
        position.setText(employee.position);
        InitFirstNameField();
        InitSecondNameField();
        InitThirdNameField();
        InitSnilsField();
        InitInnField();
        InitPassportField();
        InitPhoneNumberField();
        InitPositionField();
    }
    private void InitFirstNameField(){
        firstName.textProperty() .addListener((observable, oldValue, newValue) -> {
                employee.firstName = newValue;
        });
    };
    private void InitSecondNameField(){
        secondName.textProperty() .addListener((observable, oldValue, newValue) -> {
            employee.secondName = newValue;
        });
    };
    private void InitThirdNameField(){
        thirdName.textProperty() .addListener((observable, oldValue, newValue) -> {
            employee.thirdName = newValue;
        });
    };
    private void InitSnilsField(){
        snils.textProperty() .addListener((observable, oldValue, newValue) -> {
            employee.SNILS = newValue;
        });
    };
    private void InitInnField(){
        inn.textProperty() .addListener((observable, oldValue, newValue) -> {
            employee.INN = newValue;
        });
    };
    private void InitPassportField(){
        passport.textProperty() .addListener((observable, oldValue, newValue) -> {
            employee.passport = newValue;
        });
    };
    private void InitPhoneNumberField(){
        phoneNumber.textProperty() .addListener((observable, oldValue, newValue) -> {
            employee.phoneNumber = newValue;
        });
    };
    private void InitPositionField(){
        position.textProperty() .addListener((observable, oldValue, newValue) -> {
            employee.position = newValue;
        });
    };
    @Override
    public void ClickAccept(ActionEvent actionEvent) {
    MyDb.Update(employee);
    controller.UbdateList();
    Stage stage = (Stage)acceptButton.getScene().getWindow();
    stage.close();
    }
}


