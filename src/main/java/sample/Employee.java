package sample;


import org.apache.commons.lang3.StringUtils;




public class Employee {

    String password;
    public String firstName;
    public String secondName;
    public String thirdName;
    public String SNILS;
    public String INN;
    public String passport;
    public String phoneNumber;
    public String position;
    int id;
    public Employee(String firstName,String secondName,String thirdName, String SNILS, String INN,String passport, String phoneNumber, String position, int id){
        this.firstName = firstName;
        this.secondName = secondName;
        this.thirdName = thirdName;
        this.SNILS = SNILS;
        this.INN = INN;
        this.passport = passport;
        this.phoneNumber = phoneNumber;
        this.position = position;
        this.id = id;
    }
    public Employee(String firstName,String secondName,String thirdName, String SNILS, String INN,String passport, String phoneNumber, String position){
        this.firstName = firstName;
        this.secondName = secondName;
        this.thirdName = thirdName;
        this.SNILS = SNILS;
        this.INN = INN;
        this.passport = passport;
        this.phoneNumber = phoneNumber;
        this.position = position;
    }

    @Override
    public String toString() {
        secondName = StringUtils.capitalize(secondName);
        String shortFullName = secondName + " "+firstName.substring(0,1).toUpperCase()+"."+thirdName.substring(0,1).toUpperCase()+".";
        return shortFullName;
    }
}
