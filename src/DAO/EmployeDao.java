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
        if(employee.isEmpty())
            return null;
        try {
            this.connection.setAutoCommit(false);
            PreparedStatement statement = this.connection.prepareStatement("INSERT INTO person (firstName, lastName, dateofbirth, phonenumber) VALUES (?, ?, ?, ?) ;");
            PreparedStatement statement1 = this.connection.prepareStatement("INSERT INTO employe (id, registrationNumber, recrutmentDate, email) VALUES ( (SELECT id FROM person WHERE firstName = ? AND lastName = ?), ?, ?, ?);");
            statement.setString(1,employee.get().getFirstName());
            statement.setString(2,employee.get().getLastName());
            statement.setDate(3, employee.get().getDateOfBirth());
            statement.setString(4,employee.get().getPhoneNumber());
            statement1.setString(1,employee.get().getFirstName());
            statement1.setString(2,employee.get().getLastName());
            statement1.setString(3,employee.get().getRegistrationNumber());
            statement1.setDate(4, employee.get().getRecruitmentDate());
            statement1.setString(5,employee.get().getEmail());
            if(statement.execute() && statement1.execute())
            {
                this.connection.commit();
                return employee;
            }
        }catch(Exception e)
        {
            this.connection.rollback();
            throw new RuntimeException(e);
        }finally {
            this.connection.setAutoCommit(true);
        }
        return null;
    }

    @Override
    public int delete(String registrationNumber) {
        return 0;
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
