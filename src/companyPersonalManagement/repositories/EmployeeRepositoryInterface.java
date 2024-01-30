package companyPersonalManagement.repositories;

import companyPersonalManagement.Dtos.NewEmployeeDto;

import companyPersonalManagement.entitys.Employee;

import java.util.List;

public interface EmployeeRepositoryInterface {
    void addNewEmployee(NewEmployeeDto newEmployeeDto);
    void employeeLayOff(Integer id);
    Employee findEmployeeById(Integer id);
   List<Employee> findEmployeeByLastname(String lastName);
   List<Employee> findEmployeesByPosition(String Position);

   Integer wholePersonalCount();


}
