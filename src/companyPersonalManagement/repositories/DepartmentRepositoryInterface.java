package companyPersonalManagement.repositories;

import companyPersonalManagement.dtos.requestDtos.DepartmentDto;
import companyPersonalManagement.entitys.Employee;

import java.util.List;

public interface DepartmentRepositoryInterface {
    void addNewDepartment(DepartmentDto DepartmentDto);

    void removeDepartment(String departmentName);

    void addEmployeeToDepartment(String departmentName, Employee employee);

    void removeEmployeeFromDepartment(String departmentName, Employee employee);

    List<Employee> findAllDepartmentEmployees(String departmentName);
}
