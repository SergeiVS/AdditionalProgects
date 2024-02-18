package companyPersonalManagement.repositories;

import companyPersonalManagement.dtos.requestDtos.EmployeeDto;

import companyPersonalManagement.entitys.Employee;

import java.util.List;

public interface EmployeeRepositoryInterface {
    void addNewEmployee(EmployeeDto employeeDto);
    void employeeLayOff(Integer id);
    Employee findEmployeeById(Integer id);
   List<Employee> findEmployeeByLastname(String lastName);
   List<Employee> findEmployeesByPosition(String Position);

   Integer wholePersonalCount();


}
