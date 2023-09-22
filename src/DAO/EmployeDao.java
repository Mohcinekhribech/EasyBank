package DAO;

import DTO.Employee;
import Interfaces.EmployeInterface;

import java.util.List;

public class EmployeDao implements EmployeInterface {

    @Override
    public Employee add(Employee employee) {

        return null;
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
