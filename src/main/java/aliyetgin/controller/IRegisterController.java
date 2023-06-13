package aliyetgin.controller;

import aliyetgin.database.DatabaseConnection;
import aliyetgin.dto.RegisterDto;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public interface IRegisterController {

    // CREATE
    public void create(RegisterDto registerDto);

    // LIST
    public ArrayList<RegisterDto> list();

    // FIND
    public RegisterDto find(long id);

    // UPDATE
    public void update(RegisterDto registerDto);

    // DELETE
    public void delete(RegisterDto registerDto);


} // end of interface

