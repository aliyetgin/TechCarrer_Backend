package aliyetgin.database;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//LOMBOK
@Log4j2
@Getter @Setter
public class DatabaseConnection extends DatabaseInformation {

    // Connection
    private Connection connection;
    private String url=this.getUrl();
    private String user=this.getUser();
    private String password=this.getPassword();
    private String forNameData=this.getForNameData();

    // Singleton Design Pattern
    // Singleton Class

    private static DatabaseConnection instance;

    // Singleton Constructor: to make sure we dont get new instances
    private DatabaseConnection() throws ClassNotFoundException, SQLException {
        try {
            // Database ilgili classa erişim sağlamak için
            Class.forName(forNameData);
            log.info("Driver Yüklendi");
            connection = DriverManager.getConnection(url, user, password);
            log.info("Database bağlantısı başarılı");
        } catch (Exception exception) {
            exception.printStackTrace();
            log.error(DatabaseConnection.class + "driver or connection failed!!!");
        }// end of catch
    }// end of DatabaseConnection

    // Connection
    public static DatabaseConnection getInstance() throws SQLException, ClassNotFoundException {
        try {
            if(instance==null || instance.connection.isClosed()) {
                instance= new DatabaseConnection();
            }
        }catch (SQLException sqlException) {
          sqlException.printStackTrace();
          log.error(DatabaseConnection.class + "couldn't create an instance " + sqlException);
        }catch (Exception exception) {
          exception.printStackTrace();
          log.error(DatabaseConnection.class + "couldn't create an instance " + exception);
        }
        return instance;
    }// end of database connection

    // PSVM
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        DatabaseConnection databaseConnection = new DatabaseConnection();
    }
}// end of class
