package DAO;

import DTO.Employee;
import Helpers.Database;
import Interfaces.EmployeInterface;

import java.sql.*;
import java.sql.Date;
import java.time.LocalDate;
import java.util.*;

public class EmployeDao implements EmployeInterface {
    Connection connection = Database.ConnectToDb();
    @Override
    public Optional<Employee> add(Optional<Employee> employee) throws SQLException {
        if(employee.isPresent()) {
            connection.setAutoCommit(false);
            PreparedStatement statement = connection.prepareStatement("INSERT INTO person (firstName, lastName, dateofbirth, phonenumber) VALUES (?, ?, ?, ?)");
            statement.setString(1, employee.get().getFirstName());
            statement.setString(2, employee.get().getLastName());
            statement.setDate(3, Date.valueOf(employee.get().getDateOfBirth()));
            statement.setString(4, employee.get().getPhoneNumber());
            if(statement.executeUpdate()>0)
            {
                PreparedStatement statement1 = connection.prepareStatement("INSERT INTO employe (id, registrationNumber, recrutmentDate, email) VALUES ((SELECT id FROM person WHERE firstName = ? AND lastName = ? AND dateofbirth = ?), ?, ?, ?)");
                statement1.setString(1, employee.get().getFirstName());
                statement1.setString(2, employee.get().getLastName());
                statement1.setDate(3, Date.valueOf(employee.get().getDateOfBirth()));
                statement1.setString(4, employee.get().getRegistrationNumber());
                statement1.setDate(5, Date.valueOf(employee.get().getRecruitmentDate()));
                statement1.setString(6, employee.get().getEmail());
                   if(statement1.executeUpdate()>0)
                   {
                       connection.commit();
                       return employee;
                   }
            }
        }
        connection.rollback();
        return Optional.empty();
    }

    @Override
    public int delete(String registrationNumber) {
        try{
            PreparedStatement statement = this.connection.prepareStatement("delete from person where id = (select id from employe where registrationNumber = ?)");
            statement.setString(1,registrationNumber);
            return statement.executeUpdate();
        }catch(Exception e)
        {
            throw new RuntimeException();
        }
    }

    @Override
    public Optional<Employee> update(Employee employee, String registrationNumber) throws SQLException {
            connection.setAutoCommit(false);
            PreparedStatement statement = connection.prepareStatement("UPDATE  person set  firstName= ?, lastName=? , dateofbirth = ?, phonenumber = ? where id = (select id from employe where registrationNumber = ?) ");
            statement.setString(1, employee.getFirstName());
            statement.setString(2, employee.getLastName());
            statement.setDate(3, employee.getRecruitmentDate()!=null?Date.valueOf(employee.getRecruitmentDate()):null);
            statement.setString(4, employee.getPhoneNumber());
            statement.setString(5,registrationNumber);
            if(statement.executeUpdate()>0)
            {
                PreparedStatement statement1 = connection.prepareStatement("UPDATE employe set recrutmentDate = ?, email = ? where registrationNumber = ?");
                statement1.setDate(1, employee.getRecruitmentDate()!=null?Date.valueOf(employee.getRecruitmentDate()):null);
                statement1.setString(2,employee.getEmail());
                statement1.setString(3,registrationNumber);
                if(statement1.executeUpdate()>0)
                {
                    connection.commit();
                    return Optional.of(employee);
                }
            }
        connection.rollback();
        return Optional.empty();
    }

    @Override
    public Map<String,String> SearchByRegistrationNumber(String registratonNumber){
        Map<String,String> employe = new HashMap<>();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM person AS pr INNER JOIN employe as em ON em.id = pr.id  where em.registrationNumber = ?;");
            statement.setString(1,registratonNumber);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){
                employe.put("firstName",resultSet.getString("firstName"));
                employe.put("lastName",resultSet.getString("lastName"));
                employe.put("dateOfBirth",resultSet.getString("dateOfBirth"));
                employe.put("phoneNumber",resultSet.getString("phoneNumber"));
                employe.put("registrationNumber",registratonNumber);
                employe.put("recrutmentDate",resultSet.getString("recrutmentDate"));
                employe.put("email",resultSet.getString("email"));
                return employe;
            }
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Map<String , String>> Search(Employee employee) {
        List<Map<String , String>> employes = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM person AS pr INNER JOIN employe as em ON em.id = pr.id  where em.registrationNumber = ? OR firstname = ? OR lastName = ? OR phonenumber = ? OR dateOfBirth = ? OR recrutmentDate = ? OR email = ?;");
            statement.setString(1,employee.getRegistrationNumber());
            statement.setString(2,employee.getFirstName());
            statement.setString(3,employee.getLastName());
            statement.setString(4,employee.getPhoneNumber());
            statement.setDate(5, employee.getDateOfBirth()!=null?Date.valueOf(employee.getDateOfBirth()):null);
            statement.setDate(6, employee.getRecruitmentDate()!=null?Date.valueOf(employee.getRecruitmentDate()):null);
            statement.setString(7,employee.getEmail());
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
                Map<String,String> employe = new HashMap<>();
                employe.put("registrationNumber",resultSet.getString("registrationNumber"));
                employe.put("firstName",resultSet.getString("firstName"));
                employe.put("lastName",resultSet.getString("lastName"));
                employe.put("dateOfBirth",resultSet.getString("dateOfBirth"));
                employe.put("phoneNumber",resultSet.getString("phoneNumber"));
                employe.put("recrutmentDate",resultSet.getString("recrutmentDate"));
                employe.put("email",resultSet.getString("email"));
                employes.add(employe);
            }
            return employes;
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Map<String, String>> getAll() {
        List<Map<String,String>> employes = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM person AS pr INNER JOIN employe as em ON em.id = pr.id ;");
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
                Map<String,String> employe = new HashMap<>();
                employe.put("firstName",resultSet.getString("firstName"));
                employe.put("lastName",resultSet.getString("lastName"));
                employe.put("dateOfBirth",resultSet.getString("dateOfBirth"));
                employe.put("phoneNumber",resultSet.getString("phoneNumber"));
                employe.put("registrationNumber",resultSet.getString("registrationNumber"));
                employe.put("recrutmentDate",resultSet.getString("recrutmentDate"));
                employe.put("email",resultSet.getString("email"));
                employes.add(employe);
            }
            return employes;
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

}
