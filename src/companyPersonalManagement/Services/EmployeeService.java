package companyPersonalManagement.Services;

import companyPersonalManagement.dtos.errorsDto.ErrorCodes;
import companyPersonalManagement.dtos.errorsDto.ErrorDto;
import companyPersonalManagement.dtos.requestDtos.EmployeeDto;
import companyPersonalManagement.dtos.responseDtos.PresentEmployeeDto;
import companyPersonalManagement.entitys.Employee;
import companyPersonalManagement.repositories.EmployeeRepository;
import companyPersonalManagement.repositories.RepositoryServices.EmployeeRepositoryService;

import java.util.ArrayList;
import java.util.List;

public class EmployeeService {
    EmployeeRepositoryService service = new EmployeeRepositoryService();
    EmployeeRepository repository = new EmployeeRepository();

    public PresentEmployeeDto addNewEmployee(EmployeeDto dto) {
        List<ErrorDto> errors = employeeDtoValidate.validate(dto);
        if (errors.isEmpty()) {
            Employee employee = service.addNewEmployee(dto);
            Integer id = employee.getPersonalId();
            String fName = employee.getFirstName();
            String lName = employee.getLastName();

            return new PresentEmployeeDto(id, fName, lName, "-", "-", errors);
        } else {
            return new PresentEmployeeDto(0, "-", "-", "-", "-", errors);
        }
    }
    public PresentEmployeeDto layOffEmployee(PresentEmployeeDto dto){
        List<ErrorDto> errors = presentEmployeeDtoValidate.validate(dto);
        if (errors.isEmpty()){
            Integer id = dto.getPersonalId();
            String fName = dto.getFirstName();
            String lName = dto.getLastName();
            String dName = dto.getDepartmentName();
            String position = dto.getPosition();
            Employee e = repository.getEmployeesRepository().get(id);
            service.employeeLayOff(id);
            return new PresentEmployeeDto(id, fName, lName, position, dName, errors);
        }else {
            return new PresentEmployeeDto(0, "-", "-", "-", "-", errors);
        }
    }
    public PresentEmployeeDto setEmployeePosition(PresentEmployeeDto dto, String position){
        List<ErrorDto> errors = presentEmployeeDtoValidate.validate(dto);

        if (errors.isEmpty()) {
            Integer id = dto.getPersonalId();
            String fName = dto.getFirstName();
            String lName = dto.getLastName();
            String dName = dto.getDepartmentName();
            service.setEmployeePosition(id, position);
            return new PresentEmployeeDto(id, fName, lName, position, dName, errors);
        }else {
            return new PresentEmployeeDto(0, "-", "-", "-", "-", errors);
        }
    }



    ValidationInterface<EmployeeDto> employeeDtoValidate = new ValidationInterface<EmployeeDto>() {
        @Override
        public List<ErrorDto> validate(EmployeeDto request) {
            List<ErrorDto> errors = new ArrayList<>();

            if (request == null) {
                errors.add(new ErrorDto(ErrorCodes.ER401, "First or lastname field can not be empty"));
                return errors;
            } else {
                try {
                    String fName = request.getFirstName();
                    String lastName = request.getLastName();
                } catch (Exception e) {
                    errors.add(new ErrorDto(ErrorCodes.ER402, "Request in wrong format"));
                    return errors;
                }
            }
            if (request.getLastName().isEmpty() || request.getFirstName().isEmpty()) {
                errors.add(new ErrorDto(ErrorCodes.ER401, "First or lastname field can not be empty"));
                return errors;

            }
            return errors;
        }
    };
    ValidationInterface<PresentEmployeeDto> presentEmployeeDtoValidate = new ValidationInterface<PresentEmployeeDto>() {
        @Override
        public List<ErrorDto> validate(PresentEmployeeDto request) {
            List<ErrorDto> errors = new ArrayList<>();

            if (request == null) {
                errors.add(new ErrorDto(ErrorCodes.ER401, "Request can not be empty"));
                return errors;
            } else {
                try {
               Integer id = request.getPersonalId();

                } catch (Exception e) {
                    errors.add(new ErrorDto(ErrorCodes.ER402, "Request in wrong format"));
                    return errors;
                }
            }
            if (request.getLastName().isEmpty() || request.getFirstName().isEmpty() || request.getPersonalId() == 0) {
                errors.add(new ErrorDto(ErrorCodes.ER401, "Fields of request can not be empty"));
                return errors;
            }
            return errors;
        }
    };
}
