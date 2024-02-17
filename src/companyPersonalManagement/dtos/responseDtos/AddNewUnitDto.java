package companyPersonalManagement.dtos.responseDtos;

import companyPersonalManagement.dtos.errorsDto.ErrorDto;

import java.util.List;

public class AddNewUnitDto {
    private final String message;

    private  final List<ErrorDto> errors;

    public AddNewUnitDto(String message, List<ErrorDto> errors) {
        this.message = message;
        this.errors = errors;
    }

    @Override
    public String toString() {
        return "AddNewUnitDto{" +
                "message='" + message + '\'' +
                ", errors=" + errors +
                '}';
    }
}
