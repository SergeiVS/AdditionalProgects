package companyPersonalManagement.repositories;

import companyPersonalManagement.dtos.requestDtos.NewDepartmentDto;
import companyPersonalManagement.entitys.Employee;

import java.util.List;

public interface DepartmentRepositoryInterface {
    void addNewDepartment(NewDepartmentDto newDepartmentDto);
    void removeDepartment(String departmentName);
    void addEmployeeToDepartment(String departmentName, Employee employee);

    void removeEmployeeFromDepartment(String departmentName, Employee employee);

    List<Employee> findAllDepartmentEmployees(String departmentName);

    List<Employee> findDepartmentEmployeesByPosition(String departmentName, String position);

 }
