package aliyetgin.controller;

import aliyetgin.dao.RegisterDao;
import aliyetgin.dto.RegisterDto;

import java.util.ArrayList;

public class RegisterControllerImplementation implements IRegisterController{

    private RegisterDao registerDao = new RegisterDao();

    // CREATE
    @Override
    public void create(RegisterDto registerDto) {
        registerDao.create(registerDto);
    }

    // UPDATE
    @Override
    public void update(RegisterDto registerDto) {
        registerDao.update(registerDto);
    }

    // DELETE
    @Override
    public void delete(RegisterDto registerDto) {
        registerDao.delete(registerDto);
    }

    // LIST
    @Override
    public ArrayList<RegisterDto> list() {
        return registerDao.list();
    }

    // FIND
    @Override
    public RegisterDto find(long id) {  return registerDao.find(id); }
}
