package aliyetgin.database;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

//Lombok
@Getter
@Setter

abstract public class DatabaseInformation {
    //Fields
    private String url;
    private String user;
    private String password;
    private String forNameData;

    //Constructor without parameters
    public DatabaseInformation() {
        this.url="jdbc:mysql://localhost:3306/blog";
        this.user="root";
        this.password="ali2459";
        this.forNameData="com.mysql.cj.jdbc.Driver";
    }

    //Constructor with parameters
    public DatabaseInformation(String url, String userName, String userPassword, String forNameData) {
        this.url = url;
        this.user = userName;
        this.password = userPassword;
        this.forNameData = forNameData;
    }



} //end of class
