package sample;
import java.net.URL;
import java.util.ResourceBundle;

public class RegistrationController extends ControllerParent  {

    public RegistrationController(Controller controller) {
        super(controller);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    MyDb = new MyDataBase();

        ModeLabel.setText("Регистрация");

    }

    @Override
    public void ClickAccept(ActionEvent actionEvent) {
        Employee employee = new Employee(firstName.getText(),
                secondName.getText(),
                thirdName.getText(),
                snils.getText(),
                inn.getText(),
                passport.getText(),
                phoneNumber.getText(),
                position.getText());
        var answer = MyDb.Insert(employee);

        if (answer){
            employee= MyDb.getLast();
            controller.AddElementToList(employee);

        }
        controller.UbdateList();
        Stage stage = (Stage)acceptButton.getScene().getWindow();
        stage.close();
    }


    public void Registrate(ActionEvent actionEvent) {
        Employee employee = new Employee(firstName.getText(),
                secondName.getText(),
                thirdName.getText(),
                snils.getText(),
                inn.getText(),
                passport.getText(),
                phoneNumber.getText(),
                position.getText());
       var answer = MyDb.Insert(employee);

       if (answer){
           employee= MyDb.getLast();
           controller.AddElementToList(employee);

       }


    }
}
