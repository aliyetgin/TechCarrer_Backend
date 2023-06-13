package aliyetgin.dao;

import aliyetgin.dto.RegisterDto;
import lombok.extern.log4j.Log4j2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

// LOMBOK
@Log4j2
public class RegisterDao implements IDaoConnection<RegisterDto> {
    // CREATE
    @Override
    public void create(RegisterDto registerDto) {
        try(Connection connection=getInterfaceConnection()) {
            // Connection, Close Transaction
            connection.setAutoCommit(false);

            String sql="insert into blog.register (name,surname,email,password) values (?,?,?,?);";
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1, registerDto.getName());
            preparedStatement.setString(2, registerDto.getSurname());
            preparedStatement.setString(3, registerDto.getEmail());
            preparedStatement.setString(4, registerDto.getPassword());
            // ADDING
            int rowsEffected = preparedStatement.executeUpdate();
            if(rowsEffected > 0){
                log.info(RegisterDto.class + " Added successfully");
                // if transaction is successful, process continues
                connection.commit();
            }else {
                log.info(RegisterDto.class + " Addition failed");
                // if transaction is unsuccessful, process doesn't continue
                connection.rollback();
            }
        }catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    // LIST
    @Override
    public ArrayList<RegisterDto> list() {
        ArrayList<RegisterDto> registerDtoList = new ArrayList<>();
        RegisterDto registerDto;
        try(Connection connection=getInterfaceConnection()) {
            String sql="select * from blog.register;";
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                registerDto = new RegisterDto();
                registerDto.setId(resultSet.getLong("id"));
                registerDto.setName(resultSet.getString("name"));
                registerDto.setSurname(resultSet.getString("surname"));
                registerDto.setEmail(resultSet.getString("email"));
                registerDto.setPassword(resultSet.getString("password"));
                registerDtoList.add(registerDto);
            }
        }catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return registerDtoList;
    }

    // FIND
    @Override
    public RegisterDto find(long id) {
        RegisterDto registerDto = new RegisterDto();
        try(Connection connection=getInterfaceConnection()) {
            // Connection, Close Transaction
            connection.setAutoCommit(false);

            String sql="select * from blog.register where id=?";
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                registerDto.setId(resultSet.getLong("id"));
                registerDto.setName(resultSet.getString("name"));
                registerDto.setSurname(resultSet.getString("surname"));
                registerDto.setEmail(resultSet.getString("email"));
                registerDto.setPassword(resultSet.getString("password"));
            } else {
                log.info("No register found with ID: " + id);
            }
        }catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return registerDto;
    }

    // UPDATE
    @Override
    public void update(RegisterDto registerDto) {
        try(Connection connection=getInterfaceConnection()) {
            // Connection, Close Transaction
            connection.setAutoCommit(false);

            String sql="update blog.register set name=?,surname=?,email=?,password=? where id=?;";
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1, registerDto.getName());
            preparedStatement.setString(2, registerDto.getSurname());
            preparedStatement.setString(3, registerDto.getEmail());
            preparedStatement.setString(4, registerDto.getPassword());
            preparedStatement.setLong(5, registerDto.getId());
            // UPDATING
            int rowsEffected = preparedStatement.executeUpdate();
            if(rowsEffected > 0){
                log.info(RegisterDto.class + " Updated successfully");
                // if transaction is successful, process continues
                connection.commit();
            }else {
                log.info(RegisterDto.class + " Update failed");
                // if transaction is unsuccessful, process doesn't continue
                connection.rollback();
            }
        }catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    // DELETE
    @Override
    public void delete(RegisterDto registerDto) {
        try(Connection connection=getInterfaceConnection()) {
            // Connection, Close Transaction
            connection.setAutoCommit(false);

            String sql="delete from blog.register where id=?";
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setLong(1, registerDto.getId());
            int rowsEffected = preparedStatement.executeUpdate();
            if(rowsEffected > 0){
                log.info(RegisterDto.class + " Deleted successfully");
                // if transaction is successful, process continues
                connection.commit();
            }else {
                log.info(RegisterDto.class + " Delete failed");
                // if transaction is unsuccessful, process doesn't continue
                connection.rollback();
            }
        }catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }// end of delete method
}// end of class
