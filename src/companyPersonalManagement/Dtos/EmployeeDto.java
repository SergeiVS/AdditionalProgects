package companyPersonalManagement.Dtos;

import companyPersonalManagement.Dtos.ErrorsDto.ErrorDto;

import java.util.List;

public class EmployeeDto {

    private final String firstName;
    private final String lastName;
    private final String position;
    private final String departmentName;

    private final List<ErrorDto> errorDtos;

    public EmployeeDto(String firstName, String lastName, String position, String departmentName, List<ErrorDto> errorDtos) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.position = position;
        this.departmentName = departmentName;
        this.errorDtos = errorDtos;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPosition() {
        return position;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public List<ErrorDto> getErrorDtos() {
        return errorDtos;
    }

    @Override
    public String toString() {
        return "EmployeeDto{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", position='" + position + '\'' +
                ", departmentName='" + departmentName + '\'' +
                ", errorDtos=" + errorDtos +
                '}';
    }
}
