package companyPersonalManagement.repositories;

import companyPersonalManagement.Dtos.NewDepartmentDto;
import companyPersonalManagement.entitys.Department;
import companyPersonalManagement.entitys.Employee;

import java.util.List;

public interface DepartmentRepositoryInterface {
    void addNewDepartment(NewDepartmentDto newDepartmentDto);
    void removeDepartment(String departmentName);
    void addEmployeeToDepartment(String departmentName, Employee employee);

    void removeEmployeeFromDepartment(String departmentName, Employee employee);

    List<Employee> findAllDepartmentEmployees(String departmentName);

    List<Employee> findDepartmentEmployeesBzPosition(String departmentName,String position);

 }
