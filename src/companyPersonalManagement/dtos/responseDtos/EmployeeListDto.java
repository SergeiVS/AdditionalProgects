package companyPersonalManagement.dtos.responseDtos;

import companyPersonalManagement.dtos.errorsDto.ErrorDto;
import companyPersonalManagement.entitys.Employee;

import java.util.List;

public class EmployeeListDto {

   private final List<PresentEmployeeDto> employees;
    private final List<ErrorDto> errors;

    public EmployeeListDto(List<PresentEmployeeDto> employees, List<ErrorDto> errors) {
        this.employees = employees;
        this.errors = errors;
    }

    public List<PresentEmployeeDto> getEmployees() {
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
