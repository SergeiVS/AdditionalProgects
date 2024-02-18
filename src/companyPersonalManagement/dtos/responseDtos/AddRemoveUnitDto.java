package companyPersonalManagement.dtos.responseDtos;

import companyPersonalManagement.dtos.errorsDto.ErrorDto;

import java.util.List;

public class AddRemoveUnitDto {
    private final String message;

    private  final List<ErrorDto> errors;

    public AddRemoveUnitDto(String message, List<ErrorDto> errors) {
        this.message = message;
        this.errors = errors;
    }

    @Override
    public String toString() {
        return "AddRemoveUnitDto{" +
                "message='" + message + '\'' +
                ", errors=" + errors +
                '}';
    }
}
