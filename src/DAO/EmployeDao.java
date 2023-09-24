package DAO;

import DTO.Employee;
import Helpers.Database;
import Interfaces.EmployeInterface;

import java.sql.*;
import java.util.List;

public class EmployeDao implements EmployeInterface {
    Connection connection = Database.ConnectToDb();
    @Override
    public Employee add(Employee employee) throws SQLException {
        try {
            this.connection.setAutoCommit(false);
            PreparedStatement statement = this.connection.prepareStatement("INSERT INTO person (firstName, lastName, dateofbirth, phonenumber) VALUES (?, ?, ?, ?) ;");
            PreparedStatement statement1 = this.connection.prepareStatement("INSERT INTO employe (id, registrationNumber, recrutmentDate, email) VALUES ( (SELECT id FROM person WHERE firstName = ? AND lastName = ?), ?, ?, ?);");
            statement.setString(1,employee.getFirstName());
            statement.setString(2,employee.getLastName());
            statement.setDate(3, employee.getDateOfBirth());
            statement.setString(4,employee.getPhoneNumber());
            statement1.setString(1,employee.getFirstName());
            statement1.setString(2,employee.getLastName());
            statement1.setString(3,employee.getRegistrationNumber());
            statement1.setDate(4, employee.getRecruitmentDate());
            statement1.setString(5,employee.getEmail());
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
        return employee;
    }
    @Override
    public int delete(String registrationNumber) {
        return 0;
    }

    @Override
    public Employee update(Employee employee, String registrationNumber) {
        return null;
    }

    @Override
    public Employee SearchByRegistrationNumber(String registratonNumber) {
        return null;
    }

    @Override
    public List<Employee> Search(Employee employee) {
        return null;
    }
}
