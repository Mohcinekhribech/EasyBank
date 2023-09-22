package Interfaces;

import DTO.Client;
import DTO.Employee;

import java.util.List;

public interface EmployeInterface {
    Employee add(Employee employee);
    int delete(String registrationNumber);
    Employee update(Employee employee,String registrationNumber);
    Employee SearchByRegistrationNumber(String registratonNumber);
    List<Employee> Search(Employee employee);
}
