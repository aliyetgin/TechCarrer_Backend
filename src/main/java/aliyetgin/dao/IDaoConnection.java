package aliyetgin.dao;

import aliyetgin.database.DatabaseConnection;
import aliyetgin.dto.RegisterDto;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public interface IDaoConnection <T>{
    // CRUD

    // CREATE
    public void create(T t);

    // LIST
    public ArrayList<T> list();

    // FIND
    public RegisterDto find(long id);

    // UPDATE
    public void update(T t);

    // DELETE
    public void delete(T t);


    // Concerete Method Connection
    default Connection getInterfaceConnection() throws SQLException, ClassNotFoundException {
        return DatabaseConnection.getInstance().getConnection();
    }

} // end of interface
