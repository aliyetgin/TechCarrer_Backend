package aliyetgin.controller;

import aliyetgin.database.DatabaseConnection;
import aliyetgin.dto.RegisterDto;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public interface IRegisterController {

    // CREATE
    public void create(RegisterDto registerDto);

    // UPDATE
    public void update(RegisterDto registerDto);

    // DELETE
    public void delete(RegisterDto registerDto);

    // LIST
    public ArrayList<RegisterDto> list();
} // end of interface

