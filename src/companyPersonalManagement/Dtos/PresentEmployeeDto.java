package companyPersonalManagement.Dtos;

import companyPersonalManagement.Dtos.ErrorsDto.ErrorDto;

import java.util.List;

public class PresentEmployeeDto extends EmployeeDto {


    private final String position;
    private final String departmentName;

    private final List<ErrorDto> errorDtos;

    public PresentEmployeeDto(String firstName, String lastName, String position, String departmentName, List<ErrorDto> errorDtos) {
        super(firstName, lastName);
        this.position = position;
        this.departmentName = departmentName;
        this.errorDtos = errorDtos;
    }

    @Override
    public String getFirstName() {
        return super.getFirstName();
    }

    @Override
    public String getLastName() {
        return super.getLastName();
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
        return "PresentEmployeeDto{" +
                "position='" + position + '\'' +
                ", departmentName='" + departmentName + '\'' +
                ", errorDtos=" + errorDtos +
                "} " + super.toString();
    }
}

