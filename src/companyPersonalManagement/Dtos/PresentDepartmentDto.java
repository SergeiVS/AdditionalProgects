package companyPersonalManagement.Dtos;

import companyPersonalManagement.Dtos.ErrorsDto.ErrorDto;
import companyPersonalManagement.entitys.Employee;

import java.util.List;

public class PresentDepartmentDto extends DepartmentDto{

    private final List<Employee> employees;
    private final List<ErrorDto> errors;

    public PresentDepartmentDto(String departmentName, List<Employee> employees, List<ErrorDto> errors) {
        super(departmentName);
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
    public String getDepartmentName() {
        return super.getDepartmentName();
    }

    @Override
    public String toString() {
        return "PresentDepartmentDto{" +
                "employees=" + employees +
                ", errors=" + errors +
                "} " + super.toString();
    }
}
