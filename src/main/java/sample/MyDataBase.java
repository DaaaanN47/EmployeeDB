package sample;

import javafx.scene.control.ListView;

import java.sql.*;
import java.util.ArrayList;

import static java.lang.Integer.parseInt;

public class MyDataBase {
    private static final String  dbURL = "jdbc:sqlserver://RAMAZANPC;databaseName=FirstDB";
    private static final String LOGIN = "MyJavaApp";
    private static final String PASSWORD = "12345";

    ListView<String> list;
    public MyDataBase(){

    }



    public Connection getConnection()throws SQLException {
        return DriverManager.getConnection(dbURL,LOGIN,PASSWORD);
    }
    public boolean Insert(Employee employee){
        try{
            var connection = getConnection();
            String sql = " INSERT INTO "+ DataBaseContract.USER_TABLE+ " ( "+
                    DataBaseContract.USER_FIRSTNAME + " , " + DataBaseContract.USER_SECONDNAME + " , " +
                    DataBaseContract.USER_THIRDNAME + " , "+ DataBaseContract.USER_SNILS + " , " +
                    DataBaseContract.USER_INN + " , " + DataBaseContract.USER_PASSPORT + " , " +
                    DataBaseContract.USER_PHONE_NUMBER + " , " + DataBaseContract.USER_POSITION + " ) " +
                    " VALUES ( ? , ? , ? , ? , ? , ? , ? , ? ) ";
            PreparedStatement prSt = getConnection().prepareStatement(sql);
            prSt.setString(1,employee.firstName);
            prSt.setString(2,employee.secondName);
            prSt.setString(3,employee.thirdName);
            prSt.setString(4,employee.SNILS);
            prSt.setString(5,employee.INN);
            prSt.setString(6,employee.passport);
            prSt.setString(7,employee.phoneNumber);
            prSt.setString(8,employee.position);

            int rows = prSt.executeUpdate();
            if(rows > 0){
                System.out.println("Строка добавлена");
            }
            connection.close();
            return rows>0;
        }
        catch (SQLException exeption){
            System.out.println(exeption.getMessage());
            exeption.printStackTrace();
            return false;
        }
    }
    public boolean Update(Employee newEmployee){
        try {
            String sql = " UPDATE " + DataBaseContract.USER_TABLE + " SET " +
                    DataBaseContract.USER_FIRSTNAME + " = ? , " +
                    DataBaseContract.USER_SECONDNAME + " = ?, " +
                    DataBaseContract.USER_THIRDNAME + " = ?, " +
                    DataBaseContract.USER_SNILS + " = ?, " +
                    DataBaseContract.USER_INN + " = ?, " +
                    DataBaseContract.USER_PASSPORT + " = ?, " +
                    DataBaseContract.USER_PHONE_NUMBER + " = ?, " +
                    DataBaseContract.USER_POSITION + " = ? " +

                " WHERE id=? ";
            var connection = getConnection();
            PreparedStatement prst = connection.prepareStatement(sql);
            prst.setString(1,newEmployee.firstName);
            prst.setString(2,newEmployee.secondName);
            prst.setString(3,newEmployee.thirdName);
            prst.setString(4,newEmployee.SNILS);
            prst.setString(5,newEmployee.INN);
            prst.setString(6,newEmployee.passport);
            prst.setString(7,newEmployee.phoneNumber);
            prst.setString(8,newEmployee.position);
            prst.setInt(9,newEmployee.id);

            int rows = prst.executeUpdate();
            if(rows > 0){
                System.out.println("Строка добавлена");
            }
            connection.close();
                return true;



        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }

    }
//    public void Delete() throws SQLException {
//        String value = "11";
//        var connection = getConnection();
//        String sql = " DELETE FROM Employees where id=?";
//
//        PreparedStatement pst = connection.prepareStatement(sql);
//        pst.setInt(1,12);
//        pst.executeUpdate();
//
//
//    }
    public  void UpdateUserList() throws SQLException {

    }
    public  Employee getLast() {
        String sql = "SELECT * FROM "+ DataBaseContract.USER_TABLE+ " WHERE id=(SELECT max(id) FROM "+ DataBaseContract.USER_TABLE+ ")";
        try {
            var connection = getConnection();
            PreparedStatement prs = connection.prepareStatement(sql);
            ResultSet resultSet = prs.executeQuery();
            resultSet.next();
            Employee employee = new Employee(
                    resultSet.getNString(DataBaseContract.USER_FIRSTNAME),
                    resultSet.getNString(DataBaseContract.USER_SECONDNAME),
                    resultSet.getNString(DataBaseContract.USER_THIRDNAME),
                    resultSet.getNString(DataBaseContract.USER_SNILS),
                    resultSet.getNString(DataBaseContract.USER_INN),
                    resultSet.getNString(DataBaseContract.USER_PASSPORT),
                    resultSet.getNString(DataBaseContract.USER_PHONE_NUMBER),
                    resultSet.getNString(DataBaseContract.USER_POSITION),
                    resultSet.getInt(DataBaseContract.USER_ID));
            return employee;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }
    public ArrayList<Employee> GetAll(){
        String sql = "SELECT * FROM "+ DataBaseContract.USER_TABLE+  "  ";
        ArrayList<Employee>employees = new ArrayList<>();
        try {
            var connection = getConnection();
            PreparedStatement prs = connection.prepareStatement(sql);
            ResultSet resultSet = prs.executeQuery();
            while (resultSet.next()){
                Employee employee = new Employee(
                        resultSet.getNString(DataBaseContract.USER_FIRSTNAME),
                        resultSet.getNString(DataBaseContract.USER_SECONDNAME),
                        resultSet.getNString(DataBaseContract.USER_THIRDNAME),
                        resultSet.getNString(DataBaseContract.USER_SNILS),
                        resultSet.getNString(DataBaseContract.USER_INN),
                        resultSet.getNString(DataBaseContract.USER_PASSPORT),
                        resultSet.getNString(DataBaseContract.USER_PHONE_NUMBER),
                        resultSet.getNString(DataBaseContract.USER_POSITION),
                        resultSet.getInt(DataBaseContract.USER_ID));
                employees.add(employee);
            }

            return employees;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return employees;
        }
    }
    public void Delete(Employee employee){
        String  sql = " DELETE " + DataBaseContract.USER_TABLE + " WHERE ID = " + employee.id;
        try {
            var connection = getConnection();
            PreparedStatement prst = connection.prepareStatement(sql);
            prst.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
    public void SignUpUser(String first, String second, String third, String snils,
                           String inn,String passport, String PhoneNumber, String position){

    }

}
