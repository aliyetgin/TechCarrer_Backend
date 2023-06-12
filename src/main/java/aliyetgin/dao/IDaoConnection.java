package aliyetgin.dao;

import aliyetgin.database.DatabaseConnection;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public interface IDaoConnection <T>{
    // CRUD

    // CREATE
    public void create(T t);

    // UPDATE
    public void update(T t);

    // DELETE
    public void delete(T t);

    // LIST
    public ArrayList<T> list();

    // Concerete Method Connection
    default Connection getInterfaceConnection() throws SQLException, ClassNotFoundException {
        return DatabaseConnection.getInstance().getConnection();
    }

} // end of interface
