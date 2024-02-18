package companyPersonalManagement.repositories;

import companyPersonalManagement.dtos.requestDtos.EmployeeDto;

import companyPersonalManagement.dtos.responseDtos.PresentEmployeeDto;
import companyPersonalManagement.entitys.Employee;

import java.util.List;

public interface EmployeeRepositoryInterface {
    Employee addNewEmployee(EmployeeDto employeeDto);
    Employee employeeLayOff(Integer id);

    Employee setEmployeePosition(Integer id, String position);
    Employee findEmployeeById(Integer id);
    List<Employee> findAllEmployees();
   List<Employee> findEmployeeByLastname(String lastName);


   Integer wholePersonalCount();


}
