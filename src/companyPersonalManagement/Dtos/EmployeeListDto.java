package companyPersonalManagement.Dtos;

import companyPersonalManagement.Dtos.ErrorsDto.ErrorDto;
import companyPersonalManagement.entitys.Employee;

import java.util.List;

public class EmployeeListDto {
    List<Employee>employees;
    List<ErrorDto> errors;

    public EmployeeListDto(List<Employee> employees, List<ErrorDto> errors) {
        this.employees = employees;
        this.errors = errors;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public List<ErrorDto> getErrors() {
        return errors;
    }

    @Override
    public String toString() {
        return "EmployeeListDto{" +
                "employees=" + employees +
                ", errors=" + errors +
                '}';
    }
}
