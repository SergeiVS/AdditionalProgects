package companyPersonalManagement.Services;

import companyPersonalManagement.dtos.errorsDto.ErrorDto;
import companyPersonalManagement.dtos.requestDtos.EmployeeDto;
import companyPersonalManagement.repositories.EmployeeRepository;

import java.util.List;

public class EmployeeService {
    EmployeeService service = new EmployeeService();
    EmployeeRepository repository = new EmployeeRepository();

    public EmployeeRepository addNewEmployee(EmployeeDto dto){

    }
    ValidationInterface<EmployeeDto> newEmployeeValidate = new ValidationInterface<EmployeeDto>() {
        @Override
        public List<ErrorDto> validate(EmployeeDto request) {

            return null;
        }
    }
}
