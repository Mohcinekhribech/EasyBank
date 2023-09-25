package DAO;

import DTO.Employee;
import Helpers.Database;
import Interfaces.EmployeInterface;

import java.sql.*;
import java.util.List;
import java.util.Optional;

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
    public Optional<Employee> update(Employee employee, String registrationNumber) {
        return Optional.empty();
    }

    @Override
    public Optional<Employee> SearchByRegistrationNumber(String registratonNumber) {
        return Optional.empty();
    }

    @Override
    public List<Optional<Employee>> Search(Employee employee) {
        return null;
    }

}
