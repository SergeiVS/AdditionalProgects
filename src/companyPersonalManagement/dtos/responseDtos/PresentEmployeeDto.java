package companyPersonalManagement.dtos.responseDtos;

import companyPersonalManagement.dtos.errorsDto.ErrorDto;
import companyPersonalManagement.dtos.requestDtos.EmployeeDto;

import java.util.List;

public class PresentEmployeeDto extends EmployeeDto {

private final Integer personalId;
    private final String position;
    private final String departmentName;

    private final List<ErrorDto> errorDtos;

    public PresentEmployeeDto(Integer personalId, String firstName, String lastName, String position, String departmentName, List<ErrorDto> errorDtos) {
        super(firstName, lastName);
        this.personalId = personalId;
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

    public Integer getPersonalId() {
        return personalId;
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

