package companyPersonalManagement.Dtos;

import companyPersonalManagement.Dtos.ErrorsDto.ErrorDto;

import java.util.List;

public class NewEmployeeDto extends EmployeeDto {

    public NewEmployeeDto(String firstName, String lastName) {
        super(firstName, lastName);
    }

    @Override
    public String getFirstName() {
        return super.getFirstName();
    }

    @Override
    public String getLastName() {
        return super.getLastName();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
